package programmers.level1.p42840;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[][] answerRoutine = {
                {1, 2, 3, 4, 5}
                , {2, 1, 2, 3, 2, 4, 2, 5}
                , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] score = new int[3];

        // 점수 계산
        for(int i = 0; i < answerRoutine.length; i++){
            for(int j = 0; j < answers.length; j++) {
                if(answers[j] == answerRoutine[i][j % (answerRoutine[i].length)]) {
                    score[i] += 1;
                }
            }
        }

        // 등수 지정
        int maxScore = 0;
        for(int i = 0; i < score.length; i++) {
            if(score[i] > maxScore) {
                maxScore = score[i];
            }
        }

        int maxScoreNumber = 0;
        for(int i = 0; i < score.length; i++) {
            if(score[i] == maxScore) {
                maxScoreNumber++;
            }
        }

        answer = new int[maxScoreNumber];
        int maxScoreIndex = 0;
        for(int i = 0; i < score.length; i++) {
            if(score[i] == maxScore) {
                answer[maxScoreIndex++] = i + 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] answers;
        int[] answer;
        answers = new int[]{1, 2, 3, 4, 5};
        answer = solution.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();

        answers = new int[]{1, 3, 2, 4, 2};
        answer = solution.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();

        answers = new int[]{3, 3};
        answer = solution.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();
    }
}
