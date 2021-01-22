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
public class TablaPlaca extends AbstractTableModel {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private Auto[] auto;

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    public Auto[] getAuto() {
        return auto;
    }

    public void setAuto(Auto[] auto) {
        this.auto = auto;
    }


    @Override
    public int getRowCount() {
        return auto.length;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
         Auto a = lista.verDato(row);
         Auto as = auto[row];
         switch(column){
             case 0:
                 return as.getPlaca();
             case 1:
                 return as.getPersona().getNombre();
             case 2:
                 return as.getPersona().getApellido();
             default:
                 return null;
         }
    }
    
     
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: 
                return  "Placa";
            case 1: 
                return  "Nombre";
            case 2:
                return  "Apellido";
            default: 
                return null;
        }
    }
    
}
