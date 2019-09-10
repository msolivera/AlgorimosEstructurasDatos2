package ut1td4;

/**
 *
 * @author Bruno
 */
public interface IArbolBB<T> {
    
    public void setRaiz(INodoABB<T> raiz);
    
    public INodoABB<T> getRaiz();
    
    public boolean insertar(INodoABB<T> nodo);
    
    public INodoABB<T> buscar(Comparable etiqueta);
    
    public boolean eliminar(Comparable etiqueta);
    
    public int getAltura();
    
    public int getTamaño();
    
    public int getNivel(Comparable etiqueta);
    
    public int getCantidadHojas();
    
    public int getCantidadNodosInternos();
    
    public String preOrden();
    
    public String inOrden();
    
    public String postOrden();
    
    public int sumaAlturasNodos();
}
