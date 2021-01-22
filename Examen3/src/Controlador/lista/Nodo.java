/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.lista;

import Modelo.Auto;


/**
 *
 * @author uwu
 */
public class Nodo {

    private Auto dato;
    private Nodo sig; 

    public Nodo() {
        this.dato = null;
        this.sig = null;
    }

    public Nodo(Auto dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public Auto getDato() {
        return dato;
    }

    public void setDato(Auto dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

}
