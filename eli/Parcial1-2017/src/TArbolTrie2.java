



import java.util.Collection;
import java.util.LinkedList;


public class TArbolTrie2 implements IArbolTrie {

    private TNodoTrie2 raiz; 
    
    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> lista  = new LinkedList<>();
        return raiz.buscarTelefonos(pais, area, lista);
    
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie2();
        }
        raiz.insertar(unAbonado);
    
    }

  
    
    
}
