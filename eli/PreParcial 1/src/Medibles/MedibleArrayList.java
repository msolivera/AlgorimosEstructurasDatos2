/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medibles;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MedibleArrayList extends Medible{

    private ArrayList arrayList;

    public MedibleArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                arrayList.contains(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arrayList;
    }
    
}
