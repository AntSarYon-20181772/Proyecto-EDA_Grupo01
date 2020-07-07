/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mis.clases;

 // @author ANTONIO

import Tarificador.tarificador;
import java.text.SimpleDateFormat;
import java.util.Date;



public class comprobante {
    
    private String tipo;
    private String Origen;
    private String Destino;
    private Date FechaEmision;
    private tarificador tarificador;
    private int monto;
    

    public comprobante(String tipo, String Origen, String Destino) {
        
        this.tipo = tipo;
        this.Origen = Origen;
        this.Destino = Destino;
        
        this.tarificador = new tarificador();
        this.monto = 0;
        
        this.FechaEmision = new Date();
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }
    
    
    
    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }   
    

    
        public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }
    
    
    
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public void recalcularMonto()
    {
        monto = tarificador.calcularMonto(Origen, Destino);
    }
    
    
    public String toString() {
        return "INFORMACIÓN DE COMPROBANTE: " + 
                "\nTipo: " + tipo + 
                "\nciudadOrigen: " + Origen + 
                "\nciudadDestino: " + Destino + 
                "\nFechaEmision: " + FechaEmision + 
                "\nmonto: " + monto + "\n";
    }
}
