package programmers.level1.p12930;

public class Solution02 {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        char[] cArr = s.toCharArray();

        for(int i = 0; i < cArr.length; i++) {
            cArr[i] = (index % 2 == 0)
                    ? Character.toUpperCase(cArr[i])
                    : Character.toLowerCase(cArr[i]);
            index = (cArr[i] ==' ')? 0 : index+1;
        }

        answer = String.valueOf(cArr);
        return answer;
    }

    public static void main(String[] args) {
        Solution02 s = new Solution02();
        s.solution("try hello world");
    }
}
