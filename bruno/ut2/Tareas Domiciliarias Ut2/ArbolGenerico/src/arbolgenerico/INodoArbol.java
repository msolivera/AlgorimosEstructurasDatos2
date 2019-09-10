package arbolgenerico;

/**
 *
 * @author Bruno Garcia
 */
public interface INodoArbol<T> {
    public Comparable getEtiqueta();
    
    public void setPrimerHijo(INodoArbol<T> primerHijo);
    
    public void setHermanoDerecho(INodoArbol<T> hermanoDerecho);
    
    public INodoArbol<T> getPrimerHijo();
    
    public INodoArbol<T> getHermanoDerecho();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public INodoArbol<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado(int nivel);
}
