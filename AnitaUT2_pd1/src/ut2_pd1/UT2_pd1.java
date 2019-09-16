/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_pd1;

/**
 *
 * @author anabe
 */
public class UT2_pd1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Raiz
        TArbolGenerico arbol = new TArbolGenerico(new TNodoArbolGenerico("Rectoria"));
        
        //Nivel 1
        arbol.insertar("Vicerrectoria del medio universitario", "Rectoria");
        arbol.insertar("Vicerrectoria academica", "Rectoria");
        arbol.insertar("Vicerrectoria administrativa", "Rectoria");
        
        //Nivel 2
        arbol.insertar("Facultad de ciencias empresariales", "Vicerrectoria academica");
        arbol.insertar("Facultad de ciencias humanas", "Vicerrectoria academica");
        arbol.insertar("Facultad de ingenieria y tecnologias", "Vicerrectoria academica");
        arbol.insertar("Facultad de psicologia", "Vicerrectoria academica");
        
        //nivel 3
        arbol.insertar("Departamento de informatica y ciencias de la computacion", "Facultad de ingenieria y tecnologias");
        arbol.insertar("Departamento de ingenieria electrica", "Facultad de ingenieria y tecnologias");
        arbol.insertar("Departamento de matematicas", "Facultad de ingenieria y tecnologias");
        
        System.out.println(arbol.listarIndentado());
        
        System.out.println(arbol.buscar("Facultad de psicologia").getEtiqueta());
        // modifico etiqueta
        arbol.buscar("Facultad de psicologia").setEtiqueta("Facultad de psicologia 2");
        
        System.out.println(arbol.buscar("Facultad de psicologia 2").getEtiqueta());

        
        
    }
    
}
