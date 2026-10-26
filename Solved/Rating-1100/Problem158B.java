import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem158B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());

        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int[] arr = new int[4];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num-1]++;
        }
        
        int response = 0;

        response += arr[3]; // Groups of 4

        if(arr[2] >= arr[0]) {
            // TRÓJEK JEST WIĘCEJ LUB RÓWNO
            response += arr[2];
            arr[0] = 0;
        } else {
            // JEDYNEK JEST WIĘCEJ
            response += arr[2];
            arr[0] -= arr[2];
        }

        // W TYM MIEJSCU NIE MA ŻADNYCH 4 ANI 3
        response += arr[1] / 2; // Groups of 2
        arr[1] = arr[1] % 2;

        if(arr[1] == 0) {
            response += (arr[0]+3) / 4;
        } else {
            response += 1;
            arr[0] -= 2;
            if (arr[0] > 0) {
                response += (arr[0]+3) / 4;
            }
        }

        System.out.println(response);
    }
}