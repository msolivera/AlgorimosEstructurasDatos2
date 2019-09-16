/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd1;

/**
 *
 * @author anabe
 */
public class TArbolGenerico<T> implements IArbol<T> {
    private TNodoArbolGenerico<T> raiz = null;
    
    public TArbolGenerico(){}
    
    public TArbolGenerico(TNodoArbolGenerico<T> raiz){
        this.raiz = raiz;
    }
    
    @Override
    public TNodoArbolGenerico<T> getRaiz(){
        return this.raiz;
    }
    
    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if (etiquetaPadre.compareTo("") == 0){
            if (this.raiz == null){
                this.raiz = new TNodoArbolGenerico(unaEtiqueta);
                return true;
            }
            else{
                TNodoArbolGenerico exRaiz = this.raiz;
                TNodoArbolGenerico nuevaRaiz = new TNodoArbolGenerico(unaEtiqueta);
                nuevaRaiz.setPrimerHijo(exRaiz);
                this.raiz = nuevaRaiz;
                return true;
            }
        }
        else if (raiz == null){         // si raiz es null, entonces no existe nodo con raiz = etiquetaPadre
            return false;
        }
        return raiz.insertar(unaEtiqueta, etiquetaPadre);
    }

    @Override
    public TNodoArbolGenerico<T> buscar(Comparable unaEtiqueta) {
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
