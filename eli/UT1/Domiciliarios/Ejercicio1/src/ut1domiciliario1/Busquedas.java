/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1domiciliario1;

import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class Busquedas {
    
    ArrayList<Integer> comparacionesLinealesExitosas = new ArrayList<Integer>();
    ArrayList<Integer> comparacionesBinariasExitosas = new ArrayList<Integer>();
    ArrayList<Integer> comparacionesLinealesFracasos = new ArrayList<Integer>();
    ArrayList<Integer> comparacionesBinariasFracasos = new ArrayList<Integer>();
    
    public boolean busquedaLineal (int[] array, int valor)
    {
        int comparaciones = 0;
        for (int i=0; i<array.length; i++)
        {
          comparaciones+=1;
          if (array[i]==valor)
          {
              comparacionesLinealesExitosas.add(comparaciones);
              return true;
          }
        }
        comparacionesLinealesFracasos.add(comparaciones);
        return false;
    }
    
    
    
    
    public boolean busquedaBinaria (int[] array, int valor)
    {
        int comparaciones = 0;
        int inicio = 0;
        int fin = array.length-1;
           
        while (inicio <= fin)
        {
            int mitad = (fin+inicio)/2;
            comparaciones+=1;
            
            if (valor == array[mitad])
            {
                comparacionesBinariasExitosas.add(comparaciones);
                return true;
            }
            
            else if (valor > array[mitad])
            {
                inicio = mitad+1;
            }
            
            else if (valor < array[mitad])
            {
                fin = mitad-1;
            }
        }
        
        comparacionesBinariasFracasos.add(comparaciones);
        return false;
    }
    
}
