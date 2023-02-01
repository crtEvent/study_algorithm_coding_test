# 크레인 인형뽑기 게임
- 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하세요
- [크레인 인형뽑기 게임](https://school.programmers.co.kr/learn/courses/30/lessons/64061)

## :x: 첫 번째 시도(실패, 예상 결과: 4, 내 코드의 결과: 6)
### 계획
1. move[0] 과 board를 매칭 시킴
2. board의 인형을 바구니(stack)에 넣기, board의 인형 제거
3. 바구니에 넣을 때 바구니 맨 위의 인형과 비교하여 같으면 둘 다 제거
4. 반복

### 코드
```java
public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>((int) Math.pow(board.length, 2));

        for(int i = 0; i < moves.length; i++) {
            int pickUpPosition = (int) moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                int stuffedToy = board[j][pickUpPosition];
                board[j][pickUpPosition] = 0;
                if (stuffedToy == 0) {
                    continue;
                }
                if (!basket.isEmpty()) {
                    int peek = basket.get(basket.size() - 1);
                    if (peek == stuffedToy) {
                        basket.remove(basket.size()-1);
                        answer += 2;
                        continue;
                    }
                }
                basket.add(stuffedToy);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        
        int result = q1.solution(board, moves);
        System.out.println(result);
    }
}
```
### 문제점
- 크레인이 인형을 뽑을 때 for 문으로 해당 줄의 맨 위 부터 한칸씩 내려가면서 인형이 있는지 검증하고 있다
- 이 때 인형을 뽑았으면 다음 줄으로 이동해야 하지만 계속 같은 라인에서 인형을 뽑고 있음

## :o: 두 번째 시도(예상 결과: 4, 내 코드의 결과: 4, 정답입니다!)
### 코드
```java
public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>((int) Math.pow(board.length, 2));

        for(int i = 0; i < moves.length; i++) {
            int pickUpPosition = (int) moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                int stuffedToy = board[j][pickUpPosition];
                board[j][pickUpPosition] = 0;
                if (stuffedToy == 0) {
                    continue;
                }
                if (!basket.isEmpty()) {
                    int peek = basket.get(basket.size() - 1);
                    if (peek == stuffedToy) {
                        basket.remove(basket.size()-1);
                        answer += 2;
                        break;
                    }
                }
                basket.add(stuffedToy);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        
        int result = q1.solution(board, moves);
        System.out.println(result);
    }
}
```

### 변경 사항
- 인형을 뽑는 작업이 끝나면 `break;`로 2번째 for문을 끝내고 다음 줄로 이동하도록 변경.

## 기타
### java에서 Stack을 쓰지 않는 이유?
- Vector는 get()과 set()역할을 하는 모든 메서드에 synchronized 키워드가 붙어 있다.
- Vector의 모든 get() set() 등의 메서드에 synchronized가 붙어있는건 특정 상황에서 성능을 꽤 저하시킬 수 있다.
- 단순히 Vector에 Iterator를 붙여 순차적으로 item들을 탐색하기만 해도 원소탐색 시마다 get() 메서드의 실행을 위해 계속 lock을 걸고 닫으므로 Iterator연산과정 전체에 1번만 걸어주면 될 locking에 쓸데없는 오버헤드가 엄청나게 발생
- 멀티스레드 프로그래밍을 할 때에도 마찬가지
- ArrayList를 멀티쓰레드 환경에서 사용하려면? (thread-safe한 ArrayList)
    - `ArrayList<T> al = new ArrayList<>(Collections.synchronizedList());`
- Stack이 Vector를 상속받기 때문에 Stack도 마찬가지
- Vector를 상속 받고 있어서 get(), set(), remove()를 사용할 수 있다 -> 완전한 LIFO가 아니다
- Stack은 초기 용량 설정도 없다 -> 내부적으로 배열의 크기를 늘리는 작업이 추가로 필요함
- 일반적으로 Stack 대신 Deque, ArrayDeque를 사용함
  <br>
  [자바 컬렉션 프레임워크 Vector와 Stack은 왜 안쓰는가? by aahcbird](https://aahc.tistory.com/8)<br>
  [[Java] Stack 클래스는 무엇이고 문제점은 무엇일까?](https://devlog-wjdrbs96.tistory.com/244)<br>