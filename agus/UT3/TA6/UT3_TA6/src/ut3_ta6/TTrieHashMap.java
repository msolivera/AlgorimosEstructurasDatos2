package ut3_ta6;
import java.util.ArrayList;
import java.util.LinkedList;

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
}