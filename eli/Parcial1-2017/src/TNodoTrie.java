



import static java.lang.Math.abs;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private TAbonado persona;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        persona = null;
    }

 
    public LinkedList<TAbonado> buscarTelefonos(String codigoPais, String codigoArea,LinkedList<TAbonado> abonados){
        int contador = 0;
        LinkedList<TAbonado> lista  = abonados;
        TNodoTrie nodo = this;
        if(codigoPais != null){
            for (int c = 0; c < codigoPais.length(); c++) {
                int indice = codigoPais.charAt(c);
                if (nodo.hijos[indice] == null) {
                    return null;
                 }         
            nodo = nodo.hijos[indice];
            contador ++;
            }
        }else{
            if(codigoArea != null){
                for (int c = 0; c < codigoPais.length(); c++) {
                    int indice = codigoPais.charAt(c);
                    if (nodo.hijos[indice] == null) {
                        return null;
                     }         
                nodo = nodo.hijos[indice];
                contador ++;
                }
            }
        }
        TNodoTrie aux = nodo;
        for(int i =0; i< nodo.hijos.length;i++){
            lista.addAll(aux.hijos[i].buscarHoja());
        }
       return lista;
    }
    
    public LinkedList<TAbonado> buscarHoja(){
        LinkedList<TAbonado> lista = new LinkedList<>();
        TNodoTrie auxiliar = this.hijos[0];
        for (int i = 1; i < this.hijos.length; i++) {
            if(auxiliar.hijos == null){
                lista.add(auxiliar.persona);
            }else{
                
                while (auxiliar.hijos[i] != null){
                  LinkedList<TAbonado> auxiliar2 = new LinkedList<>();
                  auxiliar2.addAll(auxiliar.hijos[i].buscarHoja());
              }
            }
        }
        return lista;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrie nodo = this;
        String telefono = unAbonado.getTelefono();
        for (int c = 0; c < telefono.length(); c++){            
            int indice = Integer.parseInt(telefono.substring(c,c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.persona = unAbonado;
    }
}
      