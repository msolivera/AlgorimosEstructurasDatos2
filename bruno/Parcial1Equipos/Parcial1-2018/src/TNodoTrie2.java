
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrie2 {

    private static final int CANT_CHR_ABECEDARIO = 10;
    private HashMap hijos;
    private boolean esIp;
    private TDispositivo dispositivoGeneral;

    public TNodoTrie2() {
        hijos = new HashMap(CANT_CHR_ABECEDARIO);
        esIp= false;
    }

    public void insertar(TDispositivo dispositivo) {
        TNodoTrie2 nodo = this;
        String dirIp= dispositivo.getDirIP().replace(".", "");
        int indice;
        for (int c = 0; c < dirIp.length(); c++) {
            indice = Integer.parseInt(dirIp.substring(c,c+1));
            if(nodo.hijos.get(indice)==null){
                nodo.hijos.put(indice, new TNodoTrie2());
            }
            nodo = (TNodoTrie2) nodo.hijos.get(indice);
        }
        nodo.esIp = true;
        nodo.dispositivoGeneral=dispositivo; 
        
    }




    private void predecirAux(LinkedList<TDispositivo> palabras) {
        if (this.esIp) {
            palabras.add(this.dispositivoGeneral);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (this.hijos.get(c) != null) {
                ((TNodoTrie2) this.hijos.get(c)).predecirAux(palabras);
            }
        }

    }

    public void buscarDispositivos(String prefijo, LinkedList<TDispositivo> palabras) {
        TNodoTrie2 nodo = this;
        for (int c = 0; c < prefijo.length(); c++) {
            int indice = prefijo.charAt(c) - '0';
            if (nodo.hijos.get(indice) != null) {
                nodo = (TNodoTrie2) nodo.hijos.get(indice);
            } else {
                return;
            }
        }
        nodo.predecirAux(palabras);
    }
}
