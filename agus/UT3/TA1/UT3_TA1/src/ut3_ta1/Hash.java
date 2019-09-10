/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta1;



/**
 *
 * @author usuario
 */
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
    public int insertar(int unaClave) {
        boolean terminar = false;
        int comparaciones = 0;
        int posicion = funcionHashing (unaClave);
        int pos = posicion;
        
        while (!terminar){
            comparaciones++;
            if (tabla[pos] == null){
                tabla[pos] = unaClave;
                return comparaciones;
            }
            else{
                pos+= 1;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
