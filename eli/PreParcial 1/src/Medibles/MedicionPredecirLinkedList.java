/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medibles;

import java.util.LinkedList;

/**
 *
 * @author Equipo5
 */
public class MedicionPredecirLinkedList extends Medible{
    LinkedList<String> list;
    public MedicionPredecirLinkedList(LinkedList lista){
        this.list = lista;
    }
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                this.precedir(palabra);
            }
        }
    }
    public LinkedList<String> precedir(String prefijo){
        LinkedList<String> resultado = new LinkedList();
        for(String a : list){
//             if((a.length() >= prefijo.length()) && (a.substring(0,prefijo.length()-1).equals(prefijo))){
//              startsWith realiza lo mismo que lo superior.
             if(a.startsWith(prefijo)){
                    resultado.add(a);
             }
        
            
        }
        return resultado;
        
    }
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.list;
    }
}
