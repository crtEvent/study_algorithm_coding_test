package programmers.level1.p12930;

public class Solution01 {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        char[] cArr = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            if(index % 2 == 0) {
                cArr[i] = Character.toUpperCase(cArr[i]);
            } else {
                cArr[i] =  Character.toLowerCase(cArr[i]);
            }

            index++;

            if(cArr[i] == ' ') {
                index = 0;
            }
        }

        answer = String.valueOf(cArr);

        return answer;
    }

    public static void main(String[] args) {
        Solution01 s = new Solution01();

    }
}
