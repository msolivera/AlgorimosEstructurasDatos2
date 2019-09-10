package arbolgenerico;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Garcia
 */
public class TArbolTest {
    
    public TArbolTest() {
    }

    @Test
    public void testInsertarRaizVacio() {
        TArbol arbol = new TArbol();
        arbol.insertar("EtiquetaRaiz", "");
        assertTrue(arbol.getRaiz().getEtiqueta() == "EtiquetaRaiz");
    }
    
    @Test
    public void testInsertarRaizNoVacio(){
        TNodoArbol raiz = new TNodoArbol("EtiquetaRaizOriginal");
        TArbol arbol = new TArbol(raiz);
        arbol.insertar("EtiquetaRaizNueva", "");
        assertTrue(arbol.getRaiz().getEtiqueta() == "EtiquetaRaizNueva");
    }
    
}
