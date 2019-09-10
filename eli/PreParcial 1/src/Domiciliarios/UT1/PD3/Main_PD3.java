
package Domiciliarios.UT1.PD3;



/**
 *
 * @author Bruno MARTINEZ
 */
public class Main_PD3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] valor1 = {5,4,3};
        int[] valor2 = {5,5,6};
        int[] valor3 = {6,6};
        int[] valor4 = {2};
        int[] binario1 = {1,0,1,0};
        int[] binario2 = {1,1,1,1};
        Multiplicacion multiplicacion = new Multiplicacion();
        Suma suma = new Suma();
        System.out.println("543 x 556 = " + multiplicacion.multiplicacion(valor1, valor2,10));
        System.out.println("66 x 2 = " + multiplicacion.multiplicacion(valor3, valor4,10));
        System.out.println("556 x 2 = " + multiplicacion.multiplicacion(valor2, valor4,10));
        System.out.println("Binario: 1010 x 1010 = " + multiplicacion.multiplicacion(binario1, binario1,2) + " en decimal");
        System.out.println("Binario: 1111 x 1111 = " + multiplicacion.multiplicacion(binario2, binario2,2) + " en decimal");
        
        int[] suma1 = {4,5};
        int[] suma2 = {7,5,6};
        System.out.println("45 + 756 = " + suma.sumar(suma1, suma2,10));
        System.out.println("756 + 45 = " + suma.sumar(suma2, suma1,10));
        System.out.println("Binario: 1010 + 1111 = " + suma.sumar(binario1, binario2,2) + " en decimal");
        System.out.println("Decimal: 1010 + 1111 = " + suma.sumar(binario1, binario2,10));
    }
    
}
