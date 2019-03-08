/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Libreria;
import edu.eci.arsw.cinema.model.Libro;
import edu.eci.arsw.cinema.persistence.LibraryException;

import edu.eci.arsw.cinema.persistence.LibraryPersitence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
@Service
public class InMemoryLibraryPersistence implements LibraryPersitence {

    //private final Map<String,Cinema> cinemas=new HashMap<>();
    List<Libreria> libreriass = new ArrayList<Libreria>();
    List<Libro> libros1 = new ArrayList<Libro>();

    List<Libro> libros2 = new ArrayList<Libro>();
    List<Libro> v = new ArrayList<Libro>();

    public InMemoryLibraryPersistence() {

        Libro b1 = new Libro(1, "Como se robam a Colombia", "Pepito", "De cmo los corruptos se roban el pais y la justicia no hace nada");
        Libro b2 = new Libro(2, "Como olvidar a un ser querido", "Andres", "De como lidiar el duelo y despedirse de ese ser que partio del mundo fisico");
        Libro b3 = new Libro(3, "Como Estudiar Sistemas y no mrir en el intento", "Cesar Eduardo", "Tecnicas y metodos que le salvarna la vida al momento de estudiar esta espetacular carrera");
        Libro b4 = new Libro(4, "Como olvidar a tu ex", "maria", "para que no recuerdes a ese maldito traidor");
        Libro b5 = new Libro(5, "como encender un pc", "tu abuela", "para encender un pc");
        libros1.add(b1);
        libros1.add(b2);
        libros1.add(b3);
        libros1.add(b4);
        libros1.add(b5);

        Libreria libre1 = new Libreria("BigBan", "Calle Andromera con carrera via lactea", 654789, 1, libros1);
        //
        Libro b11 = new Libro(6, "¿cOMO SECUESTRAR UN AVION Y NO morir en el intento?", "Osama ben ladn", "Como secuestrar un avion, evitar la seguridad y estrellarlo contra tu objetivo");
        Libro b12 = new Libro(7, "¿Como entender a la mujer?", "Socates", "No lo vas a enteder aun asi");
        Libro b13 = new Libro(8, "¿Como entender a un hombre?", "lopez", "No hay que, no somos complejos");
        Libro b14 = new Libro(9, "¿Como ser buenos hijos?", "maria", "Como ser un buen hijo y que te sientas orgullosso");

        libros2.add(b11);
        libros2.add(b12);
        libros2.add(b13);
        libros2.add(b14);

        Libreria libre2 = new Libreria("Dico", "Calle 1 con carrera 1", 111112, 2, libros2);
        Libreria libre3 = new Libreria("pais", "Calle 10 con carrera 12", 111112, 3, v);

        //
        libreriass.add(libre1);
        libreriass.add(libre2);
        libreriass.add(libre3);

    }

    @Override
    public List<Libreria> getAllLibrarys() throws LibraryException {
        return libreriass;
    }

    @Override
    public Libreria getLibrarysByName(String name) throws LibraryException {
        Libreria temp = new Libreria();

        for (Libreria tr : libreriass) {
            if (tr.getNombre().equals(name)) {
                temp = tr;
            }
        }
        return temp;
    }

    @Override
    public List<Libro> getAllBooks(String nameLibrary) throws LibraryException {
        List<Libro> temp = new ArrayList<Libro>();

        for (Libreria tr : libreriass) {
            if (tr.getNombre().equals(nameLibrary)) {
                temp = tr.getLibros();
            }
        }
        return temp;
    }

    @Override
    public void deleteLibraryById(String id) throws LibraryException {

        for (Libreria tr : libreriass) {
            if (tr.getNombre().equals(id) && tr.getLibros().size() == 0) {
                System.out.println("leegamos");
                libreriass.remove(tr);
            }
        }
    }

    @Override
    public void createLibreria(String Nombre, String Dirrecion, Integer Telefono) throws LibraryException {
        List<Libro> v = new ArrayList<Libro>();
        Libreria temp = new Libreria(Nombre, Dirrecion, Telefono, libreriass.size(), v);
    }

    @Override
    public void createLibros( String Nombre, String Autor, String Sinopsis, String libreria) throws LibraryException {
        Libro t = new Libro(libros1.size(), Nombre, Autor, Sinopsis);
        for (Libreria tr : libreriass) {
            if (tr.getNombre().equals(libreria) ) {
                List<Libro> te=tr.getLibros();
                te.add(t);
                
            }
        }

    }

}
