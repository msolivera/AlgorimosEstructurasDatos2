/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medibles;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class MedicionPredecirHashMap extends Medible{
    private HashMap mapa;
    public MedicionPredecirHashMap(HashMap map){
        this.mapa = map;
    }
    @Override
    public void ejecutar(Object... params){
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for(String palabra : palabras){
                this.predecir(palabra);
            }
        }
    }
    
    public LinkedList<String> predecir (String prefijo){
        LinkedList<String> resultado = new LinkedList<>();
        for (Object a: mapa.keySet()){
            
            String b = (String)a;
            if (b.startsWith(prefijo)){
                resultado.add(b);
            }                
        }
        return resultado;
    }
    
    @Override
    public Object getObjetoAMedirMemoria(){
        return this.mapa;
    }
}
