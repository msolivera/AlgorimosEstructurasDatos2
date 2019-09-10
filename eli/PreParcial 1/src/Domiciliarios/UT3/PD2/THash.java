package Domiciliarios.UT3.PD2;

/**
 * @author Equipo 5
 */
public class THash {
    /**
     * Cantidad comparaciones promedio de todas las busquedas realizadas. 
     */
    public int[] cantidadPromedioBusquedasExito;
    public int[] cantidadPromedioBusquedasSinExito;  
    public int[] cantidadPromedioInsercionesExitosas;
    /**
     * Acumuladores para cada busqueda realizada. Sirve para saber cuantas comparaciones se realizan y se suman a la cantidad
     * promedio de busquedas tanto con exito o sin exito.
     */
    private int acumuladorBusquedaExito;
    private int acumuladorBusquedaNoExito;  
    /**
     * Tamaño de la tabla hash.
     */
    private int tamaño;    
    /**
     * Acumulador para la insercion. Su utilidad es para saber la cantidad de comparaciones que se realizan al insertar.
     * 
     */
    private int acumuladorInsercion;   
    /**
     * TABLA HASH
     */
    private int[] tabla;
    /**
     * Constructor de la clase THash
     * @param tamaño  tamaño de la tabla  hash.
     */
    public THash(int tamaño)
    {
        this.tamaño = tamaño;
        tabla = new int[tamaño];
        this.cantidadPromedioBusquedasSinExito = new int[1];
        this.cantidadPromedioBusquedasExito = new int[1];
        this.cantidadPromedioInsercionesExitosas = new int[1];
        
    }
    /**
     * Funcion de hash que devuelve la ubicacion de una determinada clave en la tabla hash.
     * @param unaClave clave clave para realizar el hashing
     * @return la ubicacion de una determinada clave en la tabla hash.
     */
    public int funcionHashing(int unaClave){
        return unaClave % tamaño;
    }
    /**
     * Metodo insertar de la tabla hash. Obtiene la ubicacion de la clave a insertar en la tabla, y si no hay colisiones
     * en la misma inserta, si las hay entonces sigue recorriendo hasta que encuentro un lugar libre. Si no encuentro lugar
     * libre la insercion es infructuosa. En todos los casos de devuelve como resultado la cantidad de comparaciones realizadas.
     * @param unaClave clave a insertar.
     * @return  cantidad de comparaciones realizadas
     */
    public int insertar(int unaClave){
        this.acumuladorInsercion = 1;
        int Ho =this.funcionHashing(unaClave);   //Ho es el resultado de la funcion hashing..
        int tamañoMaximo = tamaño -1;
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            Hi++;            
            if( Hi >= tamañoMaximo){        //estoy en el final, debo pasar al inicio...
                Hi = 0;
            }   
            if( Ho == Hi){ // ya di la vuelta entera..
                //System.out.println("No hay lugar disponible.");
                //System.out.println("Total comparaciones: " + acumuladorInsercion);                
                return acumuladorInsercion; 
            }
            this.acumuladorInsercion++;
                     
        }
        //Si encontre un lugar vacio... inserto
       
        tabla[Hi] = unaClave;
        this.cantidadPromedioInsercionesExitosas[0]+= this.acumuladorInsercion;
        //System.out.println("Insercion correcta: Total comparaciones: " + acumuladorInsercion);
        return acumuladorInsercion;
    }
    
    /**
     * Metodo identico al insertar anterior, pero devuelve true or false dependiendo si se inserto correctamente o no.
     * @param unaClave clave a insertar
     * @return true or false dependiendo si se inserto correctamente.
     */
    public boolean insertarAux(int unaClave){
        this.acumuladorInsercion = 1;
        int Ho =this.funcionHashing(unaClave);   //Ho es el resultado de la funcion hashing..
        int tamañoMaximo = tamaño -1;
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            Hi++;            
            if( Hi >= tamañoMaximo){        //estoy en el final, debo pasar al inicio...
                Hi = 0;
            }   
            if( Ho == Hi){ // ya di la vuelta entera..
//                System.out.println("No hay lugar disponible.");
//                System.out.println("Total comparaciones: " + acumuladorInsercion);
                return false; 
            }
            this.acumuladorInsercion++;
                     
        }
        //Si encontre un lugar vacio... inserto
       
        tabla[Hi] = unaClave;
        this.cantidadPromedioInsercionesExitosas[0]+= this.acumuladorInsercion;
//        System.out.println("Insercion correcta: Total comparaciones: " + acumuladorInsercion);
        return true;
    }
    
    
    /**
     * Metodo buscar de la tabla hash. Obtiene la ubicacion de la clave a insertar en la tabla y busca en esa ubicacion.
     * Si el elemento se encuentra en esa posicion simplemente devolvemos la cantidad de comparaciones que se realizaron.
     * En caso contrario se sigue recorriendo posicion por posicion del array hasta encontrar el elemento o hasta dar una
     * vuelta entera a la tabla.
     * @param unaClave clave a buscar
     * @return cantidad de comparaciones realizadas.
     */
    public int buscar(int unaClave){
        int tamañoMaximo = tamaño - 1;
        int contadorBusqueda = 1;
        int Ho = this.funcionHashing(unaClave);
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            if(tabla[Hi] == unaClave){
                this.cantidadPromedioBusquedasExito[0] += contadorBusqueda;
                //System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return contadorBusqueda;
            }
            Hi++;
            if(Hi >= tamañoMaximo){
                Hi = 0;
            }
            
            if(Hi == Ho){ //di la vuelta entera
                this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
                System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");
                return contadorBusqueda;
            }
            contadorBusqueda++;
        }
        // si encuentro un espacio vacio entonces la clave no se encuentra. Esto se debe a que cuando insertamos, si hay una colision
        // entonces seguimos recorriendo hasta encontrar un espacio vacio, NUNCA se saltea un espacio, por lo tanto es imposible que 
        // este despues de este espacio el elemento a buscar.
        
        this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return this.acumuladorBusquedaNoExito;
    }
    
    
    
    
    /**
     * Metodo identico a buscar anterior pero devuelve true si se encuentra o falso en caso contrario
     * @param unaClave clave a buscar
     * @return true si se encuentra, falso en caso contrario
     */
    public boolean existeClave(int unaClave){
        int tamañoMaximo = tamaño - 1;
        int contadorBusqueda = 1;
        int Ho = this.funcionHashing(unaClave);
        int Hi = Ho;
        while(tabla[Hi] > 0){
            
            if(tabla[Hi] == unaClave){
                this.cantidadPromedioBusquedasExito[0] += contadorBusqueda;
//                System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return true;
            }
            Hi++;
            if(Hi >= tamañoMaximo){
                Hi = 0;
            }
            
            if(Hi == Ho){ //di la vuelta entera
                this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
                //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");
                return false;
            }
            contadorBusqueda++;
            
        }
        // si encuentro un espacio vacio entonces la clave no se encuentra. Esto se debe a que cuando insertamos, si hay una colision
        // entonces seguimos recorriendo hasta encontrar un espacio vacio, NUNCA se saltea un espacio, por lo tanto es imposible que 
        // este despues de este espacio el elemento a buscar.
        
        this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return false;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
}
