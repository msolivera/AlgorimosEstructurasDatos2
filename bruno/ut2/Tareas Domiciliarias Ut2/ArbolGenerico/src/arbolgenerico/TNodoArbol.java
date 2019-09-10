package arbolgenerico;

/**
 *
 * @author Bruno Garcia
 */
public class TNodoArbol<T> implements INodoArbol<T> {
    
    private Comparable etiqueta = null;
    private INodoArbol<T> primerHijo = null;
    private INodoArbol<T> hermanoDerecho = null;
    
    public TNodoArbol(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }
    public TNodoArbol(Comparable etiqueta, INodoArbol<T> primerHijo, INodoArbol<T> hermanoDerecho){
        this.etiqueta = etiqueta;
        this.primerHijo = primerHijo;
        this.hermanoDerecho = hermanoDerecho;
    }
    
    @Override
    public void setPrimerHijo(INodoArbol<T> primerHijo){
        this.primerHijo = primerHijo;
    }
    
    @Override
    public void setHermanoDerecho(INodoArbol<T> hermanoDerecho){
        this.hermanoDerecho = hermanoDerecho;
    }
    
    @Override
    public INodoArbol<T> getPrimerHijo(){
        return this.primerHijo;
    }
    
    @Override
    public INodoArbol<T> getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    
    @Override
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        INodoArbol<T> aux = null;
        
        if (this.etiqueta.compareTo(etiquetaPadre) == 0){
            if (this.primerHijo == null){
                this.primerHijo = new TNodoArbol(unaEtiqueta);
                return true;
            }
            
            aux = this.primerHijo;
            while (aux.getHermanoDerecho() != null){
                aux = aux.getHermanoDerecho();
            }
            
            aux.setHermanoDerecho(new TNodoArbol(unaEtiqueta));
            return true;
        }
        
        aux = this.primerHijo;
        while(aux != null){
            if(aux.insertar(unaEtiqueta, etiquetaPadre)){
                return true;
            }
            aux = aux.getHermanoDerecho();
        }
        
        return false;
    }

    @Override
    public INodoArbol<T> buscar(Comparable unaEtiqueta) {
        if(this.etiqueta.compareTo(unaEtiqueta) == 0){
            return this;
        }
        
        INodoArbol<T> unHijo = this.primerHijo;
        INodoArbol<T> aux = null;
        
        while(unHijo != null){
            aux = unHijo.buscar(unaEtiqueta);
            if(aux != null){
                return aux;
            }
            unHijo = unHijo.getHermanoDerecho();
        }
        
        return null;
    }

    @Override
    public String listarIndentado(int nivel) {
        String listado = "";
        String espacios = "";
        for (int i = 0; i < nivel; i++){
            espacios += "|";
        }
        
        listado = espacios + this.etiqueta + "\n";
        
        if(this.primerHijo != null){
            listado += this.primerHijo.listarIndentado(nivel+1);
        }
        if(this.hermanoDerecho != null){
            listado += this.hermanoDerecho.listarIndentado(nivel);
        }
        
        return listado;
    }
    
}
