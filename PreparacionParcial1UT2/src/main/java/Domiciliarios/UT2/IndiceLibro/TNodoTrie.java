package Domiciliarios.UT2.IndiceLibro;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private static final int OCURRENCIAS_MAXIMAS_INDICE = 20;
    public TNodoTrie[] hijos;
    private boolean esPalabra;
    private ILista<Integer> paginasIndice;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginasIndice = new Lista();
    }
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();                
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }
    public void insertar(String unaPalabra,Integer indicePagina) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
                nodo.hijos[indice].getPaginasIndice().insertarAlFinal(new Nodo(indicePagina,indicePagina));
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    private void imprimirIndice(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " -> " + nodo.getPaginasIndice().imprimir(","));
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    public int tamaño(){
        int tamaño = 0;
        for (int i = 0; i < this.hijos.length; i++) {
            if(this.hijos[i] != null){
                tamaño+= hijos[i].tamaño();
                tamaño++;

            }
        }
        return tamaño;
    }
    public void imprimir() {
        imprimir("", this);
    }
    public void imprimirIndice(){
        imprimirIndice("",this);
    }
    public TNodoTrie buscar(char letra){
        
        int indice = letra - 'a';        
        if (hijos[indice] != null) {
            return hijos[indice];
        }
        return null;
    }
    
    public boolean getEsPalabra(){
        return esPalabra;
    }

    public TNodoTrie[] getHijos() {
        return hijos;
    }

    public void setHijos(TNodoTrie[] hijos) {
        this.hijos = hijos;
    }

    public boolean isEsPalabra() {
        return esPalabra;
    }

    public ILista<Integer> getPaginasIndice() {
        return paginasIndice;
    }

    public void setPaginasIndice(ILista<Integer> paginasIndice) {
        this.paginasIndice = paginasIndice;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }
    
 }
