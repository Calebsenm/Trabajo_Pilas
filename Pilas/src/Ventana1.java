
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Ventana1 extends JFrame implements ActionListener {

    private JButton cerrar;
    private JButton apilar;
    private JButton desapilar;
    private JButton sombra;
    private JButton base;
    private JTable tabla1;
    private JTable tabla2;

    private String[] columna1 = { "Pila1" };
    private String[] columna2 = { "Pila2" };
    private Object[][] dato1 = {};
    private Object[][] dato2 = {};

    private Pila pila1 = new Pila();
    private Pila pila2 = new Pila();

    public Ventana1() {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Boton Cerrar
        cerrar = new JButton("Cerrar");
        cerrar.setBounds(320, 400, 100, 30);
        cerrar.addActionListener(this);
        this.add(cerrar);

        // Boton Apilar
        apilar = new JButton("Apilar");
        apilar.setBounds(100, 20, 100, 30);
        apilar.addActionListener(this);
        this.add(apilar);

        // Boton Desapilar
        desapilar = new JButton("Desapilar");
        desapilar.setBounds(210, 20, 100, 30);
        desapilar.addActionListener(this);
        this.add(desapilar);

        // Boton Sombra
        sombra = new JButton("Sombra");
        sombra.setBounds(320, 20, 100, 30);
        sombra.addActionListener(this);
        this.add(sombra);

        // Boton Base
        base = new JButton("Base");
        base.setBounds(320, 60, 100, 30);
        base.addActionListener(this);
        this.add(base);

        // Tabla
        tabla1 = new JTable(dato1, columna1);
        JScrollPane scroll = new JScrollPane(tabla1);
        scroll.setBounds(100, 60, 100, 300);
        this.add(scroll);

        tabla2 = new JTable(dato2, columna2);
        JScrollPane scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(210, 60, 100, 300);
        this.add(scroll2);

        this.setTitle("Pila");
    }

    private void actualizar(DefaultTableModel model, Pila pila, JTable tabla) {

        Pila temporal = pila;

        while (temporal != null) {
              temporal.desapilar();
           model.addRow(new Object[] { temporal});

          
        }
    
        System.out.println(temporal);

        tabla.setModel(model);

    }

    DefaultTableModel modelo = new DefaultTableModel();

    public void Update(int eleccion) {

        if (eleccion == 1) {
            modelo.addColumn(columna1);
            actualizar(modelo, pila1, tabla1);

        } else if (eleccion == 2) {
            modelo.addColumn(columna2);
            actualizar(modelo, pila2, tabla2);

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrar) {
            System.exit(0);
        } else if (e.getSource() == apilar) {
            int elegir = Integer.parseInt(JOptionPane.showInputDialog(null, "Que lista deseas apilar ? 1  -   2"));

            if (elegir == 1 || elegir == 2) {

                int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));

                if (elegir == 1) {
                    pila1.apilar(valor);
                    Update(elegir);

                } else if (elegir == 2) {
                    pila2.apilar(valor);
                    Update(elegir);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } else if (e.getSource() == desapilar) {

            int elegir = Integer.parseInt(JOptionPane.showInputDialog(null, "Que lista deseas desapilar ? 1  -   2"));
            if (elegir == 1 || elegir == 2) {
                if (elegir == 1) {
                    pila1.desapilar();
                    Update(elegir);

                } else if (elegir == 2) {
                    pila2.desapilar();
                    Update(elegir);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } else if (e.getSource() == base) {

            int elegir = Integer.parseInt(JOptionPane.showInputDialog(null, "Que lista deseas ver la base ? 1  -   2"));
            if (elegir == 1 || elegir == 2) {
                if (elegir == 1) {
                    JOptionPane.showMessageDialog(null, pila1.verficarBase());

                } else if (elegir == 2) {
                    JOptionPane.showMessageDialog(null, pila2.verficarBase());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } else if (e.getSource() == sombra) {
            int elegir = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Que lista deseas ver la sombra ? 1  -   2"));
            if (elegir == 1 || elegir == 2) {
                if (elegir == 1) {
                    JOptionPane.showMessageDialog(null, pila1.esSombrero(pila2));

                } else if (elegir == 2) {
                    JOptionPane.showMessageDialog(null, pila2.esSombrero(pila1));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}