/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD6;

/**
 *
 * @author Micaela
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
    public int fibonacciTopDown(int numero){
        
        if(memo[numero] == 0){ //no esta en memo
            contadorMetodo++;
            if(numero<=2){
                memo[numero] = 1;
            }
            else{
               
                memo[numero] = fibonacciTopDown(numero -1) + fibonacciTopDown(numero-2);
            }
        }
        contadorValorPrevio++;
        return memo[numero];  
        
    }
    public int fibonacciBottomTop(){
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
