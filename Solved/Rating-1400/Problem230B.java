import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem230B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        line = reader.readLine();
        st = new StringTokenizer(line);

        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());

            int sqrtX = (int) Math.sqrt(x);

            if (Math.pow(sqrtX, 2) != x) {
                result.append("NO\n");
                continue;
            }

            if (isPrime[sqrtX]) {
                result.append("YES\n");
            } else {
                result.append("NO\n");
            }

            
        }
        System.out.print(result);
    }
}