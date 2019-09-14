/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD2;

/**
 *
 * @author Micaela
 */
public class MainPD2 {
    
   public static void main(String[] args) {
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT2PD2/palabras-paginas.txt");
        TArbolTrie trie = new TArbolTrie();
        for (String linea : palabrasclave) {
            
            String[] aux = linea.split(",");
            
            trie.insertar(aux[0], Integer.parseInt(aux[1].trim()));
        }
        
        trie.imprimir();
//      String l = "000.111.555.";
//      System.out.println(l.split(".").length);
        trie.paginasDePalabra("ala");
    } 
}
