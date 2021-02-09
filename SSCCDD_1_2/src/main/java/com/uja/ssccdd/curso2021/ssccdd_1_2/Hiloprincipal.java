/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author alber
 */
public class Hiloprincipal {

    /**
     * @param args the command line arguments
     */
    public static final int NUM_ORDENDADORES=10;
    public static final int NUM_FOTOGRAMAS=20;
    public static final int NUM_CAPACIDADES=CapacidadGrafica.values().length;
    
    public enum CapacidadGrafica{
        
        Basica(25),Medianas(50),Avanzadas(100);
        
        int valor;

        private CapacidadGrafica(int valor) {
            this.valor = valor;
        }
        
        public static CapacidadGrafica AgregarCapacida(int valor){
            
            CapacidadGrafica resultado=null;
            CapacidadGrafica[] listatodascapacidades=CapacidadGrafica.values();
            
            for (CapacidadGrafica capacidad : listatodascapacidades) {
                
                if(capacidad.getValor()>=valor){
                    resultado=capacidad;
                    return resultado;
                }
                
            }
            
            return resultado;
        }

        public int getValor() {
            return valor;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        System.out.println("Inicio del hilo principal");
        Random aleatorio=new Random();
        Ordenador[] listaOrdenadores=new Ordenador[NUM_ORDENDADORES];
  
        //Inicializar los vectores;
        for (int i = 0; i < NUM_ORDENDADORES; i++) {
            int valor=aleatorio.nextInt(101);
            ArrayList<Fotograma> listafotogramas=new ArrayList<>();
            listaOrdenadores[i]=new Ordenador(CapacidadGrafica.AgregarCapacida(valor),listafotogramas);
            
        }
        
        
        Fotograma[] listaFotogramas=new Fotograma[NUM_FOTOGRAMAS];
       
        for (int i = 0; i < NUM_FOTOGRAMAS; i++) {
            int valor=aleatorio.nextInt(101);
            listaFotogramas[i]=new Fotograma(i, CapacidadGrafica.AgregarCapacida(valor));
           
            listaFotogramas[i].getCapacidad();
        }
           
            
        
        
        int i=0;
        while(i<NUM_FOTOGRAMAS){
            int j=0;
            boolean asignado=false;
            Fotograma fotograma=listaFotogramas[i];
            
            while(j<NUM_ORDENDADORES && !asignado){
                if(!listaOrdenadores[j].AsignarFotograma(fotograma)){
                    
                    j++;
                }else{
                    asignado=true;
                }
            }
            i++;
        }        
        
        for (Ordenador ordenador : listaOrdenadores) {
               System.out.println(ordenador.toString());
        }
    }
    
}
