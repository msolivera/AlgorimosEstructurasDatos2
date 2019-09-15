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
public class Clasificacion_Topologica {
    public static void main(String[] args) {
        //System.out.println("+++ NUEVO GRAFO DIRIGIDO INVERTIDO +++");
        TGrafoDirigido gdInvertido = (TGrafoDirigido) UtilGrafos.cargarGrafoInvertido(
                "./src/grafos_dirigidos/asignaturas.txt", 
                "./src/grafos_dirigidos/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/asignaturas.txt", 
                "./src/grafos_dirigidos/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        System.out.println("\n");
        System.out.println("+++ ORDEN TOPOLOGICO +++");
        Comparable ini = "SO";
        TVertice inicio = gd.buscarVertice(ini);
        gd.imprimirTopologico(gd.ordenTopologico());
        gdInvertido.imprimirTopologico(gdInvertido.ordenTopologico());
        
        System.out.println("\n");
        System.out.println("+++ ORDEN PREVIATURAS +++");
        Comparable ini2 = "PROYECTO";
        TVertice inicio2 = gdInvertido.buscarVertice(ini2);
        gdInvertido.ordenPreviaturas(inicio2);
        
        if (gd.esConexo()){
            System.out.println("es conexo");
        }else{
            System.out.println("no es conexo");
        }
    }
    
}
