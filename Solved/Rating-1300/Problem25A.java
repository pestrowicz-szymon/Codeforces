import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem25A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int firstFoundEven = -1;
        int firstFoundOdd = -1;
        int foundEven = 0;
        int foundOdd = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                if (firstFoundEven == -1) {
                    firstFoundEven = i;
                }
                foundEven++;
            } else {
                if (firstFoundOdd == -1) {
                    firstFoundOdd = i;
                }
                foundOdd++;
            }

            if (foundEven != 0 && foundOdd != 0) {
                if(foundEven < foundOdd) {
                    System.out.println(firstFoundEven + 1);
                } else if (foundOdd < foundEven) {
                    System.out.println(firstFoundOdd + 1);
                } else {
                    continue;
                }
                return;
            }
        }
    }
}