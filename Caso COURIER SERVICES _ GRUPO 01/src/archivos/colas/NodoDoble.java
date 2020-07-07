/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos.colas;

import mis.clases.clienteCorporativo;

/**
 *
 * @author ANTONIO
 */
public class NodoDoble {
    
    public clienteCorporativo info;
    public NodoDoble anterior;
    public NodoDoble siguiente;

    
    public NodoDoble(clienteCorporativo dato){
        this.info = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    
    public clienteCorporativo info() {
        return info;
    }

    public NodoDoble anterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble siguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
