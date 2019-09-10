package ut3_ta1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta1/claves_insertar.txt");
        Hash t = new Hash(claves.length);
        
        System.out.println("++++ INSERCIONES ++++");
        double promedioComparaciones = 0;
        for (String c : claves) {
            int actual = t.insertar(Integer.parseInt(c));
            System.out.println("Comparaciones al INSERTAR la clave "+c+"-> "+actual);
            promedioComparaciones = promedioComparaciones + actual;
        }
        System.out.println("PROMEDIO DE COMPARACIONES: "+promedioComparaciones/claves.length);

        //Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        String[] claves_buscar = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta1/claves_buscar.txt");
        System.out.println("");
        System.out.println("");
        
        System.out.println("++++ BUSQUEDAS ++++");
        int noExiste=0;
        int existe=0;
        promedioComparaciones = 0;
        for (String c : claves_buscar) {
            int actual = t.buscar(Integer.parseInt(c));
            if (actual==-1)
                noExiste+=1;
            else
                existe+=1;
            
            System.out.println("Comparaciones al BUSCAR la clave "+c+"-> "+actual);
            promedioComparaciones = promedioComparaciones + actual;
        }
        System.out.println("PROMEDIO DE COMPARACIONES: "+promedioComparaciones/claves_buscar.length);
        System.out.println("CANT DE CLAVES NO ENCONTRADAS: "+noExiste);
        System.out.println("CANT DE CLAVES ENCONTRADAS: "+existe);
        
        //Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves.txt"
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta1/claves.txt");
        System.out.println("");
        System.out.println("");
        
        System.out.println("++++ INSERTAR PALABRAS ++++");
        HashMap<Integer,String> mapa = new HashMap<Integer,String>();
        noExiste=0;
        existe=0;
        
        promedioComparaciones = 0;
        for (String c : palabras) {
            int ind = t.funcionHashing(t.word2key(c));
            mapa.put(ind, c);
        }
        
        System.out.println("IMPRIMIR LAS PALABRAS (valor de cada clave)");
        Collection<String> lista = mapa.values();
        for (String s : lista){
            System.out.println(s);
        }
        
//        for (int k : mapa.keySet()){
//            System.out.println(mapa.get(k));
//        }
    }
}
