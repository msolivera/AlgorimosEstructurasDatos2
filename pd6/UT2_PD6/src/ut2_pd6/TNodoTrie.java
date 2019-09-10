package ut2_pd6;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Bruno Garcia
 */
public class TNodoTrie<T> {

    private TNodoTrie<T>[] hijos = new TNodoTrie[4];
    private LinkedList posiciones = new LinkedList();

    public boolean esHoja() {
        return !posiciones.isEmpty();
    }

    public TNodoTrie<T>[] getHijos() {
        return hijos;
    }

    private int indexOf(char caracter) {
        switch (caracter) {
            case 'a':
                return 0;
            case 'c':
                return 1;
            case 'g':
                return 2;
            case 't':
                return 3;
            default:
                return -1;
        }
    }

    public TNodoTrie<T> getHijo(char letra) {
        return hijos[indexOf(letra)];
    }

    public TNodoTrie<T> setHijo(char letra) {
        TNodoTrie<T> hijo = new TNodoTrie();
        int i = indexOf(letra);
        if (i != -1) {
            hijos[i] = hijo;
            return hijo;
        }
        return null;
    }

    public boolean agregarPosicion(int posicion) {
        if (posiciones.contains(posicion)) {
            return false;
        }
        posiciones.add(posicion);
        return true;
    }

    public LinkedList getPosiciones() {
        return posiciones;
    }

    public boolean agregarSufijo(String cadena, int posicion) {
        char c = cadena.charAt(0);
        TNodoTrie<T> hijo = getHijo(c);
        if (hijo == null) {
            hijo = setHijo(c);
        }
        if (cadena.length() > 1) {
            cadena = cadena.substring(1);
            return hijo.agregarSufijo(cadena, posicion);
        }
        return hijo.agregarPosicion(posicion);
    }

    public void buscarPatron(String cadena, LinkedList posiciones) {
        char c = cadena.charAt(0);
        TNodoTrie<T> hijo = getHijo(c);
        if (hijo == null) {
            return;
        }
        if (cadena.length() > 1) {
            cadena = cadena.substring(1);
            hijo.buscarPatron(cadena, posiciones);
        } else {
            hijo.leerPosiciones(posiciones);
        }
    }

    private void leerPosiciones(LinkedList pos) {
        Iterator iterator = posiciones.iterator();
        while (iterator.hasNext()) {
            pos.add(iterator.next());
        }
        for(TNodoTrie nodo : hijos){
            if(nodo!=null)
                nodo.leerPosiciones(pos);
        }
    }
}
