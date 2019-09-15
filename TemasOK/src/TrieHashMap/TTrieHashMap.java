package TrieHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TTrieHashMap {
    private TNodoTrieHashMap raiz;
    
    public TTrieHashMap(){
        this.raiz=null;
    }
    
    public TNodoTrieHashMap getRaiz() {
        return raiz;
    }
   
    public void setRaiz(TNodoTrieHashMap raiz) {
        this.raiz = raiz;
    }
   
    public void insertar (String palabra){
        if (raiz == null){
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }
    
    public void insertar (String palabra, int pagina){
        if (raiz == null){
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra,pagina);
    }
    
    public void imprimir(){
        if (raiz != null){
            raiz.imprimir();
        }
    }
    
    public boolean buscar (String palabra){
        if (this.raiz == null) 
            return false;
        return raiz.buscar(palabra);
    }

    public ArrayList buscarPaginas (String palabra){
        if (this.raiz == null) 
            return null;
        return raiz.buscarPaginas(palabra);
    }
    
    public LinkedList<String> predecir(String a) {
        LinkedList lista = new LinkedList<>();
        if(raiz != null){
            raiz.predecir(a, lista);
            return lista;
        }
        else{
            return lista;
        }
    }
    
    public static Map eliminaNulo(Map map){
        Map<Object,Object> map1 = new HashMap(map);
        Map map2 = new HashMap();
        for (Map.Entry<Object,Object> entrySet : map1.entrySet()) {
            if(entrySet.getValue()!=null){
                map2.put(entrySet.getKey(),entrySet.getValue());
            }            
        }
        return map2;
    }
    public static Map<String,String> darVuelta(Map<String,String> map) {
        Map<String,String> map2 = new HashMap<String,String>();
        try{
            for (Map.Entry<String, String> entrySet : map.entrySet()) {
                String key = entrySet.getKey();
                String value = entrySet.getValue();
                if (map2.containsKey(value)) {
                    throw new Exception();
                }
                map2.put(value,key);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return map2;
    }
    
    public static String ordenar(String[] palabras) {
        TreeMap<Integer,Set<String>> arbol1=new TreeMap<>();
        for (String palabra : palabras) {
            if (!arbol1.containsKey(palabra.length())) {
                TreeSet lista = new TreeSet();
                arbol1.put(palabra.length(), lista);
                lista.add(palabra);
            }
            else{
                arbol1.get(palabra.length()).add(palabra);
            }            
        }
        String resultado ="";
        for (Map.Entry<Integer, Set<String>> entrySet : arbol1.entrySet()) {
            Integer key = entrySet.getKey();
            Set<String> value = entrySet.getValue();
            for (String palabra : value) {
                resultado+= palabra + "\n";
            }
        }
        return resultado;
    }
}