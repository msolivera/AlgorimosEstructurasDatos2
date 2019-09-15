package Tries_Palabras;
public class UT2TA2 {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasArchivo = ManejadorArchivosGenerico.leerArchivo("src/UT2/TA2/palabras.txt");
        for (int i=0; i < palabrasArchivo.length; i++){
            trie.insertar(palabrasArchivo[i]);
        }
    }
}
