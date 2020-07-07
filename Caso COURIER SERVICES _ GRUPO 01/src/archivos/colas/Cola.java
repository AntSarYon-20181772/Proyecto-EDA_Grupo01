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
public class Cola {
    
    ListaEnlazadaDoble lista;
    
    public Cola(){
        lista = new ListaEnlazadaDoble();
    }
    
    //- - - - - - - - - - - - - -
    
    public boolean estaVacia()
    {
        //Lista vacia: I (nodo inicial) es nulo y F (nodo final) es nulo
        return (lista.getI() == null && lista.getF() == null);
    }
    
    //--------------------------------------------------
    public void encolar(clienteCorporativo dato)
    {
        lista.insertarAlFinal(dato);
    }
    
    //--------------------------------------------------
    public clienteCorporativo desencolar()
    {
        clienteCorporativo respuesta = null;
        
        if(!this.estaVacia())
        {
            respuesta = lista.getI().info;
            lista.eliminarPrimero();
        }
        
        return respuesta;
    }
    
    //--------------------------------------------------
    public String mostrarElementos()
    {
        String cad = "";
        
        cad = "_____FRENTE DE LA COLA_____" + "\n";
        cad = cad + lista.mostrar();
        cad = cad + "_____FINAL DE LA COLA_____" + "\n";
        
        return cad;
    }
}
