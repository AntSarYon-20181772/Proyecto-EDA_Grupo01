/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mis.clases;

import archivos.pilas.Pila;

// @author ANTONIO

public class clienteCorporativo {
    private String RUC;
    private String razonSocial;
    private Pila listaComprobantes;

    public clienteCorporativo(String RUC, String razonSocial, Pila listaComprobantes) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.listaComprobantes = listaComprobantes;
    }

    public String getRUC() {
        return RUC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
   
    public Pila getListaComprobantes() {
        return listaComprobantes;
    }

    
   //--------------------------------------------------------
    public int calcularTarifaFinal_Giros()
    {
        int total = 0;
        Pila aux = new Pila();
        
        while(!listaComprobantes.estaVacia())
        {
            comprobante c = listaComprobantes.desapilar();
            
            if(c.getTipo().equals("Giro"))
                {total = total + c.getMonto();}
            
            aux.apilar(c);
        }
        
        while(!aux.estaVacia())
            {listaComprobantes.apilar(aux.desapilar());}
        
        return total;
    }
    
    //----------------------------------------------------
    public int calcularTarifaFinal_Encomiendas()
    {
        int total = 0;
        Pila aux = new Pila();
        
        while(!listaComprobantes.estaVacia())
        {
            comprobante c = listaComprobantes.desapilar();
            
            if(c.getTipo().equals("Encomienda"))
                {total = total + c.getMonto();}
            
            aux.apilar(c);
        }
        
        while(!aux.estaVacia())
            {listaComprobantes.apilar(aux.desapilar());}
        
        return total;
    }
    
    //-----------------------------------------------------
    public void apilarComprobante(comprobante C)
        {listaComprobantes.apilar(C);}

   
    //-------------------------------------------------------
    public int contarComprobantes()
    {
        int contador = 0;
        Pila aux = new Pila();
        
        while(!listaComprobantes.estaVacia())
        {
            comprobante c = listaComprobantes.desapilar();
            contador++;
            aux.apilar(c);
        }
        while(!aux.estaVacia())
            {listaComprobantes.apilar(aux.desapilar());}
        
        return contador;
    }
    
    public String toString() {
        
        String cad = "\nCLIENTE: " + 
                "\nRUC:" + RUC + 
                "\nrazonSocial: " + razonSocial + 
                "\n\n Lista de Comprobantes: " + "\n\n";
        
        cad = cad + listaComprobantes.mostrarElementos() + "\n";
        
        return cad;
    }

   
    
    
    }
    
    
    
    
    

