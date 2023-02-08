package util;

import java.util.StringTokenizer;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class AverageCalculator {

    public void averageProgrammers(String testResult) {
        String[] tokens = Pattern.compile("([0-9.]*ms)|([0-9.]*MB)")
                .matcher(testResult)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        double ms = 0.0d;
        double mb = 0.0d;
        double minMs = Double.MAX_VALUE;
        double minMB = Double.MAX_VALUE;
        double maxMs = 0.0d;
        double maxMB = 0.0d;

        int index = 0;
        while(index < tokens.length) {
            double tempMs = Double.parseDouble(tokens[index].substring(0, tokens[index++].length() - 2));
            double tempMb = Double.parseDouble(tokens[index].substring(0, tokens[index++].length() - 2));

            minMs = Math.min(minMs, tempMs);
            maxMs = Math.max(maxMs, tempMs);
            ms += tempMs;

            minMB = Math.min(minMB, tempMb);
            maxMB = Math.max(maxMB, tempMb);
            mb += tempMb;
        }

        System.out.printf("Runtime: %.2fms", ms / (tokens.length / 2));
        System.out.printf(", Memory: %.2fMB", mb / (tokens.length / 2));
        System.out.println();

        System.out.printf("Runtime: Min(%.2fms), Max(%.2fms)%n",minMs, maxMs);
        System.out.printf("Memory : Min(%.2fMB), Max(%.2fMB)%n", minMB, maxMB);
    }

    public static void main(String[] args) {
        String s = "테스트 1 〉\t통과 (0.04ms, 69.5MB)\n" +
                "테스트 2 〉\t통과 (0.03ms, 78.8MB)\n" +
                "테스트 3 〉\t통과 (0.03ms, 70.5MB)\n" +
                "테스트 4 〉\t통과 (0.05ms, 74.4MB)\n" +
                "테스트 5 〉\t통과 (0.05ms, 73.1MB)\n" +
                "테스트 6 〉\t통과 (0.05ms, 72.2MB)\n" +
                "테스트 7 〉\t통과 (0.05ms, 75.8MB)\n" +
                "테스트 8 〉\t통과 (0.08ms, 74.2MB)\n" +
                "테스트 9 〉\t통과 (0.06ms, 76.7MB)\n" +
                "테스트 10 〉\t통과 (0.10ms, 72MB)\n" +
                "테스트 11 〉\t통과 (0.06ms, 77.7MB)\n" +
                "테스트 12 〉\t통과 (0.55ms, 64.9MB)\n" +
                "테스트 13 〉\t통과 (0.06ms, 77.3MB)\n" +
                "테스트 14 〉\t통과 (0.05ms, 75.5MB)\n" +
                "테스트 15 〉\t통과 (0.06ms, 78.1MB)\n" +
                "테스트 16 〉\t통과 (0.08ms, 76.3MB)";

        AverageCalculator ac = new AverageCalculator();
        ac.averageProgrammers(s);
    }
}
