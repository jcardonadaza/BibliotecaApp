package proyecto;
/**
 * Clase que representa a una Persona
 */
public class Persona {
    // Atributos
    private String nombre;
    private String documentoIdentidad;
    private String correoElectronico;
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // getters
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }
    
    // setters
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    
    // getters
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    // setters
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}