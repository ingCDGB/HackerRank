public class main {

    public static void main(String[] args){
        int[] c = {0,1,0,0,0,1,0};

        System.out.println(jumpingOnClouds(c));
    }

    static int jumpingOnClouds(int[] c) {

        int cantidadSaltos = 0;
        int posicion = 0;
        int largoArray = c.length;

        if(validarLargoArray(c) && validarElementosDelArray(c)){

            while(posicion < largoArray){

                posicion += cuantoPuedoSaltar(c,posicion);

                cantidadSaltos++;

                if(posicion == largoArray-1)
                    posicion++;
            }
        }else
            System.out.println("NO ES VALIDO EL ARRAY");

        return cantidadSaltos;

    }

    static boolean validarLargoArray(int[] c){
        return c.length >= 2 && c.length <= 100;
    }

    static boolean validarElementosDelArray(int[] c){
        int elemento;
        int largoArray = c.length;

        if(c[largoArray-1] != 0 || c[0] != 0)
            return false;

        for(int i=1; i<largoArray;i++){
            elemento = c[i];

            if(elemento != 0 && elemento !=1)
                return false;

        }

        return true;
    }

    static int cuantoPuedoSaltar(int[] c, int posicionActual){
        int largoArray = c.length;
        int totalASaltar = 0;

        int posicionMasUno = posicionActual+1;
        int posicionMasDos = posicionActual+2;

        if(posicionMasUno < largoArray && c[posicionMasUno] != 1){
            totalASaltar = 1;
        }

        if(posicionMasDos < largoArray && c[posicionMasDos] != 1){
            totalASaltar = 2;
        }

        return totalASaltar;
    }
}
