package com.laserants.spring_api.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laserants.spring_api.models.LibroModel;
import com.laserants.spring_api.services.LibroService;


/*para identificarlo / Ruta de nuestra tabla en la base de datos*/
@RestController 
@RequestMapping("/Libro") 
public class LibroController {
	
	//Instanciamos un objeto de la clase Service y hacemos el llamado con @Autowired
	@Autowired 
	private LibroService libroService;
	
	
	//declaramos el metodo para obtener informacion de la tabla libro
	//*para rastriar cuando invoquen el metodoGet*/
	@GetMapping 
	public ArrayList<LibroModel>getLibros(){
		return this.libroService.getLibros();
	}
	
	//Declaramos el metodo para guardar un nuevo Libro
	@PostMapping
	public ResponseEntity<LibroModel> saveLibro(@RequestBody LibroModel libro) {
		return this.libroService.saveLibro(libro);
	}
	
}
