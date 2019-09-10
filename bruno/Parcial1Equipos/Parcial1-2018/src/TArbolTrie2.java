import java.util.LinkedList;

public class TArbolTrie2 {

    private TNodoTrie2 raiz;

    public void insertar(TDispositivo dispositivo) {
        if (raiz == null) {
            raiz = new TNodoTrie2();
        }
        raiz.insertar(dispositivo);
    }


    public LinkedList<TDispositivo> buscarDispositivos(String prefijo) {
        LinkedList<TDispositivo> lista = new LinkedList();
        raiz.buscarDispositivos(prefijo, lista);
        return lista;
}

}
