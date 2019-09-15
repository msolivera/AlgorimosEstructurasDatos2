package Parcial1.Tabla;


import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private TNodoTrie[] hijos;
    private boolean esIp;
    private String ip;
    private TDispositivo dev;
    private String dato;

    public TNodoTrie[] getHijos() {
        return hijos;
    }

    public String getDato() {
        return dato;
    }

    public void setHijos(TNodoTrie[] hijos) {
        this.hijos = hijos;
    }

    public boolean isEsIp() {
        return esIp;
    }

    public void setEsIp(boolean esIp) {
        this.esIp = esIp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public TDispositivo getDev() {
        return dev;
    }

    public void setDev(TDispositivo dev) {
        this.dev = dev;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    public TNodoTrie(){
        this.hijos=new TNodoTrie[11];
        this.esIp=false;
        this.dev=null;
    }
    
    @Override
    public void insertar(TDispositivo dispositivo) {
        TNodoTrie nodo=this;
        String nroip = dispositivo.getDirIP().trim();
        int indice=-1;
        for (int c=0; c < nroip.length() ; c++){
            char letra = nroip.charAt(c);
            if (nroip.charAt(c)=='.'){
                indice=10;
            }else{
                if (letra!=' '){
                    indice = nroip.charAt(c) - '0';
                }
            }
            if(indice<11 && indice>=0){
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            }else{
                return;
            }
        }
        nodo.esIp = true;
        nodo.ip= nroip;
        nodo.dev = dispositivo;
    }
    
    public LinkedList<TDispositivo> buscarDispositivos(String subred, LinkedList<TDispositivo> lista) {
        TNodoTrie nodo=this;
        for(int c=0; c<subred.length();c++){
            int indice;
            if (subred.charAt(c)=='.'){
                indice=10;
            }else{
                indice=subred.charAt(c) - '0';
            }
            TNodoTrie nodoAux=nodo.hijos[indice];
            if(nodoAux!=null){
                nodo=nodoAux;
            }else{
                return null;
            }
        }
        this.getTraerTodos(subred, lista, nodo);
        return lista;
    }
    
    public void getTraerTodos(String subred, LinkedList<TDispositivo> lista, TNodoTrie nodo) {
        if(nodo.esIp){
            lista.add(nodo.dev);
            return;
        }
        else{
            for (int c = 0; c < 11; c++){
                if (nodo.hijos[c] != null){
                    char letra;
                    if (c==10){
                        letra ='.';
                    }else{
                        letra = (char) (c + '0');
                    }
                    this.getTraerTodos(subred+letra, lista, nodo.hijos[c]);
                }
            }
        }
    }
}
