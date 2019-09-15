package Grafos_Dirigidos;

public class Matrices_Costos_Centro {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/aeropuertos_1.txt",
                "./src/grafos_dirigidos/conexiones_1.txt",
                false, 
                TGrafoDirigido.class
        );

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();
        Double[][] costos = gd.getMatriz_costos();
        UtilGrafos.imprimirMatrizMejorado(costos, gd.getVertices(),
                "************************************************************************** "
                        + "MATRIZ DE COSTOS "
                        + "******************************************************************************"); 
        System.out.println();
       
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "************************************************************************** "
                + "MATRIZ DE FLOYD "
                + "*******************************************************************************");
        
        System.out.println();
        
        for (int i = 0; i < etiquetasarray.length; i++){
            Comparable vertice = etiquetasarray[i].toString().trim();
            System.out.println("EXCENTRICIDAD DE "+vertice+": " + gd.obtenerExcentricidad(vertice));
        }
        System.out.println();
        
        System.out.println("CENTRO DEL GRAFO: " + gd.centroDelGrafo());
        System.out.println();
        
        UtilGrafos.imprimirMatrizBooleanos(gd.getMatriz_warshall(), gd.getVertices(), "************************************************************************** "
                + "MATRIZ DE WARSHALL "
                + "****************************************************************************");
        
        
        System.out.println("\n");
        System.out.println("++++ EXISTE CONEXION ENTRE DOS DESTINOS ++++");
        Comparable i = "Montevideo";
        Comparable f = "Asuncion";
        boolean existe=gd.existeConexion(i,f);
        System.out.println("Existe conexion entre "+i+" y "+f+"? "+ existe);

    }
}
