/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.lista;

import Modelo.Auto;
import javax.swing.JOptionPane;

/**
 *
 * @author uwu
 */
public class ListaSimple {

    public Nodo cabecera;

    public ListaSimple() {
        this.cabecera = null;
    }

    public boolean estaVacio() {
        return (this.cabecera == null);
    }

    public void insertar(Auto dato) {
        if (dato == null) {
            new NullPointerException("Se debe de agregar una Marca");
        }
        if (!existeMarca(dato.getMarca())) {
            Nodo tmp = new Nodo(dato, null);
            tmp.setSig(cabecera);
            cabecera = tmp; //
        }else{
            JOptionPane.showMessageDialog(null,"Ya existe esa marca");
        }
    }

    public void imprimir() {
        if (!estaVacio()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                System.out.println("..." + tmp.getDato());
                tmp = tmp.getSig();
            }
        } else {
            System.out.println("No contiene datos la lista");
        }
    }

    public Auto verDato(int poss) {
        Auto r = null;
        if (!estaVacio() && poss >= 0) {
            Nodo tmp = cabecera;
            for (int i = 0; i < poss; i++) {
                tmp = tmp.getSig();
                if (tmp == null) {
                    break;
                }
                //System.out.println(tmp.getDato());
            }
            if (tmp != null) {
                r = tmp.getDato();
            }
        }
        return r;
    }

    public boolean existeMarca(String c) {
        boolean existe = false;
        if (!estaVacio()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                if (tmp.getDato().getMarca() == c) {
                    existe = true;
                    break;
                }
                tmp = tmp.getSig();
            }
        }
        return existe;
    }

}
