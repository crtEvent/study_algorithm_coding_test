package programmers.level1.p12930;

public class Solution {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < s.length(); i++) {
            String slice = s.substring(i, i+1);

            if(index % 2 == 0) {
                sb.append(slice.toUpperCase());
            } else {
                sb.append(slice.toLowerCase());
            }

            index++;

            if(slice.equals(" ")) {
                index = 0;
            }
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("try hello world");
        s.solution("hello try hello world");
        s.solution("abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz");
        s.solution("h h h h h");
        s.solution("hp hp hp hp hp");
        s.solution("pumped pumped pumped pumped");
        s.solution("i my me mine");
        s.solution(" i  my   me    mine     ");
        s.solution("       moo       moo  ");
    }
}
