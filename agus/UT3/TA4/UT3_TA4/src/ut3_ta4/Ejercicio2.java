package ut3_ta4;
import java.util.Collection;
import java.util.HashMap;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        System.out.println("<<<< SONDEO CUADRATICO >>>>");
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta4/claves_insertar.txt");
        //Hash t = new Hash(claves.length);
        
        double[] vec = {0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.91,0.92,0.93,0.94,0.95,0.96,0.97,0.98,0.99};
        String[] lineas = new String[500];
        int j = 0;
        lineas[j++] = "factor de carga,prom inserción, prom busq exitosa, prom busq no exitosa";
        for (int i=0; i < vec.length; i++){
            Hash t = new Hash(claves.length,vec[i]);

            System.out.println("++++ INSERCIONES FACTOR DE CARGA ("+vec[i]+")++++");
            double promedioComparaciones = 0;
            
            for (String c : claves) {
                int actual = t.insertar(Integer.parseInt(c));
                //System.out.println("Comparaciones al INSERTAR la clave "+c+"-> "+actual);
                promedioComparaciones = promedioComparaciones + actual;
            }
            double promInsercion = promedioComparaciones/claves.length;
            System.out.println("PROMEDIO DE COMPARACIONES: "+promInsercion);

            //Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
            String[] claves_buscar = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta4/claves_buscar.txt");

            System.out.println("++++ BUSQUEDAS ++++");
            int noExiste=0;
            int existe=0;
            promedioComparaciones = 0;
            for (String c : claves_buscar) {
                int actual = t.buscar(Integer.parseInt(c));
                if (actual==-1)
                    noExiste+=1;
                else
                    existe+=1;
                //System.out.println("Comparaciones al BUSCAR la clave "+c+"-> "+actual);
                promedioComparaciones = promedioComparaciones + actual;
            }
            float cla=claves_buscar.length;
            float ex=existe;
            float noEx=noExiste;
            float promBusqExito = ex/cla;
            float promBusqNoExito = noEx/cla;
//            System.out.println("CANT DE CLAVES NO ENCONTRADAS: "+noExiste);
//            System.out.println("CANT DE CLAVES ENCONTRADAS: "+existe);
            System.out.println("Promedio de Comparaciones con Exito: "+ promBusqExito);
            System.out.println("Promedio de Comparaciones sin Exito: "+ promBusqNoExito);
             double prueba=0;
           
           
            lineas[j++] = vec[i]+","+promInsercion+","+promBusqExito+","+promBusqNoExito;
            
            System.out.println("");
            System.out.println("");

        }
        ManejadorArchivosGenerico.escribirArchivo("src/ut3_ta4/salida.csv",lineas);
    }
}
