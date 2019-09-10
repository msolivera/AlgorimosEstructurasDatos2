



import java.util.Collection;
import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz; 
    
    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> lista  = new LinkedList<>();
        return raiz.buscarTelefonos(pais, area, lista);
    
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unAbonado);
    
    }

  
    
    
}
