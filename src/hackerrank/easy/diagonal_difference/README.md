# Diagonal Difference
[Diagonal Difference](https://www.hackerrank.com/challenges/diagonal-difference/problem)<br>

## 문제 요약
- n*n 2차원의 정가가 담긴  배열이 주어진다
- `왼쪽 위 -> 오른쪽 아래 대각선 정수들의 합`과 `오른쪽 위 -> 왼쪽 아래 대각선 정수들의 합`을 구한다
- 두 합의 차를 절대값으로 반환한다

## 규칙 찾기
```text
arr[x][y]

 
x (0,0) (0,1) (0,2) 
x (1,0) (1,1) (1,2)
x (2,0) (2,1) (2,2)
```
- 반복문 i -> 0 ~ 2(배열 size=3)
- `왼쪽 위 -> 오른쪽 아래 대각선 정수들의 합`
  - (0,0) -> (1,1) -> (2,2)
  - (i,i)
- `오른쪽 위 -> 왼쪽 아래 대각선 정수들의 합`
  - (0,2) -> (1,1) -> (2,0)
  - (i, y-i)

## 코드
```java
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int l2r = 0;
        int r2l = 0;
        int size = arr.size();

        for(int i = 0; i < size; i++) {
            l2r += arr.get(i).get(i);
            r2l += arr.get(i).get(size-i-1);
        }

        return Math.abs(l2r - r2l);
    }
```