import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {
/*Ejercicio 4:
Crear un programa para administrar una agenda simple de contactos.
El sistema deberá permitir: Agregar contactos.
 Buscar un contacto por nombre.
 Mostrar todos los contactos.
 Modificar un número telefónico.
Utilizar dos arrays: uno para nombres otro para teléfonos
Crear funciones: agregarContacto() buscarContacto() modificarTelefono() mostrarContactos()
Validar que no existan nombres repetidos.*/

  public static void main(String[] args) {
    int cantidad = 0;
    String[] nombres;
    String[] telefonos;

    // llama a la funcion que ingresa la cantidad
    cantidad = ingresarCantidad();
    // dimensione los arrays
    nombres = new String[cantidad];
    telefonos = new String[cantidad];
    // llamo al menu
    int opcion = 0;
    int cantIngresada = 0;

    System.out.println("Bienvenido a la agenda de contactos, por favor ingrese los contactos a agregar");
    for (int i=0;i<cantidad;i++){
        System.out.println("Agregar un contacto.");
        AgregarContacto(nombres, telefonos, i);
        cantIngresada++;
    }

    do {
      opcion = mostrarEIngresarOpcion();
      switch (opcion) {
        case 1:
          System.out.println("Buscar un contacto por nombre.");
          int nro= BuscarContactoPorNombre(nombres, telefonos);
          break;
        case 2:
          System.out.println("Mostrar todos los contactos.");
          mostrarTodosContactos(nombres, telefonos);
          mostrarContactos(nombres, telefonos);
          break;
        case 3:
          System.out.println("Modificar un número telefónico.");
          modificarTelefono(nombres, telefonos);
          break;
        case 4:
          System.out.println("Salir.");
          break;
      }
    } while (opcion != 4);
  }

  public static int mostrarEIngresarOpcion() {
    System.out.println("1. Buscar un contacto por nombre.");
    System.out.println("2. Mostrar todos los contactos.");
    System.out.println("3. Modificar un número telefónico.");
    System.out.println("4. Salir.");
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese la opción seleccionada: (entre 1y4)");
    int opc = sc.nextInt();
    opc = (opc >= 1 && opc <= 4) ? opc : mostrarEIngresarOpcion();
    return opc;
  }

  public static int ingresarCantidad() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese la cantidad de contactos a agregar: ");
    int cantidad = sc.nextInt();
    return cantidad;
  }

  public static void AgregarContacto(String[] nombres, String[] telefonos, int posicion) {

    if (posicion < nombres.length) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Por favor ingrese el nombre ");
      String nom = sc.next();

      System.out.print("Por favor ingrese el telefono ");
      String tel = sc.next();

      nombres[posicion] = nom;
      telefonos[posicion] = tel;
    } else
      System.out.println("No se pueden agregar mas contactos");
  }

  public static int BuscarContactoPorNombre(String[] nombres, String[] telefonos) {
    //pedir nombre

    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el nombre buscado:");
    String nom = sc.next();
    if (nom.isEmpty() || nom.isBlank()) BuscarContactoPorNombre(nombres, telefonos);

    // buscar nombre (coincidencia) en el array
    // tomar del array de telefonos el que en = posición
    for (int i = 0; i < nombres.length; i++) {
      if (nom.trim().equalsIgnoreCase(nombres[i].trim())) {
        System.out.println("El telefono del contacto es: " + telefonos[i]);
        return i;
      }
    }
    System.out.println("El contacto no existe");
    return -1;
  }
  public static void mostrarTodosContactos(String[] nombres, String[]telefonos){
    System.out.println( Arrays.toString(nombres));
    System.out.println( Arrays.toString(telefonos));
  }
  public static void mostrarContactos(String[] nombres, String[]telefonos){
      for (int i=0; i<nombres.length;i++){
        System.out.println("Contacto nro " + i +  ": Nombre: " + nombres[i] + " Telefono: " + telefonos[i]);
      }

  }

  public static void modificarTelefono(String[] nombres, String[] telefonos){
    int posicion= BuscarContactoPorNombre(nombres, telefonos);
    if(posicion != -1) {
      System.out.print("Ingrese el nuevo telefono: ");
      Scanner sc = new Scanner(System.in);
      String nuevoTelefono = sc.next();
      telefonos[posicion] = nuevoTelefono;
    }
    else {
      System.out.println("No se pudo modificar el telefono porque el contacto no existe");
    }
  }

}
