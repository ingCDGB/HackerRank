public class main {

    public static void main(String[] args){
        System.out.println(repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",685118368975L));
    }

    static long repeatedString(String s, long n) {
        long totalAs = 0;
        long totalRepeticiones;
        int largoString;
        long totalAsEnString=0;

        if(validateString(s) && validateN(n)){

            if(validarSiSoloEsUnaA(s))
                return n;

            largoString = s.length();

            totalRepeticiones = getTotalRepeticionesDelString(s,n);

            totalAsEnString = obtenerTotalDeAsEnString(s, totalAs);

            totalAs = totalAsEnString * totalRepeticiones;

            totalAs = obtenerTotalDeAsEnString(s.substring(0,(int)(n - totalRepeticiones*largoString)), totalAs);
        }
        return totalAs;
    }

    private static long obtenerTotalDeAsEnString(String s, long totalAs) {
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                totalAs++;
            }
        }
        return totalAs;
    }

    static boolean validateString(String s){
        long largoString = s.length();

        return largoString >= 1 && largoString <= 100;
    }

    static boolean validateN(long n){
        return n >= 1 && n <= Math.pow(10,12);
    }

    static long getTotalRepeticionesDelString(String s, long n){

        return (n / s.length());
    }

    static boolean validarSiSoloEsUnaA(String s){
        return s.length() == 1 && s.equals("a");
    }

    /*static String obtenerStringRepetido(String s, long n){
        String stringRepetido = "";

        long totalDeRepeticiones = n / s.length();

        for(long i=0; i <= totalDeRepeticiones; i++){
            stringRepetido += s;
        }

        return stringRepetido;
    }*/
}
