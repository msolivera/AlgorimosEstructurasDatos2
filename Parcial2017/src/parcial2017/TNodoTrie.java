package parcial2017;

import java.util.TreeMap;

/**
 *
 * @author Bruno Garcia
 */
public class TNodoTrie {
    private TNodoTrie[] hijos = new TNodoTrie[10];
    private Abonado abonado;
    
    public TNodoTrie(){}
    public TNodoTrie(Abonado abonado){
        this.abonado = abonado;
    }
    
    public Abonado getAbonado(){
        return abonado;
    }
    
    public void setAbonado(Abonado aboando){
        this.abonado = abonado;
    }
    
    public TNodoTrie getHijo(int i){
        if(i > -1 && i < hijos.length){
            return hijos[i];
        }
        return null;
    }
    
    public boolean setHijo(int i){
        if(i > -1 && i < hijos.length && hijos[i] == null){
            hijos[i] = new TNodoTrie();
            return true;
        }
        return false;
    }
    
    public boolean deleteHijo(int i){
        if(i > -1 && i < hijos.length && hijos[i] != null){
            hijos[i] = null;
            return true;
        }
        return false;
    }
    
    public boolean insertar(String numero, Abonado abonado){
        TNodoTrie nodo = this;
        int n;
        for(int i = 0; i < numero.length(); i++){
            n = Integer.parseInt(numero.substring(i, i+1));
            nodo.setHijo(n);
            nodo = nodo.getHijo(n);
        }
        if(nodo.abonado != null){
            return false;
        }
        nodo.abonado = abonado;
        return true;
    }
    
    public TNodoTrie buscarNodo(String numero){
        TNodoTrie nodo = this;
        int n;
        for(int i = 0; i < numero.length(); i++){
            n = Integer.parseInt(numero.substring(i, i+1));
            nodo = nodo.getHijo(n);
            if(nodo == null){
                return null;
            }
        }
        return nodo;
    }
    
    public void buscarTelefonos(TreeMap telefonos){
        if(abonado != null){
            telefonos.put(abonado.getNombre(), abonado);
        }
        TNodoTrie nodo;
        for(int i = 0; i < hijos.length; i++){
            nodo = hijos[i];
            if(nodo != null){
                nodo.buscarTelefonos(telefonos);
            }
        }
    }
    
}
