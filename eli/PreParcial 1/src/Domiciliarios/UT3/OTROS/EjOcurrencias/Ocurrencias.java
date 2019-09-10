
package Domiciliarios.UT3.OTROS.EjOcurrencias;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Bruno Martinez
 */
public class Ocurrencias {
    public static void main(String[] args){
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/Domiciliarios/UT3/OTROS/EjOcurrencias/libro.txt");
        HashMap<String,Integer> mapa = new HashMap();
        for(String linea : lineas){
            String[] palabras = linea.split(" ");
            for(String palabra : palabras){
                palabra = palabra.toLowerCase();
                palabra = palabra.replaceAll("[^a-z\\s]", "");               
                if(mapa.containsKey(palabra)){
                   
                    int ocurrencia = mapa.get(palabra).intValue();
                    ocurrencia++;                    
                    mapa.put(palabra, ocurrencia);
                    
                    
                }
                else{
                    
                    mapa.put(palabra,1);
                }
            }
        }
        TreeMap<Integer,String> mapaTree = new TreeMap();
        String[] escribir = new String[mapa.entrySet().size()];
        int contador =0;
        /**
         * Imprimo cada clave con sus ocurrencias
         */
        for(Entry<String,Integer> elemento : mapa.entrySet()){             
            String key = elemento.getKey();
            Integer valor = elemento.getValue();
            System.out.println("Key: "+ key+ " -> Valor : "+ valor.toString());            
            mapaTree.put(valor, key);          
            
        }
        /**
         * Paso a excel para obtener 10 mejores y graficar.
         */
        for(Entry<Integer,String> elemento : mapaTree.entrySet()){
            escribir[contador] = elemento.getValue() + ";" + elemento.getKey();
            contador++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/Domiciliarios/UT3/OTROS/EjOcurrencias/Ocurrencias.csv", escribir);
        
    }
    
}
