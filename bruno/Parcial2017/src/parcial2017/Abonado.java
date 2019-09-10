package parcial2017;

/**
 *
 * @author Bruno Garcia
 */
public class Abonado {
    private String nombre;
    private String telefono;
    
    public Abonado(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
}
