package proyecto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InterfazBiblioteca extends JFrame {

    private Biblioteca biblioteca;
    private JTextArea textAreaLibros;
    private JTextField textFieldTitulo, textFieldId, textFieldNombre, textFieldCorreo, textFieldDocumento;

    public InterfazBiblioteca() {
        biblioteca = new Biblioteca();
        crearInterfaz();
    }

    private void crearInterfaz() {
        setTitle("Biblioteca");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // se agrega el contenido del panel como tal 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245)); // se coloca el color del fondo de la interfaz o ventana

        // se añade el titulod e la interfaz
        JLabel titulo = new JLabel("Sistema de Biblioteca");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);

        // agregar imagen de header header.jpeg
        try {
            Image imagen = ImageIO.read(getClass().getResource("/header.jpeg"));
            JLabel imagenLabel = new JLabel(new ImageIcon(imagen));
            imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(imagenLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // panel donde se agregaran los libros
        JPanel libroPanel = new JPanel();
        libroPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // es el espacio que hay entre los componentes 

        // se colocan los enunciados y los campos de texto para agregar un libro 
        gbc.gridx = 0;
        gbc.gridy = 0;
        libroPanel.add(new JLabel("ID del Libro:"), gbc);
        
        gbc.gridx = 1;
        textFieldId = new JTextField(15);
        libroPanel.add(textFieldId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        libroPanel.add(new JLabel("Título del Libro:"), gbc);
        
        gbc.gridx = 1;
        textFieldTitulo = new JTextField(15);
        libroPanel.add(textFieldTitulo, gbc);

        JButton agregarLibroButton = new JButton("Agregar Libro");
        agregarLibroButton.setFont(new Font("Arial", Font.PLAIN, 14));
        agregarLibroButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        libroPanel.add(agregarLibroButton, gbc);

        panel.add(libroPanel);

        // se agregan los campos de texto para agregar una persona 
        JPanel personaPanel = new JPanel();
        personaPanel.setLayout(new GridBagLayout());

        // donde se agregar o ingresan los datos del autor o de la persona que escribio el libro 
        gbc.gridx = 0;
        gbc.gridy = 0;
        personaPanel.add(new JLabel("Nombre Persona:"), gbc);
        
        gbc.gridx = 1;
        textFieldNombre = new JTextField(15);
        personaPanel.add(textFieldNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        personaPanel.add(new JLabel("Correo Persona:"), gbc);
        
        gbc.gridx = 1;
        textFieldCorreo = new JTextField(15);
        personaPanel.add(textFieldCorreo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        personaPanel.add(new JLabel("Documento Identidad:"), gbc);

        gbc.gridx = 1;
        textFieldDocumento = new JTextField(15);
        personaPanel.add(textFieldDocumento, gbc);

        JButton agregarPersonaButton = new JButton("Agregar Persona");
        agregarPersonaButton.setFont(new Font("Arial", Font.PLAIN, 14));
        agregarPersonaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        agregarPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        personaPanel.add(agregarPersonaButton, gbc);

        panel.add(personaPanel);

        // se muestran los libros que se han agregado
        textAreaLibros = new JTextArea();
        textAreaLibros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaLibros);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        panel.add(scrollPane);

        // boton para mostrar los libros que se hana gregado 
        JButton mostrarLibrosButton = new JButton("Mostrar Libros");
        mostrarLibrosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        mostrarLibrosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mostrarLibrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLibros();
            }
        });
        panel.add(mostrarLibrosButton);

        // se agrega el panel al frame
        add(panel);
    }

    private void agregarLibro() {
        try {
            if (textFieldId.getText().isEmpty() || textFieldTitulo.getText().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios");
            }
            int id = Integer.parseInt(textFieldId.getText());
            String titulo = textFieldTitulo.getText();
            Libro libro = new Libro(id, titulo);
            biblioteca.agregarLibro(libro);
            JOptionPane.showMessageDialog(this, "Libro agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un ID válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarPersona() {
        if (textFieldNombre.getText().isEmpty() || textFieldCorreo.getText().isEmpty() || textFieldDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = textFieldNombre.getText();
        String correo = textFieldCorreo.getText();
        String documento = textFieldDocumento.getText();
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setCorreoElectronico(correo);
        persona.setDocumentoIdentidad(documento);
        JOptionPane.showMessageDialog(this, "Persona agregada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarLibros() {
        textAreaLibros.setText(biblioteca.mostrarLibros());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazBiblioteca().setVisible(true);
            }
        });
    }
}
