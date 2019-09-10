

import java.util.Collection;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS DISPOSITIVOS PARTIR DEL ARCHIVO DISPOSITIVOS.TXT
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/dispositivos.txt");
        String[] datos;
        TDispositivo dispositivo;
        String ip;
        String nombre;
        for(String linea:lineas){
            datos = linea.split(",");
            
            ip = datos[0];
            nombre = datos[1];
            
            dispositivo = new TDispositivo(ip, nombre, "");
            
            trie.insertar(dispositivo);
        }
        
        
        String subRed = "141." ; // utilizar el indicado en el archivo "subredes.txt"
        
        Collection<TDispositivo> dispositivos = trie.buscarDispositivos(subRed);
        
        
        subRed = "005.116." ; // utilizar el indicado en el archivo "subredes.txt"
        
        Collection<TDispositivo> dispositivos2 = trie.buscarDispositivos(subRed);
        
        // crear el archivo "salida.txt", con los dispositivos(1 por linea) 
        // correspondientes a la subred indicada
        // imprimir Nombre y dirección de  IP, 
        String[] resultados = new String[dispositivos.size() + dispositivos2.size()];
        int i = 0;
        for(TDispositivo d : dispositivos){
            resultados[i] = d.getNombre()+","+d.getDirIP();
            i++;
        }
        for(TDispositivo d : dispositivos2){
            resultados[i] = d.getNombre()+","+d.getDirIP();
            i++;
        }
        
        
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",resultados);
        
    }
}