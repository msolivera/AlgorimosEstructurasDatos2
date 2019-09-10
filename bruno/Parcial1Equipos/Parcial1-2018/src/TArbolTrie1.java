
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Bruno Garcia
 */
public class TArbolTrie1 implements IArbolTrie{

    private TNodoTrie1 raiz = new TNodoTrie1();

    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        mascaraSubRed = mascaraSubRed.replace(".", "");
        LinkedList<TDispositivo> dispositivos = new LinkedList();
        
        raiz.buscarDispositivos(mascaraSubRed, dispositivos);
        
        return dispositivos;
    }
    
    @Override
    public void insertar(TDispositivo unDispositivo) {
        raiz.insertar(unDispositivo);
    }
    
}
