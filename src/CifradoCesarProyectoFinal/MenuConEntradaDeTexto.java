package CifradoCesarProyectoFinal;

import java.util.Scanner;

public class MenuConEntradaDeTexto {


    private static Scanner scanner_solo_para_ingresar_el_texto = new Scanner(System.in);
    public static Scanner scanner_solo_para_ingresar_opcion = new Scanner(System.in);
    private static Scanner scanner_solo_para_ingresar_numero_de_recorridos = new Scanner(System.in);

    public static String AbecedarioMayString = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static String opcion, Text, txtDescodificado, textocodificado;

    private static int Numero_de_recorridos;

    public static void menu() {

            do {
                try {
                System.out.println("=".repeat(25) + "Cifrado Cesar con entrada de texto" + "=".repeat(25));
                System.out.println("1.- Cifrado de texto");
                System.out.println("2.- Descifrado del texto");
                System.out.println("3.- Descifrado mediante el método de brute force");
                System.out.println("4.- Para regresar al primer menu");
                System.out.println("0.- Salir");

                System.out.print("Ingrese la opcion que desea: ");
                opcion = scanner_solo_para_ingresar_opcion.nextLine();
                    System.out.println("=".repeat(50));
                    scanner_solo_para_ingresar_numero_de_recorridos.useDelimiter("\n");
                validaropcion();
;
                } catch (Exception e) {
                    System.err.println("Upps escribio una letra en vez de un numero \n Vuelva a digitar el numero por favor");
                }
            } while (!opcion.equals("0"));


    }
    private static void validaropcion() {
        int opcionint = Integer.parseInt(opcion);
        switch (opcionint) {
            case 1: System.out.println("Cifrado de texto");
                System.out.println("Digite el texto a codificar: ");
                Text = scanner_solo_para_ingresar_el_texto.nextLine();

                System.out.println("Ingrese numero de recorridos");
                Numero_de_recorridos = scanner_solo_para_ingresar_numero_de_recorridos.nextInt();

                textocodificado = CifradoDeTexto.CifradorDeTexto(AbecedarioMayString, Text, Numero_de_recorridos);
                System.out.println("texto codificado: " + textocodificado);

                System.out.println("-".repeat(40));
                System.out.println();
                break;

            case 2: System.out.println("Descifrado del texto");
                System.out.println("Ingrese texto a descodificar: ");
                Text = scanner_solo_para_ingresar_el_texto.nextLine();

                System.out.println("Ingrese numero de recorridos");
                Numero_de_recorridos = scanner_solo_para_ingresar_numero_de_recorridos.nextInt();


                txtDescodificado = CifradoDeTexto.DescifradorDeTexto(AbecedarioMayString, Text, Numero_de_recorridos);
                System.out.println("texto descodificado: " + txtDescodificado);

                System.out.println("-".repeat(40));
                System.out.println();
            break;

            case 3: System.out.println("Descifrado mediante el método de brute force");
                System.out.println("Ingrese el texto a descodificar con todas las combinaciones posibles");

                Text = scanner_solo_para_ingresar_el_texto.nextLine();

                CifradoDeTexto.DescifradorDeTextoFuerzaBruta(AbecedarioMayString, Text);
                System.out.println("-".repeat(40));
                System.out.println();
            break;

            case 4:
                System.out.println("Regresamos a la pregunta inicial");
                System.out.println();
                CifradorCesar.main(null);
                break;

            case 0: System.out.println("Gracias por su preferencia vuelva pronto....."); System.exit(0);

            default:
                System.out.println("Opcion no valida");
                System.out.println();
                System.out.println();
                break;

        }
    }
}
