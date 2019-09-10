package Domiciliarios.UT3.OTROS;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Bruno Martinez
 */
public class Ejercicio4 {
    public static void main(String[] args){
        Ejercicio4 ej = new Ejercicio4();
        ej.imprimir("src/Domiciliarios/UT3/OTROS/libro.txt", 50);
    }
    
    public void imprimir(String nombreArchivo, int cantidadLineasAimprimir){
        Random random = new Random();
        List<String> lineas = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (int i = 0; i < cantidadLineasAimprimir; i++) {
            Integer valorRandom = random.nextInt(lineas.size() -1);
            System.out.println(lineas.get(valorRandom));
        }
        
        
        
    }
}
