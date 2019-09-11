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
public class MainPD1 {
     public static void main(String[] args) {
         
        System.out.println("Claves : {1,2,3,4,5,6,7,8,9,10}");
        int[] claves = {1,2,3,4,5,6,7,8,9,10};
        int[] comparaciones = {0};
        System.out.println("Busqueda lineal del 5: ");
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves, 5));
        System.out.println("Busqueda binaria del 5: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves, 5, 0, claves.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
        System.out.println("");
        System.out.println("");
        comparaciones[0] = 0;
        System.out.println("Busqueda lineal del 0: ");        
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves, 0));
        System.out.println("Busqueda binaria del 0: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves, 0, 0, claves.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
        System.out.println("");
        System.out.println("");
        
        comparaciones[0] = 0;
        System.out.println("Busqueda lineal del 9: ");
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves, 9));
        System.out.println("Busqueda binaria del 9: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves, 9, 0, claves.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
        
        System.out.println("");
        System.out.println("");
        System.out.println("Claves : {1,2,3,5,6,7,8,10,25,26,28,43,144,155,178,199,200}");
        int[] claves2 = {1,2,3,5,6,7,8,10,25,26,28,43,144,155,178,199,200};
        System.out.println("Busqueda lineal del 28: ");
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves2, 28));
        System.out.println("Busqueda binaria del 28: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves2, 28, 0, claves2.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
        System.out.println("");
        System.out.println("");
        comparaciones[0] = 0;
        
        
        System.out.println("Busqueda lineal del 1000: ");        
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves2, 1000));
        System.out.println("Busqueda binaria del 1000: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves2, 1000, 0, claves2.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
        System.out.println("");
        System.out.println("");
        
        
        comparaciones[0] = 0;
        System.out.println("Busqueda lineal del 178: ");
        System.out.println(BusquedaLinealBinaria.busquedaLineal(claves2, 178));
        System.out.println("Busqueda binaria del 178: ");
        System.out.println(BusquedaLinealBinaria.busquedaBinaria(claves2, 178, 0, claves2.length,comparaciones));
        System.out.println("Cantidad de comparaciones realizadas: " + comparaciones[0]);
    }
}
