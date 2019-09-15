package Grafos_Dirigidos;

public class Numero_Bacon {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/grafos_dirigidos/asignaturas.txt", 
                "./src/grafos_dirigidos/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        Comparable origen = "SO";
        System.out.println(gd.numeroBacon(origen));
    }
}
