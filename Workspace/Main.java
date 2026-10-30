import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int m = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());

        int largest = 0;
        int smallest = 0;

        int remainingS = s;
        int numLength = 0;
        while (remainingS > 0) {
            if (remainingS >= 9) {
                largest = largest * 10 + 9;
                remainingS -= 9;
            } else {
                largest = largest * 10 + remainingS;
                remainingS = 0;
            }
            numLength++;
        }

        largest = largest * (int) Math.pow(10, m - numLength);

        if (largest > (int) Math.pow(10, m) - 1 || largest < (int) Math.pow(10, m - 1)) {
            largest = -1;
        }

        // ADD SMALLEST NUMBER CALCULATION


        System.out.println(smallest + " " + largest);
    }
}