/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andres
 */
public class TablaHashTest {
    
    public TablaHashTest() {
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
     * Test of insertar method, of class TablaHash.
     */
    @Test
    public void testInsertarCuad() {
        System.out.println("insertarCuad");
        int unaClave = 1;
        TablaHash instance = new TablaHash(1, 0.5);
        boolean expResult = true;
        instance.insertar(unaClave);
        boolean result = instance.estaCompleto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of buscar method, of class TablaHash.
     */
    @Test
    public void testBuscarCuad() {
        System.out.println("buscarCuad");
        int unaClave = 0;
        TablaHash instance = null;
        boolean expResult = false;
        boolean result = instance.buscar(unaClave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
