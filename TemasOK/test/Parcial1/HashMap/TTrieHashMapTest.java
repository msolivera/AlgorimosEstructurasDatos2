package Parcial1.HashMap;

import Parcial1.HashMap.TTrieHashMap;
import Parcial1.HashMap.TDispositivo;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

public class TTrieHashMapTest {
    
    public TTrieHashMapTest() {
    }

    @Test
    public void testBuscarDispositivos() {
        System.out.println("buscarDispositivos");
        String mascaraSubRed = "192169000";
        TTrieHashMap instance = new TTrieHashMap();
        instance.insertar(new TDispositivo("192169000222","Esteban"));
        instance.insertar(new TDispositivo("192169000223","Carlos"));
        instance.insertar(new TDispositivo("192169001525","Agustin"));
        Collection<TDispositivo> expResult = null;
        Collection<TDispositivo> result = instance.buscarDispositivos(mascaraSubRed);
        assertTrue(result.size()==2);
        
    }
    @Test
    public void testBuscarDispositivosSinResultado() {
        System.out.println("buscarDispositivos");
        String mascaraSubRed = "321";
        TTrieHashMap instance = new TTrieHashMap();
        instance.insertar(new TDispositivo("192169000222","Esteban"));
        instance.insertar(new TDispositivo("192169000223","Carlos"));
        instance.insertar(new TDispositivo("192169001525","Agustin"));        
        Collection<TDispositivo> expResult = null;
        Collection<TDispositivo> result = instance.buscarDispositivos(mascaraSubRed);
        assertTrue(result.isEmpty());
        
    }    
}
