package Hashing_Mediciones;


import java.util.LinkedList;

public class MedicionBuscarTrie extends Medible{

    private TArbolTrie linkedList;

    public MedicionBuscarTrie(TArbolTrie linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
