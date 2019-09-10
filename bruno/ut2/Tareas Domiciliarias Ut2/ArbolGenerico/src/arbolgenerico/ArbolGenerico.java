package arbolgenerico;

/**
 *
 * @author Bruno Garcia
 */
public class ArbolGenerico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbol arbolUCU = new TArbol(new TNodoArbol("Rectoria"));
        arbolUCU.insertar("Vicerrectoria del medio universitario", "Rectoria");
        arbolUCU.insertar("Vicerrectoria academica", "Rectoria");
        arbolUCU.insertar("Vicerrectoria administrativa", "Rectoria");
        
        arbolUCU.insertar("Facultad de ciencias empresariales", "Vicerrectoria academica");
        arbolUCU.insertar("Facultad de ciencias humanas", "Vicerrectoria academica");
        arbolUCU.insertar("Facultad de ingenieria y tecnologias", "Vicerrectoria academica");
        arbolUCU.insertar("Facultad de psicologia", "Vicerrectoria academica");
        
        arbolUCU.insertar("Departamento de informatica y ciencias de la computacion", "Facultad de ingenieria y tecnologias");
        arbolUCU.insertar("Departamento de ingenieria electrica", "Facultad de ingenieria y tecnologias");
        arbolUCU.insertar("Departamento de matematicas", "Facultad de ingenieria y tecnologias");
        
        System.out.println(arbolUCU.listarIndentado());
    }

}
