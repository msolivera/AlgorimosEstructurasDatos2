package Clasificaciones;

public class Binsort {
    public static void main(String[] args) {
        String[] datosCrudos = ManejadorArchivosGenerico.leerArchivo("src/clasificaciones/claves.txt", false);
        int[] datos = new int[datosCrudos.length];
        int i=0;
        for (String s : datosCrudos){
            //System.out.println(s);
            datos[i]= Integer.parseInt(s);
            i+=1;
        }
        TClasificador c = new TClasificador();
        
        //ORDEN ASCENDENTE - sin repetidos (si el archivo tiene claves duplicadas, se descartan las repeticiones)
        int[] lista = c.ordenarPorBinsort(datos);
        System.out.println("\n");
        c.imprimirBinsort(lista);
        System.out.println("");
        System.out.println(c.ordenadoAscendenteBinSort(lista));
        System.out.println("\n");
        String[] salida = c.arrayIntToStringBinsort(lista);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaBinsort.txt", salida,false);
        
        //ORDEN DESCENDENTE - sin repetidos (si el archivo tiene claves duplicadas, se descartan las repeticiones)
        int[] lista2 = c.ordenarPorBinsortDesc(datos);
        System.out.println("\n");
        c.imprimirBinsort(lista2);
        System.out.println("");
        System.out.println(c.ordenadoDescendenteBinSort(lista2));
        System.out.println("\n");
        salida = c.arrayIntToStringBinsort(lista2);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaBinsort.txt", salida,true);
        
        
        //ORDEN ASCENDENTE - con repetidos
        int[] lista3 = c.ordenarPorBinsortRepetidos(datos);
        System.out.println("\n");
        c.imprimirBinsortRepetidos(lista3);
        System.out.println("\n");
        salida = c.arrayIntToStringBinsortRepetidos(lista3);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaBinsort.txt", salida,true);
        
        //ORDEN DESCENDENTE - con repetidos
        int[] lista4 = c.ordenarPorBinsortRepetidosDesc(datos);
        System.out.println("\n");
        c.imprimirBinsortRepetidosDesc(lista4);
//        System.out.println("");
//        System.out.println(c.ordenadoDescendenteBinSortRepetidos(lista4));
        System.out.println("\n");
        salida = c.arrayIntToStringBinsortRepetidosDesc(lista4);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaBinsort.txt", salida,true);
    }
}

