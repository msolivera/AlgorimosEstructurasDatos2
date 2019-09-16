package Hash;
public class Hash implements IHash{
    int tamanio;
    Integer [] tabla;
    
    public Hash (int cantElem){
        tamanio = (cantElem*110)/100;
        tabla = new Integer[tamanio];
    }
    
    @Override
    public int buscar(int unaClave) {
        boolean terminar = false;
        int comparaciones = 0;
        int posicion = funcionHashing (unaClave);
        int pos = posicion;
        
        while (!terminar){
            comparaciones++;
            Integer elemento = tabla[pos];
            if (elemento !=null){
                if ( elemento == unaClave){
                    return comparaciones;
                }
            }
            pos +=1;
            if (pos == tabla.length){
                pos = 0;
            }
            if (pos == posicion){
                return -1;
            }
        }
        return comparaciones;
    }

    @Override
    public int insertar(int clave){
        boolean terminar = false;
        int comparaciones = 0;
        int posicion = funcionHashing(clave);
        System.out.print("Posición "+posicion+" de la tabla -> ");
        int pos = posicion;

        while(!terminar){
            comparaciones ++;
            if (tabla[pos] == null){
                tabla[pos] = clave;
                return comparaciones;
            }
            else{   
                pos += 1;
                if (pos == tabla.length){
                    pos = 0;
                }
            }
            if (pos == posicion){
                return -1;
            }
        }
        return comparaciones;
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
    
}
