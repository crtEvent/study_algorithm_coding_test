# 이상한 문자 만들기
[링크](https://school.programmers.co.kr/learn/courses/30/lessons/12930)

## ❌ 첫 번째 시도(실패)
### 계획
1. 문자열을 첫 번째 문자부터 끝까지 for문으로 돌림
2. index를 따로 두어 for문이 돌아갈 때마다 같이 1씩 증가
3. index가 짝수이면 때어낸 문자를 대문자로 변경
4. index는 공백을 만날 때 마다 0으로 초기화

### 코드
```java
public class Solution {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            String slice = s.substring(i, i + 1);

            if (index % 2 == 0) {
                sb.append(slice.toUpperCase());
            } else {
                sb.append(slice);
            }

            index++;

            if (slice.equals(" ")) {
                index = 0;
            }
        }

        answer = sb.toString();

        return answer;
    }
}
```

### 문제점
- 입력값으로 대문자가 들어올 수 있음
- 단어의 홀수번째 문자를 소문자로 바꿔야 함

## ⭕️ 두 번째 시도(통과, Runtime: 0.12ms, Memory: 75.70MB)
### 코드
```java
public class Solution {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            String slice = s.substring(i, i + 1);

            if (index % 2 == 0) {
                sb.append(slice.toUpperCase());
            } else {
                sb.append(slice.toLowerCase());
            }

            index++;

            if (slice.equals(" ")) {
                index = 0;
            }
        }

        answer = sb.toString();

        return answer;
    }
}
```

### 변경 사항
- index가 홀수일 경우 해당 문자를 소문자로 변경해 주도록 함

---
## 다른 사람의 답안 참고
### toCharArray
- `toCharArray()` 쓰면 성능이 더 좋아 지는지?
```java
public class Solution01 {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        char[] cArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (index % 2 == 0) {
                cArr[i] = Character.toUpperCase(cArr[i]);
            } else {
                cArr[i] = Character.toLowerCase(cArr[i]);
            }

            index++;

            if (cArr[i] == ' ') {
                index = 0;
            }
        }

        answer = String.valueOf(cArr);

        return answer;
    }
}
```
- `StringBuilder` 방식: Runtime: 0.12ms, Memory: 75.70MB
  - Runtime: Min(0.04ms), Max(0.30ms)
  - Memory : Min(65.90MB), Max(82.30MB)
- `toCharArray()` 방식: Runtime: 0.06ms, Memory: 75.12MB
  - Runtime: Min(0.03ms), Max(0.08ms)
  - Memory : Min(64.80MB), Max(83.00MB)
- ∴ char 배열로 하는것이 실행 속도가 더 빠르다

### 코드 수 줄이기
```java
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
}
```
- Runtime: 0.09ms, Memory: 74.19MB
  - Runtime: Min(0.03ms), Max(0.55ms)
  - Memory : Min(64.90MB), Max(78.80MB)
- 메모리 작아짐