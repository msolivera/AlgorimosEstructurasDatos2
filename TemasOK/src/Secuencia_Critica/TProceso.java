package Secuencia_Critica;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */
public class TProceso extends TGrafoDirigido implements IProceso{

    public TProceso(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }
   

    
    private TVertice busVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }
    
    @Override
    public void obtenerSecuenciaCritica() {
        if(!this.tieneCiclo()){
            this.desvisitarVertices();
            Comparable origen = "Start";
            TCaminos caminos = this.todosLosCaminos(origen, "End");
            TVertice vOrigen = this.busVertice(origen);
            vOrigen.caminoCritico(caminos);
        }
        else{
            System.out.println("ATENCIÓN: El grafo tiene ciclos. Finaliza el proceso de caminoCritico().");
        }
    }
    
    public TCaminos setCostoTotalCaminos()
    {   
        TCaminos misCaminos = this.todosLosCaminos("Start","End");
        LinkedList<TCamino> caminos = (LinkedList<TCamino>) misCaminos.getCaminos();
        for (TCamino c : caminos)
        {
            Double costo = 0.0;
            costo = costo + (double) c.getOrigen().getDatos();
            Collection<Comparable> otros = c.getOtrosVertices();
            
            for (Comparable v : otros)
            {
                TVertice este = this.busVertice(v);
                costo = costo +(double) este.getDatos();
            }
            c.setCostoTotal(costo);
            //System.out.println(c.getCostoTotal());
        }
        return misCaminos;
    }
}
