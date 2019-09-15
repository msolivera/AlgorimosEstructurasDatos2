package Grafos_No_Dirigidos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices;
    private Collection<TArista> aristas;
    
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> listaAristas) {
        this.vertices = new HashMap<>();
        this.aristas  = listaAristas;
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : listaAristas) {
            insertarArista(arista);
        }
    }
    
    public TGrafoDirigido() {
        this.vertices = new HashMap<>();
    }
    
    public Collection<TArista> getAristas(){
        return this.aristas;
    }
    
    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return 
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * invalida, retorna false.
     *
     * @param nombreVertice
     * @return 
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }
 
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    
    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
 
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }
    
 

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }
    
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matriz = this.floyd();
        Set<Comparable> etiquetasVertices = this.vertices.keySet();
        Comparable[] array = new Comparable[matriz.length];
        array = etiquetasVertices.toArray(array);
        int columna = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == etiquetaVertice){
                columna = i;
                break;
            }
        }
        Double ex = matriz[0][columna];
        for (int i =0; i<matriz.length; i++){
            if(matriz[i][columna]>ex && matriz[i][columna]<Double.MAX_VALUE && matriz[i][columna]>0.0){
                ex = matriz[i][columna];
            }
        }
        return ex;
    }

    @Override
    public Comparable centroDelGrafo() {
        Iterator<TVertice> it = vertices.values().iterator();
        Comparable[] excentricidades = new Comparable[vertices.size()];
        Comparable centro = Double.MAX_VALUE;
        Comparable etiqueta_centro = "";
        
        int i = 0;
        while(it.hasNext()){
            Comparable a = excentricidades[i];
            Comparable etiqueta_vertice = it.next().getEtiqueta();
            
             a = this.obtenerExcentricidad(etiqueta_vertice);
            if(a.compareTo(centro) == -1){
                Double valor = Double.parseDouble(a.toString());
                if(valor>1){
                    centro = a;
                    etiqueta_centro = etiqueta_vertice;
                }
            }
        }
        return etiqueta_centro+" (" + centro.toString().trim()+")";
    }
    
    @Override
    public Double[][] floyd() {
        Double[][] A = UtilGrafos.obtenerMatrizCostos(vertices);
        for(int i=0;i<A.length;i++){
            A[i][i]=0.0;
        }
        int longitud = A.length;
        for (int k = 0; k < longitud; k++) {
            for (int i = 0; i < longitud; i++) {
                for (int j = 0; j < longitud; j++) {
                    if(i != j && i != k && k != j){
                        if (A[i][k] + A[k][j] < A[i][j]) {
                            A[i][j] = A[i][k] + A[k][j];
                        }
                    }
                }
            }
        }
        return A;
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] war = new boolean[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                war[i][j] = false;

                if (i != j && matriz[i][j] != Double.MAX_VALUE) {
                    war[i][j] = true;
                }
            }
        }
        for (int k = 0; k < war.length; k++) {
            for (int i = 0; i < war.length; i++) {
                for (int j = 0; j < war.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!war[i][j]) {
                            war[i][j] = war[i][k] && war[k][j];
                        }
                    }
                }
            }
        }
        return war;
    }
    
    public Double getCostoMinimo(Comparable origen, Comparable destino){
        Double costo=0.0;
        TVertice ori = this.buscarVertice(origen);
        TVertice des = this.buscarVertice(destino);
        Double[][] matriz = this.floyd();
        int columna = -1;
        int fila=-1;
        if (ori!=null && des!=null && matriz!=null){
            Set<Comparable> etiquetasVertices = vertices.keySet();
            Comparable[] array = new Comparable[matriz.length];
            array = etiquetasVertices.toArray(array);
          
            for (int i = 0; i < array.length; i++) {
                    if(array[i]==des.getEtiqueta() || array[i]==ori.getEtiqueta())
                        if(array[i]==des.getEtiqueta())
                            columna=i;
                        else
                            fila=i;
                    
                    if(fila!=-1 && columna!=-1)
                        break;
                }
            }  
        costo = matriz[fila][columna];
        return costo;
    }
    
    public boolean existeConexion(Comparable origen, Comparable destino){
        boolean existe = false;
        int columna = -1;
        int fila=-1;
        TVertice ori = this.buscarVertice(origen);
        TVertice des = this.buscarVertice(destino);
        boolean [][] matriz = this.warshall();
        if (ori!=null && des!=null && matriz!=null){
            
            Set<Comparable> etiquetasVertices = vertices.keySet();
            Comparable[] array = new Comparable[matriz.length];
            array = etiquetasVertices.toArray(array);
          
            for (int i = 0; i < array.length; i++) {
                    if(array[i]==des.getEtiqueta() || array[i]==ori.getEtiqueta())
                        if(array[i]==des.getEtiqueta())
                            columna=i;
                        else
                            fila=i;
                    
                    if(fila!=-1 && columna!=-1)
                        break;
            }
            existe= matriz[fila][columna];
        }
        return existe;    
    }
    
    public boolean tieneCiclo() {
        this.desvisitarVertices();
        boolean res = false;
        
        for (TVertice vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                TCamino camino = new TCamino(vertV);
                res = vertV.tieneCiclo(camino);
                if(res){
                    camino.imprimirEtiquetasConsola();
                    return true;
                }
            }
        }
        return res;
    }
    
    public boolean tieneCiclo(TCamino camino) {
        /**** ESTE METODO HAY QUE REVISARLO *****/
        this.desvisitarVertices();
        camino.getOrigen().setVisitado(true);
        LinkedList<Comparable> lista = (LinkedList<Comparable>) camino.getOtrosVertices();
        TVertice v = null;
        for (Comparable etiqueta : lista){
            v = this.buscarVertice(etiqueta);
            if (v!=null){
                v.setVisitado(true);
            }
        }
        boolean res = false;
        res = v.tieneCiclo(camino);
        if(res){
            camino.imprimirEtiquetasConsola();
            return true;
        }
        return res;
        /**** ESTE METODO HAY QUE REVISARLO *****/
    }

    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        TVertice v = this.buscarVertice(etiquetaOrigen);
        boolean res = false;
        if (v!=null){
            TCamino camino = new TCamino(v);
            res = v.tieneCiclo(camino);
            if(res){
                camino.imprimirEtiquetasConsola();
                return true;
            }
        }
        return res;
    }
    
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }
    
    /**
     * BPF del grafo, a partir del primer vértice, para todos los vertices
     * @return 
     */
    public Collection<Comparable> bpf() {
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        this.desvisitarVertices();
        
        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    vertV.bpf(listaBpf);
                }
            }
        }
        return listaBpf;
    }
    
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        this.desvisitarVertices();
        TVertice origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            origen.bpf(listaBpf);
        }
        return listaBpf;
    }

    public Collection<Comparable> bpf(TVertice vertice) {
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        this.desvisitarVertices();
        TVertice origen = vertices.get(vertice.getEtiqueta());
        if (origen != null) {
            origen.bpf(listaBpf);
        }
        return listaBpf;
    }
    
    /**
     *
     * @param origen
     * @param destino
     */
    public Collection<Comparable> bpf(Comparable origen, Comparable destino){
        TVertice vOrigen = this.buscarVertice(origen);
        TVertice vDestino = this.buscarVertice(destino);
        Collection<Comparable> listaBpf = new LinkedList<>();
        if(vOrigen!=null && vDestino!=null){
            this.desvisitarVertices();
            vOrigen.bpf(listaBpf, vDestino);
        }
        else{
            System.out.println("ATENCIÓN: El vértice Origen o Destino NO existen.");
        }
        return listaBpf;
    }
    
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        TCaminos todosLosCaminos = new TCaminos();
        TVertice ori = buscarVertice(etiquetaOrigen);
        TVertice des = buscarVertice(etiquetaDestino);
        if (ori!=null && des!=null) {
            TCamino caminoPrevio = new TCamino(ori);
            ori.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }else{
            if (ori==null)
                System.out.println("Origen no existe");
            else
                System.out.println("Destino no existe");
        }
        return null;
    }
    
    /**
     *
     * @param origen
     * @param destino
     */
    public void caminoCritico(Comparable origen, Comparable destino){
        if(!this.tieneCiclo()){
            this.desvisitarVertices();
            TCaminos caminos = this.todosLosCaminos(origen, destino);
            TVertice vOrigen = this.buscarVertice(origen);
            vOrigen.caminoCritico(caminos);
        }
        else{
            System.out.println("ATENCIÓN: El grafo tiene ciclos. Finaliza el proceso de caminoCritico().");
        }
    }
    
    public TCamino caminoMasCorto(Comparable origen, Comparable destino){
        Double minimo = Double.MAX_VALUE;
        TCamino resultado = null;
        if(!this.tieneCiclo()){
            this.desvisitarVertices();
            
            TCaminos caminos = this.todosLosCaminos(origen, destino);
            for(TCamino camino : caminos.getCaminos()){
                camino.imprimirEtiquetasConsola();
                if (camino.getCostoTotal()<minimo){
                    minimo = camino.getCostoTotal();
                    resultado = camino.copiar();
                }
            }
        }
        else{
            System.out.println("ATENCIÓN: El grafo tiene ciclos.");
        }
        return resultado;
    }
    
    public void ordenPreviaturas(TVertice origen){
        Collection<TArista> aristasInvertidas = new LinkedList<>();
        for (TArista a : aristas){
            
        }
        TGrafoDirigido gdInvertido = new TGrafoDirigido(this.vertices.values(),aristasInvertidas);
        if(origen!=null){
            TVertice ori = this.buscarVertice(origen.getEtiqueta());
            if(ori!=null){
                if(!this.tieneCiclo()){
                    this.desvisitarVertices();
                    ori.ordenPreviaturas();
                }else{
                    System.out.println("El grafo tiene ciclos.");
                }
            }else{
                System.out.println("El vertice '"+origen.getEtiqueta().toString().trim()+"' NO pertenece al grafo.");
            }
        }else{
            System.out.println("El vertice Origen dado es nulo.");
        }
    }
    
    public LinkedList<TVertice> ordenTopologico(){
        if(!tieneCiclo()){
            this.desvisitarVertices();
            LinkedList<TVertice> camino = new LinkedList();
            for(TVertice v: vertices.values()){
                if(!v.getVisitado()){
                    v.ordenTopologico(camino);
                }
            }
            return camino;
        }
        System.out.println("Tiene ciclos");
        return null;
    }
    
    public void imprimirTopologico(LinkedList<TVertice> camino){
        String oTopologico = "";
        if(camino!=null){  
            for(TVertice v: camino){
                oTopologico = v.getEtiqueta() + " - " + oTopologico;
            }
            System.out.println(oTopologico);           
        }
    }
}
