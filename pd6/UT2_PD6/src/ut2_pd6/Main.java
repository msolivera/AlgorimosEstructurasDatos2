package ut2_pd6;

import java.util.LinkedList;

/**
 *
 * @author Bruno Garcia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        
        String cadena = "ccttgacttgc";
        TArbolTrie arbol = new TArbolTrie();
        arbol.agregarSufijos(cadena);
        
        LinkedList patronCT = arbol.buscarPatron("ct");
        System.out.println(patronCT);
        
        LinkedList patronTG = arbol.buscarPatron("tg");
        System.out.println(patronTG);
        
        
        System.out.println("\nEjercicio 2\n");
        
        String secuencia = ManejadorArchivosGenerico.leerArchivo("src/ut2_pd6/secuencia.txt")[0];
        
        TArbolTrie arbol2 = new TArbolTrie();
        arbol2.agregarSufijos(secuencia);
        
        LinkedList patronCCTA = arbol2.buscarPatron("ccta");
        LinkedList patronGGTCA = arbol2.buscarPatron("ggtca");
        LinkedList patronAACCT = arbol2.buscarPatron("aacct");
        
        System.out.println("Patron ccta: "+patronCCTA);
        System.out.println("Patron ggtca: "+patronGGTCA);
        System.out.println("Patron aacct: "+patronAACCT);
    }
    
}
