package ut1td1;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bruno Garcia
 */
public class Ut1Td1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] col1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] col2 = {0, 1, 2, 3, 5, 6, 8, 12, 50, 64, 84, 85, 86, 87, 88, 89, 90, 91, 92, 100, 2033, 100235, 100236, 1000000};

        int randomNum, resLineal = 0, resBinaria = 0, n = 100;

        for (int i = 0; i < n; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(col2[0], col2[col2.length - 1] + 1);
            resLineal += busquedaLineal(col2, randomNum);
            resBinaria += busquedaBinaria(col2, randomNum);
        }

        System.out.println("Busqueda lineal: " + resLineal/n);
        System.out.println("Busqueda binaria: " + resBinaria/n);
    }

    /**
     * Utiliza busqueda lineal para encontrar un valor en una coleccion de
     * enteros ordenados y retorna la cantidad de iteraciones realizadas.
     *
     * @param coleccion Coleccion de enteros ordenados ascendentemente.
     * @param objetivo Numero entero a buscar en la coleccion
     * @return Cantidad de comparaciones realizadas durante la busqueda.
     */
    public static int busquedaLineal(int[] coleccion, int objetivo) {
        int i = 0;

        for (int n : coleccion) {
            i++;
            if (n >= objetivo) {
                return i;
            }
        }

        return i;
    }

    /**
     * Utiliza busqueda binaria para encontrar un valor en una coleccion de
     * enteros ordenados y retorna la cantidad de iteraciones realizadas.
     *
     * @param coleccion Coleccion de enteros ordenados ascendentemente.
     * @param objetivo Numero entero a buscar en la coleccion.
     * @return Cantidad de comparaciones realizadas durante la busqueda.
     */
    public static int busquedaBinaria(int[] coleccion, int objetivo) {
        int i = 0;
        int min = 0;
        int med = 0;
        int max = coleccion.length - 1;

        while (max > min) {
            i++;

            med = (max - min) / 2 + min;
            if (coleccion[med] < objetivo) {
                min = med + 1;
            } else {
                max = med;
            }
        }

        return i;
    }

}
