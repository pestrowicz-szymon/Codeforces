import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem231A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int counter = 0;

        String str = "";

        for (int i=0; i<n; i++) {
            str = reader.readLine();
            if (str.equals("1 1 1") || str.equals("1 1 0") || str.equals("1 0 1") || str.equals("0 1 1")) {
                counter++;
            }       
        }

        System.out.println(counter);
    }
}