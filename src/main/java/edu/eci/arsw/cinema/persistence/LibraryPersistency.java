/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence;

import edu.eci.arsw.cinema.model.Libreria;
import edu.eci.arsw.cinema.model.Libro;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiante
 */
@Service
public interface LibraryPersistency {
    
    
    public Libreria getAllLibrarys();
    
    public Libreria getLibrarybyName(String name) throws LibraryException;
    
    public List<Libro> getAllBookByLibrary(String name) throws LibraryException ;
    
    //public Libro  getLibroByNamebyLibrary(String nameLibrary, String nameBook) throws LibraryException ;
    
    
    
}
