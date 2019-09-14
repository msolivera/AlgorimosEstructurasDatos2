/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1PD4;

/**
 *
 * @author Micaela
 */
public class MainPD4 {
        public static void main(String[] args) {
        
        TNodoABB a = new TNodoABB(1);
        TNodoABB b = new TNodoABB(2);
        TNodoABB c = new TNodoABB(5);
        TNodoABB d = new TNodoABB(3);
        TNodoABB e = new TNodoABB(6);
        TNodoABB f = new TNodoABB(10);
        TNodoABB g = new TNodoABB(4);
        TNodoABB h = new TNodoABB(7);
        TNodoABB i = new TNodoABB(9);
        
        TArbolBB arbol = new TArbolBB();
        arbol.insertar(a);
        arbol.insertar(b);
        arbol.insertar(c);
        arbol.insertar(d);
        arbol.insertar(e);
        arbol.insertar(f);
        arbol.insertar(g);
        arbol.insertar(h);
        arbol.insertar(i);
        
            System.out.println("atura "+arbol.getAltura());
            System.out.println("cant hojas "+arbol.getCantidadHojas());
            System.out.println("cant nodos internos "+arbol.getCantidadNodosInternos());
            System.out.println("suma alturas "+arbol.sumaAlturasNodos());
            System.out.println("tamaño "+arbol.getTamaño());
            System.out.println("inorden "+arbol.inOrden());
            
    }
        
}
