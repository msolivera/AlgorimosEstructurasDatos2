package HashConIcuadrado;



/**
 * @author Equipo 5
 */
public class THash {
    /**
     * Cantidad comparaciones para inserciones
     */
    public int[] cantidadPromedioInsercionesExitosas;
    public int[] cantidadPromedioInsercionesNoExitosas;
    /**
     * Cantidad comparaciones promedio de todas las busquedas realizadas. 
     */
    public int[] cantidadPromedioBusquedasExito;
    public int[] cantidadPromedioBusquedasSinExito;  
    /**
     * Acumuladores para cada busqueda realizada. Sirve para saber cuantas comparaciones se realizan y se suman a la cantidad
     * promedio de busquedas tanto con exito o sin exito.
     */
    private int acumuladorBusquedaExito;
    private int acumuladorBusquedaNoExito;  
    /**
     * Tamaño de la tabla hash.
     */
    public int tamaño;    
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
        this.cantidadPromedioInsercionesNoExitosas = new int[1];
        
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
        int i = 1;        
        int vueltas =1;
        while(tabla[Hi] > 0){
            
            Hi=Hi+ (int) (Math.pow(i, 2));
            i++;
            
            if( Hi >= tamañoMaximo){        //estoy en el final, debo pasar al inicio...
                if(vueltas == 0){
                    //System.out.println("No hay lugar disponible.");
                    //System.out.println("Total comparaciones: " + acumuladorInsercion);                
                    this.cantidadPromedioInsercionesNoExitosas[0] += acumuladorInsercion;
                    return acumuladorInsercion; 
                }
                vueltas--;
                Hi = 0;
                i = 1;
                
            }   
           
            
            this.acumuladorInsercion++;
            
                     
        }
        
        //Si encontre un lugar vacio... inserto      
        
        tabla[Hi] = unaClave;
        //System.out.println("Insercion correcta: Total comparaciones: " + acumuladorInsercion);
        this.cantidadPromedioInsercionesExitosas[0] += acumuladorInsercion;
        return acumuladorInsercion;
    }
    
    /**
     * Segundo metodo insertar de la tabla hash. Obtiene la ubicacion de la clave a insertar en la tabla, y si no hay colisiones
     * en la misma inserta, si las hay entonces sigue recorriendo hasta que encuentro un lugar libre. Si no encuentro lugar
     * libre la insercion es infructuosa. En todos los casos de devuelve como resultado veradero en caso de insercion con exito
     * o falso en caso contrario
     * @param unaClave clave a insertar.
     * @return  verdadero o falso si la insercion es hecha con exito o no.
     */
    public boolean insertar2(int unaClave){
        this.acumuladorInsercion = 1;
        int Ho = this.funcionHashing(unaClave);   //Ho es el resultado de la funcion hashing..
        int tamañoMaximo = tamaño -1;
        int Hi = Ho;
        int i = 1;        
        int vueltas =1;
        while(tabla[Hi] > 0){
            
            Hi=Hi+ (int) (Math.pow(i, 2));
            i++;
            
            if( Hi >= tamañoMaximo){        //estoy en el final, debo pasar al inicio...
                if(vueltas == 0){
                    //System.out.println("No hay lugar disponible.");
                    //System.out.println("Total comparaciones: " + acumuladorInsercion);                
                    this.cantidadPromedioInsercionesNoExitosas[0] += acumuladorInsercion;
                    return false; 
                }
                vueltas--;
                Hi = 0;
                i = 1;
                
            }             
            
            this.acumuladorInsercion++;
            
                     
        }
        
        //Si encontre un lugar vacio... inserto      
        
        tabla[Hi] = unaClave;
        //System.out.println("Insercion correcta: Total comparaciones: " + acumuladorInsercion);
        this.cantidadPromedioInsercionesExitosas[0] += acumuladorInsercion;
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
        int i =1;
        int vueltas = 1;
        while(tabla[Hi] > 0){
            
            if(tabla[Hi] == unaClave){
                this.cantidadPromedioBusquedasExito[0] +=contadorBusqueda;
//                System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return contadorBusqueda;
            }
            Hi=Hi + (int) (Math.pow(i, 2));
            i++;
            if(Hi >= tamañoMaximo){
                if(vueltas == 0){
                    this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;                
                    //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");
                    return contadorBusqueda;
                }
                Hi = 0;
                i = 1;
                vueltas--;
            }
            
            contadorBusqueda++;
        }
          
        this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return contadorBusqueda;
    }
    /**
     * Mismo metodo que el buscar pero devuelve verdadero o falso en caso de busquedas infructuosas o con exito.
     * @param unaClave clave a buscar
     * @return verdadero o falso dependiendo si la busqueda es infructuosa o con exito.
     */
    public boolean buscar2(int unaClave){
            
        int tamañoMaximo = tamaño - 1;
        int contadorBusqueda = 1;
        int Ho = this.funcionHashing(unaClave);
        int Hi = Ho;
        int i =1;
        int vueltas = 1;
        while(tabla[Hi] > 0){
            
            if(tabla[Hi] == unaClave){
                this.cantidadPromedioBusquedasExito[0] +=contadorBusqueda;
//                System.out.println("Se encontro la clave : " + unaClave + " con un total de " + acumuladorBusquedaExito + " comparaciones.");
                return true;
            }
            Hi=Hi + (int) (Math.pow(i, 2));
            i++;
            if(Hi >= tamañoMaximo){
                if(vueltas == 0){
                    this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;                
                    //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");
                    return false;
                }
                Hi = 0;
                i = 1;
                vueltas--;
            }
            
            contadorBusqueda++;
        }
          
        this.cantidadPromedioBusquedasSinExito[0] += contadorBusqueda;
        //System.out.println(" Busqueda sin exito, no se encontro la clave " + unaClave + ", con un total de " + acumuladorBusquedaNoExito + " comparaciones.");           
        return false;
    }
    
    
    
    
}
