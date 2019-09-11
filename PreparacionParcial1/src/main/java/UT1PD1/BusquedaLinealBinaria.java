/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD1;

/**
 *
 * @author Micaela
 */
public class BusquedaLinealBinaria {
      
    /* Busqueda lineal de una clave en un arreglo.
     * @param claves arreglo de enteros
     * @param valorAbuscar clave a buscar
     * @return true si se encuentra la clave, false en caso contrario
     */
    public static boolean busquedaLineal(int[] claves,int valorAbuscar){
        for (int i = 0; i < claves.length; i++) {
            
            if(claves[i] == valorAbuscar){
                System.out.println("Se ha encontrado el valor!");
                String valor = String.valueOf(i +1) ;
                System.out.println("Cantidad comparaciones realizadas: " + valor);
                return true;
            }
        }
        System.out.println("No se ha encontrado el valor :(");
        System.out.println("Cantidad de comparaciones realizadas: " + claves.length);
        return false;
    }

     /**
     * Busqueda binaria de una clave dentro de un arreglo de enteros
     * @param claves arreglo de enteros
     * @param x clave a buscar
     * @param i indice inicio de arreglo
     * @param j indice final de arreglo
     * @param contadorComparaciones contador de comparaciones realizadas en el metodo.
     * @return true or false dependiendo si se encuentra o no el elemento buscado.
     */
    public static boolean busquedaBinaria(int[] claves, int x , int i, int j,int[] contadorComparaciones){
         contadorComparaciones[0]++;
         int medio;
         if(i>j || i > claves.length -1){
             System.out.println("No se ha encontrado el valor :(");
             return false;
         }
         
         medio = (i+j)/2;
         if(claves[medio] == x){
             System.out.println("Se ha encontrado el valor!");
             return true;
         }
         else if(claves[medio] < x){
             
             return busquedaBinaria(claves,x,medio+1,j,contadorComparaciones);
         
         }
         else{ 
             
             return busquedaBinaria(claves,x,i,medio-1,contadorComparaciones);
         }
    }
}
