/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.controllers.ResourceNotFoundException;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaFilter;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
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
public class CinemaServices {
    @Autowired
    CinemaPersitence cps;
    
    @Autowired
    CinemaFilter cpsf;

  
    public Movie CynemasByNameDateMovie(String cinema, String date, String movie){
        List<CinemaFunction> temp=cps.getFunctionsbyCinemaAndDate(cinema, date);
        Movie resp=null;
        for(CinemaFunction tr: temp){
            System.out.print("pensando");
            if(tr.getMovie().equals(movie)){
                System.out.print("entro");
                resp=tr.getMovie();
            }
        }
        return resp;
    }
    
    public List<Movie> getMovieByGender(Cinema cinema, String date, Object factor){
        return cpsf.getListMovies(cinema, date, factor);
    }
    
    /**
    public List<Movie> getMovieByAvailability(String cinema, String date, int factor){
        return cpsf.getListMovies(cinema, date, factor);
    }*/
    public void addNewCinema(Cinema c) throws ResourceNotFoundException, CinemaPersistenceException{
        
        cps.saveCinema(c);
    }
    
    public Collection<Cinema> getAllCinemas() throws ResourceNotFoundException, CinemaPersistenceException{
        return cps.getCinemaValues();
    }
    
    /**
     * 
     * @param name cinema's name
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     */
    public Cinema getCinemaByName(String name) throws CinemaException, CinemaPersistenceException{
        return  cps.getCinema(name);
        
    }
    
    
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException{
        cps.buyTicket(row, col, cinema, date, movieName);
    }
    
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        return cps.getFunctionsbyCinemaAndDate(cinema, date);
    }
    

    
    
    
}
