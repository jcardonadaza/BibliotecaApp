package proyecto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Biblioteca {
    private ArrayList<Libro> libros;
    
    // constructor
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // los metodos de la clase Biblioteca
    public String mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append(libro.getTitulo()).append("\n");
        }
        return sb.toString();
    }
    
    // getters y los setters
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    public Libro buscarLibro(long id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // se actualiza el libro con el id dado por el usuario 
    public boolean actualizarLibro(long id, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.set(i, nuevoLibro);
                return true;
            }
        }
        return false;
    }

    // se elimina el libro con el id dado por el usuario 
    public boolean eliminarLibro(long id) {
        return libros.removeIf(libro -> libro.getId() == id);
    }

    // se obtienen los libros ordenados alfabeticamente segun se ballan agregando por el titilo
    public ArrayList<Libro> obtenerLibrosAlfabeticamente() {
        ArrayList<Libro> librosOrdenados = new ArrayList<>(libros);
        Collections.sort(librosOrdenados, Comparator.comparing(Libro::getTitulo));
        return librosOrdenados;
    }
}