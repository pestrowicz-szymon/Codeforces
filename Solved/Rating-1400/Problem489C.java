import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem489C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int m = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());

        if (s == 0) {
            if (m == 1) {
                System.out.println("0 0");
            } else {
                System.out.println("-1 -1");
            }
            return;
        }

        if (s > 9 * m) {
            System.out.println("-1 -1");
            return;
        }

        BigInteger largest = BigInteger.ZERO;
        BigInteger smallest = BigInteger.ZERO;

        int remainingS = s;
        int numLength = 0;
        while (remainingS > 0) {
            if (remainingS >= 9) {
                largest = largest.multiply(BigInteger.TEN).add(BigInteger.valueOf(9));
                remainingS -= 9;
            } else {
                largest = largest.multiply(BigInteger.TEN).add(BigInteger.valueOf(remainingS));
                remainingS = 0;
            }
            numLength++;
        }

        largest = largest.multiply(BigInteger.TEN.pow(m - numLength));

        if (largest.compareTo(BigInteger.TEN.pow(m).subtract(BigInteger.ONE)) > 0 || largest.compareTo(BigInteger.TEN.pow(m - 1)) < 0) {
            largest = BigInteger.valueOf(-1);
        }

        smallest = BigInteger.TEN.pow(m - 1);
        remainingS = s-1;
        int iterations = 0;
        while (remainingS > 0) {
            if (remainingS >= 9) {
                smallest = smallest.add(BigInteger.valueOf(9).multiply(BigInteger.TEN.pow(iterations)));
                remainingS -= 9;
            } else {
                smallest = smallest.add(BigInteger.valueOf(remainingS).multiply(BigInteger.TEN.pow(iterations)));
                remainingS = 0;
            }
            iterations++;
        }

        if (smallest.compareTo(BigInteger.TEN.pow(m).subtract(BigInteger.ONE)) > 0 || smallest.compareTo(BigInteger.TEN.pow(m - 1)) < 0) {
            smallest = BigInteger.valueOf(-1);
        }

        System.out.println(smallest + " " + largest);
    }
}