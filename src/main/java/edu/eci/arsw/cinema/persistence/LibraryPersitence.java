/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence;


import edu.eci.arsw.cinema.model.Libreria;
import edu.eci.arsw.cinema.model.Libro;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author cristian
 */
public interface LibraryPersitence {
    
    public List<Libreria>getAllLibrarys() throws  LibraryException;
    
    public Libreria getLibrarysByName(String name) throws  LibraryException;
    
    public List<Libro> getAllBooks(String nameLibrary)throws  LibraryException;
    
    public void deleteLibraryById(String id)throws LibraryException;
    
    public void createLibreria(String Nombre, String Dirrecion, Integer Telefono)throws LibraryException;
    public void createLibros(String Nombre, String Autor, String Sinopsis, String libreria)throws LibraryException;
}
