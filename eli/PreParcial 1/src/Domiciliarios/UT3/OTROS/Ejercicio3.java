package Domiciliarios.UT3.OTROS;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Bruno Martinez
 */
public class Ejercicio3 {
     TreeMap<Integer,TreeSet<String>> arbolMapa;
     public Ejercicio3(){
         arbolMapa = new TreeMap();
     }
     public void obtenerOrdenadoLongitud(String[] palabras) {
        
        for (String palabra : palabras) {
            if (arbolMapa.containsKey(palabra.length())) {
                arbolMapa.get(palabra.length()).add(palabra);
            }
            else{
                TreeSet arbolOrdenadoLexicograficamente = new TreeSet();
                arbolOrdenadoLexicograficamente.add(palabra);
                arbolMapa.put(palabra.length(), arbolOrdenadoLexicograficamente);               
            }            
        }
        
    }
    public void imprimir(){
        
        for (Map.Entry<Integer, TreeSet<String>> entrySet : arbolMapa.entrySet()) {            
            TreeSet<String> palabras = entrySet.getValue();            
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        }
    }
    public static void main(String[] args){
        Ejercicio3 ej = new Ejercicio3();
        String[] palabrasParaOrdenar = {"hola","chau","bienvenido","welcome","hello","hi","ya","jaja","balcon","jugaran"};
        ej.obtenerOrdenadoLongitud(palabrasParaOrdenar);
        ej.imprimir();
    }
}
