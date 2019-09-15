package Secuencia_Critica;

public class SecuenciaCriticaTareas {

    public static void main(String[] args) {
        TProceso proceso  = (TProceso) UtilGrafos.cargarGrafo(
                "src/secuencia_critica/tasks.txt",
                "src/secuencia_critica/links.txt",
                false, TProceso.class);

        proceso.obtenerSecuenciaCritica();
        //System.out.println(proceso.getVertices().get("Start").getDatos());
    }
}
