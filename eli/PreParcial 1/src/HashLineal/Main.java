/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashLineal;

/**
 *
 * @author Equipo 5
 */
public class Main {
    public static void main(String[] args){
        String[] aInsertar = ManejadorArchivosGenerico.leerArchivo("src/HashLineal/claves_insertar.txt");
        String[] aBuscar = ManejadorArchivosGenerico.leerArchivo("src/HashLineal/claves_buscar.txt");
        int contadorCantidadBusquedasExito = 0 ;
        int contadorCantidadBusquedasSinExito = 0;
        int elementosInsertados = 0;
        THash tabla = new THash(new Double(aInsertar.length/0.9).intValue());
        for(String clave: aInsertar){
            if(tabla.insertarAux(Integer.valueOf(clave))){
                elementosInsertados++;
            }
            
        }
        for(String claveAbuscar : aBuscar){
            if(tabla.existeClave(Integer.valueOf(claveAbuscar))){
                contadorCantidadBusquedasExito++;
            }             
            else{
                contadorCantidadBusquedasSinExito++;
            }
        }
        System.out.println("Tamaño de la tabla: " + tabla.getTamaño());
        System.out.println("Busquedas con exito promedio: " + tabla.cantidadPromedioBusquedasExito[0]/contadorCantidadBusquedasExito);
        System.out.println("Busquedas sin exito promedio: " + tabla.cantidadPromedioBusquedasSinExito[0]/contadorCantidadBusquedasSinExito);
        System.out.println("Insercion con exito promedio: " + tabla.cantidadPromedioInsercionesExitosas[0]/aInsertar.length);
    }
}
  