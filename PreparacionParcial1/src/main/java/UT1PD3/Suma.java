/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD3;

/**
 *
 * @author Micaela
 */
public class Suma {
    /**
     * Constructor
     */
    public Suma(){       
    }
/**
 * Suma de dos numeros enteros de cualquier base.
 * @param valor1 Array con cada digito del primer numero
 * @param valor2 Array con cada digito del segundo numero
 * @param base base a usar
 * @return resultado de la suma
 */
public  int sumar(int[] valor1,int[] valor2,int base){   
    /**
     * DOS CASOS: UNO PARA CUANDO EL NUMERO 1 ES MAYOR QUE EL 2, Y OTRO PARA CUANDO EL NUMERO 2 ES MAYOR QUE EL 1.
     */
    if(valor2.length > valor1.length){
            int[] resultado = new int[valor2.length +1];
            int carry = 0;
            for (int i = 0; i < valor2.length; i++) {
                if( i < valor1.length){
                     int val2 =  (valor2[(valor2.length - i) -1]);
                     int val1 = + (valor1[(valor1.length - i) -1]);
                     if(val2 >= base || val1 >= base){
                            System.out.println("Existen digitos que no pertenecen a la base especificada.");
                            return 0;
                     }
                     resultado[i] = (val2 + val1 + carry) % base;
                     carry = (val2 + val1 + carry) / base ;
                }
                else{
                    resultado[i] = (valor2[(valor2.length - i)-1] + carry) % base;
                    carry = (valor2[(valor2.length - i) -1] + carry)/base;
                }       
            }
            int carryFinal = carry;
            if(carryFinal > 0) {
                resultado[resultado.length -1] = carry;
            }
            int resultadoFinal = 0;
            for (int i = 0; i < resultado.length; i++) {
                resultadoFinal = resultadoFinal + (resultado[i] * (int) Math.pow(base, i));
            }
            return resultadoFinal;
    }
    else{
        int[] resultado = new int[valor1.length +1];
        int carry = 0;
        for (int i = 0; i < valor1.length; i++) {
            if( i < valor2.length){
                 int val1 =  (valor1[(valor1.length - i) -1]);
                 int val2 = + (valor2[(valor2.length - i) -1]);
                 if(val2 >= base || val1 >= base){
                            System.out.println("Existen digitos que no pertenecen a la base especificada.");
                            return 0;
                 }
                 resultado[i] = (val1 + val2 + carry) % base;
                 carry = (val2 + val1 + carry) / base ;
            }
            else{
                resultado[i] = (valor1[(valor1.length - i)-1] + carry) % base;
                carry = (valor1[(valor1.length - i) -1] + carry)/base;
            }       
        }
        int carryFinal = carry;
        if(carryFinal > 0) {
            resultado[resultado.length -1] = carry;
        }
        int resultadoFinal = 0;
        for (int i = 0; i < resultado.length; i++) {
            resultadoFinal = resultadoFinal + (resultado[i] * (int) Math.pow(base, i));
        }
        return resultadoFinal;
        }
}
   
}
