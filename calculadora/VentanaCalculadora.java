/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadora;

/**
 *
 * @author crxss
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaCalculadora extends JFrame {

    
// Componentes
    // variables 
    private double primerNumero = 0;
    private String operacionActual = "";
    private boolean nuevaEntrada = true; // dice si el próximo dígito limpia el display

    public VentanaCalculadora() {
        setTitle("Calculadora Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        
        inicializarComponentes();
        configurarTeclado();
    }

    private void inicializarComponentes() {
       
        setLayout(new BorderLayout(10, 10));

        
        txtDisplay = new JTextField("0");
        txtDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        txtDisplay.setEditable(false);
        txtDisplay.setFocusable(false); //  no roba foco al teclado
        add(txtDisplay, BorderLayout.NORTH);

        
        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] botones = {
           
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "", "", "", "C",
        };

        for (String texto : botones) {
            if (texto.isEmpty()) {
                panelBotones.add(new JLabel("")); // hueco vacío
                continue;
            }

            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setFocusable(false); 

            // asignar eventos según el tipo de botón
            if ("0123456789".contains(texto)) {
                btn.addActionListener(e -> eventoNumero(texto));
            } else if (texto.equals(".")) {
                btn.addActionListener(e -> eventoDecimal());
            } else if ("+-*/".contains(texto)) {
                btn.addActionListener(e -> eventoOperacion(texto));
            } else if (texto.equals("=")) {
                btn.addActionListener(e -> resultado());
            } else if (texto.equals("C")) {
                btn.addActionListener(e -> limpiar());
            }

            panelBotones.add(btn);
        }

        add(panelBotones, BorderLayout.CENTER);
    }



    // Método para botones de números (0-9)
    private void eventoNumero(String numero) {
        if (nuevaEntrada) {
            txtDisplay.setText(numero);
            nuevaEntrada = false;
        } else {
            
            if (txtDisplay.getText().equals("0")) {
                txtDisplay.setText(numero);
            } else {
                txtDisplay.setText(txtDisplay.getText() + numero);
            }
        }
    }

    // Método boton decimal
    private void eventoDecimal() {
        if (nuevaEntrada) {
            // Si el usuario empieza directamente con el punto
            txtDisplay.setText("0.");
            nuevaEntrada = false;
        } else if (!txtDisplay.getText().contains(".")) {
            // un número solo puede tener un punto decimal
            txtDisplay.setText(txtDisplay.getText() + ".");
        }
    }

    // Método botones operaciones
    private void eventoOperacion(String op) {
        if (!operacionActual.isEmpty() && !nuevaEntrada) {
            resultado(); 
        }
        
        primerNumero = Double.parseDouble(txtDisplay.getText());
        operacionActual = op;
        nuevaEntrada = true; 
    }

    // Método resultado
    private void resultado() {
        if (operacionActual.isEmpty() || nuevaEntrada) {
            return;
        }

        double segundoNumero = Double.parseDouble(txtDisplay.getText());
        double res = 0;

        switch (operacionActual) {
            case "+": res = primerNumero + segundoNumero; break;
            case "-": res = primerNumero - segundoNumero; break;
            case "*": res = primerNumero * segundoNumero; break;
            case "/": 
                if (segundoNumero == 0) {
                    txtDisplay.setText("Error");
                    limpiarVariables();
                    return;
                }
                res = primerNumero / segundoNumero; 
                break;
        }

        // quitar el .0 (si es un entero perfecto)
        if (res % 1 == 0) {
            txtDisplay.setText(String.valueOf((long) res));
        } else {
            txtDisplay.setText(String.valueOf(res));
        }

        limpiarVariables();
    }

    //Método limpiar()
    private void limpiar() {
        txtDisplay.setText("0");
        limpiarVariables();
    }

    private void limpiarVariables() {
        primerNumero = 0;
        operacionActual = "";
        nuevaEntrada = true;
    }

    // Teclado del ordenador (KeyListener)
    private void configurarTeclado() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (Character.isDigit(c)) {
                    eventoNumero(String.valueOf(c));
                } else if (c == '.' || c == ',') {
                    eventoDecimal();
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    eventoOperacion(String.valueOf(c));
                } else if (c == '=' || e.getKeyChar() == '\n') { 
                    resultado();
                } else if (c == 'c' || c == 'C') {
                    limpiar();
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtDisplay = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jSiete = new javax.swing.JButton();
        jOcho = new javax.swing.JButton();
        jNueve = new javax.swing.JButton();
        jDividir = new javax.swing.JButton();
        jCuatro = new javax.swing.JButton();
        jCinco = new javax.swing.JButton();
        jSeis = new javax.swing.JButton();
        jMultiplicar = new javax.swing.JButton();
        jUno = new javax.swing.JButton();
        jDos = new javax.swing.JButton();
        jTres = new javax.swing.JButton();
        jResta = new javax.swing.JButton();
        jCero = new javax.swing.JButton();
        jDecimal = new javax.swing.JButton();
        jIgual = new javax.swing.JButton();
        jSuma = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDisplay.setEditable(false);
        txtDisplay.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtDisplay.setText("0");
        getContentPane().add(txtDisplay, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(5, 4));

        jSiete.setText("7");
        jSiete.addActionListener(this::jSieteActionPerformed);
        jPanel1.add(jSiete);

        jOcho.setText("8");
        jPanel1.add(jOcho);

        jNueve.setText("9");
        jPanel1.add(jNueve);

        jDividir.setText("/");
        jPanel1.add(jDividir);

        jCuatro.setText("4");
        jPanel1.add(jCuatro);

        jCinco.setText("5");
        jPanel1.add(jCinco);

        jSeis.setText("6");
        jPanel1.add(jSeis);

        jMultiplicar.setText("*");
        jPanel1.add(jMultiplicar);

        jUno.setText("1");
        jPanel1.add(jUno);

        jDos.setText("2");
        jPanel1.add(jDos);

        jTres.setText("3");
        jPanel1.add(jTres);

        jResta.setText("-");
        jPanel1.add(jResta);

        jCero.setText("0");
        jPanel1.add(jCero);

        jDecimal.setText(".");
        jPanel1.add(jDecimal);

        jIgual.setText("=");
        jPanel1.add(jIgual);

        jSuma.setText("+");
        jSuma.setToolTipText("");
        jPanel1.add(jSuma);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);

        jBorrar.setText("C");
        jPanel1.add(jBorrar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void jSieteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBorrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jCero;
    private javax.swing.JButton jCinco;
    private javax.swing.JButton jCuatro;
    private javax.swing.JButton jDecimal;
    private javax.swing.JButton jDividir;
    private javax.swing.JButton jDos;
    private javax.swing.JButton jIgual;
    private javax.swing.JButton jMultiplicar;
    private javax.swing.JButton jNueve;
    private javax.swing.JButton jOcho;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jResta;
    private javax.swing.JButton jSeis;
    private javax.swing.JButton jSiete;
    private javax.swing.JButton jSuma;
    private javax.swing.JButton jTres;
    private javax.swing.JButton jUno;
    private javax.swing.JTextField txtDisplay;
    // End of variables declaration                   
}
