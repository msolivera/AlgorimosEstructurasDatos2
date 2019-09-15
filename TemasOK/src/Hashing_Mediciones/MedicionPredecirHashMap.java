package Hashing_Mediciones;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class MedicionPredecirHashMap  {

    public HashMap<String, String> predecir(String prefijo, HashMap<String, String> hash) {
        HashMap<String, String> salida = new HashMap<>();
        Set<String> s = hash.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            String ob = it.next();
            if(ob.length() >= prefijo.length() && 
                    ob.substring(0,prefijo.length()).contains(prefijo)){
                salida.put(ob, ob);
            }
        }
        
        return salida;
    }
   
  
}
