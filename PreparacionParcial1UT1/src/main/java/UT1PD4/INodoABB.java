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
public interface INodoABB<T> {
 public void setDato(T dato);
    
    public T getDato();
    
    public void setEtiqueta(Comparable etiqueta);
    
    public Comparable getEtiqueta();
    
    public void setHijoIzq(INodoABB<T> nodo);
    
    public INodoABB<T> getHijoIzq();
    
    public void setHijoDer(INodoABB<T> nodo);
    
    public INodoABB<T> getHijoDer();
    
    public boolean insertar(INodoABB<T> nodo);
    
    public INodoABB<T> buscar(Comparable etiqueta);
    
    public INodoABB<T> eliminar(Comparable etiqueta);
    
    public INodoABB<T> quitarNodo();
    
    public int getAltura();
    
    public int getTamaño();
    
    public int getNivel(Comparable etiqueta);
    
    public int getCantidadHojas();
    
    public int getCantidadNodosInternos();
    
    public String preOrden();
    
    public String inOrden();
    
    public String postOrden();
    
    public int sumaAlturasNodos(int[] alturas, int[] indice);   
}
