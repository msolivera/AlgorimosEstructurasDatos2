 package Domiciliarios.UT2.IndiceLibro;

/**
 * Clase que permite representar una determina lista con enlace simple
 * @author Equipo5
 * @param <E> Tipo de objeto de cada elemento de la lista
 */
public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    /**
     * Primer constructor de la clase. Inicializa el nodo primero a nulo.
     */
    public Lista() {
        primero = null;
    }

    /**
     * Segundo constructor de la clase, recibe como parametro el nodo para
     * asignarlo al primero.
     * @param unNodo nodo inicial de la lista
     */
    public Lista(INodo<E> unNodo) {
        this.primero = unNodo;
    }
    
    @Override
    public boolean insertarOrdenado(INodo<E> unElemento) 
    {
       if(unElemento!=null)
       {
            if(esVacia())
            {
                primero=unElemento;
                return true;
            }
            else
            {
                INodo<E>  actual= this.getPrimero();
                if(unElemento.getEtiqueta().compareTo(actual.getEtiqueta())<0)
                {
                    return insertarAlPrincipio(unElemento);
                }
                while(actual.getSiguiente()!=null && (actual.getSiguiente().getEtiqueta().compareTo(unElemento.getEtiqueta())<0))
                {
                    actual=actual.getSiguiente();
                }
                insertarDespues(actual,unElemento);
                return true; 
            }
       }
       return false;
    }
    @Override
     public boolean insertarAlPrincipio (INodo<E> unElemento)
    {
       
        if (unElemento!=null)
        {
            if (!esVacia())
            {
                unElemento.setSiguiente(primero);
            }
            primero=unElemento;
            return true;
        }
        return false;
    }
    @Override
    public boolean insertarAlFinal(INodo<E> unNodo) {
        if (unNodo!=null)
        {
            if (!esVacia())
            {
                insertarDespues(obtenerUltimo(),unNodo); 
            }
            else
            {
                primero=unNodo;
            }
            return true;
            
        }
        return false;
        
    }
    @Override
    public boolean insertarDespues(INodo<E> actual,INodo<E> elementoAInsertar)
    {
            if(actual!= null && elementoAInsertar != null)
            {
                INodo<E> actualSiguiente = actual.getSiguiente();
                elementoAInsertar.setSiguiente(actualSiguiente); 
                actual.setSiguiente(elementoAInsertar);
                return true;
            }
            return false;
    }
    @Override
    public INodo<E> obtenerUltimo()
    {
        if(!esVacia())
        {
            INodo<E> actual= this.getPrimero();
            while(actual.getSiguiente()!=null)
            {
                actual=actual.getSiguiente();
            }
            return actual;
        }
        return null;
    }
    @Override
    public INodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    @Override
    public boolean existeElemento(INodo<E> nodo){
        if (nodo!=null)
        {
            if(!esVacia())
            {
                return (this.buscar(nodo.getEtiqueta())!=null);
            }
        }
        return false;
        
    }
    
    @Override
    public INodo<E> anterior(INodo<E> unElemento) 
    {
        if (unElemento!=null && !unElemento.equals(getPrimero()))
        {
            if(!esVacia())
            {
                INodo<E> actual= getPrimero();
                while(actual!=null)
                {
                    if(actual.getSiguiente().getEtiqueta().equals(unElemento.getEtiqueta())){
                        return actual;
                    }else{  
                        actual= actual.getSiguiente();
                    }
                }
                return null;
            }
            
        }
        return null;
    }
    @Override
    public boolean eliminar (INodo<E> unElemento) 
    {
         if (unElemento!=null)
        {
            if(!esVacia() && existeElemento(unElemento))
            {
                if(unElemento.equals(this.getPrimero()))
                {
                    this.setPrimero(this.getPrimero().getSiguiente());
                }
                else
                {
                    INodo<E> anterior = anterior(unElemento);
                    anterior.setSiguiente(unElemento.getSiguiente());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta!=null)
        {
            if(!esVacia())
            {
                INodo<E> actual = this.buscar(unaEtiqueta);
                if (actual!=null)
                {
                    return eliminar(actual);
                }
            }
        }
        return false;
    }
    
    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                aux += temp.getEtiqueta();
                temp = temp.getSiguiente();
            }
            return aux;
        }
        return aux;
    }
    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }
    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
    @Override
    public INodo<E> getPrimero() {
        return primero;
    }
    @Override
    public void setPrimero(INodo<E> primero) {
        this.primero = primero;
    }
    @Override
    public INodo<E> quitarPrimero() 
    {
        if(!esVacia())
        {
            INodo<E> actual = this.getPrimero().getSiguiente();
            INodo<E> eliminado = this.getPrimero();
            eliminar(this.getPrimero());
            this.setPrimero(actual);
            return eliminado;
        }
        return null;
    }
    @Override
    public void vaciar() 
    {
        if(!esVacia())
        {
            while(this.getPrimero()!=null)
            {
                quitarPrimero();
            }
        }
    }
    @Override
    public INodo<E> anterior(Comparable unaEtiqueta) 
    {
       
        if(unaEtiqueta!=null)
        {
            if(!esVacia())
            {
                INodo<E> anterior= null;
                INodo<E> actual= this.buscar(unaEtiqueta);
                if (actual!=null)
                {
                    anterior=anterior(actual);
                }
                return anterior;
            }
        }
        return null;
    }
    @Override
     public void ordenar(){
        if(!esVacia()){
            Lista auxiliar = new Lista();
            INodo<E> actual= this.getPrimero();
            while(actual!=null){
                INodo<E> copia = actual.clonar();
                auxiliar.insertarOrdenado(copia);
                actual=actual.getSiguiente();
            }
            this.setPrimero(auxiliar.getPrimero());
        }
    }
    @Override
    public void invertir(){
        if(!esVacia()){
            Lista auxiliar = new Lista();
            INodo<E> actual=this.getPrimero();
            while(actual!=null){
                INodo<E> copia=actual.clonar();
                auxiliar.insertarAlPrincipio(copia);
                actual=actual.getSiguiente();
            }
            this.setPrimero(auxiliar.getPrimero());
        }
    }
    
    @Override
    public Lista<E> mezclar(Lista otraLista){
           
               Lista<E> resultado= new Lista();
               INodo<E> first =this.getPrimero();
               INodo<E>  second =otraLista.getPrimero();
                while(first!=null && second!=null){
                    first = pasarDeUnaAOtra(resultado,this,first);
                    second = pasarDeUnaAOtra(resultado,otraLista,second);
                }
                if(first==null){
                    while(second!=null){
                        second=pasarDeUnaAOtra(resultado,otraLista,second);
                    }
                }else{
                    while(first!=null){
                        first=pasarDeUnaAOtra(resultado,this,first);
                    }
                }
                return resultado;
            
            
    }
    
    @Override
    public INodo<E>  pasarDeUnaAOtra(Lista resultado, Lista otraLista, INodo<E>  actual){
               INodo<E>  copia= actual.clonar();
               resultado.insertarOrdenado(copia);
               actual=actual.getSiguiente();
               otraLista.quitarPrimero();
               return actual;
    }
    
    
    @Override
    public boolean estaOrdenada(){
        if(!esVacia()){
            INodo<E>  actual = this.getPrimero();
            while(actual.getSiguiente()!=null){
                if(actual.getEtiqueta().compareTo(actual.getSiguiente().getEtiqueta())>0){
                    return false;
                }else{
                    actual=actual.getSiguiente();
                }
            }
        }
        return true;
    }
    @Override
    public void eliminarDuplicados(){
        INodo<E> aux = this.getPrimero();
        while(aux!=null){
            INodo<E> siguiente = aux.getSiguiente();
            while(siguiente!=null){
                if(siguiente.getEtiqueta().equals(aux.getEtiqueta())){
                    this.eliminar(siguiente);
                }
                else{
                    siguiente = siguiente.getSiguiente();
                }
            }
            aux = aux.getSiguiente();
        }
    }
    
}


