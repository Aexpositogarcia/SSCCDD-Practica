/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_1;

import java.awt.Component;
import java.util.Random;

/**
 *
 * @author alber
 */
public class HiloPrincipal {

    /**
     * @param args the command line arguments
     */
    final static int NUM_ORDENADORES = 10;
    final static int NUM_COMPONENTES = 20;

    public enum TipoComponente {
        CPU(25), GRAFICA(50), RATON(100);

        int valor;

        private TipoComponente(int valor) {
            this.valor = valor;
        }
        //Obtenemos un Componente alatorio gracias al valor del enum 
        public static TipoComponente ObtenerComponente(int valor){
            
            TipoComponente resultado=null;
            TipoComponente[] todosloscomponentes=TipoComponente.values();
            int i=0;
            
            while ((i<todosloscomponentes.length) && (resultado==null)) {
            if(todosloscomponentes[i].valor >= valor){
                resultado=todosloscomponentes[i];
            }
                
             i++;
            }
           
                    
            return resultado;
        }

    }

    public static void main(String[] args) {
        
        Random aleatorio=new Random();
        Ordenador[] listaOrdenadores;
        Vendedor[] listaVendedores;
        TipoComponente[] listacomponentes=TipoComponente.values();
        
        System.out.println("Se inicio Hilo Principal");
        
        //Inicializar Los vectores
        listaOrdenadores=new Ordenador[NUM_ORDENADORES];
        for (int i = 0; i < NUM_ORDENADORES; i++) {
            
            listaOrdenadores[i]=new Ordenador();
            listaOrdenadores[i].setId(i);
            
        }
        
        listaVendedores=new Vendedor[listacomponentes.length];
        for (int i = 0; i < listacomponentes.length ; i++) {
         
            listaVendedores[i]=new Vendedor(i+1, listacomponentes[i]);
        
        }
     
        int i=0;
        while(i<NUM_COMPONENTES){
            int valor=aleatorio.nextInt(101);
            //Seleccionamos un vendedor para el ordenadorcon un componente asociado para eso obtenemos el componente al azar y
            //con ordinal sacamos que posicion es teniendo asi el mismo vendedor y el mismo numero de componente
            Vendedor vendedor=listaVendedores[TipoComponente.ObtenerComponente(valor).ordinal()];
           
            int OrdenadorSeleccionado=aleatorio.nextInt(NUM_ORDENADORES);
            
            if(listaOrdenadores[OrdenadorSeleccionado].addComponente(vendedor)){
                i++;
            }else{
                System.out.println("[HILO PRINCIPAL] Ya tiene este componente el ordenador: "
                        +listaOrdenadores[OrdenadorSeleccionado].getId()+ " ya tiene este componente "+vendedor.getId());
                
            }
            
        }
        
        System.out.println("(HILO_PRINCIPAL) Lista de pedidos de ordenadores");
        for( Ordenador ordenador : listaOrdenadores )
            System.out.println(ordenador);
        
        System.out.println("Ha finalizado la ejecución el Hilo(PRINCIPAL)");
                
    }

}
