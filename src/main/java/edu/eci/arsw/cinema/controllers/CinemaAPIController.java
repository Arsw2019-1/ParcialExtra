/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import edu.eci.arsw.cinema.services.CinemaServices;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian
 */

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaAPIController {

    @Autowired
    CinemaServices rt;  
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoXX() throws ResourceNotFoundException {
        try {   
            return new ResponseEntity<>(rt.getAllCinemas(), HttpStatus.ACCEPTED);
        } catch (CinemaPersistenceException ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new CinemaPersistenceException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{cinema}")
    public ResponseEntity<?> CynemasByName(@PathVariable String cinema) throws ResourceNotFoundException, CinemaException {
        try {
            return new ResponseEntity<>(rt.getCinemaByName(cinema), HttpStatus.ACCEPTED);
        } catch (CinemaPersistenceException ex) {
            Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new CinemaPersistenceException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{cinema}/{date}")
    public ResponseEntity<?> CynemasByNameDate(@PathVariable String cinema,@PathVariable String date) throws  CinemaException {
        try{ 
            return new ResponseEntity<>(rt.getFunctionsbyCinemaAndDate(cinema, date), HttpStatus.ACCEPTED);
        }catch( Exception ex){            
            return new ResponseEntity<>(new CinemaPersistenceException("NO se pudo encontrar la pagina solicitada.  error HTTP 404 "), HttpStatus.NOT_FOUND);
        }

    }    
}
