package parcial2017;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Bruno Garcia
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] datos = ManejadorArchivosGenerico.leerArchivo("src/parcial2017/abonados.txt");
        Abonado abonado;
        
        TTrie arbol = new TTrie();
        
        for(String dato:datos){
            String[] datosAbonado = dato.split(",");
            abonado = new Abonado(datosAbonado[1], datosAbonado[0]);
            arbol.insertar(abonado);
        }
        
        TreeMap<String, Abonado> resultados = arbol.buscarTelefonos("054", "90");
        String[] resLineas = new String[resultados.size()];
        int i = 0;
        
        for(Map.Entry<String, Abonado> elemento : resultados.entrySet()){
            resLineas[i++] = elemento.getKey() + "," + elemento.getValue().getTelefono();
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/parcial2017/salida.txt", resLineas);
    }
    
}
