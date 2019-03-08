/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import java.util.List;

/**
 *
 * @author estudiante
 */
public class Libreria {
    
    private String Nombre;
    private String Dirrecion;
    private Integer Telefono;
    private Integer id;
    private List<Libro> libros;

    public Libreria() {
    }

    
    public Libreria(String Nombre, String Dirrecion, Integer Telefono, Integer id,List<Libro> libros) {
        this.Nombre = Nombre;
        this.Dirrecion = Dirrecion;
        this.Telefono = Telefono;
        this.id = id;
        this.libros=libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public String getDirrecion() {
        return Dirrecion;
    }

    public String getNombre() {
        return Nombre;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setDirrecion(String Dirrecion) {
        this.Dirrecion = Dirrecion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
   
}
