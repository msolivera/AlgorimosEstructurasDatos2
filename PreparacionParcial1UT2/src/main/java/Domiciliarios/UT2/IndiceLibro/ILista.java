package Domiciliarios.UT2.IndiceLibro;


/**
 * Interface para la clase Lista.
 * @author Equipo5
 * @param <E>
 */
public interface ILista<E> {
    /**
     * Metodo encargado de agregar un nodo a la lista a continuacion de otro
     * @param actual nodo donde queremos insertar a continuacion
     * @param elementoAInsertar nodo que queremos insertar.
     * @return Verdadero o falso dependiendo si se inserto correctamente.
     */
    public boolean insertarDespues(INodo<E> actual,INodo<E> elementoAInsertar);
    /**
     * Metodo encargado de agregar un nodo a la lista de manera ordenada
     * @param nodo a agregar
     * @return True si se inserto adecuadamente.
     */
    public boolean insertarOrdenado(INodo<E> nodo);
    /**
     * Metodo encargado de agregar un nodo al principio de la lista
     * @param nodo
     * @return True si se inserto adecuadamente.
     */
    public boolean insertarAlPrincipio(INodo<E> nodo);
    /**
     * Metodo encargado de agregar un nodo al final de la lista
     * @param nodo 
     * @return True si se inserto adecuadamente.
     */
    public boolean insertarAlFinal(INodo<E> nodo);   
    
    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retorna null.
     */
    public INodo buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminacion haya sido efectuada con exito.
     */
    public boolean eliminar(Comparable clave);
    /**
     * Metodo encargado de eliminar un nodo en una lista
     * @param unElemento el nodo a ser eliminado
     * @return  True en caso de que la eliminacion haya sido efectuada con exito.
     */
    public boolean eliminar (INodo<E> unElemento);
    /**
     * Metodo que retorna un String con todas las claves.
     * @return un String con todas las claves.
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parametro.     *
     * @param separador Separa las claves
     * @return String con las claves separadas por el separador.
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacia, retornar 0.     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Retorna el primer nodo de la lista.     *
     * @return Primer nodo de la lista.
     */
    public INodo<E> getPrimero();
    /**
     *  Cambia el nodo primero
     * @param primero el reemplazo
     */
    public void setPrimero(INodo<E> primero);
    /**
     * Retorna el ultimo nodo de la lista.
     * @return Ultimo nodo de la lista.
     */
    public INodo<E> obtenerUltimo();
    /**
     *  Retorna si existe o no un determinado elemento
     * @param nodo nodo a comprobar
     * @return True or False dependiendo si se encuentra en la lista o no.
     */
    public boolean existeElemento(INodo<E> nodo);
    /**
     * Retorna el nodo anterior a otro nodo.
     * @param unElemento el nodo al cual quiero obtener su anterior
     * @return el nodo anterior.
     */
    public INodo<E> anterior(INodo<E> unElemento); 
    /**
     * Metodo que obtiene el elemento que se encuentra antes del elemento que tiene la etiqueta elejida
     * @param unaEtiqueta etiqueta del elemento al que queremos encontrar su anterior en la lista
     * @return el elemento anterior si existe, de lo contrario null
     */
    public INodo<E> anterior(Comparable unaEtiqueta);
    /**
     * Metodo que elimina el primer elemento de la lista
     * @return el primero de la lista o null en caso de ser vacía
     */
    public INodo<E> quitarPrimero();
    /**
     * Metodo encargado de vaciar la lista.
     */
    public void vaciar();
    /**
     * Metodo encargado de ordenar la lista.
     */
    public void ordenar();
    /**
     * Metodo encargado de invertir la lista.
     */
    public void invertir();
    /**
     * Metodo que determina si una lista esta ordenada en orden ascendente de acuerdo a las etiquetas de sus elementos
     * @return true si esta ordenada, de lo contrario false
     */
    public boolean estaOrdenada();
    /**
     * Metodo utilizado por la operacion mezclar, encargado de pasar un elemento de una lista a la otra y
     * eliminar el primer elemento de donde se sacó el elemento a pasar
     * @param resultado
     * @param otraLista lista  de donde vamos a quitar el primero
     * @param actual elemento que se insertará en la lista resultado
     * @return el elemento siguiente al actual
     */
    public INodo<E>  pasarDeUnaAOtra(Lista resultado, Lista otraLista, INodo<E>  actual);
    /**
    * Metodo que mezcla una lista con otra en caso de que ambas sean ordenadas o una sea ordenada y la otra vacía
    * @param otraLista otra que será parte de la mezcla
    * @return en el caso que se pueda realizar la mezcla se obtiene una lista resultado la cual está ordenada, de lo contrario null
    */  
    public Lista mezclar(Lista otraLista);
    /**
     * Metodo encargado de eliminar duplicados.
     */
    public void eliminarDuplicados();
}
