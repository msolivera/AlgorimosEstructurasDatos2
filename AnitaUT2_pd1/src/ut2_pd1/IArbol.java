package ut2_pd1;

/**
 *
 * @author Bruno Garcia
 */
public interface IArbol<T> {
    public TNodoArbolGenerico<T> getRaiz();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TNodoArbolGenerico<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado();
}
