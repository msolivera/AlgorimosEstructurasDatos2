package Tries_Abonados;
import java.util.Collection;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("./src/tries_abonados/abonados.txt");
       
        for(int i=0;i<abonados.length;i++){
            String [] tmp=abonados[i].split(",");
            String numero=tmp[0].trim();
            String nombre=tmp[1].trim();

            TAbonado abonado=new TAbonado(nombre, numero);
            trie.insertar(abonado);
        }
        
        String codigoPais = "" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "" ;// utilizar el indicado en el archivo "codigos.txt"
        
        String []codigos=ManejadorArchivosGenerico.leerArchivo("./src/tries_abonados/codigos.txt");
        String [] tmp=codigos[0].split(":");
        codigoPais=tmp[1].trim();
        tmp=codigos[1].split(":");
        codigoArea=tmp[1].trim();
        
        int cpais = Integer.parseInt(codigoPais);
        int carea = Integer.parseInt(codigoArea);
        //Obtengo una coleccion con los abonados dentro del código país y código área dados
        //Collection<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        Collection<TAbonado> ab = trie.buscarTelefonos(cpais,carea);
        if (ab!=null){
            //Ordeno la colección en otra que inserta ordenado
            TreeSet<TAbonado> tree=new TreeSet();
            for(TAbonado a : ab){
                tree.add(a);
            }

            //Obtengo la lista de abondados ordenados alfabeticamente para grabar en archivo
            String[] lineas = new String[tree.size()];
            int i =0;
            for(TAbonado abo: tree){
                System.out.println(abo.getNombre()+", "+abo.getTelefono());
                lineas[i]=abo.getNombre()+", "+abo.getTelefono();
                i +=1;
            }

            //Grabar en archivo la salida obtenida
            ManejadorArchivosGenerico.escribirArchivo("./src/Tries_Abonados/salida.txt",lineas,false);
        }else{
            System.out.println("NO SE ENCONTRARON RESULTADOS");
        }
    }
}