public class main {

    public static void main(String[] args){
        //{ {fila1}, {fila2},..., {filaN}};
        int[] fila1= {1,1,1,0,0,0};
        int[] fila2= {0,1,0,0,0,0};
        int[] fila3= {1,1,1,0,0,0};
        int[] fila4= {0,0,2,4,4,0};
        int[] fila5= {0,0,0,2,0,0};
        int[] fila6= {0,0,1,2,4,0};


        fila1= new int[]{-0, -4, -6, 0, -7, -6};
         fila2= new int[]{-1, -2, -6, -8, -3, -1};
         fila3= new int[]{-8, -4, -2, -8, -8, -6};
         fila4= new int[]{-3, -1, -2, -5, -7, -4};
         fila5= new int[]{-3, -5, -3, -6, -6, -6};
         fila6= new int[]{-3, -6, 0, -8, -6, -7};

        int[][] arr = {(fila1),(fila2),(fila3),(fila4),(fila5),(fila6)};

        System.out.println(hourglassSum(arr));
    }

    static int hourglassSum(int[][] arr) {
        int resultado = -999999999;
        int sumado = 0;
        if(arregloValido(arr)){
            for(int i=0; i<=3; i++){
                for(int j=0; j<=3; j++){
                    sumado = sumar(arr,i,j);
                    resultado = (resultado >= sumado)?resultado:sumado;
//                    System.out.println(i+","+j+" = "+sumar(arr,i,j)+" ");
                }
            }
        }
        return resultado;
    }

    static boolean estaEntreMenos9Y9(int elemento){
        return elemento >= -9 && elemento <= 9;
    }

    static boolean arregloValido(int[][] arr){
        for(int i=0; i<=5; i++){
            for(int j=0; j<=5; j++){
                if(!estaEntreMenos9Y9(arr[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static int sumar(int[][] arr, int filaInicio, int columnaInicio){
        int resultado = 0;
        boolean esFilaDelMedio = false;
        boolean esFilaIgualAColumna = false;

//        System.out.println("********************************************");
        for(int i=filaInicio; i<filaInicio+3; i++) {

            for (int j = columnaInicio; j <columnaInicio+3; j++) {
                esFilaDelMedio = i == filaInicio+1;
                esFilaIgualAColumna = i == filaInicio+1 && j == columnaInicio+1;

                if(!esFilaDelMedio){
                    resultado+=arr[i][j];
                }
                else{
                    if(esFilaIgualAColumna)
                        resultado+=arr[i][j];
                }
//                System.out.print(arr[i][j]+" ");
            }
//            System.out.println("");
        }

        return resultado;
    }
}
