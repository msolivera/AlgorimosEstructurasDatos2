/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos_Dirigidos;

/**
 *
 * @author jsilva
 */
public class CaminoCriticoMain {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/actividades.txt", 
                "./src/grafos_dirigidos/dependencias_actividades.txt",
                false, 
                TGrafoDirigido.class);
        
        //Object[] etiquetasarray = gd.getEtiquetasOrdenado();
        if (gd.tieneCiclo()) {
            System.out.println("ATENCIÓN: El grafo tiene ciclos");
        } else {
            System.out.println("El grafo NO tiene ciclos");
        }
        
        Comparable origen = "Inicio";
        Comparable destino = "Fin";
        gd.caminoCritico(origen, destino);
    }
}
