package Domiciliarios.UT2.IndiceLibro;

public class TArbolTrie {

    private TNodoTrie raiz;
    public int cantidadComparaciones;

    public void insertar(String palabra,Integer indicePagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, indicePagina);
    }
     public void insertar(String unaPalabra) {
         if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unaPalabra);
     }

    public TNodoTrie buscar(String palabra){
        palabra = palabra.toLowerCase();
        cantidadComparaciones = 0;
        int indice = 0;        
        TNodoTrie aux = raiz;
        while (indice < palabra.length() && aux != null)
        {
            cantidadComparaciones++;
            aux = aux.buscar(palabra.charAt(indice));
            indice ++;
        }
        if(aux!=null && aux.getEsPalabra()){
            return aux;
        }
        return null;
    }
    public void indizarLibro(String rutaArchivo){
        int contadorPaginas = 0;
        String[] lineas = ManejadorArchivos.leerArchivo(rutaArchivo);
        for (int i = 0; i < lineas.length; i++) {
            contadorPaginas++;
            String[] palabras = lineas[i].split(" ",-1);
            for (int j = 0; j < palabras.length; j++) {
                palabras[j] = palabras[j].toLowerCase();
                int pagina = contadorPaginas / 50;
                palabras[j]= palabras[j].replaceAll("[^a-z\\s]", "");
                TNodoTrie palabra = this.buscar(palabras[j]);
                if(palabra!=null){
                        if(palabra.getPaginasIndice().buscar(pagina) ==null){
                            palabra.getPaginasIndice().insertarAlFinal(new Nodo(pagina,pagina));
                        }                        
                }     
            }
        }
    }
    public int tamaño(){
        if(raiz!=null){
            return raiz.tamaño();
        }
        return 0;
        
    }
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public void imprimirIndice(){
        if(raiz != null){
            raiz.imprimirIndice();
        }
    }
    public TNodoTrie getRaiz() {
        return raiz;
    }

    public void setRaiz(TNodoTrie raiz) {
        this.raiz = raiz;
    }
    
}
