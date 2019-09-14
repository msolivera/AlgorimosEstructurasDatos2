/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Manuel
 */
public class UT1Domiciliario1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Busquedas busqueda = new Busquedas();
        int[] array = new int[] {2,5,8,10,11,13,14,15,17,20,22,23,24,26,27,29,30};
        Random ran = new Random();
        int aleatorio = 0;
        
        for (int i=0; i<20; i++)   //Evaluamos 20 casos
        {
          aleatorio = ran.nextInt(30);
          busqueda.busquedaLineal(array, aleatorio);
          busqueda.busquedaBinaria(array, aleatorio);
        }
        
        ArrayList<Integer> exitosLineales = busqueda.comparacionesLinealesExitosas;
        ArrayList<Integer> exitosBinarios = busqueda.comparacionesBinariasExitosas;
        ArrayList<Integer> fracasosLineales = busqueda.comparacionesLinealesFracasos;
        ArrayList<Integer> fracasosBinarios = busqueda.comparacionesBinariasFracasos;
        
        int promedioExitosLineales = 0;
        int promedioExitosBinarios = 0;
        for (int i=0; i<exitosLineales.size()-1; i++)
        {
            promedioExitosLineales+= exitosLineales.get(i);
            promedioExitosBinarios+= exitosBinarios.get(i);
        }
        promedioExitosLineales = promedioExitosLineales / exitosLineales.size();
        promedioExitosBinarios = promedioExitosBinarios / exitosBinarios.size();
        
        
        int promedioFracasosLineales = 0;
        int promedioFracasosBinarios = 0;
        for (int i=0; i<fracasosLineales.size()-1; i++)
        {
            promedioFracasosLineales+= fracasosLineales.get(i);
            promedioFracasosBinarios+= fracasosBinarios.get(i);
        }
        promedioFracasosLineales = promedioFracasosLineales / fracasosLineales.size();
        promedioFracasosBinarios = promedioFracasosBinarios / fracasosBinarios.size();
        
        
        System.out.println("BUSCAMOS 20 NÚMEROS ALEATORIOS EN UN VECTOR DE 17 ELEMENTOS");
        System.out.println("\n**************RESULTADOS****************");
        System.out.println("\nPROMEDIO DE COMPARACIONES EN CASOS DE ÉXITO:");
        System.out.println("En búsquedas lineales: "+promedioExitosLineales);
        System.out.println("En búsquedas binarias: "+promedioExitosBinarios);
        
        System.out.println("\nPROMEDIO DE COMPARACIONES EN CASOS DE FRACASO:");
        System.out.println("En búsquedas lineales: "+promedioFracasosLineales);
        System.out.println("En búsquedas binarias: "+promedioFracasosBinarios);
    }
    
}
