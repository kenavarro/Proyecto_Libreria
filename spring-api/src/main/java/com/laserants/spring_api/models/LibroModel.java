package com.laserants.spring_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//declaramos la clase con el nombre de la tabla y convinando el componente
@Entity
@Table(name ="`Libro`")
public class LibroModel{
	
	//declaramos los atributos con sus respectivas llamadas
	//primary key
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//El resto de campos que vamos a usar
	@Column(name = "`titulo`")
	private String titulo;
	@Column(name = "`autor`")
	private String autor;
	@Column(name = "`genero`")
	private String genero;
	@Column(name = "`precio`")
	private Float precio;
	@Column(name = "`cantidad`")
	private Integer cantidad;
	
	
	//Declaramos los setters y getters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
