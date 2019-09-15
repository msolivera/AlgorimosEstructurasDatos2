/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA4ELI;

import UT3.TA4ELI.TablaHash;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Micaela
 */
public class TablaHashTest {
    
    public TablaHashTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
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
