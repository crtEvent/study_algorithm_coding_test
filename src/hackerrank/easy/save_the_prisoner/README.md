# Save the Prisoner!
[Save the Prisoner!](https://www.hackerrank.com/challenges/save-the-prisoner/problem)<br>

## 문제 요약
- 죄수의 숫자(n), 사탕의 수(m), 처음 사탕을 받을 의자(죄수) 번호(s)
- 시작할 의자 번호(s)부터 죄수들에게 사탕을 하나씩 나눠준다
- 마지막 사탕은 쓰레기 이다. 마지막 사탕을 받을 죄수의 의자 번호를 반환하라

---
# 풀이 1 (실패)

## 계획
- 사탕의 수 만큼 반복문돌림
- 의자 번호부터 +1씩 해준다
- 의자 번호가 n이 되면 다시 1로 리셋
- 반복문이 끝났을 때 의자 번호를 반환
  - 반복문이 끝났을 때 다시 1로 리셋되지 않도록 주의하기

## 코드(실패)
```java
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        for(int i = 0; i < m; i++) {
            m++;
            if(m > n) {
                m = 1;
            }
        }
        
        return m;
    }
```
### 문제점
- 반복문이 끝났을 때 마지막 사탕을 받은사람의 다음사람이 출력됨
  - m++ 때문에 반복문이 끝났을 때 한번터 count 됨
- 의자의 시작 번호도 고려하지 않음

# 풀이 2 (실패, Terminated due to timeout)

## 코드(실패)
```java
    public static int saveThePrisoner(int n, int m, int s) {
    // Write your code here
        int result = s;
        for(int i = 0; i < m-1; i++) {
            result++;
            if(result > n) {
                result = 1;
            }
        }
        
        return result;
    }
```
### 변경 사항
- 의자의 시작 번호부터 count `int result = s`
- 반복문은 0 ~ m-1 까지로 마지막에 사탕을 받은사람을 반환하도록 변경

### 문제점
- Terminated due to timeout
- 샘플 테스트 케이스는 통과하였으나 시간 초과로 실패함

# 풀이 3 (실패, test cases failed)

## 코드
```java
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        m = (m > n)? m%n : m;
        int result = s + m -1;
        
        return (result <= n)? result : 1;
    }
```
### 변경 사항
- 반복문을 사용하지 않도록 변경
- m이 n의 배수이면 결과가 같은 것을 확인
  - m을 n으로 나눈 나머지를 n으로 설정하여 계산하기

### 문제점
- 샘플 테스트 케이스는 통과, 실제 테스트 케이스는 실패
- 모르겠다...

# 풀이 4(실패, test cases failed, Time limit exceeded)
```java
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        m = (m > n)? m%n : m;
        int result = s;
        for(int i = 0; i < m-1; i++) {
            result++;
            if(result > n) {
                result = 1;
            }
        }

        return result;
    }
```
### 변경사항
- 풀이 3과 풀이 2를 조합하여 m을 줄인 상태로 반복문 돌림

### 문제점
- test cases failed, Time limit exceeded
- 답이 틀린 것도 있고, 여전히 시간 초과
- 모르겠다...

# 그냥 답 봄
```java
    public static int saveThePrisoner(int n, int m, int s) {
        if ((m%n + s -1)%n == 0) {
            return n;
        } else {
            return (m%n + s -1)%n;
        }
    }
```
```java
    public static int saveThePrisoner(int n, int m, int s){
        int t=(m-1)%n+s;

        return t>n?t-n:t;
    }
```
## 풀이
- 1번째 의자부터 시작할 때 마지막 사탕을 받을 죄수는 `m%n`
- s번째 릐자부터 시작할 때 마시막 사탕을 받을 죄수는 `m%n + s - 1`
- 만약 `m%n + s - 1`가 죄수의 수(n)보다 크다면?
  - `m%n + s - 1`을 죄수의 수(n)로 나눈 나머지를 구한다 `(m%n + s - 1)%n`
  - `m%n + s - 1`가 죄수의 수(n)보다 작거나 같으면 결과는 그대로 `m%n + s - 1`이 나온다
- `(m%n + s - 1)%n`은 항상 0 ~ n-1의 값이 나오게 된다(%n 이니까)
- 만약 `(m%n + s - 1)%n`이 0이라면?
  - `(m%n + s - 1)`가 n의 배수인 경우(5%5 = 0, 10%5 = 0)
  - 사탕의 수(m)과 죄수의 수(n)이 같고 s=1인 경우(`(0+1-1)%n`)
  - 이 경우 마지막 사탕은 항상 마지막 죄수가 밭게 된다 => `n`

[Save the Prisoner HackerRank solution by JAVAAID](https://www.youtube.com/watch?v=LeNU3WjrV_w)<br>