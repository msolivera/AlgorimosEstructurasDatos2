package Arboles_Genericos;

public class Elemento {
    private Comparable etiqueta;
    private Elemento hijo;
    private Elemento herDer;
    
    public Elemento (Comparable etiqueta){
        this.etiqueta = etiqueta;
        this.hijo = null;
        this.herDer = null;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Elemento getHijo() {
        return hijo;
    }

    public void setHijo(Elemento hijo) {
        this.hijo = hijo;
    }

    public Elemento getHerDer() {
        return herDer;
    }

    public void setHerDer(Elemento herDer) {
        this.herDer = herDer;
    }
    
    /*
    obtengo referencia al padre
    Si es nulo es porque el etiquetaPadre no existe
    Si lo encontro pero es diferente de etiquetaPadre, no lo inserto
    Si todo lo otro cumple, entonces tengo que insertar teniendo en cuenta que el hijo de Padre es el que voy a insertar
    pero si el Padre tenia hijo, va a ser el hermano del que voy a insertar. Si tenia mas de un hijo, entonces los hijos 
    van a ser los hijos del que voy a insertar.
    
            NodoRaiz
            
            Nodo1 ----> Nodo2 ----> Nodo 3
            
            Nodo4 ----> Nodo 5
    
    Si inserto "Nodo0" y etiquetaPadre es NodoRaiz, entonces tiene que quedar asi
            NodoRaiz
            
            Nodo0 ----> Nodo1 ----> Nodo2 ----> Nodo 3
            
            Nodo4 ----> Nodo 5
    
    Padre = NodoRaiz
    hijoaux = Nodo1
    nuevoElemento = Nodo0
    herDer de Nodo0 es hijoaux -Nodo1-
    hijo de Nodo0 es hijoaux.getHijo - Nodo4 -
    */
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        Elemento padre = this.buscar(etiquetaPadre);
        if(padre == null) 
            return false; //padre es nulo y por eso devuelve false, sin embargo yo busco el "1" y lo encuentra
        
        if(padre.getEtiqueta() != etiquetaPadre) 
            return false;
        else{
            Elemento hijoaux = padre.getHijo();
            Elemento nuevoElemento = new Elemento(unaEtiqueta);
            padre.setHijo(nuevoElemento);
            nuevoElemento.setHerDer(hijoaux);
            
            if(hijoaux != null) 
                nuevoElemento.setHijo(hijoaux.getHijo());
            return true;
        }
    }
    
    public Elemento buscar(Comparable etiqueta){
        if(this.etiqueta == etiqueta) 
            return this;
        if(this.hijo !=null) {
            return this.hijo.buscar(etiqueta);
        }
        if(this.herDer != null) {
            return this.herDer.buscar(etiqueta);
        }
        return null;
    }
    
    public String preOrden(){
        String res = this.etiqueta.toString() + " --> ";
        if(this.hijo != null) {
            res+= this.hijo.preOrden();
        }
        if( this.herDer != null) {
            res+= this.herDer.preOrden();
        }
        return res;
        
    }
}
