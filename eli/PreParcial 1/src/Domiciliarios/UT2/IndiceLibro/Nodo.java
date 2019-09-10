package Domiciliarios.UT2.IndiceLibro;

/**
 * Clase que representa un nodo de una lista.
 * @author Equipo5
 * @param <T> Tipo de objeto de cada nodo
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /**
     * Constructor de la clase.
     * @param dato dato del nodo.
     * @param etiqueta etiqueta del nodo.
     */
    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
    }
    
    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;

    }

    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }


    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

   
    @Override
    public INodo<T> clonar() {
        INodo<T> nuevo = new Nodo<T>(this.dato, this.etiqueta);
        return nuevo;
    }


    @Override
    public boolean equals(INodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }


    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
