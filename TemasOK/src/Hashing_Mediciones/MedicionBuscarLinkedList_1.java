package Hashing_Mediciones;


import java.util.LinkedList;

public class MedicionBuscarLinkedList_1 extends Medible{

    private LinkedList linkedList;

    public MedicionBuscarLinkedList_1(LinkedList linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.contains(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
