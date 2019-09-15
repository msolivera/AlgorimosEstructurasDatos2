package Tries_Abonados;
import java.util.LinkedList;
public interface INodoTrie {

    void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados, TNodoTrie nodo);

    void insertar(TAbonado unAbonado);
    
}
