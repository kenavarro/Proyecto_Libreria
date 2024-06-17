package com.laserants.spring_api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.laserants.spring_api.models.LibroModel;
import com.laserants.spring_api.repositories.ILibroRepository;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTest {

    @Mock
    private ILibroRepository libroRepositorio;

    @InjectMocks
    private LibroService libroServicio;

    @BeforeEach
    public void configurar() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Probando metodo de obtencion de datos")
    @Test
    public void obtenerLibroTest() {
        // Crear un nuevo libro
        LibroModel libroEsperado = new LibroModel();
        libroEsperado.setId(1);
        libroEsperado.setTitulo("Libro Esperado");
        libroEsperado.setAutor("Autor Esperado");
        libroEsperado.setGenero("Genero Esperado");
        libroEsperado.setPrecio(49.99f);
        libroEsperado.setCantidad(20);

        // Configurar el mock para que devuelva el libro esperado cuando se llame a findAll
        when(libroRepositorio.findAll()).thenReturn(new ArrayList<>(Arrays.asList(libroEsperado)));

        // Obtener la lista de libros
        ArrayList<LibroModel> libros = libroServicio.getLibros();

        // Verificar que la lista contiene el libro esperado con los datos correctos
        assertEquals(1, libros.size(), "La lista debe contener un libro");
        LibroModel libroObtenido = libros.get(0);
        assertEquals(libroEsperado.getId(), libroObtenido.getId(), "El ID del libro debe ser el esperado");
        assertEquals(libroEsperado.getTitulo(), libroObtenido.getTitulo(), "El título del libro debe ser el esperado");
        assertEquals(libroEsperado.getAutor(), libroObtenido.getAutor(), "El autor del libro debe ser el esperado");
        assertEquals(libroEsperado.getGenero(), libroObtenido.getGenero(), "El género del libro debe ser el esperado");
        assertEquals(libroEsperado.getPrecio(), libroObtenido.getPrecio(), "El precio del libro debe ser el esperado");
        assertEquals(libroEsperado.getCantidad(), libroObtenido.getCantidad(), "La cantidad del libro debe ser la esperada");
    }
    
    @DisplayName("Probando metodo de ingreso de datos")
    @Test
    public void LibroNuevoTest() {
        // Crear un nuevo libro
        LibroModel nuevoLibro = new LibroModel();
        nuevoLibro.setTitulo("Nuevo Libro");
        nuevoLibro.setAutor("Nuevo Autor");
        nuevoLibro.setGenero("Nuevo Genero");
        nuevoLibro.setPrecio(39.99f);
        nuevoLibro.setCantidad(15);

        // Configurar el mock para que devuelva una lista vacía inicialmente
        when(libroRepositorio.findAll()).thenReturn(new ArrayList<>());

        // Obtener la lista de libros (debe estar vacía inicialmente)
        ArrayList<LibroModel> libros = libroServicio.getLibros();

        // Agregar el nuevo libro a la lista
        boolean agregado = libros.add(nuevoLibro);

        // Verificar que el libro se ha agregado correctamente
        assertTrue(agregado, "El libro debe ser agregado a la lista");
        assertTrue(libros.contains(nuevoLibro), "La lista debe contener el nuevo libro");
    }

    @DisplayName("Probando metodo de ingreso de datos muestra un error")
    @Test
    public void probarGuardarLibroConError() {
        LibroModel libro = new LibroModel();
        libro.setTitulo("Nuevo Libro");
        libro.setAutor("Nuevo Autor");
        libro.setGenero("Nuevo Genero");
        libro.setPrecio(39.99f);
        libro.setCantidad(15);

        when(libroRepositorio.save(libro)).thenThrow(new RuntimeException("Error al guardar"));

        try {
            libroServicio.saveLibro(libro);
        } catch (RuntimeException e) {
            assertEquals("Error al guardar", e.getMessage());
        }

        verify(libroRepositorio).save(libro); // Verifica que el método save() fue llamado
    }
}
