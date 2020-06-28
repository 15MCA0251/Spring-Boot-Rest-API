package com.shiva.Main.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.Main.Model.Tutorials;
import com.shiva.Main.Repository.TutorialsRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialsRepository tutorialsRepository;

  @GetMapping("/GetTutorials")
  public ResponseEntity<List<Tutorials>> getAllTutorials(@RequestParam(required = false) String title) {
    try 
    {
    
      List<Tutorials> tutorials = new ArrayList<Tutorials>();
      if (title == null)
      {
    	  tutorialsRepository.findAll().forEach(tutorials::add);
      }   
      
      else
      {
    	  tutorialsRepository.findByTitleContaining(title).forEach(tutorials::add);
      }  
      
      if (tutorials.isEmpty()) 
      {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } 
    
    catch (Exception e) 
    {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/GetTutorial/{id}")
  public ResponseEntity<Tutorials> getTutorialById(@PathVariable("id") long id) {
    Optional<Tutorials> tutorialData = tutorialsRepository.findById(id);

    if (tutorialData.isPresent()) 
    {
      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    } 
    else 
    {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/AddTutorial")
  public ResponseEntity<Tutorials> createTutorial(@RequestBody Tutorials tutorial) {
    try 
    {
    	Tutorials tutorial2 = tutorialsRepository.save(new Tutorials(tutorial.getTitle(), tutorial.getDescription()));
        return new ResponseEntity<>(tutorial2, HttpStatus.CREATED);
    } 
    catch (Exception e) 
    {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/UpdateTutorial/{id}")
  public ResponseEntity<Tutorials> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorials tutorial) 
  {
    Optional<Tutorials> tutorialData = tutorialsRepository.findById(id);

    if (tutorialData.isPresent()) 
    {
    	Tutorials tutorial1 = tutorialData.get();
    	tutorial1.setTitle(tutorial.getTitle());
    	tutorial1.setDescription(tutorial.getDescription());
      return new ResponseEntity<>(tutorialsRepository.save(tutorial1), HttpStatus.OK);
    } 
    else 
    {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/DeleteTutorial/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
    	tutorialsRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }

}

