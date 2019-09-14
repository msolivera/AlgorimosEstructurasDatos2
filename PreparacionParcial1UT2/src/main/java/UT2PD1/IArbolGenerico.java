/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD1;

/**
 *
 * @author Micaela
 */
public interface IArbolGenerico {
    
    public INodoGenerico buscar (Comparable etiqueta);
    
    public INodoGenerico getRaiz();

    public void setRaiz(INodoGenerico raiz);
    
    public int tamaño();
    
    public int altura();
    
    public boolean insertar (Comparable etiqueta, Comparable padre);
    
    public void listarIndentado ();
    
    public void listarIndentadoYNivel();
}
