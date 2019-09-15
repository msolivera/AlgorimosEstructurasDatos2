package Tries_Sufijos;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TTrieSufijosHashMap trie = new TTrieSufijosHashMap();
        String eltexto = "bananasenlasmananascuandolasranasnocomenlasanaspanamalozanas";
        
        for (int i = 0; i<eltexto.length(); i++) {
            String sufijo = eltexto.substring(i);
            System.out.println(sufijo);
            trie.insertar(sufijo, i);
        }
        
        String prefijo = "ana";
        ArrayList<Integer> posiciones = trie.ocurrenciasPosicionesPatron(prefijo);
        
        int contador = 0;
        for(Integer i : posiciones){
           if(contador == 0){
               System.out.println("CANTIDAD OCURRENCIAS:" + i);
           }
            else{
                System.out.println("posicion: " + i);
            }
            contador++;
        }
    }
}
