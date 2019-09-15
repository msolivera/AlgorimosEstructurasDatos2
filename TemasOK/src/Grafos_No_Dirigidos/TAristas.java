package Grafos_No_Dirigidos;


import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class TAristas {
    private Collection<TArista> aristas;

    public TAristas() {
        this.aristas = new LinkedList<TArista>();
    }
    public Collection<TArista> getAristas() {
        return aristas;
    }
    
    public String imprimirAristas(){
        StringBuilder sb = new StringBuilder();
        for (TArista arista : aristas){
            sb.append(arista.getEtiquetaOrigen() +" ->" + arista.getEtiquetaDestino()+"\n");
        }
        return sb.toString();
    }

    public void imprimirAristasConsola(){
        System.out.println(imprimirAristas());
    }
    public TArista buscar (Comparable etiquetaOrigen, Comparable etiquetaDestino){
        
        for (TArista arista: aristas){
            if ( (arista.getEtiquetaOrigen() == etiquetaOrigen && arista.getEtiquetaDestino() == etiquetaDestino) || (arista.getEtiquetaOrigen() == etiquetaDestino && arista.getEtiquetaDestino() == etiquetaOrigen)){
                return arista;
            }
        }
        return null;
    }
    public TArista buscarMin (Collection<TVertice> U ,Collection<TVertice> V ){
        TArista aristaAAM = null;
        double minCosto = Double.MAX_VALUE;
        for ( TVertice verU : U){
            for (TVertice verV  : V){
                TArista temp = buscar(verU.getEtiqueta(),verV.getEtiqueta());
                if (temp!= null){
                    if (temp.getCosto() < minCosto){
                        aristaAAM = temp;
                        minCosto = aristaAAM.getCosto();
                    }
                }
            }
        }        
        return aristaAAM;
    }
    
}
