import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem466A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int totalCostOnlySpecialTickets = ((n + m - 1) / m) * b;
        int totalCostOnlySingleTickets = n * a;

        int totalCostMixedTickets = 0;

        totalCostMixedTickets += (n / m) * b;
        n %= m;
        totalCostMixedTickets += n * a;

        System.out.println(Math.min(totalCostOnlySpecialTickets, Math.min(totalCostOnlySingleTickets, totalCostMixedTickets)));
    }
}