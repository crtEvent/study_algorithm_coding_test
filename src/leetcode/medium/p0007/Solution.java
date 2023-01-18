package leetcode.medium.p0007;

public class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder solutionSb = new StringBuilder();

        if(sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            solutionSb.append('-');
        }

        try {
            return Integer.parseInt(solutionSb.append(sb.reverse()).toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
