import java.util.Random;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // Initialization variables
        var w = new long[(19 - 7) / 2 + 1];
        var x = new float[10];
        var w_1 = new float[7][10];
        var random = new Random();

        // Fill arrays
        for (int n = 19, i = 0; n >= 7; n -= 2, i++)
            w[i] = n;
        for (var i = 0; i < 10; i++)
            x[i] = -11f + (5f + 11f) * random.nextFloat(); // random float in [-11;5]

        // Calculations and output
        for (var i = 0; i < 7; i++) {
            for (var j = 0; j < 10; j++) {
                if (w[i] == 19)
                    w_1[i][j] = (float) Math.pow(Math.pow(1 - Math.pow(x[j], 3), 3) + 0.5f, Math.cos(Math.cos(x[j])));
                else if (w[i] == 9 || w[i] == 11 || w[i] == 13)
                    w_1[i][j] = (float) Math.pow(Math.E, Math.cbrt(x[j])) + 1;
                else
                    w_1[i][j] = (float) Math.log(Math.pow(Math.sin(Math.tan(Math.asin(3f / 4f * (x[j] - 3) / 16))), 2));

                System.out.print(String.format(Locale.US, "%14.3f", w_1[i][j]) + " ");
            }
            System.out.println();
        }
    }

}
