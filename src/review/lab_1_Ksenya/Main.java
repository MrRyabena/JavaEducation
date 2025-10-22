import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var l = new int[17 - 2];
        for (int i = 0; i < l.length; i++) l[i] = i+3;

        var x = new double[15];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) x[i] = -9d + 17d * random.nextDouble();   // [-9.0 ; 8.0)
        

        double[][] s = new double[15][15];

        for (int i = 0; i < l.length; i++)
           for (int j = 0; j < x.length; j++) s[i][j] = calculate(l[i], x[j]);
                
        printOutput(s);       

    }

    private static double calculate(int li, double xj)
    {
        return switch (li) {
            case 7 -> Math.pow(Math.pow((0.5)/Math.asin(((xj - 0.5)/17)), Math.log(Math.abs(xj))), (0.5 + Math.sin(Math.pow(2*xj, xj)))/Math.pow((Math.PI*(3.0/4.0 + Math.pow((3.0/4.0)*xj,2))),2));
            case 4, 5, 6, 10, 12, 16, 17 -> Math.pow(4/(Math.asin(1/Math.pow(Math.E,Math.abs(xj)))-1),3);
            default -> (2/(2*3)) * (1-Math.pow((Math.PI)/(1-Math.pow((2*xj),3)),Math.tan(xj)));
        };
    }

    private static void printOutput(double[][] s)
    {
        for (var y : s) {
            for (var x : y) System.out.printf("%10.4f", x);
            System.out.println();
        }
    }
}
