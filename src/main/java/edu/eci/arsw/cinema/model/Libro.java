/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

/**
 *
 * @author estudiante
 */
public class Libro {
    
    private Integer id;
    private String Nombre;
    private String Autor;
    private String Sinopsis;

    public Libro() {
    }

    
    
    public Libro(Integer id,String Nombre, String Autor, String Sinopsis) {
        this.id=id;
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Sinopsis = Sinopsis;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getAutor() {
        return Autor;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }    
}
