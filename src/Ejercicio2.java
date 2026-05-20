import java.util.Scanner;

public class Ejercicio2 {

  public static void main(String[] args) {
/*Ejercicio 2: Crear un programa que simule operaciones básicas de un cajero automático.
El usuario podrá:Consultar saldo. Depositar dinero. Extraer dinero.Salir del sistema.
Implementar funciones: mostrarMenu() consultarSaldo() depositarDinero() extraerDinero()
Validar que no se pueda extraer más dinero del saldo disponible.*/
      int opcion;
      final String MENSAJE_SALIDA="Gracias por usar el cajero automático, vuelva pronto";

      double saldo=1000000;
      do{
        opcion=ingresarOpcion();
        switch (opcion){
          case 1:
            consultarSaldo(saldo);
            break;
          case 2:
            saldo= depositarDinero(saldo);
            break;
          case 3:
            saldo=extraerDinero(saldo);
            break;
          case 4:
            System.out.println(MENSAJE_SALIDA);
            break;
          default:
            opcion=4;
        }
      }while(opcion!=4);

  }

  public static void mostrarMenu() {
    System.out.println("Bienvenido al cajero automático");
    System.out.println("1. Consultar saldo");
    System.out.println("2. Depositar dinero");
    System.out.println("3. Extraer dinero");
    System.out.println("4. Salir del sistema");
  }

  public static int ingresarOpcion() {
    Scanner sc = new Scanner(System.in);
    mostrarMenu();
    System.out.println("Ingrese la opción seleccionada: ");
    int opcion = sc.nextInt();
    if (opcion < 1 || opcion > 4) {
      System.out.println("Opción inválida, por favor ingrese una opción válida");
      opcion = ingresarOpcion();
    }
    return opcion;
  }

  //  consultarSaldo() depositarDinero() extraerDinero()
  public static void consultarSaldo(double saldo) {
    System.out.println("El saldo disponible es: " + saldo);
  }

  public static double depositarDinero(double saldo) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el importe a depositar: ");
    double deposito = sc.nextDouble();
    double nuevoSaldo = (deposito > 0) ? (saldo + deposito) : depositarDinero(saldo);
    System.out.println("El nuevo saldo es: " + nuevoSaldo);
    return nuevoSaldo;
  }

  public static double extraerDinero(double saldo) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el importe a extraer: ");
    double extraccion = sc.nextDouble();
    if(extraccion > saldo){
      System.out.println("No se puede extraer más dinero del saldo disponible, " +
          "por favor ingrese un importe válido");
      return extraerDinero(saldo);
    }
    double nuevoSaldo= saldo- extraccion;
    System.out.println("El nuevo saldo disponible es: " + nuevoSaldo);
    return nuevoSaldo;
  }

}
