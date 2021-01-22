/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.tabla;

import Controlador.lista.ListaSimpleAvanzada;
import Modelo.Auto;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author uwu
 */
public class TablaAuto extends AbstractTableModel {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private Auto[] auto;

    public Auto[] getAuto() {
        return auto;
    }

    public void setAuto(Auto[] auto) {
        this.auto = auto;
    }

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Auto a = lista.verDato(row);
        switch(column){
            case 0:
                return a.getMarca();
            case 1:
                return a.getModelo();
            case 2:
                return a.getPlaca();
            case 3:
                return a.getPersona().getNombre();
            case 4:
                return a.getPersona().getApellido();
            default: 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: 
                return  "Marca";
            case 1: 
                return  "Modelo";
            case 2: 
                return  "Placa";
            case 3: 
                return  "Nombre";
            case 4:
                return  "Apellido";
            default: 
                return null;
        }
    }
    
}
