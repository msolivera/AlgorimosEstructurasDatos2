/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashConIcuadrado;


import java.text.DecimalFormat;

/**
 *
 * @author Equipo 5
 */
public class Main {
    public static void main(String[] args){
        String[] aInsertar = ManejadorArchivosGenerico.leerArchivo("src/HashConIcuadrado/claves_insertar.txt");
        String[] aBuscar = ManejadorArchivosGenerico.leerArchivo("src/HashConIcuadrado/claves_buscar.txt");
        
        THash tabla = new THash(new Double(aInsertar.length/0.99).intValue());
        THash tabla1 = new THash(new Double(aInsertar.length/0.98).intValue());
        THash tabla2= new THash(new Double(aInsertar.length/0.97).intValue());
        THash tabla3 = new THash(new Double(aInsertar.length/0.96).intValue());
        THash tabla4 = new THash(new Double(aInsertar.length/0.95).intValue());
        THash tabla5 = new THash(new Double(aInsertar.length/0.94).intValue());
        THash tabla6 = new THash(new Double(aInsertar.length/0.93).intValue());
        THash tabla7 = new THash(new Double(aInsertar.length/0.92).intValue());
        THash tabla8 = new THash(new Double(aInsertar.length/0.91).intValue());
        THash tabla9 = new THash(new Double(aInsertar.length/0.90).intValue());
        THash tabla10 = new THash(new Double(aInsertar.length/0.85).intValue());
        THash tabla11 = new THash(new Double(aInsertar.length/0.80).intValue());
        THash tabla12 = new THash(new Double(aInsertar.length/0.75).intValue());
        THash tabla13 = new THash(new Double(aInsertar.length/0.70).intValue());
        THash[] tablas = {tabla,tabla1,tabla2,tabla3,tabla4,tabla5,
                        tabla6,tabla7,tabla8,tabla9,tabla10,tabla11,tabla12,tabla13};
        double[] factorCarga = {0.99,0.98,0.97,0.96,0.95,0.94,0.93,0.92,0.91,0.90,0.85,0.80,0.75,0.70};
        int contador = 0;
        int busqConExito = 0;
        int busqSinExito = 0;
        int cantidadInserciones = 0;
        
        String texto = "";
        String[] lineas = new String[14];
        for(THash t : tablas){
            for(String clave: aInsertar){
                if(t.insertar2(Integer.valueOf(clave))){
                    cantidadInserciones++;
                }        
                
            }
            int j = 0;
            for(String claveAbuscar : aBuscar){
                if(t.buscar2(Integer.valueOf(claveAbuscar))){
                    busqConExito++;
                }
                else{
                    busqSinExito++;
                }

            }
                DecimalFormat df = new DecimalFormat("0.00");
                double bexito = new Double(t.cantidadPromedioBusquedasExito[0])/ busqConExito;
                double bsinexito = new Double(t.cantidadPromedioBusquedasSinExito[0])/ new Double(busqSinExito);
                double insercionexito = new Double(t.cantidadPromedioInsercionesExitosas[0])/new Double(cantidadInserciones);
                String b = df.format(bexito);
                bexito = Double.valueOf(df.format(bexito).replaceAll(",", "."));
                bsinexito = Double.valueOf(df.format(bsinexito).replaceAll(",", "."));
                insercionexito = Double.valueOf(df.format(insercionexito).replaceAll(",", "."));
                        
                texto+= factorCarga[contador] + ";" + bexito + ";" + 
                        bsinexito + ";" +insercionexito;     
               
                lineas[contador] = texto;
                texto  = "";
                contador++;
                busqSinExito =0;
                cantidadInserciones = 0;
                busqConExito =0;
                
        }
      
        ManejadorArchivosGenerico.escribirArchivo("src/HashConIcuadrado/factores.csv", lineas);
        
        
        
        
        
    }
}
  