package Grafos_No_Dirigidos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class TGrafoNoDirigido extends TGrafoDirigido {
    public TAristas aristas = new TAristas();
    
    /**
     * CONSTRUCTOR GRAFO NO DIRIGIDO
     * @param listaVertices
     * @param listaAristas 
     */
    public TGrafoNoDirigido(Collection<TVertice> listaVertices, Collection<TArista> listaAristas) {
        super(listaVertices, listaAristas); 
        for (TVertice vertice : listaVertices) {
            this.insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : listaAristas) {
            this.insertarArista(arista);
            aristas.getAristas().add(arista);
        }
    }
    
    @Override
    public boolean insertarArista(TArista arista){
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
                vertDestino.insertarAdyacencia(arista.getCosto(),vertOrigen);
                return true;
            }            
        }
        return false;
    }
    
    /**
     * Método BEA desde cualquier vértice origen
     * @return 
     */
    public String bea() {
        if (this.getVertices().isEmpty()) {
            return "El grafo está vacio";
        } else {
            this.desvisitarVertices();
            for (TVertice vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   return  vertV.bea();
                }
            }
        }
        return "#";
    }
    
    public  String bea(Comparable origen){
        this.desvisitarVertices();
        TVertice t = this.getVertices().get(origen);
        if(t != null){
            return t.bea();
        }
        return "";
    }
    
    public  String bea2(){
        if (this.getVertices().isEmpty()) {
            return "El grafo está vacio";
        } else {
            this.desvisitarVertices();
            for (TVertice vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   return  vertV.bea2();
                }
            }
        }
        return "#";
    }
    
    public  String bea2(Comparable origen){
        this.desvisitarVertices();
        TVertice t = this.getVertices().get(origen);
        if(t != null){
            return t.bea2();
        }
        return "";
    }
    
    public Collection<TArista> kruskal(){
        LinkedList<TArista> lista = (LinkedList<TArista>) aristas.getAristas();
        LinkedList<TArista> miLista = new LinkedList<>();
        LinkedList<TVertice> todosVertices = new LinkedList<>();
        LinkedList<TVertice> misVertices = new LinkedList<>();
        
        for (Iterator<TVertice> it = this.getVertices().values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            todosVertices.add(vert);
        }
        while (!misVertices.containsAll(todosVertices)) {
            try {
                TArista ar = lista.getFirst();
                if (!misVertices.contains(this.getVertices().get(ar.etiquetaDestino))) {
                    misVertices.add(this.getVertices().get(ar.etiquetaDestino));
                    miLista.add(ar);
                }
                lista.remove(ar);
            } catch (Exception e) {
                //System.out.println(e);
                break;
            }
        }
        return miLista;
    }
    
}
 