/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medibles;

import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class MedicionHashMap extends Medible{
    private HashMap mapa;
    public MedicionHashMap(HashMap map){
        this.mapa = map;
    }
    @Override
    public void ejecutar(Object... params){
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for(String palabra : palabras){
                mapa.containsKey(palabra);
            }
        }
    }
    @Override
    public Object getObjetoAMedirMemoria(){
        return this.mapa;
    }
}
