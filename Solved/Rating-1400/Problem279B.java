import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem279B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int allTimes[] = new int[n];
        int currentStart = 0;
        int currentBookCounter = 0;
        int maxBookCounter = 0;

        line = reader.readLine();
        st = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            allTimes[i] = Integer.parseInt(st.nextToken());
            t -= allTimes[i];
            if (t >= 0) {
                currentBookCounter++;
                continue;
            } else {
                if (currentBookCounter > maxBookCounter) {
                    maxBookCounter = currentBookCounter;
                }
                t += allTimes[currentStart];
                currentStart++;
            }
        }
        if (currentBookCounter > maxBookCounter) {
            maxBookCounter = currentBookCounter;
        }
        System.out.println(maxBookCounter);
    }
}