import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem71A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++) {
            String w = reader.readLine();
            int len = w.length();

            if(len <= 10) {
                result.append(w);
            } else {
                result.append(w.charAt(0))
                      .append(len-2)
                      .append(w.charAt(len-1));
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
