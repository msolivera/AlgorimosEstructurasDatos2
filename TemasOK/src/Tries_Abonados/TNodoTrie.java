package Tries_Abonados;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private TNodoTrie[] hijos;
    private boolean esNumero;
    private String nombreAbonado;
    private String telefonoAbonado;
    
    public TNodoTrie(){
        hijos=new TNodoTrie[10];
        esNumero=false;
        nombreAbonado=null;
    }
    
    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrie nodo=this;
        String telefono = unAbonado.getTelefono();
        String nombre   = unAbonado.getNombre();
        
        for (int c=0; c<telefono.length();c++){
            int indice= telefono.charAt(c) - '0';
            
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esNumero = true;
        nodo.nombreAbonado= nombre;
        nodo.telefonoAbonado = telefono;
    }
    
    public LinkedList<TAbonado> buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie nodo=this;
        for(int c=0; c<primerosDigitos.length();c++){
            char letra = primerosDigitos.charAt(c);
            int indice= letra - '0';
            TNodoTrie nodoAux=nodo.hijos[indice];
            if(nodoAux!=null){
                nodo=nodoAux;
            }else{
                return null;
            }
        }
        this.buscarTelefonos(primerosDigitos, abonados, nodo);
        return abonados;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados, TNodoTrie nodo) {
        if(nodo.esNumero){
            TAbonado abonado= new TAbonado(nodo.nombreAbonado,primerosDigitos);
            abonados.add(abonado);
        }
        else{
            for (int c = 0; c < 10; c++){
                if (nodo.hijos[c] != null){
                    this.buscarTelefonos(primerosDigitos+c, abonados, nodo.hijos[c]);
                }
            }
        }
    }
}
