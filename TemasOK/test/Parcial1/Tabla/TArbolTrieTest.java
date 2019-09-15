/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.Tabla;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsilva
 */
public class TArbolTrieTest {
    
    public TArbolTrieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarDispositivos method, of class TArbolTrie.
     */
    @Test
    public void testBuscarDispositivos() {
        System.out.println("buscarDispositivos");
        String mascaraSubRed = "";
        TArbolTrie instance = new TArbolTrie();
        Collection<TDispositivo> expResult = null;
        Collection<TDispositivo> result = instance.buscarDispositivos(mascaraSubRed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class TArbolTrie.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TDispositivo unDispositivo = null;
        TArbolTrie instance = new TArbolTrie();
        instance.insertar(unDispositivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarSalida method, of class TArbolTrie.
     */
    @Test
    public void testOrdenarSalida() {
        System.out.println("ordenarSalida");
        Collection dispositivos = null;
        TArbolTrie instance = new TArbolTrie();
        String[] expResult = null;
        String[] result = instance.ordenarSalida(dispositivos);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
