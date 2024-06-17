package com.laserants.spring_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laserants.spring_api.models.LibroModel;

@Repository
public interface ILibroRepository extends JpaRepository<LibroModel, Integer>{

}
