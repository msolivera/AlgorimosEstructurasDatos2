package ut2_pd6;

import java.util.LinkedList;

/**
 *
 * @author Bruno Garcia
 */
public class TArbolTrie<T> {
    private TNodoTrie<T> raiz = new TNodoTrie();
    
    public boolean agregarSufijos(String cadena){
        int nChar = cadena.length()-1;
        String prefijo = "";
        boolean respuesta = true;
        
        for (int i=nChar; i>=0; i--){
            prefijo = cadena.charAt(i) + prefijo;
            if(!agregarSufijo(prefijo, i)){
                respuesta = false;
            }
        }
        return respuesta;
    }
    
    public boolean agregarSufijo(String cadena, int posicion){
        return raiz.agregarSufijo(cadena, posicion);
    }
    
    public LinkedList buscarPatron(String patron){
        LinkedList posiciones = new LinkedList();
        
        raiz.buscarPatron(patron, posiciones);
        
        return posiciones;
    }
}
