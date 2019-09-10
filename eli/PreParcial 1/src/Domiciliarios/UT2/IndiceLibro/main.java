
package Domiciliarios.UT2.IndiceLibro;


/**
 *
 * @author Bruno Martinez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolTrie arbol=new TArbolTrie();
        String[] lineas = ManejadorArchivos.leerArchivo("src/Domiciliarios/UT2/IndiceLibro/PalabrasIndice.txt");
        for (int i = 0; i < lineas.length; i++) {
            String[] paginas = lineas[i].split(" ");
            for (int j = 0; j < paginas.length; j++) {
                String palabra = paginas[j].toLowerCase();
                arbol.insertar(palabra);
            }
            
        }
        arbol.indizarLibro("src/Domiciliarios/UT2/IndiceLibro/libro.txt");
        arbol.imprimirIndice();
        
        
    }
        

    
    
}
