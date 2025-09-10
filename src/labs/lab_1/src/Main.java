import java.util.Random;

public class Main {

    public static void main(String[] args) {

        var w = new long[19 - 7 + 1];
        var x = new float[10];
        var result = new float[7][10];
        var random = new Random();

        for (var i = 7; i <= 19; i++) w[i - 7] = i;
        for (var i = 0; i < 10; i++)  x[i] = 5f + 6f * random.nextFloat();
     
        for (var i = 0; i < 7; i++)
            for (var j = 0; j < 10; j++) { // TODO

                // if (w[i] == 19)
                // else if
            }
    }

}
