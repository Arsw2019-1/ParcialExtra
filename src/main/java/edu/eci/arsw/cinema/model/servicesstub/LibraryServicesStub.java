/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model.servicesstub;

import edu.eci.arsw.cinema.persistence.LibraryException;
import edu.eci.arsw.cinema.controllers.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2098325
 */
public class LibraryServicesStub {

    //CinemaServices cinema;

    public void CinemaServicesStub() throws LibraryException, ResourceNotFoundException {
        //Registrar cines
        String functionDate = "2028-9-20 19:30";
        
    }
    public void consCIne() throws LibraryException, ResourceNotFoundException{
        //System.out.println("Los cines son: "+cinema.getAllCinemas());
    }
    public void funcByCinema(String name, String date){
        //System.out.println("Las funciones del cine : "+name+" son :"+cinema.getFunctionsbyCinemaAndDate(name, date));
    }
    public void buyTickets() throws LibraryException{
       // cinema.buyTicket(1, 2, "El principio del fin", "2020-12-29 6:45", "BATTLE ANGEL: LA ÚLTIMA GUERRERA");
       // cinema.buyTicket(5, 5, "Circo Soledad", "2028-9-20 19:30", "Advengers End Game");
        //cinema.buyTicket(5, 5, "El principio del fin", "2020-12-29 6:45", "Advengers End Game");    
    }
}
