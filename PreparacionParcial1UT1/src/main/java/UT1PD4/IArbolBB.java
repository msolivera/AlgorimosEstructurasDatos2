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
public interface IArbolBB<T> {
    
    public void setRaiz(INodoABB<T> raiz);
    
    public INodoABB<T> getRaiz();
    
    public boolean insertar(INodoABB<T> nodo);
    
    public INodoABB<T> buscar(Comparable etiqueta);
    
    public boolean eliminar(Comparable etiqueta);
    
    public int getAltura();
    
    public int getTamaño();
    
    public int getNivel(Comparable etiqueta);
    
    public int getCantidadHojas();
    
    public int getCantidadNodosInternos();
    
    public String preOrden();
    
    public String inOrden();
    
    public String postOrden();
    
    public int sumaAlturasNodos(); 
}
