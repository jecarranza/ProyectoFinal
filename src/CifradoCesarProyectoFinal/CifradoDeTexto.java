package CifradoCesarProyectoFinal;

public class CifradoDeTexto {

    public static String CifradorDeTexto(String AbecedarioMay, String text, int numero_de_recorridos) {
        String textoCodificado = "";

        text = text.toUpperCase();

        char Caracter;
        for (int index = 0; index < text.length(); index++) {
            Caracter = text.charAt(index);

            int pos = AbecedarioMay.indexOf(Caracter);

            if(pos == -1){
                textoCodificado += Caracter;
            }else{
                textoCodificado += AbecedarioMay.charAt( (pos + numero_de_recorridos) % AbecedarioMay.length() );
            }

        }

        return textoCodificado;
    }

    public static String DescifradorDeTexto(String AbecedarioMay, String Text, int numero_de_recorridos) {
        String textoDescodificado = "";
        Text = Text.toUpperCase();

        char Caracter;
        for (int index = 0; index < Text.length(); index++) {
            Caracter = Text.charAt(index);

            int pos = AbecedarioMay.indexOf(Caracter);

            if(pos == -1){
                textoDescodificado += Caracter;
            }else{
                if(pos - numero_de_recorridos < 0){
                    textoDescodificado += AbecedarioMay.charAt( AbecedarioMay.length() + (pos - numero_de_recorridos) );
                }else{
                    textoDescodificado += AbecedarioMay.charAt( (pos - numero_de_recorridos) % AbecedarioMay.length() );
                }
            }
        }
        return textoDescodificado;
    }

    public static void DescifradorDeTextoFuerzaBruta(String AbecedarioMay, String Text) {
        String textoDescodificado = "";
        Text = Text.toUpperCase();
        char Caracter;
        for (int kndex = 1; kndex <= AbecedarioMay.length()-1; kndex++){
            for (int index = 0; index < Text.length(); index++) {
                Caracter = Text.charAt(index);
                int pos = AbecedarioMay.indexOf(Caracter);
                if(pos == -1){
                    textoDescodificado += Caracter;
                }else{
                    if(pos - kndex < 0){
                        textoDescodificado += AbecedarioMay.charAt(AbecedarioMay.length() + (pos - kndex) );
                    }else{
                        textoDescodificado += AbecedarioMay.charAt( (pos - kndex) % AbecedarioMay.length() );
                    }
                }
            }
            System.out.println(kndex + " = " + textoDescodificado);
            textoDescodificado = "";
            System.out.println();
        }
    }
}
