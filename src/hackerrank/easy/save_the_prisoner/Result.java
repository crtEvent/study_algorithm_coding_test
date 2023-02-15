package hackerrank.easy.save_the_prisoner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Result {

    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        int result = (m%n + s -1)%n;
        if (result == 0) {
            return n;
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(5%5);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);
                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

                System.out.println(result);
            } catch (IOException ex) {
            throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }

}
