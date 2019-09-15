package Arboles_Genericos;

public class Arbol {
    public Elemento raiz;
    
    public Arbol (){
        this.raiz = null;
    }

    public Elemento getRaiz() {
        return raiz;
    }

    public void setRaiz(Elemento raiz) {
        this.raiz = raiz;
    }
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        if(this.raiz == null){
            if(etiquetaPadre == null) {
                Elemento nuevaRaiz = new Elemento(unaEtiqueta);
                this.raiz = nuevaRaiz;
                return true;
            }
            else 
                return false;
        }
        else{
            if(etiquetaPadre == null) {
                Elemento hijoaux = this.raiz.getHijo();
                
                Elemento nuevoElemento = new Elemento(unaEtiqueta);
                nuevoElemento.setHijo(raiz);
                
                if(hijoaux != null) {
                    raiz.setHerDer(hijoaux.getHerDer());
                }
                this.raiz = nuevoElemento;
                return true;
            }
            else 
                return raiz.insertar(unaEtiqueta, etiquetaPadre);
        }
    }
    
    public Elemento buscar(Comparable etiqueta){
        if(etiqueta == null) 
            return null;
        if (this.raiz == null) 
            return null;
        else 
            return raiz.buscar(etiqueta);
    }
    
    public String preOrden(){
        if(this.raiz == null) 
            return "";
        else{
            return this.raiz.preOrden();
        }
    }
}
