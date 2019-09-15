/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos_No_Dirigidos;

/**
 *
 * @author jsilva
 */
public class BEA {
    public static void main(String[] args) {
        TGrafoNoDirigido gnd2 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_no_dirigidos/verticesBEA.txt", 
                "./src/grafos_no_dirigidos/aristasBEA.txt",
                false, 
                TGrafoNoDirigido.class);
        
        System.out.println("\n");
        System.out.println("BEA SIN PARAMETROS\n"+gnd2.bea());
        System.out.println("\n");
        Comparable origen = "d";
        System.out.println("BEA CON ORIGEN\n"+gnd2.bea(origen));        
    }
}
