package Arboles_Genericos;
public class Main {
    public static void main(String[] args) {
       
        Arbol arbol = new Arbol();
        Elemento el1 = new Elemento(1);
        Elemento el4 = new Elemento(4);
        Elemento el2 = new Elemento(2);
        Elemento el10 = new Elemento(10);
        Elemento el8= new Elemento(18);
        Elemento el15 = new Elemento(15);
        Elemento el20 = new Elemento(20);
        Elemento el9 = new Elemento(9);
        
        System.out.println(arbol.insertar(1, null)); //inserta correctamente
        System.out.println(arbol.preOrden()); //imprime correctamente
        
        System.out.println(arbol.insertar(2,1));
        System.out.println(arbol.preOrden());
        System.out.println(arbol.insertar(3, null));
        System.out.println(arbol.preOrden());
        System.out.println(arbol.insertar(10, null));
        System.out.println(arbol.preOrden());
        System.out.println(arbol.insertar(15, 2));
        System.out.println(arbol.preOrden());
        
        /**No estaria implementando una lista pero hacia abajo?
        *porque si etiquetaPadre es nulo, lo pongo como raiz. Y si etiquetaPadre no es nulo, entonces referencio al padre
        * Como mucho lo que hago es meterlo entre medio
        * Inserto 1, queda como raiz
        * inserto 2, queda abajo del 1
        * inserto 3, null y queda como raiz, esto es, 
        *      3
        *      1 
        *      2
        * inserto 10, null y pongo el 10 como raiz
        *      10
        *      3 
        *      1 
        *      2
        * 
        * Si inserto el 15 y pongo como padre el 2:
        *       10
        *       3
        *       1 
        *       2
        * 
        * Siempre inserto como raiz (arriba de todo) o entre medio, como si fuese una lista
        * 
        **/
    }    
}
