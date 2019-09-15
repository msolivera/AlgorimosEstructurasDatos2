package Grafos_Dirigidos;

import java.util.Collection;

public class BPFs {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/aeropuertos.txt",
                "./src/grafos_dirigidos/conexiones.txt",
                false, 
                TGrafoDirigido.class
        );
    
        System.out.println("+++ ES CONEXO MEDIANTE BPF +++");
        if (gd.esConexo())
            System.out.println("El grafo dirigido es conexo.");
        else
            System.out.println("El grafo dirigido NO es conexo.");
        
        System.out.println("\n");
        System.out.println("+++ BPF COMPLETO +++");
        Collection lista = gd.bpf();
        System.out.println(lista);
        
        System.out.println("\n");
        System.out.println("+++ BPF  DESDE ORIGEN +++");
        Comparable origen = "Montevideo";
        Collection lista2 = gd.bpf(origen);
        System.out.println(lista2);
        
        System.out.println("\n");
        System.out.println("+++ BPF  DESDE TVERTICE ORIGEN +++");
        TVertice ori = new TVertice("Montevideo");
        Collection lista3 = gd.bpf(ori);
        System.out.println(lista3);
        
        System.out.println("\n");
        System.out.println("+++ BPF  DESDE ETIQUETA ORIGEN HASTA DESTINO +++");
        origen = "Montevideo";
        Comparable destino = "San_Pablo";
        System.out.println("EXISTE CAMINO ENTRE '"+origen.toString().trim()+
                "' HASTA '"+destino.toString().trim()+"' ?");
        Collection lista5 = gd.bpf(origen,destino);
        System.out.println(lista5);
    }
    
    
}
