
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface INodoTrie {

    LinkedList<TAbonado> buscarTelefonos(String codigoPais, String codigoArea,LinkedList<TAbonado> abonados);

    void insertar(TAbonado unAbonado);
    
}
