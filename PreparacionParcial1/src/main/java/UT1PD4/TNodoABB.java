/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD4;

/**
 *
 * @author Micaela
 */
public class TNodoABB<T> implements INodoABB<T> {

    private Comparable etiqueta;
    private T dato;
    private INodoABB<T> hijoIzq;
    private INodoABB<T> hijoDer;

    public TNodoABB() {
    }

    public TNodoABB(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public TNodoABB(T dato) {
        this.dato = dato;
    }

    public TNodoABB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void setHijoIzq(INodoABB<T> nodo) {
        hijoIzq = nodo;
    }

    @Override
    public INodoABB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public void setHijoDer(INodoABB<T> nodo) {
        hijoDer = nodo;
    }

    @Override
    public INodoABB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public boolean insertar(INodoABB<T> nodo) {
        Comparable etiquetaNueva = nodo.getEtiqueta();
        int comparacion = etiqueta.compareTo(etiquetaNueva);

        if (comparacion == 0) {
            return false;
        }
        if (comparacion > 0) {
            if (hijoIzq != null) {
                return hijoIzq.insertar(nodo);
            }
            hijoIzq = nodo;
            return true;
        }
        if (hijoDer != null) {
            return hijoDer.insertar(nodo);
        }
        hijoDer = nodo;
        return true;
    }

    @Override
    public INodoABB<T> buscar(Comparable etiqueta) {
        int comparacion = this.etiqueta.compareTo(etiqueta);

        if (comparacion == 0) {
            return this;
        }
        if (comparacion > 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(etiqueta);
            }
            return null;
        }
        if (hijoDer != null) {
            return hijoDer.buscar(etiqueta);
        }
        return null;
    }

    @Override
    public INodoABB<T> eliminar(Comparable etiqueta) {
        int comparacion = this.etiqueta.compareTo(etiqueta);

        if (comparacion > 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(etiqueta);
            }
            return this;
        }
        if (comparacion < 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(etiqueta);
            }
            return this;
        }

        return quitarNodo();
    }

    @Override
    public INodoABB<T> quitarNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }

        INodoABB<T> padre = this;
        INodoABB<T> hijo = hijoIzq;

        while (hijo.getHijoDer() != null) {
            padre = hijo;
            hijo = hijo.getHijoDer();
        }

        if (padre != this) {
            padre.setHijoDer(hijo.getHijoIzq());
            hijo.setHijoIzq(padre);
        }

        hijo.setHijoDer(hijoDer);

        return hijo;
    }

    @Override
    public int getAltura() {
        int altura = 0;

        if (hijoIzq != null) {
            altura = 1 + hijoIzq.getAltura();
        }
        if (hijoDer != null) {
            altura = Math.max(altura, 1 + hijoDer.getAltura());
        }

        return altura;
    }

    @Override
    public int getTamaño() {
        int tamaño = 1;

        if (hijoIzq != null) {
            tamaño += hijoIzq.getTamaño();
        }
        if (hijoDer != null) {
            tamaño += hijoDer.getTamaño();
        }

        return tamaño;
    }

    @Override
    public int getNivel(Comparable etiqueta) {
        int comparacion = this.etiqueta.compareTo(etiqueta);

        if (comparacion == 0) {
            return 0;
        }
        if (comparacion > 0) {
            if (hijoIzq != null) {
                int nivelIzq = hijoIzq.getNivel(etiqueta);
                if (nivelIzq != -1) {
                    return 1 + nivelIzq;
                }
            }
        }
        if (hijoDer != null) {
            int nivelDer = hijoDer.getNivel(etiqueta);
            if (nivelDer != -1) {
                return 1 + nivelDer;
            }
        }
        return -1;
    }

    @Override
    public int getCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }

        int hojas = 0;

        if (hijoIzq != null) {
            hojas = hijoIzq.getCantidadHojas();
        }
        if (hijoDer != null) {
            hojas += hijoDer.getCantidadHojas();
        }

        return hojas;
    }

    @Override
    public int getCantidadNodosInternos() {
        if(hijoIzq == null && hijoDer == null){
            return 0;
        }
        
        int nodos = 1;
        
        if(hijoIzq != null){
            nodos += hijoIzq.getCantidadNodosInternos();
        }
        if(hijoDer != null){
            nodos += hijoDer.getCantidadNodosInternos();
        }
        
        return nodos;
    }

    @Override
    public String preOrden() {
        String preOrden = etiqueta.toString();
        
        if(hijoIzq != null){
            preOrden += hijoIzq.preOrden();
        }
        if(hijoDer != null){
            preOrden += hijoDer.preOrden();
        }
        
        return preOrden;
    }

    @Override
    public String inOrden() {
        String inOrden = "";
        
        if(hijoIzq != null){
            inOrden += hijoIzq.inOrden();
        }
        inOrden += etiqueta.toString();
        if(hijoDer != null){
            inOrden += hijoDer.inOrden();
        }
        
        return inOrden;
    }

    @Override
    public String postOrden() {
        String postOrden = "";
        
        if(hijoIzq != null){
            postOrden += hijoIzq.postOrden();
        }
        if(hijoDer != null){
            postOrden += hijoDer.postOrden();
        }
        postOrden += etiqueta.toString();
        
        return postOrden;
    }

    @Override
    public int sumaAlturasNodos(int[] alturas, int[] indice) {
        int altIzq = -1;
        int altDer = -1;
        int alt = 0;
        
        if(hijoIzq != null){
            altIzq = hijoIzq.sumaAlturasNodos(alturas, indice);
        }
        if(hijoDer != null){
            altDer = hijoDer.sumaAlturasNodos(alturas, indice);
        }
        alt = Integer.max(altIzq, altDer) + 1;
        alturas[indice[0]] = alt;
        indice[0]++;
        
        return alt;
    }
}