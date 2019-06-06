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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Fecha con sus metodos para operar en una interfaz grafica
 * 
 * @author Rafael Infante
 *
 */
public class Fecha {

  // array dias segun el mes
  final static int[] DIAS_MES = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * Comprueba si la fecha pasada como parámetro es válida.
   * 
   * @param f
   * @return boolean
   */
  public static boolean esFechaValida(String f) {
    // comprobar que es un formato dd/mm/aaaa
    if (f.length() != 10 || !Character.isDigit(f.charAt(0)) || !Character.isDigit(f.charAt(1))
        || !Character.isDigit(f.charAt(3)) || !Character.isDigit(f.charAt(4)) || !Character.isDigit(f.charAt(6))
        || !Character.isDigit(f.charAt(7)) || !Character.isDigit(f.charAt(8)) || !Character.isDigit(f.charAt(9))
        || f.charAt(2) != '/' || f.charAt(5) != '/') {
      return false;
    }
    // comprobar si mes es correcto
    int mes = Integer.parseInt(f.substring(3, 5));
    if (mes < 1 || mes > 12) {
      return false;
    }
    // comprobar si día es correcto
    int dia = Integer.parseInt(f.substring(0, 2));
    int anyo = Integer.parseInt(f.substring(6));
    int diasmes = DIAS_MES[mes - 1]; // restamos 1 al mes para que esté entre 0 y 11
    // ¿febrero y año bisisesto?
    if (mes == 2 && anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
      diasmes++;
    }
    return (dia > 0 && dia <= diasmes);
  }

  /**
   * Suma un día a la fecha
   * 
   * @param f
   * @return fecha del día siguiente
   */
  public static String suma1DiaFecha(String f) {
    int d = Integer.parseInt(f.substring(0, 2));
    int m = Integer.parseInt(f.substring(3, 5));
    int a = Integer.parseInt(f.substring(6));

    int diasmes = DIAS_MES[m - 1];
    // ¿febrero y año bisisesto?
    if (m == 2 && a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
      diasmes++;
    }
    d++;
    if (d > diasmes) {
      d = 1;
      m++;
      if (m == 13) {
        m = 1;
        a++;
      }
    }
    f = fecha(d, m, a);
    return f;
  }

  /**
   * Devuelve una cadena en formato dd/mm/aaaa
   * 
   * @param d día del mes
   * @param m día del año
   * @param a año
   * @return
   */
  public static String fecha(int d, int m, int a) {
    String dia = Integer.toString(d).trim();
    String mes = Integer.toString(m).trim();
    String anyo = Integer.toString(a).trim();
    // día
    if (dia.length() < 2) {
      dia = "0" + dia;
    }
    // mes
    if (mes.length() < 2) {
      mes = "0" + mes;
    }
    // año
    for (int i = anyo.length(); i < 4; i++) {
      anyo = "0" + anyo;
    }
    return dia + "/" + mes + "/" + anyo;
  }

  /**
   * Resta un día a la fecha
   * 
   * @param f
   * @return fecha del día siguiente
   */
  public static String resta1DiaFecha(String f) {
    int d = Integer.parseInt(f.substring(0, 2));
    int m = Integer.parseInt(f.substring(3, 5));
    int a = Integer.parseInt(f.substring(6));

    d--;
    if (d == 0) { // mes anterior
      m--;
      if (m == 0) { // año anterior
        m = 12;
        a--;
      }
      d = DIAS_MES[m - 1];
      // ¿febrero y año bisisesto?
      if (m == 2 && a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
        d++;
      }
    }
    f = fecha(d, m, a);
    return f;
  }

  /**
   * Metodo que calcula los dias hasta la fecha de hoy.
   * 
   * @param fecha
   * 
   * @return String
   * 
   * @throws ParseException
   */
  public static String cuentaDias(String fecha) throws ParseException {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // metemos como parametro una fecha
    Date fechaInicial = dateFormat.parse(fecha);

    // sacamos la fecha actual
    Date fechaActual = new Date();

    // 864.. son los segundos que tiene un dia
    int dia = (int) ((fechaActual.getTime() - fechaInicial.getTime()) / 86400000);

    // Por si sale negativo
    dia = Math.abs(dia);

    String dias = Integer.toString(dia);

    return dias;
  }

}
