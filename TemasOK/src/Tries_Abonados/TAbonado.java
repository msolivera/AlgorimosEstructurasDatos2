package Tries_Abonados;

public class TAbonado implements Comparable {

    private String nombre;
    private String telefono;
    private String codpais;
    private String codarea;

    TAbonado(String unNombre, String unTelefono) {
        this.codpais = unTelefono.substring(0,2);
        this.codarea = unTelefono.substring(3,4);
        this.nombre = unNombre;
        this.telefono = unTelefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getCodpais() {
        return codpais;
    }

    public String getCodarea() {
        return codarea;
    }
    
    @Override
    public int compareTo(Object o) {
        return (this.nombre.compareTo(((TAbonado)o).getNombre()));
    }
}
