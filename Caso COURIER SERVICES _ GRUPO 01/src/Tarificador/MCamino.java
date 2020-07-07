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
public class MCamino {
    
    public int Floyd(int [][] matriz, int caminoA ,int caminoB)
    {
        int vertices = matriz.length;
        int matrizAdyacencia[][]= matriz;
        
        int temporal1;
        int temporal2;
        int temporal3;
        int temporal4;
        int minimo;
        
        for(int k=0;k<vertices;k++)
        {
            for(int i=0;i<vertices;i++)
            {
                for(int j=0;j<vertices;j++)
                {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    
                    temporal4 = temporal2+temporal3;
                    minimo = Math.min(temporal1, temporal4);
                    
                    matrizAdyacencia[i][j] = (int)minimo;
                }
            }
        }
        caminoA--;
        caminoB--;
        
        return matrizAdyacencia[caminoA][caminoB];
    }
}
