package Parcial1.Tabla;


public class TDispositivo {
    private String direccionIP;
    private String nombre;

    TDispositivo(String dirIP, String disp) {
        this.direccionIP = dirIP.trim();
        this.nombre = disp.trim();
    }

    public String getDirIP() {
        return this.direccionIP;
    }
    public String getNombre() {
        return this.nombre;
    }   
}
