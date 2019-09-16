package ut2_pd1;

/**
 *
 * @author Bruno Garcia
 */
public interface INodoArbol<T> {
    public Comparable getEtiqueta();
    
    public void setEtiqueta(Comparable etiqueta);
    
    public void setPrimerHijo(TNodoArbolGenerico<T> primerHijo);
    
    public void setHermanoDerecho(TNodoArbolGenerico<T> hermanoDerecho);
    
    public TNodoArbolGenerico<T> getPrimerHijo();
    
    public TNodoArbolGenerico<T> getHermanoDerecho();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TNodoArbolGenerico<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado(int nivel);
}
