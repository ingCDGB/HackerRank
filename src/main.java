import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args){
        String a = "cdecdecdeqwerf";
        String b = "dcfjj";
        System.out.println(makeAnagram(a,b));
    }

    static int makeAnagram(String a, String b) {
        int totalCaracteresEliminados = 0;
        int totalCaracteresEliminadosEnA = 0;
        int totalCaracteresEliminadosEnB = 0;

        boolean largoStringOk = validarLargo(a) && validarLargo(b);
        boolean caractesStringOk = validarCaracteresDelString(a) && validarCaracteresDelString(b);

        String aLimpia = "";
        String bLimpia = "";

        if(largoStringOk && caractesStringOk){
            aLimpia = eliminarCaracteresQueNoEstanEnElOtroString(a,b);
            bLimpia = eliminarCaracteresQueNoEstanEnElOtroString(b,a);

            totalCaracteresEliminadosEnA = a.length() - aLimpia.length();
            totalCaracteresEliminadosEnB = b.length() - bLimpia.length();

            totalCaracteresEliminados = totalCaracteresEliminadosEnA + totalCaracteresEliminadosEnB;
        }

        return  totalCaracteresEliminados;
    }

    static boolean validarLargo(String palabra){
        int longitud = palabra.length();

        return longitud >= 1 && longitud <= Math.pow(10,4);
    }

    static boolean validarCaracteresDelString(String palabra){
        Pattern pat = Pattern.compile("[a-z]+");
        Matcher mat = pat.matcher(palabra);
        return mat.matches();
    }

    static String eliminarCaracteresQueNoEstanEnElOtroString(String a,String b){
        String caracter = "";
        int cantidadDelCaracterDeA = 0;
        int cantidadDelCaracterDeB = 0;

        for(int i=0; i < a.length(); i++) {
            caracter = String.valueOf(a.charAt(i));
            cantidadDelCaracterDeA = obtenerCantidadDeCaracterEnElString(a,caracter);
            cantidadDelCaracterDeB = obtenerCantidadDeCaracterEnElString(b,caracter);

            if(cantidadDelCaracterDeA > cantidadDelCaracterDeB){
                a = reemplazarNVecesUnCaracter(a,a.charAt(i),cantidadDelCaracterDeA-cantidadDelCaracterDeB);
            }
        }

        return a.replaceAll(" ","");
    }

    static int obtenerCantidadDeCaracterEnElString(String s, String caracter){
        return s.length()-s.replaceAll(caracter,"").length();
    }

    static String reemplazarNVecesUnCaracter(String s, char caracter, int cantidad){
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            if(cantidad == 0)
                break;

            if(str[i] == caracter){
                cantidad--;
                str[i] = ' ';
            }
        }

        return new String(str);
    }


}
