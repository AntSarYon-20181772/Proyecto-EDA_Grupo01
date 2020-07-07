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
public class ListaEnlazada {
 
    private Nodo L; //es el "primer" Nodo

    //Constructor
    public ListaEnlazada(){
        this.L = null;
    }
    
    //getter de L
    public Nodo getL() {
        return L;
    }
    
    
    
    public void insertarAlInicio(comprobante valor){
        
       Nodo nuevoNodo = new Nodo(valor);//Creacion de nodo
        
        if(L == null)//Si el primer nodo de la lista esta vacio, entonces la lista está vacia
        {
            nuevoNodo.setSiguiente(null);//Unico elemento no tiene sucesor
        }
        else //Si no esta vacia
        {
            nuevoNodo.setSiguiente(L); //El nodo sucesor del nuevoNodo sera el primero de la lista original
        }
        
        L = nuevoNodo; //El nodo inicial (L) de la lista enlazada ahora sera nuevoNodo
    }
    
    //----------------------------------------------------------------------------------------------------------------------------
    
    public void insertarAlFinal(comprobante valor){
        
        Nodo nuevoElemento = new Nodo(valor); //Crear nuevo nodo
        
        if(L == null)//Si la lista esta vacia, 
        {
                insertarAlInicio(valor); //insertar al inicio
        }
        else //Si no esta vacia, 
        {
            Nodo ptr = L;   //Se crea un Nodo "puntero" para el recorrido, que se sitúa en el primer nodo
            
            while(ptr.siguiente() != null) //Mientras exista un proximo nodo identificado por el puntero 
            {                              
                    ptr = ptr.siguiente(); //el puntero se desplazará a este próximo Nodo
            }
            
            //Una vez que el próximo nodo a identificar sea Nulo
            ptr.setSiguiente(nuevoElemento);  // El puntero asigna el NuevoNodo a esa posición siguiente
            nuevoElemento.setSiguiente(null); // Ya colocado, el nuevo Ultimo Nodo declara que después de él sigue un espacio Nulo
            
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------

    public String mostrarElementos(){
        
        Nodo ptr = L;   //Se crea un Nodo "puntero" para el recorrido, que se sitúa en el primer nodo
	String cad = "";
        
        while(ptr != null)  //Mientras el puntero se sitúe en un nodo
        {
            cad = cad + ptr.info().toString() + "\n"; //Mostramos la informacion del nodo actual
            ptr = ptr.siguiente();  // Pasamos al siguiente punto (puede o No ser un nodo)
        }
        return cad;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    
    public void insertarAntes(comprobante item, comprobante ref){
        
        Nodo nuevoNodo = new Nodo(item); //Creacion del nuevo nodo
        
        Nodo ptr = L;     //Creación de puntero y posicionamiento en el primer Nodo (L)
        Nodo anterior = null;   //Se crea un nodo contenedor, que contendrá al Nodo previo al puntero
        
        while(ptr != null && ptr.info() != ref) //mientras el puntero se posicione sobre un Nodo, y ese Nodo sea diferente a la referencia
        {
            anterior = ptr; //el Nodo contenedor se iguala al que el puntero está señalando
            ptr = ptr.siguiente(); //el Puntero pasa a la siguiente ubicación
        }
        if(ptr != null) //Si el puntero se posiciona sobre el nodo de Referencia
        {
            if(anterior == null) //Si el anterior a la referencia es Nulo
            {
                insertarAlInicio(item); //El nuevo Nodo se posiciona simplemente al inicio
            }
            else                // Si hay más nodos antes de la Referencia
            {
                anterior.setSiguiente(nuevoNodo); //El nodo contenedor asigna un Nuevo Nodo después del mismo, pero antes de la Referencia
                nuevoNodo.setSiguiente(ptr);   //El NuevoNodo indica que el siguiente Nodo es el que indica el puntero (La referencia)
            }        
        }
    }
    
    //-----------------------------------------------------------------------
    
    public void limpiarLista()
    {
        Nodo ptr = L;
        while (ptr!=null)
        {
            ptr.setSiguiente(null);
            ptr = ptr.siguiente();
        }
    }

    //--------------------------------------------------------------------
    
    public void eliminarInicio(){
        
        if(L != null)
        {
            L = L.siguiente();
        }
    }
    
    //-------------------------------------------------------------
    
    public void eliminarFinal(){
        
        Nodo ptr = L;
        Nodo anterior = null;
        
        if(ptr != null)
        { 
            while(ptr.siguiente() != null)
            { 
                anterior = ptr;
                ptr = ptr.siguiente();
            }
            if(anterior == null){
                eliminarInicio();
            }
            else
            {
                anterior.setSiguiente(null);
            }
        }
    }
    
    //------------------------------------------------------------
    
    public void eliminarElemento(comprobante valor){
        if(L != null)
        {
            if(L.info() == valor)
            {
                eliminarInicio();
            }
            else
            {
                Nodo ptr = L.siguiente();
                Nodo anterior = L;
                while(ptr != null && ptr.info() != valor)
                {
                    anterior = ptr;
                    ptr = ptr.siguiente();
                }
                if(ptr != null)
                {
                    anterior.setSiguiente(ptr.siguiente());                   
                }
            }
        }
    }
}
