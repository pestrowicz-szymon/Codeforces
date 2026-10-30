import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem492B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        line = reader.readLine();
        st = new StringTokenizer(line);

        int[] lanternPositions = new int[n];
        for (int i = 0; i < n; i++) {
            lanternPositions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lanternPositions);
        
        double requiredLanternSize = (double) lanternPositions[0];

        for (int i = 1; i <= n - 1; i++) {
            double currentLanternSize = (double) (lanternPositions[i] - lanternPositions[i - 1]) / 2;
            if (currentLanternSize > requiredLanternSize) {
                requiredLanternSize = currentLanternSize;
            }
        }

        double currentLanternSize = (double) l - lanternPositions[n - 1];
        if (currentLanternSize > requiredLanternSize) {
            requiredLanternSize = currentLanternSize;
        }

        System.out.println(String.format(Locale.US, "%.10f", requiredLanternSize));
        // 0 X X 3 X 5 X 7 X 9 X X X X 14 15 X X
    }
}