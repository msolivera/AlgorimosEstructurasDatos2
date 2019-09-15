package Tries_Abonados;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

public class TArbolTrieTest {
    @Test
    public void testBuscarTelefonosEncontrados() {
        System.out.println("testBuscarTelefonosEncontrados");
        TArbolTrie trie=new TArbolTrie();
        TAbonado abo0= new TAbonado("ELIAS SERRA", "05490145702");
        TAbonado abo1= new TAbonado("ITXASO DIMITROV", "05490146501");
        TAbonado abo2= new TAbonado("ALEXANDRE ARAGON", "05491147115");
        TAbonado abo3= new TAbonado("IGNACIA PEPA", "05491152370");
        TAbonado abo4= new TAbonado("JOSE MIGUEL DIEZ", "05491152496");
        trie.insertar(abo0);
        trie.insertar(abo1);
        trie.insertar(abo2);
        trie.insertar(abo3);
        trie.insertar(abo4);
        
        Collection<TAbonado> abonados=trie.buscarTelefonos("054", "91");
        assertEquals(3, abonados.size());
    }
    
    @Test
    public void testBuscarTelefonosNoEncontrados() {
        System.out.println("testInsertarNoExito");
        TArbolTrie t1 = new TArbolTrie();
       
        TAbonado abo0= new TAbonado("ELIAS SERRA", "05490145702");
        TAbonado abo1= new TAbonado("ITXASO DIMITROV", "05490146501");
        TAbonado abo2= new TAbonado("ALEXANDRE ARAGON", "05491147115");
        TAbonado abo3= new TAbonado("IGNACIA PEPA", "05491152370");
        TAbonado abo4= new TAbonado("JOSE MIGUEL DIEZ", "05491152496");
        t1.insertar(abo0);
        t1.insertar(abo1);
        t1.insertar(abo2);
        t1.insertar(abo3);
        t1.insertar(abo4);
        boolean existe = false;
        Collection<TAbonado> ab = t1.buscarTelefonos("095","91152411");
        if (ab!=null){
            for (TAbonado a:ab){
                System.out.println("ABONADO: "+a.getNombre());
            }
            if (ab.size()==1){
                existe=true;
            }
            assertFalse(existe);
        }else{
            assertFalse(existe);
        }
    }
    
    @Test
    public void testInsertarExito() {
        System.out.println("testInsertarExito");
        TArbolTrie trie=new TArbolTrie();
       
        TAbonado abo0= new TAbonado("ELIAS SERRA", "05490145702");
        TAbonado abo1= new TAbonado("ITXASO DIMITROV", "05490146501");
        TAbonado abo2= new TAbonado("ALEXANDRE ARAGON", "05491147115");
        TAbonado abo3= new TAbonado("IGNACIA PEPA", "05491152370");
        TAbonado abo4= new TAbonado("JOSE MIGUEL DIEZ", "05491152496");
        trie.insertar(abo0);
        trie.insertar(abo1);
        trie.insertar(abo2);
        trie.insertar(abo3);
        trie.insertar(abo4);
        
        Collection<TAbonado> abonados=trie.buscarTelefonos("054", "9");
        assertEquals(5, abonados.size());
    }
    
    @Test
    public void testInsertarNoExito() {
        System.out.println("testInsertarNoExito");
        TArbolTrie t1 = new TArbolTrie();
       
        TAbonado abo0= new TAbonado("ELIAS SERRA", "05490145702");
        TAbonado abo1= new TAbonado("ITXASO DIMITROV", "05490146501");
        TAbonado abo2= new TAbonado("ALEXANDRE ARAGON", "05491147115");
        TAbonado abo3= new TAbonado("IGNACIA PEPA", "05491152370");
        TAbonado abo4= new TAbonado("JOSE MIGUEL DIEZ", "05491152496");
        t1.insertar(abo0);
        t1.insertar(abo1);
        t1.insertar(abo2);
        t1.insertar(abo3);
        t1.insertar(abo4);
        int cantidad = 0;
        Collection<TAbonado> ab = t1.buscarTelefonos("099","8");
        if (ab!=null){
            for (TAbonado a:ab){
                System.out.println("ABONADO: "+a.getNombre());
            }
            cantidad = ab.size();
            assertEquals(0, cantidad);
        }else{
            System.out.println("NO SE ENCONTRARON ELEMENTOS");
            assertEquals(0, cantidad);
        }
    }
}
