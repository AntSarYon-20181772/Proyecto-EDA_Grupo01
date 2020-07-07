/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miGestion;

import archivos.colas.Cola;
import archivos.pilas.ListaEnlazada;
import archivos.pilas.Nodo;
import archivos.pilas.Pila;
import mis.clases.clienteCorporativo;
import mis.clases.comprobante;

/**
 *
 * @author ANTONIO
 */
public class gestionMensajeria {
    
    private Cola colaClientes;
    private int montoRecaudacionEncomiendas;
    private int montoRecaudacionGiros;

    public gestionMensajeria() {
        colaClientes = new Cola();
        this.montoRecaudacionEncomiendas = 0;
        this.montoRecaudacionEncomiendas = 0;
    }

    public Cola getColaClientes() {
        return colaClientes;
    }

    public int getMontoRecaudacionEncomiendas() {
        return montoRecaudacionEncomiendas;
    }

    public int getMontoRecaudacionGiros() {
        return montoRecaudacionGiros;
    }
    
    //--------------------------------------------
    public String reporteDeRecaudacion()
    {
        int totalEncomiendas = 0;
        int totalGiros = 0;
        
        Cola aux = new Cola();
        
        while(!colaClientes.estaVacia())
        {
            clienteCorporativo cc = colaClientes.desencolar();
            totalGiros = totalGiros + cc.calcularTarifaFinal_Giros();
            totalEncomiendas = totalEncomiendas + cc.calcularTarifaFinal_Encomiendas();
            aux.encolar(cc);
        }
        
        while(!aux.estaVacia())
            {colaClientes.encolar(aux.desencolar());}
        
        return "Monto total recaudado por Giros: " + totalGiros + 
             "\nMonto total recaudado por Encomiendas: " + totalEncomiendas;
    }
    
    //-------------------------------------------------
    public void encolarCliente(clienteCorporativo c)
        {colaClientes.encolar(c);}


    
    //---------------------------------------------------
    public String toString() {
       
        String cad = colaClientes.mostrarElementos();
        return cad;
    }
    
}
