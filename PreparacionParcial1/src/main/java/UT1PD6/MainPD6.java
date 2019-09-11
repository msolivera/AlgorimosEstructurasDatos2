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
public class MainPD6 {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        System.out.println("Fibonacci 8 top bottom : " + fibonacci.fibonacciTopDown(8));
        System.out.println("Cantidad llamadas metodo = " + fibonacci.contadorMetodo);
        System.out.println("Cantidad usos valores repetidos = " + fibonacci.contadorValorPrevio);
        System.out.println("Comentarios: Es una intersante manera de resolver el problema " + "\n" + 
                "Al reutilizar valores que ya han sido calculados previamente, simplemente vamos a necesitar " + "\n" + 
                "n valores de memoria.");
        System.out.println("");
        System.out.println("Fibonacci 8 bottom top: " + fibonacci.fibonacciBottomTop());
        System.out.println("Cantidad repeticiones bucle = " + fibonacci.contadorMetodo);
        System.out.println("Comentarios: Es otra intersante manera de resolver el problema " + "\n" + 
                "Tambien se reutilizar valores que ya han sido calculados previamente, pero ahora de manera iterativa," + "\n" + 
                "Al recorrer todos los elementos desde 0 hasta, simplemente vamos a necesitar " + "\n" + 
                "n valores de memoria." + "\n" + 
                "Por otro lado,la recursión invoca repetidamente al mecanismo, y por lo tanto la sobrecarga, de llamadas a subrutinas." + "\n" +
                "Esto puede ser costoso tanto en tiempo de procesador como en espacio de memoria, por lo tanto si se tuviera que elegir se elegiria la iterativa");
    }
}
