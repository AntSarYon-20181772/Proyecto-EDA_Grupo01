/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos.pilas;

import mis.clases.comprobante;

/**
 *
 * @author ANTONIO
 */
public class Nodo {
    
    private comprobante info;
    private Nodo siguiente;
    
    public Nodo(comprobante info){
        this.info = info;
        this.siguiente = null;
    }
    
    
    public comprobante info(){
        return info;
    }
    
    public Nodo siguiente(){
        return siguiente;
    }
    
    //setter del siguiente Nodo (Permite definirlo)
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
}
