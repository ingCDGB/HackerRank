public class main {

    public static void main(String[] args){
        int n = 9;
        int ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int elementosBuscados[] = new int[50];

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
