// @autor JuanJoseC

public class Autor {
    private String editorial;
    private String profesion;

    // Constructor
    public Autor(String editorial, String profesion) {
        this.editorial = editorial;
        this.profesion = profesion;
    }

    // Getters
    public String getEditorial() {
        return editorial;
    }

    public String getProfesion() {
        return profesion;
    }

    // Setters
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}