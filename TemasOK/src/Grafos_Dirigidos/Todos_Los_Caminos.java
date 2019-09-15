package Grafos_Dirigidos;

public class Todos_Los_Caminos {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/aeropuertos.txt",
                "./src/grafos_dirigidos/conexiones.txt",
                false, 
                TGrafoDirigido.class);
        
        System.out.println("+++ TODOS LOS CAMINOS SIN PARAMETROS +++");
        Comparable origen = "Montevideo";
        Comparable destino = "Rio_de_Janeiro";
        TCaminos caminos = gd.todosLosCaminos(origen,destino);
        caminos.imprimirCaminosConsola();
        
        System.out.println("\n\n+++ GRAFO CON CICLOS +++");
        if (gd.tieneCiclo()){
            System.out.println("El grafo tiene ciclos.");
        }else{
            System.out.println("El grafo NO tiene ciclos.");
        }
        
        
        TGrafoDirigido gd2 = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/asignaturas.txt",
                "./src/grafos_dirigidos/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        System.out.println("\n");
        System.out.println("+++ EL CAMINO MAS BARATO +++");
        Comparable pri = "INICIO";
        Comparable fin = "SO";
        TCaminos caminos2 = gd2.todosLosCaminos(pri, fin);
        caminos2.imprimirCaminosConsola();
        System.out.println("CAMINO BARATO: "+gd2.caminoMasCorto(pri, fin).imprimirEtiquetas());
    }
}
