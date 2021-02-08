/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_1;

import java.util.Arrays;
import com.uja.ssccdd.curso2021.ssccdd_1_1.Vendedor;
/**
 *
 * @author alber
 */
public class Ordenador {
    
    private int id;
    private final  Vendedor[] componentes;
    
    public Ordenador(){
        this.componentes=new Vendedor[3];
        for (Vendedor vendedor : componentes) {
            vendedor=null;
        }
        this.id=0;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Vendedor[] getVendedor(){
        return componentes;
    }
   

  
    public Boolean addComponente(Vendedor vendedor){
        boolean resultado=false;
        
        if(componentes[vendedor.getComponente().ordinal()]==null){
            
            componentes[vendedor.getComponente().ordinal()]=vendedor;
            resultado=true;
            
        }
        return resultado;
        
    }
    
    @Override
    public String toString(){
        if(OrdenadorCompleto()){
            return "El ordenador con Id "+id+" esta completo, Componentes: "+Arrays.toString(componentes);
        }else{
            return "El ordenador con Id "+id+" esta incompleto";
        }
    }
    
    public Boolean OrdenadorCompleto(){
        boolean resultado=true;
        for (Vendedor componente : componentes) {
            if (componente==null){
                resultado=false;
            }
        }
        return resultado;
    }
}
