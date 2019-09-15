package Hashing_Mediciones;

import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();      
        LinkedList ll = new LinkedList();
        ArrayList al = new ArrayList();
        HashMap hm = new HashMap();
        TreeMap tm = new TreeMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
                // insertar la palabra p en el trie
                trie.insertar(p);
                // insertar la palabra p en el linkedList
                ll.add(p);
                // insertar la palabra p en el arrayList
                al.add(p);
                // insertar la palabra p en el hashMap
                hm.put(p, p);
                // insertar la palabra p en el treeMap
                tm.put(p,p);
        }
        
        int i = 0;
        Medible[] medibles = new Medible[5];
        medibles[i++] = new MedicionBuscarLinkedList(ll);
        medibles[i++] = new MedicionBuscarArrayList(al);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hm);
        medibles[i++] = new MedicionBuscarTreeMap(tm);
        Medicion mi;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[6];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m: medibles){
            mi= m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto()+";"+mi.getTiempoEjecucion().toString()+";"+mi.getMemoria().toString();
        }
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv",lineas);
        MedicionPredecirLinkedList listaLinked = new MedicionPredecirLinkedList();
        String prefijo = "cas";
	System.out.println(listaLinked.predecir(prefijo,ll).toString());
        
        MedicionPredecirHashMap hashHashMap = new MedicionPredecirHashMap();
        System.out.println(hashHashMap.predecir(prefijo, hm).toString());
    }
}