import java.util.Locale;
import java.util.Random;

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
            x[i] = m_map(random.nextFloat(), 0f, 1f, -11f, 5f); // random float in [-11;5)

        // Calculations
        for (var i = 0; i < 7; i++)
            for (var j = 0; j < 10; j++)
                w_1[i][j] = m_calculate(x[j], w[i]);
        
        // Output
        m_printArray(w_1);
    }

    /**
     * Maps a value from one range to another.
     *
     * @param value   the input value to be mapped.
     * @param fromMin the lower bound of the input range.
     * @param fromMax the upper bound of the input range.
     * @param toMin   the lower bound of the target range.
     * @param toMax   the upper bound of the target range.
     * @return the mapped value in the target range.
     */
    private static float m_map(float value, float fromMin, float fromMax, float toMin, float toMax) {
        return (value - fromMin) * (toMax - toMin) / (fromMax - fromMin) + toMin;
    }

    /**
     * @param x  = x[j] (the input value from array x).
     * @param wi = w[i] (the input value from array w).
     * @return The calculated result as a float.
     */
    private static float m_calculate(final float x, final long wi) {
        return switch ((int) wi) {
            case 19 -> (float) Math.pow(Math.pow(1 - Math.pow(x, 3), 3) + 0.5f, Math.cos(Math.cos(x)));
            case 9, 11, 13 -> (float) Math.pow(Math.E, Math.cbrt(x)) + 1;
            default -> (float) Math.log(Math.pow(Math.sin(Math.tan(Math.asin(3f / 4f * (x - 3) / 16))), 2));
        };
    }

    /**
     * Prints a two-dimensional float array to the console in a formatted table.
     *
     * @param arr the 2D float array to print.
     */
    private static void m_printArray(final float[][] arr) {
        for (var line : arr) {
            for (var value : line) {
                System.out.print(String.format(Locale.US, "%14.3f", value) + " ");
            }
            System.out.println();
        }
    }

}
