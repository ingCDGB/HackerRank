import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args){
        int[] array = {3,4,6,6,3};

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(8);
        numbers.add(8);
        numbers.add(5);
        System.out.println(countMoves(numbers));
    }

    public static long countMoves(List<Integer> numbers) {

        long movimientos = 0;
        Integer maxValue;

        if(arrayValido(numbers)){
            maxValue = obtenerMayorValor(numbers);

            while(!todosLosElementosSonIguales(numbers,maxValue)){

                numbers = aumentarEnUnoCadaElemento(numbers,maxValue);
                maxValue = obtenerMayorValor(numbers);
                movimientos++;
            }

        }

        return movimientos;
    }

    public static boolean arrayValido(List<Integer> numbers){
        return numbers.size() >= 1 && numbers.size() <= Math.pow(10,5) && validarCadaElemento(numbers);
    }

    public static boolean validarCadaElemento(List<Integer> numbers){
        boolean arrayValido = true;

        return !numbers.stream().filter( num -> elementoValido(num)).findAny().isPresent();

    }
    public static boolean elementoValido(Integer numero){
        return numero.intValue() < 1 || numero.intValue() > Math.pow(10,6);
    }

    public static Integer obtenerMayorValor(List<Integer> numbers){
        return numbers
                .stream()
                .mapToInt(v -> v)
                .max().getAsInt();
    }

    public static boolean todosLosElementosSonIguales(List<Integer> numbers, Integer maxValue){
        return !numbers.stream().filter(numero -> !numero.equals(maxValue)).findAny().isPresent();
    }

    public static List<Integer> aumentarEnUnoCadaElemento(List<Integer> numbers,Integer maxValue){
        final boolean[] saltarMaxValue = {false};

        for(int i=0; i<numbers.size(); i++){

            if(!saltarMaxValue[0] && numbers.get(i).equals(maxValue) ){
                saltarMaxValue[0] = true;
            }else{
                numbers.set(i,numbers.get(i) +1);
            }

        }

        numbers.stream().map( n ->{
            if(!saltarMaxValue[0] && n.equals(maxValue) ){
                saltarMaxValue[0] = true;
            }else{
                n++;
            }
            return null;
        }).collect(Collectors.toList());

        return numbers;
    }

}
