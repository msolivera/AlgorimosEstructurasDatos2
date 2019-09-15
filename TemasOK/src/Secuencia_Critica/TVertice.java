package Secuencia_Critica;

import java.util.Collection;
import java.util.LinkedList;

public class TVertice implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;
    private Double costo;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    public void setDatos(double costo)
    {
        this.datos=costo;
    }
    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        this.costo=0.0;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    @Override
    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }


    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public Object getDatos() {
        return datos; 
    }

    @Override
    public void bpf(Collection<Comparable> visitados) {
        setVisitado(true);
        visitados.add(this.getEtiqueta());
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
    
    @Override
    public boolean tieneCiclo(TCamino camino) {
        this.setVisitado(true);
        LinkedList<TAdyacencia> lista = this.adyacentes;
        TAdyacencia destino = null;
        for(TAdyacencia adyacente : lista){
            destino = adyacente;
            if(!adyacente.getDestino().getVisitado()){
                camino.agregarAdyacencia(adyacente);
                return adyacente.getDestino().tieneCiclo(camino);
            }
            else{
                if(camino.getOtrosVertices().contains(adyacente.getEtiqueta())){
                    camino.agregarAdyacencia(adyacente);
                    return true;
                }
            }
        }
        this.setVisitado(false);
        if(destino!=null){
            camino.eliminarAdyacencia(destino);
        }
        return false;
    }
    
    /**
     *
     * @param caminos
     */
    public void caminoCritico(TCaminos caminos){
        Double costoMaximo = 0.0;
        TCamino caminoCritico = null;
        for(TCamino camino : caminos.getCaminos()){
            if(camino.getCostoTotal() > costoMaximo){
                costoMaximo = camino.getCostoTotal();
                caminoCritico = camino;
            }
        }
        if(caminoCritico!=null){
            System.out.println("CAMINO CRÍTICO: '" + caminoCritico.imprimirEtiquetas()+
                    "'\nCOSTO TOTAL: " + caminoCritico.getCostoTotal());
        }else{
            System.out.println("ATENCIÓN: No existe un camino crítico.");
        }
        int i = 1;
        for(TCamino camino : caminos.getCaminos()){
            if(camino != caminoCritico){
                System.out.println("");
                System.out.println("CAMINO CON HOLGURA " + i + "\n" + camino.imprimirEtiquetas() 
                + "\nCOSTO DEL CAMINO HOLGADO: " + camino.getCostoTotal() + " - HOLGURA: " +
                        (caminoCritico.getCostoTotal() - camino.getCostoTotal()));
                i+=1;
            }
        }
    }
}
