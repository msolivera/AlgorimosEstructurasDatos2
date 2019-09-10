
import java.util.Collection;

/**
 *
 * @author Bruno Garcia
 */
public class TNodoTrie1 implements INodoTrie {

    private TNodoTrie1[] hijos = new TNodoTrie1[10];
    private TDispositivo dispositivo;

    @Override
    public void insertar(TDispositivo unDispositivo) {
        String dirIp = unDispositivo.getDirIP().replace(".", "");
        TNodoTrie1 nodo = this;
        int indice;
        for (int i = 0; i < dirIp.length(); i++) {
            indice = Integer.parseInt(dirIp.substring(i, i + 1));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie1();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.dispositivo = unDispositivo;
    }

    public void buscarDispositivos(String mascaraSubRed, Collection<TDispositivo> dispositivos) {
        TNodoTrie1 nodo = this;
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
        for (TNodoTrie1 nodo : hijos) {
            if (nodo != null) {
                nodo.buscarDispositivosAux(dispositivos);
            }
        }
    }
}
