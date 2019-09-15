///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.util.LinkedList;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author usuario
// */
//public class TArbolTrie1Test {
//    
//    public TArbolTrie1Test() {
//    }
//
//    @Test
//    public void testBuscarDispositivos1() {
//        String cadena = "235.132.079.236,disp1014";
//        
//        String[] cadena2 = cadena.split(",");
//        TDispositivo dis = new TDispositivo(cadena2[0], cadena2[1], "");
//        
//        TArbolTrie1 arbol = new TArbolTrie1();
//        
//        arbol.insertar(dis);
//        
//        LinkedList<TDispositivo> res = (LinkedList) arbol.buscarDispositivos("235.");
//        
//        assertEquals(res.size(), 1);
//    }
//    
//    @Test
//    public void testBuscarDispositivos2() {
//            
//        String cadena = "235.132.079.236,disp1014";
//        
//        String[] cadena2 = cadena.split(",");
//        TDispositivo dis = new TDispositivo(cadena2[0], cadena2[1], "");
//        
//        TArbolTrie1 arbol = new TArbolTrie1();
//        
//        arbol.insertar(dis);
//        
//        LinkedList<TDispositivo> res = (LinkedList) arbol.buscarDispositivos("232.");
//        
//        assertEquals(res.size(), 0);
//    }
//}
