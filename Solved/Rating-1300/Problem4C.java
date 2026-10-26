import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Problem4C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        int n = Integer.parseInt(reader.readLine());

        HashMap<String, Integer> uniqueStrings = new HashMap<>();
        for(int i=0; i < n; i++) {
            String input = reader.readLine();
            if(uniqueStrings.containsKey(input)) {
                int count = uniqueStrings.get(input) + 1;
                uniqueStrings.put(input, count);
                result.append(input).append(count).append("\n");
            } else {
                result.append("OK\n");
                uniqueStrings.put(input, 0);
            }
        }
        System.out.print(result.toString());
    }
}