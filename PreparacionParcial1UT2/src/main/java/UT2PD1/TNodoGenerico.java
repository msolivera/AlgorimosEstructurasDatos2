/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD1;

/**
 *
 * @author Micaela
 */
public class TNodoGenerico implements INodoGenerico{
    
 private INodoGenerico primHijo;
    private INodoGenerico herDer;
    private Object dato;
    private Comparable etiqueta;

    public TNodoGenerico(Comparable etiqueta) {
        this.primHijo = null;
        this.herDer = null;
        this.etiqueta = etiqueta;
    }

    
    @Override
    public INodoGenerico getPrimHijo() {
        return primHijo;
    }

    @Override
    public void setPrimHijo(INodoGenerico primHijo) {
        this.primHijo = primHijo;
    }

    @Override
    public INodoGenerico getHerDer() {
        return herDer;
    }

    @Override
    public void setHerDer(INodoGenerico herDer) {
        this.herDer = herDer;
    }

    @Override
    public Object getDato() {
        return dato;
    }

    @Override
    public void setDato(Object dato) {
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public INodoGenerico buscar(Comparable etiqueta) 
    {
        if (this.etiqueta == etiqueta) {return this;}
        else 
        {
            INodoGenerico unHijo = this.getPrimHijo();
            while (unHijo != null)
            {
                INodoGenerico res = unHijo.buscar(etiqueta);
                if (res != null){return res;}
                else{unHijo=unHijo.getHerDer();}
            }
        }
        return null;
    }

    @Override
    public void tamaño(int[] cont) 
    {
        cont[0]++;
        INodoGenerico unHijo = this.getPrimHijo();
        while (unHijo != null)
        {
            unHijo.tamaño(cont);
            unHijo=unHijo.getHerDer();
        }    
    }   

    @Override
    public void altura(int[] cont) {
        if (this.getPrimHijo()==null){cont[0]++;}
        int auxAltura=0;
        INodoGenerico unHijo = this.getPrimHijo();
        while (unHijo != null)
        {
            int[] aux=new int[1];
            unHijo.altura(aux);
            int alturaHijo = aux[0];
            if(alturaHijo>auxAltura) {auxAltura=alturaHijo;}
            unHijo=unHijo.getHerDer();
        }
        cont[0] = auxAltura + 1 ;
    }
    
    @Override
    public boolean insertar (Comparable etiqueta, Comparable padre){
    
        if (this.etiqueta.compareTo(padre)==0){
            TNodoGenerico aux = new TNodoGenerico(etiqueta);
            aux.setHerDer(this.getPrimHijo());
            this.setPrimHijo(aux);
            return true;
        }
        if (this.primHijo != null){
            this.primHijo.insertar(etiqueta, padre);
        }
        if (this.herDer != null){
            this.herDer.insertar(etiqueta, padre);
        }
        return false;
    }

    @Override
    public void listarIndentado(String espacios) {
        System.out.println(espacios + etiqueta);
        if (this.herDer != null){
            this.herDer.listarIndentado(espacios);
        }
        if (this.primHijo != null){
            this.primHijo.listarIndentado(espacios + " " );
        }
                
    }    
 @Override
       public void listarIndentadoYNivel(int nivel) {
        System.out.println( nivel+")"+ etiqueta);
        if (this.herDer != null){
            this.herDer.listarIndentadoYNivel(nivel);
        }
        if (this.primHijo != null){
            this.primHijo.listarIndentadoYNivel(nivel+1);
        }
                
    }  
}
