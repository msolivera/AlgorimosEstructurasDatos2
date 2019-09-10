
package Domiciliarios.UT1.PD6;

/**
 *
 * @author Bruno
 */
public class Fibonacci {
    int[] memo;
    int contadorMetodo;
    int contadorValorPrevio;
    int numero;
    public Fibonacci(int n){
        memo = new int[n+1];
        numero = n;
        contadorMetodo = 0;
        contadorValorPrevio = 0;
    }
    public int fibTopDown(int numero){
        
        if(memo[numero] == 0){ //no esta en memo
            contadorMetodo++;
            if(numero<=2){
                memo[numero] = 1;
            }
            else{
               
                memo[numero] = fibTopDown(numero -1) + fibTopDown(numero-2);
            }
        }
        contadorValorPrevio++;
        return memo[numero];  
        
    }
    public int fibBottomTop(){
        contadorMetodo = 1;
        int n = numero;
        if(numero == 0){
            return 0;
        }
        else{
            int fibonacciAnterior = 0;
            int fibonacciActual = 1;
            while(n!=1){
                contadorMetodo++;
                int fibonacciNuevo = fibonacciAnterior + fibonacciActual;
                fibonacciAnterior = fibonacciActual;
                fibonacciActual = fibonacciNuevo;
                n--;
            }
            return fibonacciActual;
        }
    }
}
