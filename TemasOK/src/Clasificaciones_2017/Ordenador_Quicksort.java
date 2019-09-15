package Clasificaciones_2017;
import java.util.ArrayList;
public class Ordenador_Quicksort {
    
    public static TProducto[] ordenarPorQuickSort(TProducto[] datosParaClasificar, boolean ascendente) {
        int [] contador = new int[1];
        contador[0] = 0; //contador para saber las llamadas recursivas
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1,contador,ascendente);
        return datosParaClasificar;
    }

    //EL MAYOR DE LOS EXTREMOS
    public static int encuentraPivote(int izquierda,int derecha,TProducto[] entrada){
        return Integer.max(izquierda,derecha);
    }
    
    //EL MAYOR DE LOS 2 PRIMEROS ELEMENTOS
    public static int encuentraPivote(int izquierda,TProducto[] entrada){
        if (entrada[izquierda].getCodigo() > entrada[izquierda+1].getCodigo())
            return izquierda;
        else
            return izquierda+1;
    }
    
    //EL MAYOR DE LOS 2 ULTIMOS ELEMENTOS
    public static int encuentraPivote(TProducto[] entrada,int derecha){
        if (entrada[derecha].getCodigo() > entrada[derecha-1].getCodigo())
            return derecha;
        else
            return derecha-1;
    }
    
    //EL INDICE MEDIO ENTRE EL EXTREMO IZQUIERDO Y EL DERECHO
    public static int encuentraPivote(TProducto[] entrada,int izq , int der){
        return (izq+der)/2;
    }
    
    public static void quicksort(TProducto[] entrada, int i, int j, int[] contador, boolean ascendente) {
        contador[0]+=1;
        int izquierda = i;
        int derecha = j; 
        int posicionPivote = encuentraPivote(entrada,i,j); 
        if (posicionPivote >= 0){
            long pivote = entrada[posicionPivote].getCodigo();
            //System.out.println("pivote: "+pivote);
            while (izquierda <= derecha){
                if (ascendente){
                    while ((entrada[izquierda].getCodigo() < pivote) && (izquierda < j))
                        izquierda++;
                    while ((pivote < entrada[derecha].getCodigo()) && (derecha > i))
                        derecha--;
                }else{
                    while ((entrada[izquierda].getCodigo() > pivote) && (izquierda < j))
                        izquierda++;
                    while ((pivote > entrada[derecha].getCodigo()) && (derecha > i))
                        derecha--;
                }
                
                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha); 
                    izquierda++;
                    derecha--;
                }
            }
            if (i < derecha)
                quicksort(entrada, i, derecha, contador,ascendente);
            if (izquierda < j)
                quicksort(entrada, izquierda, j, contador,ascendente);
        }
    }
    
    public static String ordenadoAscendente(TProducto[] datos){
        for(int i = 0; i< datos.length-1; i++){
            if(datos[i].getCodigo()>datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }
    
    public static String ordenadoDescendente(TProducto[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i].getCodigo() < datos[i+1].getCodigo()){
                return  "NO. Conjunto desordenado entre los valores "+datos[i].getCodigo() +" y "+ datos[i+1].getCodigo();
            }
        }
        return "SI. Conjunto ordenado descendentemente";
    }
    
    public static String[] arrayCodProductoToString(TProducto[] entrada){
        String[] salida = new String[entrada.length];
        String txt = "";
        for (int j=0;j<entrada.length;j++){
            salida[j]= String.valueOf(entrada[j].getCodigo());
        }
        return salida;
    }
    
    public static TProducto[] copiar(TProducto[] entrada){
        TProducto[] salida = new TProducto[entrada.length];
        for(int i = 0; i<entrada.length ; i++){
            salida[i] = new TProducto(entrada[i].getCodigo(),entrada[i].getDescripcion(),entrada[i].getPrecio(),entrada[i].getCantidad());
        }
        return salida;
    }
    
    public static void intercambiar(TProducto[] datos, int pos1, int pos2) {
        TProducto aux = datos[pos2];
        datos[pos2] = datos[pos1];
        datos[pos1] = aux;
    }
    
    public static String[] genSalida(TProducto[] lista, int tam){
        int cant=0;
        double totalStk=0.0;
        String txt="";
        String[] salida = new String[tam];
        for(TProducto p : lista){
            if(p!=null){
                if (cant<tam-1){
                    totalStk+=p.valor();
                    int lin = cant+1;
                    txt="("+lin+") Codigo="+p.getCodigo()+ " - Valor="+p.valor();
                    System.out.println(txt);
                    salida[cant]=txt;
                }
                cant+=1;
            }
        }
        salida[tam-1]="======>>> VALOR TOTAL STOCK REDONDEADO $"+Math.rint(totalStk);
        System.out.println("======>>> VALOR TOTAL STOCK REDONDEADO $"+Math.rint(totalStk));
        return salida;
    }
    
    public static void main(String[] args) {
        ArrayList<TProducto> lista = new ArrayList();
        String[] listadoStock = ManejadorArchivosGenerico.leerArchivo("src/clasificaciones_2017/datos_productos.txt", false);
        for(String linea : listadoStock){
            //System.out.println(linea);
            if(linea.split(",").length==4){
                long cod = Long.parseLong(linea.split(",")[0]);
                String des = linea.split(",")[1];
                double precio = Double.parseDouble(linea.split(",")[2]);
                int cant = Integer.parseInt(linea.split(",")[3]);
                
                //Si existe, sumo la cantidad. Sino lo agrego a la lista
                TProducto aux = TProducto.existeProducto(lista, cod);
                if(aux==null){
                    aux = new TProducto(cod,des,precio,cant);
                    lista.add(aux);
                }else{
                    int c = aux.getCantidad() + cant;
                    aux.setCantidad(c);
                }
            }
        }
        System.out.println();
        
        //VERIFICACION DE CARGA - Imprimo la lista de stock
//        for(TProducto p : lista){
//            System.out.println("Codigo: "+p.getCodigo()+ " - Descripcion: "+p.getDescripcion()+ " - Cantidad: "+p.getCantidad());
//        }
//        System.out.println("TAMAÑO LISTA="+lista.size());

        //Agrego todo el stock a un array de productos
        TProducto[] productos = new TProducto[lista.size()];
        int a=0;
        for(TProducto p : lista){
            productos[a] = p;
            a++;
        }
        
        //ORDEN ASCENDENTE
        boolean ordenAscendente = true;
        TProducto[] listaAsc = ordenarPorQuickSort(productos,ordenAscendente);
//        for(TProducto p : listaAsc){
//            System.out.println("cod:"+p.getCodigo());
//        }
        System.out.println("+++ ORDEN ASCENDENTE +++");
        System.out.println("    - El conjunto está ordenado ASCENDENTE?\n    ===> "+ordenadoAscendente(listaAsc));
        String[] salida = arrayCodProductoToString(listaAsc);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaHeapsort.txt", salida,false);
        System.out.println();
        
        //EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        String[] salida2 = genSalida(listaAsc, 501);
        
        // escribir el archivo de salida con los datos ordenados en forma ascendente
        //Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 500 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaNombresAscendente.txt", salida2,false);        

        //ORDEN DESCENDENTE
        System.out.println("\n\n");
        System.out.println("+++ ORDEN DESCENDENTE +++");
        ordenAscendente = false;
        TProducto[] listaDesc = ordenarPorQuickSort(productos,ordenAscendente);
        System.out.println("    - El conjunto está ordenado DESCENDENTE?\n    ===> "+ordenadoDescendente(listaDesc));
        System.out.println();
        //String[] salida3 = clasif.arrayCodProductoToString(listaDesc);
        // EMITIR POR CONSOLA EL VALOR TOTAL DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        String[] salida4 = genSalida(listaDesc, 301);
        
        // escribir el archivo de salida con los datos ordenados en forma descendente
        // Y AL FINAL ESCRIBIR EL VALOR DE STOCK DE LOS PRIMEROS 300 ELEMENTOS
        ManejadorArchivosGenerico.escribirArchivo("src/clasificaciones_2017/salidaNombresDescendente.txt", salida4,false);
    }
}
