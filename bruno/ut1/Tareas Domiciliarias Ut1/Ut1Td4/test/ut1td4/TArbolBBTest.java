/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1td4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Garcia
 */
public class TArbolBBTest {

    public TArbolBBTest() {
    }

    /**
     * Altura acumulada de arbol vacio es -1
     */
    @Test
    public void testSumaAlturasNodos1() {
        TArbolBB arbol = new TArbolBB();
        assertTrue(arbol.sumaAlturasNodos() == -1);
    }

    /**
     * Altura acumulada de arbol que solo tiene raiz es 0
     */
    @Test
    public void testSumaAlturasNodos2() {
        TArbolBB arbol = new TArbolBB();
        TNodoABB raiz = new TNodoABB();
        arbol.setRaiz(raiz);
        assertTrue(arbol.sumaAlturasNodos() == 0);
    }

    /**
     * Altura acumulada conocida
     * Altura acumulada = 3
     *          0(h=2)
     *      ----|----
     *     0(h=1)    0(h=0)
     *  ---|
     * 0 (h=0)
     */
    @Test
    public void testSumaAlturasNodos3() {
        TArbolBB arbol = new TArbolBB();
        TNodoABB raiz = new TNodoABB();
        TNodoABB elem1 = new TNodoABB();
        TNodoABB elem2 = new TNodoABB();
        TNodoABB elem3 = new TNodoABB();
        arbol.setRaiz(raiz);
        raiz.setHijoIzq(elem1);
        raiz.setHijoDer(elem2);
        elem1.setHijoIzq(elem3);
        assertTrue(arbol.sumaAlturasNodos() == 3);
    }

}
