package com.shiva.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.Main.Model.ServiceLoader;

public interface UrlRepository extends JpaRepository<ServiceLoader, Long>{

}
