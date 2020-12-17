import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Nombre_project: DAMJava
 * JuegoNumero
 * Created by: magua
 * Date : 16/12/2020
 * Description:
 **/
public class JuegoNumero {

    public static int dineromaquina = 20;
    public static int dineroganadopersona = 0;

    private   static void Jugar() {

        Scanner consola = new Scanner(System.in);
        int numerorandom = (int) (Math.random()*99 + 1);
        System.out.println("*Se ha introducido una moneda*");
        dineromaquina +=1;
        System.out.println("En que numero estoy pensando?: ");
        System.out.println(numerorandom);
        int numero = consola.nextInt();
        boolean acertado = false;
        int numerointentos = 4;
        while (numerointentos > 0 && !acertado ) {

            if (numero == numerorandom) {
                acertado = true;
            } else if (numero > numerorandom) {
                System.out.println("El número es mas pequeño");
                System.out.println("Te quedan " + numerointentos + " intentos" );
                numerointentos--;
            } else {
                System.out.println("El númro es mas grande");
                System.out.println("Te quedan " + numerointentos + " intentos" );
                numerointentos--;

            }
            if (acertado != true) {
                numero = consola.nextInt();
            }

        }

          if (acertado == true && dineromaquina >= 5){
            System.out.println("Has acertado el numero. Eres un crack, tifon, huracan, capitan de navio, todoterreno.");
            dineroganadopersona +=5;
            dineromaquina -=5;
              System.out.println("El dienor de la maquina es  " + dineromaquina + " € " +" y llevas acumulado " + dineroganadopersona + " € ");
            if (dineromaquina >= 5){
            MenuPrincipal();
            }else {
                System.out.println("Bro dejala, ya esta muerta. El dinero de la maquina es: " + dineromaquina);

            }
          } else {
            System.out.println("Lo siento mi pana te has quedado sin intentos");
            MenuPrincipal();
        }
    }

    private static int getDineroganadopersona() {
        return dineroganadopersona;
    }

    public static void MenuPrincipal(){
        boolean exit = false;
        Scanner consola = new Scanner(System.in);
        while (!exit){
            try {
                System.out.println("Que quieres hacer? ");
                System.out.println("1 Iniciar Juego \n2 Dinero Ganado \n3 Salir");
                System.out.print("Elige la opcion: ");
                switch (Integer.parseInt(consola.nextLine())){
                    case 1: Jugar();
                    break;
                    case 2: System.out.println("El dinero que has ganado es " + getDineroganadopersona() + " €");
                    break;
                    case 3: exit = true;
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main (String[]args) {
        MenuPrincipal();
    }



}






