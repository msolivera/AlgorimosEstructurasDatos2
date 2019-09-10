package Domiciliarios.UT3.OTROS;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Bruno Martinez
 */
public class Ejercicio2 {
    Map<String,String> mapa;
    
    public Ejercicio2(){
        mapa = new HashMap();
    }
    public static void main(String[] args){
        Ejercicio2 ej = new Ejercicio2();
        String[] valor = {"hola","chau","bienvenido","welcome","hello","hi"};
        String[] keys = {"1","2","3","4","5","6"};
        for (int i = 0; i < valor.length; i++) {
            ej.mapa.put(keys[i], valor[i]);
        }
        Set<Entry<String,String>> elementos = ej.mapa.entrySet();
        for(Entry<String,String> elemento : elementos){
            System.out.println("Clave: " + elemento.getKey() + " , Valor: "+ elemento.getValue());
        }
        ej.intercambiarKeysValue();
        Set<Entry<String,String>> elementosPosterior = ej.mapa.entrySet();
        System.out.println("Luego de invertir:");
        for(Entry<String,String> elemento : elementosPosterior){            
            System.out.println("Clave: " + elemento.getKey() + " , Valor: "+ elemento.getValue());
        }
        
        
    }
    public void intercambiarKeysValue(){
        Map<String,String> mapaNuevo = new HashMap();
        for(Map.Entry<String,String> elemento : mapa.entrySet()){
            String key = elemento.getKey();
            String value = elemento.getValue();
            mapaNuevo.put(value, key);
        }
        mapa = mapaNuevo;
    }
}
