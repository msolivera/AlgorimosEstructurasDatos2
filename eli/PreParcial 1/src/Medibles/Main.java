
package Medibles;
import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();      
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/Medibles/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src/Medibles/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
                linkedList.add(p);
                arrayList.add(p);
                hashMap.put(p, p);
                treeMap.put(p,p);
        }
        
        Medible[] medibles = {new MedicionBuscarLinkedList(linkedList),
                            new MedibleArrayList(arrayList),
                            new MedicionTArbolTrie(trie)
                            ,new MedicionHashMap(hashMap)
                            ,new MedicionTreeMap(treeMap),
                             new MedicionPredecirHashMap(hashMap),
                         new MedicionPredecirLinkedList(linkedList),
                         new MedicionPredecirTrie(trie)    };
        //TODO: Cargar el resto de los medibles
       
        Object[] params = {REPETICIONES, palabrasBuscar};
        for (Medible m: medibles){
            m.medir(params).print();
        }
    }
}