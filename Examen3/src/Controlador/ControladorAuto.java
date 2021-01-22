/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.lista.ListaSimpleAvanzada;
import Modelo.Auto;

/**
 *
 * @author uwu
 */
public class ControladorAuto {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private Auto auto = new Auto();

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    public Auto getAuto() {
       if(auto == null){
           this.auto = new Auto();
       }
       return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
     public Auto clonar(){
        Auto s = new Auto();
        s.setMarca(this.auto.getMarca());
        s.setModelo(this.auto.getModelo());
        s.setPlaca(this.auto.getPlaca());
        s.setPersona(this.auto.getPersona());
        return s;
    }
    public boolean guardar(){
        try{
            lista.insertar(clonar(), 0);
            return true;
        }catch(Exception e){
            System.out.println("Null"+e);
            return false;
        }
    }
    
}
