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
public class TArbolBB<T> implements IArbolBB<T> {

    private INodoABB<T> raiz = null;

    public TArbolBB() {
    }

    public TArbolBB(INodoABB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public INodoABB<T> getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(INodoABB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean insertar(INodoABB<T> nodo) {
        if (raiz == null) {
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo);
    }

    @Override
    public INodoABB<T> buscar(Comparable etiqueta) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(etiqueta);
    }
    
    @Override
    public boolean eliminar(Comparable etiqueta) {
        if (raiz == null) {
            return false;
        }
        int tamañoOriginal = getTamaño();
        raiz = raiz.eliminar(etiqueta);
        return tamañoOriginal > getTamaño();
    }

    @Override
    public int getAltura() {
        if (raiz == null) {
            return -1;
        }
        return raiz.getAltura();
    }

    @Override
    public int getTamaño() {
        if (raiz == null) {
            return -1;
        }
        return raiz.getTamaño();
    }

    @Override
    public int getNivel(Comparable etiqueta) {
        if (raiz == null) {
            return -1;
        }
        return raiz.getNivel(etiqueta);
    }

    @Override
    public int getCantidadHojas() {
        if (raiz == null) {
            return -1;
        }
        return raiz.getCantidadHojas();
    }

    @Override
    public int getCantidadNodosInternos() {
        if (raiz == null) {
            return -1;
        }
        return raiz.getCantidadNodosInternos();
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.preOrden();
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.inOrden();
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.postOrden();
    }

    @Override
    public int sumaAlturasNodos() {//////////////////////
        if (raiz == null){
            return -1;
        }
        int[] alturas = new int[getTamaño()];
        
        raiz.sumaAlturasNodos(alturas, new int []{0});
        
        int resultado = 0;
        
        for(int altura:alturas){
            resultado += altura;
        }
        
        return resultado;
    }

}