/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import ch.qos.logback.classic.pattern.Util;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Libreria;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import edu.eci.arsw.cinema.persistence.LibraryException;
import edu.eci.arsw.cinema.services.CinemaServices;
import edu.eci.arsw.cinema.services.LibraryServices;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian
 */
@RestController
@RequestMapping(value = "/libreria")
public class CinemaAPIController {

    //@Autowired
    //CinemaServices rt;

    @Autowired
    LibraryServices rtt;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping("/alllibrarys")
    public ResponseEntity<?> getAllLibrarys() throws ResourceNotFoundException, LibraryException {
        System.out.println("olah");
        //rt.getAllLibrary()
        return new ResponseEntity<>(rtt.getAllLibrary(), HttpStatus.ACCEPTED);
    }

    //@RequestMapping(path = "/{librerias}",method = RequestMethod.GET)
    @GetMapping("/{librerias}")
    public ResponseEntity<?> getLibrarybyName(@PathVariable String librerias) throws ResourceNotFoundException, LibraryException {
        try {
            return new ResponseEntity<>(rtt.getAllLibraryByName(librerias), HttpStatus.ACCEPTED);
        } catch (LibraryException ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new LibraryException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }
    }
    //   clibrer/PINO/calle 5/11111
        //@RequestMapping(path = "clibrer/{nombre}/{dirrecion}/{telegono}",method = RequestMethod.PUT)
    /**
    @PostMapping("clibrer/{nombre}/{dirrecion}/{telegono}")
    Libreria createLIbrary(@RequestBody Libreria libre) throws LibraryException{
       // return rtt.createLibreria(libre.getNombre(), libre.getDirrecion(), libre.getTelefono());
        
    
    
    
    }        
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createLIbrary(@RequestBody String name, @RequestBody String dirrecion,@RequestBody Integer telefono) {
        try {
            rtt.createLibreria(name, dirrecion, telefono);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404, pagina no encontrada", HttpStatus.FORBIDDEN);
        }

    }
    /**        
    void CreateLibrary(@RequestBody String nombre,@RequestBody String dirrecion,@RequestBody Integer telefono) throws ResourceNotFoundException, LibraryException {
        try {
            rtt.createLibreria(nombre,dirrecion, telefono);
            //return new ResponseEntity<>(new LibraryException("Se pudo crear la nueva libreria "), HttpStatus.ACCEPTED);
        } catch (LibraryException ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            //return new ResponseEntity<>(new LibraryException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }
    }
    */
    //    clibro/pais/"EL AVANCE DEL MAR"/"ALGUIEN"/"ALGUNA"
     @PostMapping("clibro/{libreria}/{nombre}/{autor}/{sinopsis}")
           //@RequestMapping(path = "clibro/{libreria}/{nombre}/{autor}/{sinopsis}",method = RequestMethod.PUT)
    void CreateBook(@RequestBody String nombre,@RequestBody String autor,@RequestBody String sinopsis ,@RequestBody String libreria) throws ResourceNotFoundException, LibraryException {
        try {
            rtt.createLibro(nombre, autor, sinopsis, libreria);
            //return new ResponseEntity<>(new LibraryException("Se pudo crear el nuevo libro correctamente"), HttpStatus.ACCEPTED);
        } catch (LibraryException ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            //return new ResponseEntity<>(new LibraryException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }
    }
    

    //@RequestMapping(path = "/libreriasd/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLIbraryByName(@PathVariable String name) throws ResourceNotFoundException, LibraryException {
        try {
            rtt.deleteLibraryById(name);
           
             return new ResponseEntity<>("Se elimino la libreria.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Recurso no se pudo eliminar.", HttpStatus.NOT_FOUND);
        }
    }
    
    
    /**
    @RequestMapping(path = "/libreriasd/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<> deleteLibraryById(@PathVariable String name) throws ResourceNotFoundException, LibraryException {
        if(rtt.getAllLibraryByName(name)==null){
            
            return new ResponseEntity<>(new LibraryException("LIbreria no encontrada."), HttpStatus.NOT_FOUND);

        }else{
            return new ResponseEntity<>((MultiValueMap<String, String>) new LibraryException("LIbreria eliminada."), HttpStatus.NOT_FOUND);
        
        }
        
        
    }
*/
    /**
     *
     * @RequestMapping(method = RequestMethod.GET) public ResponseEntity<?>
     * manejadorGetRecursoXX() throws ResourceNotFoundException { try { return
     * new ResponseEntity<>(rt.getAllCinemas(), HttpStatus.ACCEPTED); } catch
     * (CinemaPersistenceException ex) {
     * Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE,
     * null, ex); return new ResponseEntity<>(new CinemaPersistenceException("NO
     * se pudo encontrar la pagina solicitada. error HTTP 404 "),
     * HttpStatus.NOT_FOUND); } }
     *
     * @GetMapping("/{cinema}") public ResponseEntity<?>
     * CynemasByName(@PathVariable String cinema) throws
     * ResourceNotFoundException, CinemaException { try { return new
     * ResponseEntity<>(rt.getCinemaByName(cinema), HttpStatus.ACCEPTED); }
     * catch (CinemaPersistenceException ex) {
     * Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE,
     * null, ex); return new ResponseEntity<>(new CinemaPersistenceException("NO
     * se pudo encontrar la pagina solicitada. error HTTP 404 "),
     * HttpStatus.NOT_FOUND); } }
     *
     * @GetMapping("/{cinema}/{date}") public ResponseEntity<?>
     * CynemasByNameDate(@PathVariable String cinema, @PathVariable String date)
     * throws CinemaException { try { return new
     * ResponseEntity<>(rt.getFunctionsbyCinemaAndDate(cinema, date),
     * HttpStatus.ACCEPTED); } catch (Exception ex) { return new
     * ResponseEntity<>(new CinemaPersistenceException("NO se pudo encontrar la
     * pagina solicitada. error HTTP 404 "), HttpStatus.NOT_FOUND); }
     *
     * }
     *
     * @GetMapping("/{cinema}/{date}/{movie}") public ResponseEntity<?>
     * CynemasByNameDateMovie(@PathVariable String cinema, @PathVariable String
     * date, @PathVariable String movie) throws CinemaException { try { return
     * new ResponseEntity<>(rt.CynemasByNameDateMovie(cinema, date, movie),
     * HttpStatus.ACCEPTED); } catch (Exception ex) { return new
     * ResponseEntity<>(new CinemaPersistenceException("NO se pudo encontrar la
     * pagina solicitada. error HTTP 404 "), HttpStatus.NOT_FOUND); }
     *
     * }
     * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<?>
     * manejadorPostRecursoXX(@RequestBody String name) { try { //registrar dato
     * return new ResponseEntity<>(HttpStatus.CREATED); } catch (Exception ex) {
     * Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE,
     * null, ex); return new ResponseEntity<>("Error 404, pagina no encontrada",
     * HttpStatus.FORBIDDEN); }
     *
     * }
     *
     * @RequestMapping(method = RequestMethod.PUT, path = "/{cinema}/{name}")
     * public ResponseEntity<?> updateFuction(@PathVariable String cinema,
     * @PathVariable String name) throws ResourceNotFoundException,
     * CinemaPersistenceException{ Movie temp=new Movie(name,"*");
     * CinemaFunction tr=new CinemaFunction(temp,"2019-15-12");
     * List<CinemaFunction> trl=new ArrayList<CinemaFunction>(); trl.add(tr);
     * Cinema ci=new Cinema(cinema, trl); rt.addNewCinema(ci); return new
     * ResponseEntity<>(HttpStatus.OK);      *
     * }
     */
}
