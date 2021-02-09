/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_2;

import com.uja.ssccdd.curso2021.ssccdd_1_2.Hiloprincipal.CapacidadGrafica;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Ordenador {
    
   private CapacidadGrafica capacidad;
   private ArrayList<Fotograma> fotogramas;

    public Ordenador(CapacidadGrafica capacidad, ArrayList<Fotograma> fotogramas) {
        this.capacidad = capacidad;
        this.fotogramas = fotogramas;
    }

    public CapacidadGrafica getCapacidad() {
        return capacidad;
    }

    public ArrayList<Fotograma> getFotogramas() {
        return fotogramas;
    }
    
    public Boolean AsignarFotograma(Fotograma fotograma){
        boolean resultado=true;
        if(fotograma.getCapacidad()==capacidad){
            this.fotogramas.add(fotograma);
        }else{
            resultado=false;
        }
        return resultado;
    }
    
   @Override
    public String toString(){
        
        String cadena="Ordenador nuemero de fotogramas asignados: "+fotogramas.size()+" capacidad: "+capacidad;
        for (Fotograma fotograma : fotogramas) {
            
            cadena = cadena + fotograma + "\n";
        }
        
        return cadena;
    }
    
   
}
