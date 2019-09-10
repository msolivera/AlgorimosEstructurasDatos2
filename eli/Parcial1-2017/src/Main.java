
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
       String[] telefonosyNombre = ManejadorArchivosGenerico.leerArchivo("src/abonados.txt");
       String[] codigos = ManejadorArchivosGenerico.leerArchivo("src/abonados.txt");
       for(String info : telefonosyNombre){
           String[] corte = info.split(",");
           trie.insertar(new TAbonado(corte[1],corte[0]));
       }
       
        String codigoPais = codigos[0].split(":")[1].trim(); // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = codigos[1].split(":")[1].trim() ;// utilizar el indicado en el archivo "codigos.txt"
        
        LinkedList<TAbonado> resultado  = trie.buscarTelefonos(codigoPais, codigoArea);
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        //ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",.....);
        
    }
}