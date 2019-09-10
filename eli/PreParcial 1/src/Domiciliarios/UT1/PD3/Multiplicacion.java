package Domiciliarios.UT1.PD3;



/**
 *
 * @author Bruno
 */
public class Multiplicacion {
    
    /**
     * Constructor
     */
    public Multiplicacion(){
        
    }
/**
 * Multiplicacion de dos numeros enteros de cualquier base.
 * @param valor1 Array con cada digito del primer numero
 * @param valor2 Array con cada digito del segundo numero
 * @param base base a usar
 * @return resultado de la multiplicacion
 */
public  int multiplicacion(int[] valor1, int[] valor2,int base){
    int[] resultadosParciales  = new int[valor2.length];
    for (int i = 0; i < valor2.length; i++) {
        int resultado = 0;
        for (int j = 0; j < valor1.length ; j++) {
            int val2 = valor2[(valor2.length -i)-1];
            int val1  = valor1[(valor1.length - j) -1];
            if(val2 >= base || val1 >= base){
                System.out.println("Existen digitos que no pertenecen a la base especificada.");
                return 0;
            }
            int exponencial = (int) Math.pow(base, j);
            resultado = resultado + (val2*val1*exponencial);
        }
        resultadosParciales[i] = resultado;
    }
    int resultadoFinal = 0 ;
    for (int i = 0; i < resultadosParciales.length; i++) {
        resultadoFinal = resultadoFinal + (resultadosParciales[i] * (int) Math.pow(base,i));
    }
    return resultadoFinal;
}

}
