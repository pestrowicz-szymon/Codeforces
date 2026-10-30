import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem455A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[100001];

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);

        int n = Integer.parseInt(tokenizer.nextToken());

        line = reader.readLine();
        tokenizer = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
           int number = Integer.parseInt(tokenizer.nextToken());
           arr[number] += number;
        }

        long[] maxSum = new long[100001];
        maxSum[1] = arr[1];

        for (int i = 2; i <= 100000; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + arr[i]);
        }

        System.out.println(maxSum[100000]);
    }
}