/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.lista;

import Modelo.Auto;
import javax.swing.JOptionPane;

public class ListaSimpleAvanzada extends ListaSimple {

    public ListaSimpleAvanzada() {
        super();
    }

    public int tamano() {
        int tamano = 0;
        if (!estaVacio()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSig();
            }
        }
        return tamano;

    }

    public void insertar(Auto dato, int pos) {
        if (estaVacio() || pos <= 0) {
            insertar(dato);
        } else {
            Nodo iterador = this.cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSig() == null) {
                    break;
                }
                iterador = iterador.getSig();
            }
            Nodo tmp = new Nodo(dato, iterador.getSig());
            iterador.setSig(tmp);
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

    public void insertarFinal(Auto dato) {
        insertar(dato, tamano() - 1);
    }

    public Auto obtenerPosicion(int pos) {
        Auto aux = null;
        if (estaVacio() || pos < 0) {
            System.out.println("vacio");
        } else if (pos > (tamano() - 1)) {
            System.out.println("esta fuera del rango");
            throw new ArrayIndexOutOfBoundsException("Esta fuera de rango");
        } else if (pos == 0) {
            aux = verDato(pos);
        } else {
            Nodo iterador = cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSig().getSig() == null) {
                    break;

                }
                iterador = iterador.getSig();
            }
            aux = iterador.getSig().getDato();
        }
        return aux;
    }

    public void Eliminar(String ele) {
        Nodo actual = cabecera;
        Nodo anterior = null;
        while (actual != null) {
            if (actual.getDato().equals(ele)) {
                if (actual == cabecera) {
                    cabecera = cabecera.getSig();
                } else {
                    anterior.setSig(actual.getSig());
                }
            }
            anterior = actual;
            actual = actual.getSig();
        }

    }

    public void EliminarLista() {
        cabecera = null;
    }

    public void EliminarporPosicion(int pos) {
        if (!estaVacio()) {
            if (pos < 0) {
                System.out.println("Debe ser una posicion mayor a cerp");

            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSig();
                } else if (pos <= (tamano() - 1)) {
                    Nodo aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSig();
                    }
                    Nodo siguiente = aux.getSig();
                    aux.setSig(siguiente.getSig());
                } else {
                    System.out.println("No se elimino");
                }
            }
        } else {
            System.out.println("Lista Vacia");
        }

    }

    public void editarPorPosicion(int posicion, Auto dato) {
        if (posicion >= 0 && posicion < tamano()) {
            if (posicion == 0) {
                cabecera.setDato(dato);
            } else {
                Nodo aux = cabecera;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSig();
                }
                aux.setDato(dato);
            }
        } else {
            System.out.println("Fuera de Rango");
        }
    }

    public String QuickSort(Auto auto[],int izq,int der) {
        String pivote = auto[(izq+der)/2].getMarca();
        int i = izq;
        int j = der;
        Auto aux;

        while (i < j) {
            while (auto[i].getMarca().compareTo(pivote) < 0) {
                i++;
            }
            while (auto[j].getMarca().compareTo(pivote) > 0) {
                j--;
            }
            if (i <= j) {
                aux = auto[i];
                auto[j] = auto[i];
                auto[i] = aux;
                i++;
                j--;

            }
            if(izq<j){
                QuickSort(auto, izq, der);
            }
            if(der>1){
                QuickSort(auto, izq, der);
            }
        }
        return pivote;
    }

    /*
    public int busquedaBinaria(Auto auto[], String dato) {
       
        int izq = 0;
        int der = auto.length-1;

        while (izq <= der) {
            int i= (int) Math.floor((izq + der)/2);
            String elMid = auto[i].getMarca();
            int res = dato.compareTo(elMid);
            
            if(res ==0){
                return i;
            }
            if(res <0){
                der = i -1 ;
            }else{
                izq = i+1;
            }
        }
        return -1;
    }*/
   
    public Auto[] pasarArreglo() {
        Auto[] a = new Auto[tamano()];
        Nodo c = cabecera;
        for (int i = 0; i < tamano(); i++) {
            a[i] = verDato(i);
        }
        return a;
    }

    public Auto[] BuscarPorMarca(Auto[] a, String dato) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getMarca().equals(dato)) {
                cont++;
            }
        }
        Auto[] at = new Auto[cont];
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getMarca().equals(dato)) {
                at[contador] = a[i];
                contador++;
            }
        }
        return at;
    }
    public Auto[] BuscarPorPlaca(Auto[] a, String dato) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getPlaca().equals(dato)) {
                cont++;
            }
        }
        Auto[] at = new Auto[cont];
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getPlaca().equals(dato)) {
                at[contador] = a[i];
                contador++;
            }
        }
        return at;
    }

}
