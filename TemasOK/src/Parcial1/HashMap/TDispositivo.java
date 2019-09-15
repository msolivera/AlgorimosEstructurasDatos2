package Parcial1.HashMap;
public class TDispositivo {
    private String direccionIP;
    private String nombre;
    

    TDispositivo(String dirIP, String unNombre) {

        this.direccionIP = dirIP;
        this.nombre = unNombre;
        
    }

    public String getDirIP() {
        return this.direccionIP;
    }
    public String getNombre() {
        return this.nombre;
    }

   

   
}
