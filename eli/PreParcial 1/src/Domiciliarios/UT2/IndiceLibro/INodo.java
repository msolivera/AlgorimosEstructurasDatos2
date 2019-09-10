package Domiciliarios.UT2.IndiceLibro;

/**
 * Interface para los elemento de la lista
 * @author Equipo5
 * @param <E> 
 */
public interface INodo<E> {

    /**
     * Retorna el dato contenido en el nodo.     *
     * @return Dato contenido en el nodo.
     */
    public E getDato();

    /**
     * Asigna un dato al nodo.     *
     * @param dato a asignar.
     */
    public void setDato(E dato);

    /**
     * Asigna el siguiente nodo al nodo actual.     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setSiguiente(INodo<E> nodo);

    /**
     * Retorna el siguiente nodo al nodo actual.     *
     * @return Siguiente nodo del actual
     */
    public INodo<E> getSiguiente();

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     * Compara si dos nodos son iguales.
     * @param unNodo
     * @return Verdadero si son iguales,falso en caso contrario.
     */
    public boolean equals(INodo<E> unNodo);

    /**
     * Retorna la etiqueta del nodoa     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();


    /**
     * Metodo que compara dos etiquetas de nodos.
     * @param etiqueta etiqueta a comparar
     * @return devueve -1 si este nodo tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
    /**
     * Metodo que permite clonar el nodo, obteniendo de esta manera
     * otro nodo con el mismo dato y etiqueta que el original.
     * @return el nuevo nodo clonado.
     */
    public INodo<E> clonar();

}
