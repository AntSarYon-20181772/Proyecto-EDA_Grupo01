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
public class Pila{
    
    private ListaEnlazada lista;
    
    public Pila(){
        lista = new ListaEnlazada();
    }
    
    //- - - - - - - - - - - - - -
    
    public boolean estaVacia()
    {
        return (lista.getL() == null);
    }
    
    //--------------------------------------------------
    public void apilar(comprobante valor)
    {
        lista.insertarAlInicio(valor);
    }
    
    //--------------------------------------------------
    public comprobante desapilar()
    {
        comprobante respuesta = null;
        
        if(!this.estaVacia())
        {
            //Obtener el valor del primer elemento (cima)
            respuesta = lista.getL().info();
            //Eliminar el primer elemento (cima)
            lista.eliminarInicio();
        }
        
        return respuesta;
    }
    
    //--------------------------------------------------
    public String mostrarElementos()
    {
        String cad = "____CIMA___\n ";
        cad = cad + lista.mostrarElementos();
        cad = cad + "____BASE___\n ";
        
        return cad;
    }
    
    
}
