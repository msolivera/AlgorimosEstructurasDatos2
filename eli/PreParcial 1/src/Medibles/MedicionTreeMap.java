/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medibles;

import java.util.TreeMap;

/**
 *
 * @author Equipo5
 */
public class MedicionTreeMap extends Medible {
    private TreeMap mapa;
    public MedicionTreeMap(TreeMap mapaTree){
        this.mapa = mapaTree;
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
