package Tries_Abonados;
import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {
    
    private TNodoTrie raiz;
    
    
    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        if (raiz== null){
            raiz=new TNodoTrie();
        }
        LinkedList<TAbonado> abonados=new LinkedList<>();
        String prefijo = pais+area;
        //System.out.println("PREFIJO: "+prefijo);
        return raiz.buscarTelefonos(prefijo, abonados);
    }
    
    public Collection<TAbonado> buscarTelefonos(int pais, int area) {
        if (raiz==null){
            raiz=new TNodoTrie();
        }
        String prefijo = "0"+String.valueOf(pais).trim()+String.valueOf(area).trim();
        LinkedList<TAbonado> abonados=new LinkedList<>();
        //System.out.println("PREFIJO: "+prefijo);
        return raiz.buscarTelefonos(prefijo, abonados);
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz==null){
            raiz=new TNodoTrie();
        }
        raiz.insertar(unAbonado);
    }
    
}
