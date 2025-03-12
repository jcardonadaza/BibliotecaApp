package proyecto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public String mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append(libro.getTitulo()).append("\n");
        }
        return sb.toString();
    }

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

    public boolean actualizarLibro(long id, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.set(i, nuevoLibro);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarLibro(long id) {
        return libros.removeIf(libro -> libro.getId() == id);
    }

    public ArrayList<Libro> obtenerLibrosAlfabeticamente() {
        ArrayList<Libro> librosOrdenados = new ArrayList<>(libros);
        Collections.sort(librosOrdenados, Comparator.comparing(Libro::getTitulo));
        return librosOrdenados;
    }
}