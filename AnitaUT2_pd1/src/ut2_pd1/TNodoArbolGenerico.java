package ut2_pd1;
/**
 *
 * @author Bruno Garcia
 */
public class TNodoArbolGenerico<T> implements INodoArbol<T> {
    
    private Comparable etiqueta = null;
    private TNodoArbolGenerico<T> primerHijo = null;
    private TNodoArbolGenerico<T> hermanoDerecho = null;
    
    public TNodoArbolGenerico(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }
    public TNodoArbolGenerico(Comparable etiqueta, TNodoArbolGenerico<T> primerHijo, TNodoArbolGenerico<T> hermanoDerecho){
        this.etiqueta = etiqueta;
        this.primerHijo = primerHijo;
        this.hermanoDerecho = hermanoDerecho;
    }
    
    @Override
    public void setPrimerHijo(TNodoArbolGenerico<T> primerHijo){
        this.primerHijo = primerHijo;
    }
    
    @Override
    public void setHermanoDerecho(TNodoArbolGenerico<T> hermanoDerecho){
        this.hermanoDerecho = hermanoDerecho;
    }
    
    @Override
    public void setEtiqueta(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }
    
    @Override
    public TNodoArbolGenerico<T> getPrimerHijo(){
        return this.primerHijo;
    }
    
    @Override
    public TNodoArbolGenerico<T> getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    
    @Override
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if (this.etiqueta.compareTo(etiquetaPadre) == 0){
            
            TNodoArbolGenerico<T> unHijo = this.primerHijo;
            if (unHijo == null){
                this.primerHijo = new TNodoArbolGenerico(unaEtiqueta);
                return true;
            }
            else{
                while (unHijo.hermanoDerecho != null){
                    unHijo = unHijo.hermanoDerecho;
                }
            }
            unHijo.setHermanoDerecho(new TNodoArbolGenerico(unaEtiqueta));
            return true;
        }
        else{
            TNodoArbolGenerico unHijo = this.primerHijo;
            while(unHijo != null){
                if(unHijo.insertar(unaEtiqueta, etiquetaPadre))
                    return true;
                unHijo = unHijo.hermanoDerecho;
            }
        }        
        return false;
    }

    @Override
    public TNodoArbolGenerico<T> buscar(Comparable unaEtiqueta) {
        if(this.etiqueta.compareTo(unaEtiqueta) == 0){
            return this;
        }
        
        TNodoArbolGenerico<T> unHijo = this.primerHijo;
        TNodoArbolGenerico<T> aux = null;
        
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
            espacios += "     ";
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
