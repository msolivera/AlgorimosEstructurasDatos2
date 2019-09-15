package Parcial1.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class TTrieHashMap implements IArbolTrie{
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
   
    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        LinkedList<TDispositivo> lista = new LinkedList<>();
        if(raiz != null){
            raiz.buscarDispositivos(mascaraSubRed, lista);
        }
        return lista;
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        if(raiz == null){
            raiz = new TNodoTrieHashMap(); 
        }
        raiz.insertar(unDispositivo);
    }   
    
    
    
    
}