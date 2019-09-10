package arbolgenerico;

/**
 *
 * @author Bruno Garcia
 */
public class TArbol<T> implements IArbol<T> {

    private INodoArbol<T> raiz = null;
    
    public TArbol(){}
    
    public TArbol(INodoArbol<T> raiz){
        this.raiz = raiz;
    }
    
    @Override
    public INodoArbol<T> getRaiz(){
        return this.raiz;
    }
    
    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if (etiquetaPadre.compareTo("") == 0){
            INodoArbol raizVieja = this.getRaiz();
            INodoArbol raizNueva = new TNodoArbol(unaEtiqueta);
            raizNueva.setPrimerHijo(raizVieja);
            this.raiz = raizNueva;
            return true;
        }
        
        if (raiz == null){
            return false;
        }
        
        return raiz.insertar(unaEtiqueta, etiquetaPadre);
    }

    @Override
    public INodoArbol<T> buscar(Comparable unaEtiqueta) {
        if (raiz != null){
            return raiz.buscar(unaEtiqueta);
        }
        
        return null;
    }

    @Override
    public String listarIndentado() {
        String listado = "";
        if (raiz != null){
            listado = raiz.listarIndentado(0);
        }
        return listado;
    }
    
}
