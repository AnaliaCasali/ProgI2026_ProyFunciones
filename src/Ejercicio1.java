import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio1 {
  /**
   * Ejercicio 1: Crear un programa que permita ingresar las temperaturas registradas durante una semana
   * y calcular:
   * El promedio de temperaturas. La temperatura más alta.
   * La temperatura más baja.
   * Cantidad de días con temperatura mayor o igual a 25°C.
   * Usar un array para almacenar las temperaturas.
   * Implementar funciones para cada cálculo:
   * calcularPromedio()
   * buscarMaxima()
   * buscarMinima()
   * contarDiasCalurosos()
   * Validar que las temperaturas ingresadas estén entre -10 y 50. Utilizar Scanner para el ingreso de datos.
   */

  public static void main(String[] args) {
    // ingreso todas las temperaturas en un array
    int[] temperaturasDiarias = new int[7];
    for (int i = 0; i < temperaturasDiarias.length; i++) {
      temperaturasDiarias[i] = ingresarTemperaturayValidar();
    }
    System.out.println(Arrays.toString(temperaturasDiarias));

    double promedio = calcularPromedio(temperaturasDiarias);
    System.out.println("El promedio de temperaturas es: " + promedio);

    double maxima = buscarMaxima(temperaturasDiarias);
    System.out.println("La temperatura más alta es: " + maxima);

    double minima = buscarMinima(temperaturasDiarias);
    System.out.println("La temperatura más baja es: " + minima);

    System.out.println("La cantidad de días con temperatura mayor" +
        " o igual a 25°C es: " + contarDiasCalurosos(temperaturasDiarias));

    //Main.sumar(5,4);
    Funciones funciones=new Funciones();
    int nro= funciones.leerEntero();

   //
 // otra forma de buscar el maximo y minimo es ordenando el array y tomando el primer y ultimo elemento
    Arrays.sort(temperaturasDiarias);
  int min= temperaturasDiarias[0];
  int max= temperaturasDiarias[6];

  }

  // FUNCION RECURSIVA: LA QUE SE LLAMA A SI MISMA
  public static int ingresarTemperaturayValidar() {
    Scanner sc = new Scanner(System.in);
    int temperatura;

    System.out.println("Ingrese la temperatura registrada (entre -10 y 50 grados): ");
    temperatura = sc.nextInt();
    // OPERADOR TERNARIO
    temperatura = (temperatura >= -10 && temperatura <= 50) ? temperatura : ingresarTemperaturayValidar();
    return temperatura;
  }

  public static double calcularPromedio(int[] temperaturas) {
    int suma = 0;
    for (int i = 0; i < temperaturas.length; i++) {
      suma += temperaturas[i];
    }
    double promedio = (double) suma / temperaturas.length;
    return promedio;
  }

  //   * buscarMinima()
//   * contarDiasCalurosos()
  public static double buscarMaxima(int[] temperaturas) {
    double maximo = 0;

    for (int i = 0; i < temperaturas.length; i++) {
      if (temperaturas[i] > maximo) {
        maximo = temperaturas[i];
      }
    }
    return maximo;
  }

  public static int contarDiasCalurosos(int[] temperaturas) {
    int cantidad = 0;

    for (int i = 0; i < temperaturas.length; i++) {
      if (temperaturas[i] >= 25) {
        cantidad++;
      }
    }
    return cantidad;
  }

  public static double buscarMinima(int[] temperaturas) {
    double minima = 0;

    for (int i = 0; i < temperaturas.length; i++) {
      if (temperaturas[i] < minima) {
        minima = temperaturas[i];
      }
    }
    return minima;
  }

}