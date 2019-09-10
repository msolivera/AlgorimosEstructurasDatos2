package ut3_ta1;

public class Hash implements IHash{
    int tamanio;
    Integer [] tabla;
    
    public Hash (int cantElem){
        tamanio = (cantElem*110)/100;
        tabla = new Integer[tamanio];
    }
  
    @Override
    public int funcionHashing(int unaClave) {
        int aux = 0;
        aux = unaClave % this.tamanio;
        return aux;
    }
    
    public int word2key(String palabra){
        int aux=-1;
        if (palabra!=null){
            for (int i=0;i<palabra.length();i++){
                aux += palabra.charAt(i);
            }
        }
        return aux;
    }
    
    @Override
    public int insertar(int clave){
        int comparaciones = 0;
        int posicion = funcionHashing(clave);
        int pos = posicion;
        
        int i = 1;
        int j = 0;
        int veces = 0;
        while(true){
                
            comparaciones ++;
            if (tabla[pos] == null){
                tabla[pos] = clave;
                return comparaciones;
            }
            else{ 
                j = pos + i*i;
                if (j > tabla.length){
                    pos = j - tabla.length - 1;
                    if (pos>tabla.length){
                        while(pos> this.tamanio){
                            pos = pos - tabla.length - 1;
                            if (pos == tabla.length){
                                pos = 0;
                            }
                        }
                    }
                }else{
                    if(j==tabla.length){
                        pos=0;}
                    else{
                        pos = j;
                    }
                }
                // Aquí controlamos la cantidad de comparaciones para que la tabla tenga sentido
                if (veces > tabla.length*4){
                    return -1;
                }
            i++;
            veces++;
            }
        }
    }
    
    @Override
    public int buscar(int clave){

        int comparaciones = 0;
        int posicion = funcionHashing(clave);
        int pos = posicion;
        
        int i = 1;
        int j = 0;
        int veces = 0;
        while (true){
            comparaciones ++;
            Integer elemento = tabla[pos];
            if (elemento == null){
                return -1;
            } 
                if (elemento == clave){
                    return comparaciones;
                }
            
            else { 
                j = pos + i*i;
                if (j > tabla.length){
                    pos = j - tabla.length - 1;
                    if (pos>tabla.length){
                        while(pos> this.tamanio){
                            pos = pos - tabla.length - 1;
                            if (pos == tabla.length){
                                pos = 0;
                            }
                        }
                    }
                }else{
                    if(j==tabla.length){
                        pos=0;}
                    else{
                    pos = j;
                    }
                } 
            }
            // Aquí controlamos la cantidad de comparaciones para que la tabla tenga sentido
            if (veces > tabla.length*4){
                return -1;
            }
            veces++;
            i++;
        } 
    }
    
    public int primerPrimo(int num){
        num++;
        for(int i = 2;i<num;i++){
            if(num%i == 0){
                num++;
                i=2;
            }
            else{
                continue;
            }
        }
        return num;
    }
}
