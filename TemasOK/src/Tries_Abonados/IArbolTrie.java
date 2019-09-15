package Tries_Abonados;
import java.util.Collection;

public interface IArbolTrie {

    Collection<TAbonado> buscarTelefonos(String pais, String area);

    void insertar(TAbonado unAbonado);
    
}
