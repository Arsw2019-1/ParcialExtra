/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaFilter;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2098325
 */
@Service
public class FilterByGender implements CinemaFilter {

    @Autowired
    CinemaPersitence por=new InMemoryCinemaPersistence(); 
    
    public FilterByGender() {

    }

    @Override
    public List<Movie> getListMovies(Cinema cinema, String date, Object factor) {
        return por.getListMovies(cinema, date, factor);
    }

    @Override
    public List<Cinema> getAllCinema() throws CinemaPersistenceException{
        return por.getAllCinema();
    }

}
