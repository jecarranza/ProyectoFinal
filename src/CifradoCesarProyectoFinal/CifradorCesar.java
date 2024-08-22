package CifradoCesarProyectoFinal;
import java.util.Scanner;

public class CifradorCesar {

    private static String opcion;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {

            System.out.println("Antes de comenzar ¿quieres hacer el cifrado cesar con un archivo existente? \n " +
                    "Responde si para hacerlo con un archivo o responde no para ingresar tu propio texto");
            System.out.println("Respuesta:  ");
            opcion = sc.nextLine();
            if (opcion.equals("si")) {
                MenuConArchivoDeTexto.menu();
            } else if (opcion.equals("no")) {
                MenuConEntradaDeTexto.menu();
            }else {
                System.out.println("opcion invalida, nuevamnete elige la opcion correcta");
                System.out.println("-".repeat(55));
            }

        } while (!opcion.equals("si") && !opcion.equals("no"));
    }
}
