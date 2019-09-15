package Parcial1.Tabla;


import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class TArbolTrie implements IArbolTrie {
    
    private TNodoTrie raiz;

    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        if (raiz== null){
            raiz=new TNodoTrie();
        }
        LinkedList<TDispositivo> dispositivos=new LinkedList<>();
        //System.out.println("PREFIJO: "+mascaraSubRed);
        return raiz.buscarDispositivos(mascaraSubRed, dispositivos);
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        if(raiz==null){
            raiz=new TNodoTrie();
        }
        raiz.insertar(unDispositivo);
    }
    
    public String[] ordenarSalida(Collection dispositivos){
        LinkedList<TDispositivo> l = (LinkedList) dispositivos;
        
        TreeSet<String> ts=new TreeSet();
        TreeSet<String> ts2=new TreeSet();
        String[] lin = new String[l.size()];
        int i=0;
        if (l.size()>0){
            //Ordeno la colección en otra que inserta ordenado
            for(TDispositivo dd : l){
                ts.add(dd.getNombre()+","+dd.getDirIP());
            }
            for(String d: ts){
                System.out.println(d);
                lin[i]=d;
                i+=1;
            }
        }
        return lin;
    }
}
