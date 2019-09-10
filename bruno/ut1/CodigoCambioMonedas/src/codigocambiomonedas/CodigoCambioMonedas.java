package codigocambiomonedas;

/**
 *
 * @author Bruno Garcia
 */
public class CodigoCambioMonedas {
    
    private int[][] memo = new int[4][1000];
    private int[] lastCoin = new int[1000];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private int[] cambioEnMonedas(int monto){
        int[] cambio = new int[4];
        int monedaGrande = lastCoin[monto-1];
        cambio[monedaGrande] = memo[monedaGrande][]
        while(monto > 0){
            
        }
        
        return cambio;
    }
    
}
