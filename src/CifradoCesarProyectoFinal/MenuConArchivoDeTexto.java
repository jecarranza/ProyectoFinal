package CifradoCesarProyectoFinal;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MenuConArchivoDeTexto {

    private static Path path = Path.of("src/CifradoCesarProyectoFinal/TextoAlmacenado");
    private static Path path2 = Path.of("src/CifradoCesarProyectoFinal/TextoIncriptado");
    private static Scanner scanner_solo_para_ingresar_opcion = new Scanner(System.in);
    private static Scanner scanner_solo_para_ingresar_recorridos = new Scanner(System.in);
    public static String AbecedarioMay = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static String opcion, text, Descodificado;
    private static int bitesLeidos, bitesLeidos2, bitesLeidos3, numero_de_recorridos;


    public static void menu() {
        do {
            try {

                System.out.println("=".repeat(25) + "Cifrado Cesar con archivo de texto" + "=".repeat(25));
                System.out.println("=".repeat(25) + "=".repeat(25));
                System.out.println("1.- Cifrado de texto");
                System.out.println("2.- Descifrado del texto");
                System.out.println("3.- Descifrado mediante el método de brute force");
                System.out.println("4.- Para regresar al primer menu");
                System.out.println("0.- Salir");
                System.out.print("Ingrese la opcion que desea: ");
                opcion = scanner_solo_para_ingresar_opcion.nextLine();
                System.out.println("=".repeat(25) + "=".repeat(25));
                System.out.println("=".repeat(25) + "=".repeat(25));
                validaropcion();

            } catch (Exception e) {

                System.err.println("Upps escribio una letra en vez de un numero \n Vuelva a digitar el numero por favor");
            }

        } while (!opcion.equals("0"));

    }
    private static void validaropcion() {
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
             FileChannel fileChanel = FileChannel.open(path2, StandardOpenOption.READ)) {

            int opcionint = Integer.parseInt(opcion);
            switch (opcionint) {
                case 1:
                    System.out.println("Cifrado de texto");
                    System.out.println("Se leera el archivo llamado texto almacenado");

                    ByteBuffer buffer = ByteBuffer.allocate(2024);
                    bitesLeidos = fileChannel.read(buffer);
                    buffer.flip();
                    byte[] arregloDeBytes = new byte[bitesLeidos];
                    buffer.get(arregloDeBytes);
                    text = new String(arregloDeBytes);

                    System.out.println("Ingresa el numero de recorridos");
                    numero_de_recorridos = scanner_solo_para_ingresar_recorridos.nextInt();

                    String textocodificado = CifradoDeTexto.CifradorDeTexto(AbecedarioMay, text, numero_de_recorridos);

                    System.out.println("texto codificado: \n" + textocodificado);
                    System.out.println("-".repeat(40));
                    System.out.println();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Descifrado del texto");
                    System.out.println("Se descifrara el mismo texto anterior");

                    ByteBuffer buffer2 = ByteBuffer.allocate(2024);
                    bitesLeidos2 = fileChanel.read(buffer2);
                    buffer2.flip();
                    byte[] arregloDeBytes2 = new byte[bitesLeidos2];
                    buffer2.get(arregloDeBytes2);
                    Descodificado = new String(arregloDeBytes2);

                    System.out.println("Ingresa el numero de recorridos");
                    numero_de_recorridos = scanner_solo_para_ingresar_recorridos.nextInt();

                    text = CifradoDeTexto.DescifradorDeTexto(AbecedarioMay, Descodificado, numero_de_recorridos);

                    System.out.println("texto descodificado: \n" + text);
                    System.out.println("-".repeat(40));
                    System.out.println();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Descifrado mediante el método de brute force");
                    System.out.println("Ingrese el texto a descodificar en todas las combinaciones");

                    ByteBuffer buffer3 = ByteBuffer.allocate(2024);
                    bitesLeidos3 = fileChanel.read(buffer3);
                    buffer3.flip();
                    byte[] arregloDeBytes3 = new byte[bitesLeidos3];
                    buffer3.get(arregloDeBytes3);
                    text = new String(arregloDeBytes3);
                    CifradoDeTexto.DescifradorDeTextoFuerzaBruta(AbecedarioMay, text);

                    System.out.println("-".repeat(40));
                    System.out.println();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Regresamos a la pregunta incial");
                    System.out.println();
                    CifradorCesar.main(null);
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Gracias por preferirnos, vuelva pronto....."); System.exit(0);

                default:
                    System.out.println("Opcion no valida");
                    System.out.println();
                    System.out.println();
                    break;

            }
        } catch (IOException e) {System.err.println(e.getMessage());}
    }
}

