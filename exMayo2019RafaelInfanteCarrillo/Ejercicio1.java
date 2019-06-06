/**1. Escribe un programa que usando la interfaz gráfica de Java escoja un fichero del sistema de archivos y
lo almacene en otro de manera que se sustituyan todas las ocurrencias de los siguientes caracteres
(mayúscula o minúscula) del fichero original por sus correspondientes números:
A 4
B 8
E 3
I 1
O 0
S 5
T 7
Componentes gráficos:
• Etiquetas.
• Fichero origen y destino.
• Botón para ejecutar la acción.
• Caja de texto con el contenido del fichero destino no editable.

@author Rafael Infante
*/
package exMayo2019RafaelInfanteCarrillo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio1 {

  private JFrame frame;
  private JTextField rutaFicheroOrigen;
  private JTextField rutaFicheroDestino;
  protected File ficheroOrigen;// variable fichero origen
  protected File ficheroDestino;// variable fichero destino
  private JButton btnMezclar;
  private JScrollPane scrollPane;
  private JTextArea textArea;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio1 window = new Ejercicio1();
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
  public Ejercicio1() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 446, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("Buscador de ocurrencias");

    JLabel lblFicheroOrigen = new JLabel("Selecciona un fichero: ");
    lblFicheroOrigen.setBounds(21, 24, 115, 14);
    frame.getContentPane().add(lblFicheroOrigen);

    /****************************************************************
     * boton fichero origen
     *************************************************************/
    JButton btnFicheroOrigen = new JButton("fichero origen");
    btnFicheroOrigen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        /* filechooser fichero origen */
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(frame);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

          ficheroOrigen = fileChooser.getSelectedFile();
          // ponemos la ruta en el textfield origen
          rutaFicheroOrigen.setText(ficheroOrigen.getAbsolutePath());
        }
      }
    });
    btnFicheroOrigen.setBounds(142, 20, 115, 18);
    frame.getContentPane().add(btnFicheroOrigen);

    rutaFicheroOrigen = new JTextField();
    rutaFicheroOrigen.setBounds(21, 49, 390, 20);
    frame.getContentPane().add(rutaFicheroOrigen);
    rutaFicheroOrigen.setColumns(10);
    /****************************************************************
     * fin boton fichero origen
     *************************************************************/
    JLabel lblFicheroDestino = new JLabel("Selecciona un fichero: ");
    lblFicheroDestino.setBounds(21, 80, 115, 14);
    frame.getContentPane().add(lblFicheroDestino);

    /****************************************************************
     * boton fichero destino
     *************************************************************/
    JButton btnFicheroDestino = new JButton("fichero destino");
    btnFicheroDestino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* filechooser fichero destino */
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(frame);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

          ficheroDestino = fileChooser.getSelectedFile();
          // ponemos la ruta en el textfield destino
          rutaFicheroDestino.setText(ficheroDestino.getAbsolutePath());
        }
      }
    });
    btnFicheroDestino.setBounds(142, 76, 115, 18);
    frame.getContentPane().add(btnFicheroDestino);

    rutaFicheroDestino = new JTextField();
    rutaFicheroDestino.setBounds(21, 105, 390, 20);
    frame.getContentPane().add(rutaFicheroDestino);
    rutaFicheroDestino.setColumns(10);
    /****************************************************************
     * fin boton fichero destino
     *************************************************************/

    /****************************************************************
     * boton fichero Mezclar
     *************************************************************/
    btnMezclar = new JButton("Mezclar");
    btnMezclar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        // mi codigo de programa

        try {
          FileReader leer = new FileReader("C:/Users/Rafael Infante/Desktop/ficherospgnpracticas/ejemplo.txt");
          FileWriter escribir = new FileWriter("C:/Users/Rafael Infante/Desktop/ficherospgnpracticas/ejemplo2.txt");

          BufferedReader br = new BufferedReader(leer);
          BufferedWriter bw = new BufferedWriter(escribir);

          String linea = "";
          String resultado = "";

          while (linea != null) {
            linea = br.readLine();

            if (linea != null) {
              linea = linea.replaceAll("a", "4");
              linea = linea.replaceAll("A", "4");
              linea = linea.replaceAll("b", "8");
              linea = linea.replaceAll("B", "8");
              linea = linea.replaceAll("e", "3");
              linea = linea.replaceAll("E", "3");
              linea = linea.replaceAll("i", "1");
              linea = linea.replaceAll("I", "1");
              linea = linea.replaceAll("o", "0");
              linea = linea.replaceAll("O", "0");
              linea = linea.replaceAll("s", "5");
              linea = linea.replaceAll("S", "5");
              linea = linea.replaceAll("t", "7");
              linea = linea.replaceAll("T", "7");

              bw.write(linea); // escribe en el fichero
              resultado += linea + "\n"; // escribe linea a linea en esta variable

            }
          }

          textArea.append(resultado);

          br.close();
          bw.close();

          JOptionPane.showMessageDialog(null, "Programa finalizado con exito");

        } catch (IOException ie) {
          JOptionPane.showMessageDialog(null, "No se encontro el archivo");

        }

      }
    });
    btnMezclar.setBounds(304, 18, 89, 23);
    frame.getContentPane().add(btnMezclar);
    /****************************************************************
     * Fin boton Mezclar
     *************************************************************/

    scrollPane = new JScrollPane();
    scrollPane.setBounds(21, 136, 390, 114);
    frame.getContentPane().add(scrollPane);

    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
  }
}
