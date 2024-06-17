package com.laserants.spring_api.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.laserants.spring_api.models.LibroModel;
import com.laserants.spring_api.repositories.ILibroRepository;



//en esta clase es en donde va toda la logica del negocio
/*hacemos el llamado que es un servicio*/
@Service
public class LibroService {
	
	//creamos una instancia de la interface ILibroRepository
	@Autowired
	private ILibroRepository libroRepository;
	
	//Vamos a empezar con nuestro CRUD
	//Metodo para obtener la lista de libros
	
	public ArrayList<LibroModel> getLibros(){	
			   /*castiamos libroRespository*/  /*Metodos de la interface Repository*/	
		return (ArrayList<LibroModel>) libroRepository.findAll();
	}
	
	
	//Metodo para ingresar info de un nuevo Libro
	public ResponseEntity<LibroModel> saveLibro(LibroModel libro) {
		// validaciones extra o logica va aca
		//return employeeRepository.save(employee);
		return new ResponseEntity<>(libroRepository.save(libro), HttpStatus.CREATED);		
	}
		
}
