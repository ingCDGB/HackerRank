public class main {

    public static void main(String[] args){

        int ar[] = {50,49,38,49,78,36,25,96,10,67,78,58,98,8,53,1,4,7,29,6,59,93,74,3,67,47,12,85,84,40,81,85,89,70,33,66,6,9,13,67,75,42,24,73,49,28,25,5,86,53,10,44,45,35,47,11,81,10,47,16,49,79,52,89,100,36,6,57,96,18,23,71,11,99,95,12,78,19,16,64,23,77,7,19,11,5,81,43,14,27,11,63,57,62,3,56,50,9,13,45};
        int n = ar.length;
        int elementosBuscados[] = new int[100];

        int cantidadPares = 0;
        int cantidadConseguida;
        int valorBuscado;

        if(datosValidos(n,ar)){
            cantidadPares += getCantidadPares(ar, elementosBuscados);
            System.out.println(cantidadPares);
        }

    }

    private static int getCantidadPares(int[] socks, int[] elementosBuscados) {
        int valorBuscado;
        int cantidadPares=0;
        for(int i = 0; i< socks.length; i++){
            valorBuscado = socks[i];

            if(!elementoFueBuscado(valorBuscado, elementosBuscados,i)){
                cantidadPares += contarElementoEnArreglo(valorBuscado, socks);
            }
         }
        return cantidadPares;
    }

    public static boolean datosValidos(int cantidadElementos, int[] array){
        return estaElNumeroEnElRangoDel1Al100(cantidadElementos) &&
                validarCadaElementoEnElRangoDel1Al100(cantidadElementos,array);
    }

    public static boolean estaElNumeroEnElRangoDel1Al100(int cantidadElementos){
        return cantidadElementos >= 1 && cantidadElementos <= 100;
    }

    public static boolean validarCadaElementoEnElRangoDel1Al100(int cantidadElementos, int[] array){
        for(int i=0; i < cantidadElementos; i++){
            if(!estaElNumeroEnElRangoDel1Al100(array[i]))
                return false;
        }

        return true;
    }

    public static int contarElementoEnArreglo(int valorBuscado, int[] array){
        int contador = 0;

        for(int i=0; i < array.length; i++){
            if(array[i] == valorBuscado){
                contador++;
            }
        }

        return contador/2;
    }

    public static boolean elementoFueBuscado(int elemento, int[] array,int posicion){
        for(int i=0; i < posicion; i++){
            if(array[i] == elemento){
//                System.out.println(" YA FUE EVALUADO - " +array[i]);

                return true;
            }
        }
        array[posicion] = elemento;

        return false;
    }
}
