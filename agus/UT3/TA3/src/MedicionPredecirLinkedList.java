

import java.util.LinkedList;

public class MedicionPredecirLinkedList  {

    public LinkedList predecir(String prefijo, LinkedList<String> lista) {
        LinkedList salida = new LinkedList();
        for (int c = 0; c < lista.size()-1; c++){
            
            if (lista.get(c).length() >= prefijo.length() && 
                    lista.get(c).substring(0,prefijo.length()).contains(prefijo)){
                salida.add(lista.get(c));
            }
        }
        return salida;
    }
   
  
}
