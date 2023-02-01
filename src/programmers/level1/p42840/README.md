# 모의고사

## 계획 1
1. 수포자들의 정답 루틴을 이중 배열로 정의하기
2. 수포자 마다 루프를 돌면서 정답과 비교하기
3. 정답 수를 저장하기(정답 수 배열 만들기)
4. 정답을 많이 맞은 순서대로 `정답 수 배열`의 index를 result에 저장
5. `정답 수 배열`의 0번부터 시작하여 정렬이 따로 필요 없도록 하기? 이게 가능한가???
6. 정렬해서 반환한다

## :x: 첫 번째 시도
```java
// 기록하는거 까먹었다..
```
- 기억 나는 거는...
- `score[i] = score[i]++;` 이거 안돼서 `score[i] = score[i] + 1;`하니까 됨
- 문제 출력하는 부분을 잘못 이해해서 최고점이 1명 인데도 3명을 다 출력함

## :o: 두 번째 시도
```java
public class Q2 {
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
        Q2 q2 = new Q2();

        int[] answers;
        int[] answer;
        answers = new int[]{1, 2, 3, 4, 5};
        answer = q2.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();

        answers = new int[]{1, 3, 2, 4, 2};
        answer = q2.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();

        answers = new int[]{3, 3};
        answer = q2.solution(answers);
        Arrays.stream(answer).forEach(System.out::println);
        System.out.println();
    }
}
```
### 점수 계산 부분
```java
public class Q2 {
  public int[] solution(int[] answers) {
    int[] answer = {};

    int[][] answerRoutine = {
            {1, 2, 3, 4, 5}
            , {2, 1, 2, 3, 2, 4, 2, 5}
            , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    int[] score = new int[3];

    // 점수 계산
    for (int i = 0; i < answerRoutine.length; i++) {
      for (int j = 0; j < answers.length; j++) {
        if (answers[j] == answerRoutine[i][j % (answerRoutine[i].length)]) {
          score[i] += 1;
        }
      }
    }
    
    // ...생략
  }
}
```
- 정답지를 처음부터 끝까지 돌리면서 정답 루틴과 비교한다
- 정답 루틴을 반복하는 법 `answerRoutine[i][j % (answerRoutine[i].length)])`
    - `정답지의 index(j)` % `정답 루틴의 길이`
    - 정답 루틴이 5개 이면 `j % (answerRoutine[i].length)`는 0~4 까지만 반복된다
- 정답이 맞을 때마다 해당 수포자의 score에 +1 해준다

### 정렬 부분
```java
public class Q2 {
  public int[] solution(int[] answers) {
    int[] answer = {};
    
    // ...생략

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
}
```
1. 최대 점수가 몇 점인지 구한다
2. 최대 점수인 수포자가 몇 명인지 구한다
3. 최대 점수인 사람의 index를 answer에 저장한다

## 다른 사람이 짠 코드(프로그래머스에 좋아요 28개 받은 풀이)
```java
import java.util.*;

class Solution {
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
```
### 최고 점수 구하는 부분
```java
int[] hit = new int[3];
// ...생략
int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
```
- `int[] hit`가 각 수포자별 시험 점수