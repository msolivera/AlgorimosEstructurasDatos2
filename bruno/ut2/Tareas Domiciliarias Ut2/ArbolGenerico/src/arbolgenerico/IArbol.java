package arbolgenerico;

/**
 *
 * @author Bruno Garcia
 */
public interface IArbol<T> {
    public INodoArbol<T> getRaiz();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public INodoArbol<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado();
}
