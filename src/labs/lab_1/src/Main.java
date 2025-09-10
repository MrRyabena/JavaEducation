import java.util.Random;

public class Main {

    public static void main(String[] args) {

        var w = new long[19 - 7 + 1];
        var x = new float[10];
        var w_1 = new float[7][10];
        var random = new Random();

        for (var i = 7; i <= 19; i++) w[i - 7] = i;
        for (var i = 0; i < 10; i++)  x[i] = 5f + 6f * random.nextFloat();
     
        for (var i = 0; i < 7; i++)
            for (var j = 0; j < 10; j++) {
                if (w[i] == 19) w_1[i][j] = (float) Math.pow(Math.pow(1 - Math.pow(x[j], 3), 3) + 0.5f, Math.cos(Math.cos(x[j])));
                else if (w[i] == 9 || w[i] == 11 || w[i] == 13) w_1[i][j] = (float) Math.pow(Math.E, Math.cbrt(x[j])) + 1; 
                else w_1[i][j] = (float) Math.log(Math.pow(Math.sin(Math.tan(Math.asin(3/4 * (x[j] - 3) / 16))), 2));
            }
    }
}
