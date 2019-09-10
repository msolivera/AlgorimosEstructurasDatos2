package parcial2017;

import java.util.TreeMap;

/**
 *
 * @author Bruno Garcia
 */
public class TTrie {
    private TNodoTrie raiz = new TNodoTrie();
    
    public TNodoTrie getRaiz(){
        return raiz;
    }
    
    public boolean insertar(Abonado abonado){
        String numero = abonado.getTelefono();
        return raiz.insertar(numero, abonado);
    }
    
    public TNodoTrie buscarNodo(String numero){
        return raiz.buscarNodo(numero);
    }
    
    public TreeMap buscarTelefonos(String codigoPais, String codigoArea){
        String numero = codigoPais + codigoArea;
        TreeMap<String, Abonado> telefonos = new TreeMap();
        TNodoTrie nodo = buscarNodo(numero);
        nodo.buscarTelefonos(telefonos);
        return telefonos;
    }
}
