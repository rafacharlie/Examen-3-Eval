/**2.- Escribe un programa que usando la interfaz gráfica de Java permita al usuario introducir una fecha en
formato dd/mm/aaaa y que tenga los siguientes botones:
• Validar fecha: muestra un mensaje diciendo si la fecha es o no válida.
• Día posterior: Modifica la fecha sumándole un día. Debe validar la fecha antes de hacer la
operación.
• Día anterior: Modifica la fecha restándole un día. Debe validar la fecha antes de hacer la
operación.
• Días hasta hoy: Muestra el número de días que hay entre la fecha introducida y la fecha de hoy.
Debe validar la fecha antes de hacer la operación.
• Terminar.
La fecha debe ser manejada mediante un objeto de una clase que o bien construyáis con sus métodos
correspondientes o de las que ya existen en la API de Java.

@author Rafael Infante
*/
package exMayo2019RafaelInfanteCarrillo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Ejercicio2 {

  private JFrame frame;
  private JTextField textFieldValida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio2 window = new Ejercicio2();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ejercicio2() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 451, 188);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    /* a mano */
    frame.setTitle("Validador de fechas");

    JLabel lblFecha = new JLabel("Introduce una fecha: ");
    lblFecha.setBounds(10, 41, 115, 14);
    frame.getContentPane().add(lblFecha);

    textFieldValida = new JTextField();
    textFieldValida.setBounds(129, 38, 132, 20);
    frame.getContentPane().add(textFieldValida);
    textFieldValida.setColumns(10);

    JButton btnValidarFecha = new JButton("Validar fecha");
    btnValidarFecha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        /* a mano */
        if (Fecha.esFechaValida(textFieldValida.getText())) {
          JOptionPane.showMessageDialog(null, "Fecha correcta");
        } else {
          JOptionPane.showMessageDialog(null, "Fecha incorrecta o no introducida");
        }
      }
    });
    btnValidarFecha.setBounds(295, 7, 129, 23);
    frame.getContentPane().add(btnValidarFecha);

    JButton btnDiaPosterior = new JButton("Dia posterior");
    btnDiaPosterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        /* a mano */
        if (Fecha.esFechaValida(textFieldValida.getText())) {
          textFieldValida.setText(Fecha.suma1DiaFecha(textFieldValida.getText()));
        } else {
          JOptionPane.showMessageDialog(null, "La fecha debe ser valida primero");
        }

      }
    });
    btnDiaPosterior.setBounds(295, 37, 129, 23);
    frame.getContentPane().add(btnDiaPosterior);

    JButton btnDiaAnterior = new JButton("Dia anterior");
    btnDiaAnterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* a mano */
        if (Fecha.esFechaValida(textFieldValida.getText())) {
          textFieldValida.setText(Fecha.resta1DiaFecha(textFieldValida.getText()));

        } else {
          JOptionPane.showMessageDialog(null, "La fecha debe ser valida primero");
        }
      }
    });
    btnDiaAnterior.setBounds(295, 74, 129, 23);
    frame.getContentPane().add(btnDiaAnterior);

    JButton btnDiaHoy = new JButton("Dias hasta hoy");
    btnDiaHoy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* a mano */
        if (Fecha.esFechaValida(textFieldValida.getText())) {
          try {
            textFieldValida.setText(Fecha.cuentaDias(textFieldValida.getText()));

          } catch (ParseException e1) {
            JOptionPane.showMessageDialog(null, "Formato no valido");
          }
        } else {
          JOptionPane.showMessageDialog(null, "La fecha debe ser valida primero");
        }

      }
    });
    btnDiaHoy.setBounds(295, 108, 129, 23);
    frame.getContentPane().add(btnDiaHoy);

    JButton btnTerminar = new JButton("Terminar");
    btnTerminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* a mano */
        System.exit(0);
      }
    });
    btnTerminar.setBounds(151, 108, 89, 23);
    frame.getContentPane().add(btnTerminar);
  }
}
