package Parcial1.Tabla;

import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS DISPOSITIVOS PARTIR DEL ARCHIVO DISPOSITIVOS.TXT
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/parcial1/tabla/dispositivos.txt");
        for(String l:lineas){
            String ip = l.split(",")[0];
            String dev = l.split(",")[1];
            
            ip=ip.trim();
            dev=dev.trim();
            if (ip!=null && dev != null){
                TDispositivo d = new TDispositivo(ip,dev);
                //System.out.println("ANTES: "+d.getDirIP()+" - "+d.getNombre());
                //System.out.println("ANTES: "+(d.getDirIP().charAt(0)-'0')+" - "+(d.getDirIP().charAt(1)-'0')+" - "+(d.getDirIP().charAt(2)-'0'));
                trie.insertar(d);
                //System.out.println("INSERTADO: "+ip+" - "+dev);
            }
        }
        String subRed = "141." ; // utilizar el indicado en el archivo "subredes.txt"
        
        Collection<TDispositivo> dispositivos = trie.buscarDispositivos(subRed);
        String[] lin = trie.ordenarSalida(dispositivos);
        
        //Grabar en archivo la salida obtenida
        boolean append = false;
        ManejadorArchivosGenerico.escribirArchivo("./src/parcial1/tabla/salida.txt",lin,append);
        
        subRed = "005.116." ; // utilizar el indicado en el archivo "subredes.txt"
        Collection<TDispositivo> dispositivos2 = trie.buscarDispositivos(subRed);
        
        lin = trie.ordenarSalida(dispositivos2);
        //Grabar en archivo la salida obtenida
        append = true;
        ManejadorArchivosGenerico.escribirArchivo("./src/parcial1/tabla/salida.txt",lin,append);            
    }
}