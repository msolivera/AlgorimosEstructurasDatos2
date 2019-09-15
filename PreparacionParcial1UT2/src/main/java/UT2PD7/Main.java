package UT2PD7;

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
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT2PD67/abonados.txt");
        for (String m : abonados){
            
            String aInsertar [] = m.split(",");
            TAbonado abonadoInsertar= new TAbonado(aInsertar[1], aInsertar[0]);
            trie.insertar(abonadoInsertar);
        }
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
          
        String[] resultados = new String[ab.size()];
        int i = 0;
        for (Object persona : ab)
        {
            resultados[i] = persona.toString();
            i++;
        }    
        ManejadorArchivosGenerico.escribirArchivo("src/main/java/UT2PD67/salida.txt",resultados);
        
    }
}