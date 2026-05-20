//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  // método y funcion son lo mismo

  public static void main(String[] args) {
    int nro1=8;
    int nro2=4;
    int resultado=sumar(nro1,nro2);
    double resultado2=sumar(nro1, 3.5);

    System.out.println("El resultado de la suma es " + resultado);
    System.out.println(nro1);
    imprimirMensaje();
    imprimirMensajePersonalizado( "Funciones en JAVA");
  }//cierra metodo main
  // las funciones no se escriben adrentro del método main
  // funcion que recibe 2 parametros(nros enteros) y devuelve un entero
  public static int sumar(int nro1, int nro2)
  {  nro1++;
    int suma=nro1+nro2;
    return suma;
  }
  public static double sumar(int nro1, double nro2)
  {  nro1++;
     double suma=nro1+nro2;
    return suma;}
  public static double sumar(int nro1, int nro2, double nro3)
  {    return nro1+nro2+nro3;}

  // funcion que no devuelve nada (void) y no recibe nada: solo hace algo
  public static void imprimirMensaje()
  {
    System.out.println("Hola, soy una función que no devuelve nada");
  }

  // funcion que no devuelve nada (void) y recibe un parametro: solo hace algo con ese parametro
  public static void imprimirMensajePersonalizado(String mensaje){
    System.out.println("Hola " +  mensaje);

  }

}