/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD1;

/**
 *
 * @author Micaela
 */
public class MainPD1 {
      public static void main(String[] args) {
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar("RECTORIA", "");
        arbol.insertar("VICERRECTORIA ADMINISTRATIVA", "RECTORIA");
        arbol.insertar("VICERRECTORIA ACADEMICA", "RECTORIA");
        arbol.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE INGENIERIA Y TECNOLOGIAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORIA ACADEMICA");
        arbol.insertar("DEPARTAMENTO DE MATEMTICAS","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.insertar("DEPARTAMENTO DE INGENIERIA ELECTRICA","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.insertar("DEPARTAMENTO DE INFORMATICA Y CIENCIAS DE LA COMPUTACIÓN","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        //arbol.listarIndentado();
        System.out.println(arbol.altura());
        System.out.println(arbol.tamaño());
        INodoGenerico buscado = arbol.buscar("VICERRECTORIA DEL MEDIO UNIVERSITARIO");
        System.out.println(buscado.getEtiqueta());
        arbol.listarIndentadoYNivel();
      }
}
