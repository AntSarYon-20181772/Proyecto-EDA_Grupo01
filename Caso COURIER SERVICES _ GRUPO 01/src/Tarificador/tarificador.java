/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tarificador;

/**
 *
 * @author ANTONIO
 */
public class tarificador {
    
    private static final int tarifaKM = 45 ;

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    public int reemplazarLetraxNumero(String letra)
    {
        int valor = 0;
        
        if(letra.equals("A"))
            {valor = 1;}
        
        else if(letra.equals("B"))
            {valor = 2;}
        
        else if(letra.equals("C"))
            {valor = 3;}
        
        else if(letra.equals("D"))
            {valor = 4;}
        
        else if(letra.equals("E"))
            {valor = 5;}
        
        return valor;
    }
    
  
    public int calcularMonto(String Origen, String Destino)
    {
        int[][] MDistancias =       //  A      B       C      D      E
                                 /*A*/ {{0,    100,    60,    250,    180}, 
                                 /*B*/  {100,  0,      999999999,    100,    75}, 
                                 /*C*/  {60,   999999999,     0,     150,    100}, 
                                 /*D*/  {250,  100,    150,   0,      999999999}, 
                                 /*E*/  {180,  75,     100,   999999999,     0}};
        
        MCamino camino = new MCamino();
        
        int nOrigen = reemplazarLetraxNumero(Origen);
        int nDestino = reemplazarLetraxNumero(Destino);
        
        int distancia = camino.Floyd(MDistancias, nOrigen, nDestino);
        
        System.out.println(distancia);
        
        return distancia*tarifaKM;
    }
}
