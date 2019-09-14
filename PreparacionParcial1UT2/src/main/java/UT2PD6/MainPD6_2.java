/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD6;

import java.util.LinkedList;

/**
 *
 * @author Micaela
 */
public class MainPD6_2 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        
        String cadena = "ccttgacttgc";
        TArbolTrie2 arbol = new TArbolTrie2();
        arbol.agregarSufijos(cadena);
        
        LinkedList patronCT = arbol.buscarPatron("ct");
        System.out.println(patronCT);
        
        LinkedList patronTG = arbol.buscarPatron("tg");
        System.out.println(patronTG);
        
        
        System.out.println("\nEjercicio 2\n");
        
        String secuencia = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT2PD6/secuencia.txt")[0];
        
        TArbolTrie2 arbol2 = new TArbolTrie2();
        arbol2.agregarSufijos(secuencia);
        
        LinkedList patronCCTA = arbol2.buscarPatron("ccta");
        LinkedList patronGGTCA = arbol2.buscarPatron("ggtca");
        LinkedList patronAACCT = arbol2.buscarPatron("aacct");
        
        System.out.println("Patron ccta: "+patronCCTA);
        System.out.println("Patron ggtca: "+patronGGTCA);
        System.out.println("Patron aacct: "+patronAACCT);
    }
}
