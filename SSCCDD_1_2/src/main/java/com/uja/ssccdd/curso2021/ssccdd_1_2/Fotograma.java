/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_2;

/**
 *
 * @author alber
 */
public class Fotograma {
    private int id;
    private CapacidadGrafica capacidad;

    public Fotograma(int id, CapacidadGrafica capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CapacidadGrafica getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(CapacidadGrafica capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString(){
        
    return "Fotograma: "+id+" ,"+capacidad;
    
    }
    
}
