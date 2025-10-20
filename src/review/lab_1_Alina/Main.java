import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // создаю одномерный массив типа int с числами от 5 до 17
        int[] n = new int[17 - 5];

        for (int i = 0; i < n.length; i++) n[i] = i + 5;
    
        //создаю одномерный массив типа double и заполняю рандомными числами
        Random rand = new Random();
        double[] x= new double[16];
        
        final double min = -6d;
        final double max = 15d;
        for (int i = 0; i < x.length; i++) {
            x[i] = map(rand.nextDouble(), min, max); // генерирую случайное число [0.0, 1.0), и привожу в [-6.0, 15.0)
        }

        // создаю двумерный массив
        double[][] n1 = new double[7][16];
        
        for (int i = 0; i < 7; i++) 
            for (int j = 0; j < 16; j++) 
                n1[i][j] = calculate(n[i], x[j]);
        
        // печатаю результат в виде таблицы
        printMatrix(n1);
    }

    
    /**
     * Maps a value from one range to another.
     *
     * @param value   the input value to be mapped.
     * @param toMin   the lower bound of the target range.
     * @param toMax   the upper bound of the target range.
     * @return the mapped value in the target range.
     */
    private static double map(double value, double toMin, double toMax) {
        return value * (toMax - toMin)  + toMin;
    }


    private static double calculate(int ni, double xi) {
        return switch (ni) {
                    case 9-> calc2(...);                    
                    case 7, 11, 17: yield Math.pow(Math.atan(Math.sin(xi)), 1.0 / 3.0);
                    default:     
                    {
                        double step = Math.pow(Math.pow((Math.pow(((xi-1)/xi),xi)), ((1.0/3.0)*Math.asin((xi+4.5)/21.0))),1.0/3.0);
                        yield Math.pow((3.0/4.0 + (Math.exp(Math.atan((xi+4.5) /21.0)-1.0)/2.0)/2.0), step);
                    }
                    };
                }
                

       
    //Отдельный статический метод для вывода матрицы
    private static void printMatrix(double[][] matrix) {
        for (double[] row: matrix) { // проходит по строкам
            for (double val: row) {//проходит по значениям
                System.out.printf("%-10.3f | ", val);
            }
            System.out.println();
        }
    }
}
    
