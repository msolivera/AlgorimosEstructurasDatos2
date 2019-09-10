
import java.util.Collection;

/**
 *
 * @author Bruno Garcia
 */
public class TNodoTrie implements INodoTrie {

    private TNodoTrie[] hijos = new TNodoTrie[10];
    private TDispositivo dispositivo;

    @Override
    public void insertar(TDispositivo unDispositivo) {
        String dirIp = unDispositivo.getDirIP().replace(".", "");
        TNodoTrie nodo = this;
        int indice;
        for (int i = 0; i < dirIp.length(); i++) {
            indice = Integer.parseInt(dirIp.substring(i, i + 1));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.dispositivo = unDispositivo;
    }

    @Override
    public void buscarDispositivos(String mascaraSubRed, Collection<TDispositivo> dispositivos) {
        TNodoTrie nodo = this;
        int indice;
        for (int i = 0; i < mascaraSubRed.length(); i++) {
            indice = Integer.parseInt(mascaraSubRed.substring(i, i + 1));
            if (nodo.hijos[indice] == null) {
                return;
            }
            nodo = nodo.hijos[indice];
        }
        nodo.buscarDispositivosAux(dispositivos);
    }

    private void buscarDispositivosAux(Collection<TDispositivo> dispositivos) {
        if (dispositivo != null) {
            dispositivos.add(dispositivo);
        }
        for (TNodoTrie nodo : hijos) {
            if (nodo != null) {
                nodo.buscarDispositivosAux(dispositivos);
            }
        }
    }
}
