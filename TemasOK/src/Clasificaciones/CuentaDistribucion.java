package Clasificaciones;

public class CuentaDistribucion {
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
        int[] lista = c.ordenarPorCuentaPorDistrubucion(datos);
        System.out.println("\n");
        c.imprimir(lista);
        System.out.println("");
        System.out.println(c.ordenadoAscendente(lista));
        System.out.println("\n");
        String[] salida = c.arrayIntToString(lista);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaCuentadistribucion.txt", salida,false);
        
        //ORDEN DESCENDENTE
        int[] lista2 = c.ordenarPorCuentaPorDistrubucionDesc(datos);
        System.out.println("\n");
        c.imprimir(lista2);
        System.out.println("");
        System.out.println(c.ordenadoDescendente(lista2));
        System.out.println("\n");
        salida = c.arrayIntToString(lista2);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaCuentadistribucion.txt", salida,true);
    
        //ORDEN ASCENDENTE PARA CHARS
        String[] datosChar = ManejadorArchivosGenerico.leerArchivo("src/clasificaciones/claves_char.txt", false);
        char[] chars = new char[datosChar.length];
        int k=0;
        for (String s : datosChar){
            //System.out.println(s);
            chars[k]= s.trim().charAt(0);
            k+=1;
        }
        char[] lista3 = c.ordenarPorCuentaPorDistrubucionChars(chars);
        System.out.println("\n");
        c.imprimir(lista3);
        System.out.println("");
        System.out.println(c.ordenadoAscendente(lista3));
        System.out.println("\n");
        salida = c.arrayCharToString(lista3);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaCuentadistribucion.txt", salida,false);
        
        //ORDEN DESCENDENTE PARA CHARS
        char[] lista4 = c.ordenarPorCuentaPorDistrubucionCharsDesc(chars);
        System.out.println("\n");
        c.imprimir(lista4);
        System.out.println("");
        System.out.println(c.ordenadoDescendente(lista4));
        System.out.println("\n");
        salida = c.arrayCharToString(lista4);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones/salidaCuentadistribucion.txt", salida,false);
        System.out.println("QUE RICA!!!");
    }
}
