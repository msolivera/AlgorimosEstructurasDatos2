package Clasificaciones;

public class Insercion {
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
        
        //ORDEN ASCENDENTE
        int[] lista = c.ordenarPorInsercion(datos);
        System.out.println("\n");
        c.imprimir(lista);
        System.out.println("");
        System.out.println(c.ordenadoAscendente(lista));
        System.out.println("\n");
        
        String[] salida = c.arrayIntToString(lista);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaInsercion.txt", salida,false);
        
        //ORDEN DESCENDENTE
        int[] lista2 = c.ordenarPorInsercionDesc(datos);
        System.out.println("\n");
        c.imprimir(lista2);
        System.out.println("");
        System.out.println(c.ordenadoDescendente(lista2));
        System.out.println("\n");
        
        salida = c.arrayIntToString(lista2);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaInsercion.txt", salida,true);
    }
}
