/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anabe
 */
public class TArbolGenericoTest<T> {
    
    private TArbolGenerico<T> arbolVacio;
    private TArbolGenerico<T> arbolSoloRaiz;
    private TArbolGenerico<T> arbolCompleto;
    
    public TArbolGenericoTest() {
        arbolVacio =  new TArbolGenerico();
        arbolSoloRaiz = new TArbolGenerico();
        arbolCompleto = new TArbolGenerico();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        arbolVacio = new TArbolGenerico();
        arbolSoloRaiz = new TArbolGenerico(new TNodoArbolGenerico("Raiz")); 
        arbolCompleto = new TArbolGenerico(new TNodoArbolGenerico("Raiz"));
        arbolCompleto.insertar("Hijo_1", "Raiz");
        arbolCompleto.insertar("Hijo_2", "Raiz");
        arbolCompleto.insertar("Hijo_3", "Raiz");
        arbolCompleto.insertar("Nieto_1", "Hijo_2");
        arbolCompleto.insertar("Nieto_2", "Hijo_2");
        arbolCompleto.insertar("Nieto_3", "Hijo_2");
        
        /*   ##   ARBOL   COMPLETO ##
                
                Raiz
              /
        Hijo1 -->   Hijo2 -->   Hijo3
                    /
                Nieto1 --> Nieto2 --> Nieto3 
                    
        */         
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRaiz method, of class TArbolGenerico.
     */
    @Test
    public void testGetRaiz() {
        assertNull(this.arbolVacio.getRaiz());
        assertNotNull(this.arbolSoloRaiz.getRaiz());
        assertEquals(this.arbolSoloRaiz.getRaiz().getEtiqueta(),"Raiz");
        assertNotNull(this.arbolCompleto.getRaiz());
        assertEquals(this.arbolCompleto.getRaiz().getEtiqueta(),"Raiz");
    }

    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertar() {
        assertNull(this.arbolVacio.getRaiz());
        this.arbolVacio.insertar("inserto","");
        assertNotNull(this.arbolVacio.getRaiz());
        assertEquals(this.arbolVacio.getRaiz().getEtiqueta(), "inserto");
        assertNull(this.arbolSoloRaiz.getRaiz().getPrimerHijo());
        this.arbolSoloRaiz.insertar("inserto","Raiz");
        assertNotNull(this.arbolSoloRaiz.getRaiz().getPrimerHijo());
        assertEquals(this.arbolSoloRaiz.getRaiz().getPrimerHijo().getEtiqueta(), "inserto");
        
    }

    /**
     * Test of buscar method, of class TArbolGenerico.
     */
    @Test
    public void testBuscar() {
        assertNull(this.arbolVacio.buscar("Raiz"));
        assertNotNull(this.arbolSoloRaiz.buscar("Raiz"));
        assertSame(TNodoArbolGenerico.class, this.arbolSoloRaiz.buscar("Raiz").getClass());
        assertEquals(this.arbolSoloRaiz.buscar("Raiz").getClass(), TNodoArbolGenerico.class);
        assertEquals(this.arbolCompleto.buscar("Esta clave no esta en el arbol"),null);
    }

    /**
     * Test of listarIndentado method, of class TArbolGenerico.
     */
    @Test
    public void testListarIndentado() {
        assertEquals(this.arbolVacio.listarIndentado(),"");
        assertNotEquals(this.arbolSoloRaiz.listarIndentado(), "");
    }
    
}
