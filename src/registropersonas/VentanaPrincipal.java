/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registropersonas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author piero
 */

public class VentanaPrincipal extends JFrame {
    private RegistroPersonas registro;
    private JPanel panelPrincipal;

    public VentanaPrincipal() {
        registro = new RegistroPersonas();
        setTitle("Registro de Personas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnReportes = new JButton("Reportes");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnReportes);

        panelPrincipal = new JPanel(new CardLayout());

        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new GridLayout(5, 2));
        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtCedula = new JTextField();
        JTextField txtEdad = new JTextField();
        JButton btnGuardar = new JButton("Guardar");

        panelRegistro.add(new JLabel("Nombre:"));
        panelRegistro.add(txtNombre);
        panelRegistro.add(new JLabel("Apellido:"));
        panelRegistro.add(txtApellido);
        panelRegistro.add(new JLabel("Cédula:"));
        panelRegistro.add(txtCedula);
        panelRegistro.add(new JLabel("Edad:"));
        panelRegistro.add(txtEdad);
        panelRegistro.add(new JLabel(""));
        panelRegistro.add(btnGuardar);

        JPanel panelReportes = new JPanel(new BorderLayout());
        JTextArea areaReportes = new JTextArea();
        areaReportes.setEditable(false);
        JScrollPane scrollReportes = new JScrollPane(areaReportes);
        panelReportes.add(scrollReportes, BorderLayout.CENTER);

        panelPrincipal.add(panelRegistro, "Registro");
        panelPrincipal.add(panelReportes, "Reportes");

        btnRegistrar.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) panelPrincipal.getLayout();
            cl.show(panelPrincipal, "Registro");
        });

        btnReportes.addActionListener((ActionEvent e) -> {
            areaReportes.setText("");
            for (Persona p : registro.obtenerPersonas()) {
                areaReportes.append(p.toString() + "\n");
            }
            CardLayout cl = (CardLayout) panelPrincipal.getLayout();
            cl.show(panelPrincipal, "Reportes");
        });

        btnGuardar.addActionListener((ActionEvent e) -> {
            try {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String cedula = txtCedula.getText().trim();
                String edadStr = txtEdad.getText().trim();

                if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || edadStr.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                if (!nombre.matches("[a-zA-Z]{1,50}")) {
                    throw new IllegalArgumentException("El nombre solo debe contener letras (máximo 50 caracteres).");
                }

                if (!apellido.matches("[a-zA-Z]{1,50}")) {
                    throw new IllegalArgumentException("El apellido solo debe contener letras (máximo 50 caracteres).");
                }

                if (!cedula.matches("\\d{10}")) {
                    throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
                }

                int edad = Integer.parseInt(edadStr);

                registro.registrarPersona(nombre, apellido, cedula, edad);
                JOptionPane.showMessageDialog(this, "Persona registrada con éxito.");
                txtNombre.setText("");
                txtApellido.setText("");
                txtCedula.setText("");
                txtEdad.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}