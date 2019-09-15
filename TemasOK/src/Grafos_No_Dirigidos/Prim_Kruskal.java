/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos_No_Dirigidos;

import java.util.Collection;

/**
 *
 * @author jsilva
 */
public class Prim_Kruskal {
    public static void main(String[] args) {        
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_no_dirigidos/verticesBEA.txt", 
                "./src/grafos_no_dirigidos/aristasBEA.txt",
                false, 
                TGrafoNoDirigido.class);
        
               
        System.out.println("\n");
        System.out.println("KRUSKAL\n");
        Collection<TArista> lista = gnd.kruskal();
        Double costo = 0.0;
        for (TArista a : lista){
            System.out.println("Arista: "+a.etiquetaOrigen+"=>"+a.etiquetaDestino+"=>"+a.costo);
            costo += a.costo;
        }
        System.out.println("COSTO del AAM: "+costo);
        TGrafoNoDirigido aam = new TGrafoNoDirigido(gnd.getVertices().values(),lista);
        System.out.println("BPF de AAM: "+aam.bpf());
        System.out.println("\n"); 
        System.out.println("BEA de AAM\n"+aam.bea2());
             
    }
}
