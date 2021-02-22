public class main {

    public static void main(String[] args){
        int steps = 8;
        String path = "UDDDUDUU";
        System.out.println(countingValleys(steps,path));
    }

    static int countingValleys(int steps, String path) {
        int totalValleys = 0;
        int nivelDelMar = 0;

        boolean isAValley = false;

        if(validateSteps(steps) && validatePath(path)){
            for(int i=0; i< path.length(); i++){

                nivelDelMar += esUpHillODownHill(path.charAt(i));

                if(nivelDelMar < 0 && !isAValley){
                    totalValleys++;
                    isAValley = true;
                }
                if(nivelDelMar == 0 && isAValley){
                    isAValley = false;
                }
            }
        }
        return totalValleys;
    }

    public static boolean validateSteps(int steps){
        return steps >= 2 && steps <= Math.pow(10,6);
    }

    public static boolean validatePath(String path){

        for(int i=0; i< path.length(); i++){
            if(charNoEsUoD(path.charAt(i))){
                return false;
            }
        }

        return true;
    }

    static boolean charNoEsUoD(char caracterAComparar){
        char u = 'U';
        char d = 'D';

        return Character.compare(caracterAComparar,u) != 0 && Character.compare(caracterAComparar,d) != 0;
    }

    static int esUpHillODownHill(char caracter){
        return (Character.compare(caracter,'U')==0)?1:-1;
    }

}
