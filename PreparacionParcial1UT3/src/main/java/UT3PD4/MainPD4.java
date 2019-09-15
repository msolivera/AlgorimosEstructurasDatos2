/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD4;

/**
 *
 * @author Micaela
 */
public class MainPD4 {
   public static void main(String[] args){
      Ocurrencias ocu = new Ocurrencias();
      String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT3PD3/libro.txt");  
      ocu.insertConOcurrencias(lineas);
      ocu.imprimirConOcurrencias();
      String[] escribir = ocu.escribirReady();
      
      ManejadorArchivosGenerico.escribirArchivo("src/main/java/UT3PD4/Ocurrencias.csv", escribir);
      
   } 
}
