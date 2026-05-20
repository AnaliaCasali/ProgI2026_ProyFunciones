import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
  public static void main(String[] args) {
/*Crear un programa que permita ingresar las ventas realizadas durante un mes y luego:
Calcular el total vendido.
Obtener el promedio de ventas.
 Mostrar la venta más alta.
 Contar cuántas ventas superaron los $50.000.
Utilizar un array para almacenar las ventas.
Crear funciones: cargarVentas()
            mostrarVentas()calcularTotalVentas()calcularPromedioVentas()buscarVentaMaxima()
Validar que las ventas no sean negativas.*/

    Double ventasDiarias[] = new Double[30];
    cargarVentas(ventasDiarias);
    mostrarVentas(ventasDiarias);
    System.out.println( "El total es " + calcularTotal(ventasDiarias));


  }

  public static void mostrarVentas(Double[] ventasDiarias) {
    System.out.println("las Ventas diarias son: " + Arrays.toString(ventasDiarias));
         }
  public static Double calcularTotal(Double[] ventasDiarias) {
    Double total=0.0;
    for ( int i=0; i<ventasDiarias.length;i++){
      total+=ventasDiarias[i];
    }
    return total;
  }

    public static  void cargarVentas(Double[] ventasDiarias ) {
        for(int i=0;i<ventasDiarias.length;i++){
            ventasDiarias[i]=cargarUnaVenta();
        }
    }

    public static double cargarUnaVenta(){
        Scanner sc = new Scanner(System.in);
        double venta;
        System.out.println("Ingrese el monto de la venta realizada (no puede ser negativo): ");
        venta=sc.nextDouble();

        double valor= (venta>=0) ? venta : cargarUnaVenta();
        return valor;
    }
}
