package ut3_ta4;

public class Hash implements IHash{
    int tamanio;
    Integer [] tabla;
    
    public Hash (int cantElem){
        tamanio = this.primerPrimo((cantElem*150)/100);
        tabla = new Integer[tamanio];
    }
    
    public Hash(int cantElem, double factor){
        double aux = cantElem/factor;
        int aux2 = (int) Math.round(aux);
        this.tamanio = primerPrimo(aux2);
        //System.out.println("Tamaño tabla: "+tamanio);
        tabla = new Integer[tamanio];
    }
  
    @Override
    public int funcionHashing(int unaClave) {
        int aux = 0;
        aux = unaClave % this.tamanio;
        return aux;
    }
    
    @Override
    public int insertar(int clave){
        int comparaciones = 0;
        int posicion = funcionHashing(clave);
        int pos = posicion;
        int clavesNoIns=0;
        int clavesIns=0;
        
        int i = 1;
        int j = 0;
        int veces = 0;
        while(true){
            comparaciones ++;
            if (pos<tabla.length && tabla[pos] == null){
                tabla[pos] = clave;
                clavesIns+=1;
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
                    clavesNoIns+=1;
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
        Integer elemento = null;
        while (true){
            comparaciones ++;
            if (pos<tabla.length)
                elemento = tabla[pos];
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
                    if (pos>=tabla.length){
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
    
    public int word2key(String palabra){
        int aux=-1;
        if (palabra!=null){
            for (int i=0;i<palabra.length();i++){
                aux += palabra.charAt(i);
            }
        }
        return aux;
    }
}
