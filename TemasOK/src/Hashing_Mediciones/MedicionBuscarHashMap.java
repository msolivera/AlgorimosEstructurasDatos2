package Hashing_Mediciones;


import java.util.LinkedList;
import java.util.HashMap;

public class MedicionBuscarHashMap extends Medible{

    private HashMap linkedList;

    public MedicionBuscarHashMap(HashMap linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.containsValue(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
