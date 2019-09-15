package Parcial1.HashMap;

import java.util.Collection;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

       // CARGAR EN EL TRIE LOS DISPOSITIVOS PARTIR DEL ARCHIVO DISPOSITIVOS.TXT
       // Mi estructura no guardará el punto de las direcciones IP.
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/parcial1/hashmap/dispositivos.txt");
       
        for(String s: lineas){
           String[] split = s.split(",");                     
           TDispositivo aux = new TDispositivo(split[0], split[1]);
           trie.insertar(aux);
        }
        String subRed = "141." ; // utilizar el indicado en el archivo "subredes.txt"       
        String subRed2 = "005.116.";
        Collection<TDispositivo> dispositivos = trie.buscarDispositivos(subRed);
        Collection<TDispositivo> dispositivos2 = trie.buscarDispositivos(subRed2);
        
        // crear el archivo "salida.txt", con los dispositivos(1 por linea) 
        // correspondientes a la subred indicada
        // imprimir Nombre y dirección de  IP, 
        String[] salida = new String[dispositivos.size() + dispositivos2.size()];
        int i = 0;
        for(TDispositivo t: dispositivos){
            salida[i] = t.getNombre()+","+t.getDirIP();
            i++;
        }        
        for(TDispositivo t: dispositivos2){
            salida[i] = t.getNombre()+","+t.getDirIP();
            i++;
        } 
        
        ManejadorArchivosGenerico.escribirArchivo("./src/parcial1/hashmap/salida.txt",salida);
        
    }
}