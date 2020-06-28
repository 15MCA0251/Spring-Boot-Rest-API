package com.shiva.Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.Main.Model.Tutorials;

public interface TutorialsRepository extends JpaRepository<Tutorials, Long>
{
	List<Tutorials> findByTitleContaining(String title);
}
