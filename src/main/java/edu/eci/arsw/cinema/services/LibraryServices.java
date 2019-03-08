/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;


import edu.eci.arsw.cinema.model.Libreria;
import edu.eci.arsw.cinema.model.Libro;
import edu.eci.arsw.cinema.persistence.LibraryException;
import edu.eci.arsw.cinema.persistence.LibraryPersitence;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author 2098325
 */
@Service
public class LibraryServices {
    @Autowired
    LibraryPersitence cps;
    
    public List<Libreria> getAllLibrary() throws LibraryException{
    
        return cps.getAllLibrarys();
    
    }
    public Libreria getAllLibraryByName(String name) throws LibraryException{
    
        return cps.getLibrarysByName(name);
    
    }    

    public List<Libro> getAllBookByLibrary(String nameLibrary) throws LibraryException{
    
        return cps.getAllBooks(nameLibrary);
    }
    
    public void deleteLibraryById(String id) throws LibraryException{
    
        cps.deleteLibraryById(id);
    }
    public void createLibreria(String Nombre, String Dirrecion, Integer Telefono)throws LibraryException{
        cps.createLibreria(Nombre, Dirrecion, Telefono);
    }
    
    public void createLibro(String Nombre, String Autor, String Sinopsis, String libreria)throws LibraryException{
    
        cps.createLibros( Nombre, Autor, Sinopsis, libreria);
    }
   
    
    
    
}
