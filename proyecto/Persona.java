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
    
    /**
     * Obtiene el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el documento de identidad de la persona
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }
    
    /**
     * Establece el documento de identidad de la persona
     */
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    
    /**
     * Obtiene el correo electrónico de la persona
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    /**
     * Establece el correo electrónico de la persona
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}