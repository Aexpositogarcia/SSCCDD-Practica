/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uja.ssccdd.curso2021.ssccdd_1_1;

import com.uja.ssccdd.curso2021.ssccdd_1_1.HiloPrincipal.TipoComponente;

/**
 *
 * @author alber
 */
public class Vendedor {
    
    private int id;
    private TipoComponente componente;

    public Vendedor(int id, TipoComponente componente) {
        this.id = id;
        this.componente = componente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoComponente getComponente() {
        return componente;
    }

    public void setComponente(TipoComponente componente) {
        this.componente = componente;
    }
    
    @Override
    public String toString() {
        return "VENDEDOR Id: "+id+" componente: "+componente;
    }
}
