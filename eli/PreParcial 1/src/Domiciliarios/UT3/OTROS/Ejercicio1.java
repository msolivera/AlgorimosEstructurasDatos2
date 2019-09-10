package Domiciliarios.UT3.OTROS;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bruno Martinez
 */
public class Ejercicio1 {
    
    
    Map<Object,Object> mapa;
    Map<Object,Object> mapaNuevo;
    
    public Ejercicio1(){
        mapa = new HashMap();
        mapaNuevo = new HashMap();
    }
    public void eliminarNulos(){
        
        for(Map.Entry<Object,Object> elemento : mapa.entrySet()){
            if(elemento.getValue() != null){
                mapaNuevo.put(elemento.getKey(), elemento.getValue());
            }
        }
        mapa = mapaNuevo;
    }
    public boolean verificarFuncionamientoEliminarNulos(){
        for(Map.Entry<Object,Object> elemento : mapa.entrySet()){
            if(elemento == null){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Ejercicio1 ej = new Ejercicio1();
        Integer[] valor = {1,10,23,null,3,2,18,null};
        Integer[] keys = {1,10,23,11,3,2,18,15};
        for (int i = 0; i < keys.length; i++) {
            ej.mapa.put(keys[i], valor[i]);
        }
        System.out.println("Tamaño mapa: " + ej.mapa.size());
        ej.eliminarNulos();
        if(ej.verificarFuncionamientoEliminarNulos()){
            System.out.println("Se han eliminado todos los elementos nulos del mapa!");
            System.out.println("Nuevo tamaño del mapa: " + ej.mapa.size());
        }
        else{
            System.out.println("Error, no se han eliminado correctamente los elementos nulos");
        }
        
        
        
    }
}
