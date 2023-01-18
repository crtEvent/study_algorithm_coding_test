# 0009. Palindrome Number
- 입력된 정수가 palindrome(거꾸로 해도 똑같은 문자) 인지 검사하기
- 조건: String 으로 형변환 하지 않고 해결할 수 있는가?

## :x: 첫 번째 시도(Runtime Error, IndexOutOfBoundsException)
### :arrow_right: 요약: 입력된 정수가 0 일 때 처리 X

```java
class RunningTest {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> numbersByOneDigit = new ArrayList<>();
        while (x != 0) {
            numbersByOneDigit.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i <= numbersByOneDigit.size() / 2; i++) {
            if (numbersByOneDigit.get(i) != numbersByOneDigit.get(numbersByOneDigit.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
```
- 입력된 숫자를 ArrayList 에 한 자리수씩 넣는다
- ArrayList 의 처음과 끝 지점부터 중간 지점까지 차례로 비교한다
- 하나라도 일치하지 않으면 false 반환

## :o: 두 번째 시도(Accepted, Runtime 10 ms, Memory 41.8 MB)
### :arrow_right: 요약: 입력된 정수가 0 일 때 처리 O
```java
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        if(x == 0) {
            return true;
        }

        List<Integer> numbersByOneDigit = new ArrayList<>();
        while(x != 0) {
            numbersByOneDigit.add(x % 10);
            x /= 10;
        }

        for(int i = 0; i <= numbersByOneDigit.size() / 2; i++) {
            if(numbersByOneDigit.get(i) != numbersByOneDigit.get(numbersByOneDigit.size() - i - 1)) {
                return false;
            }
        }

        return true;

    }
}
```

## 상위권 정답
<details>
<summary>Runtime 상위권</summary>

### Runtime 9 ms
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        String str = Integer.toString(x);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }
}
```

### Runtime 8 ms
```java
class Solution {
    public boolean isPalindrome(int x) {
        if ((x < 0) || (x % 10 == 0 && x != 0)) {
            return false;
        } 
        int invertedNum = 0; 
        while (x > invertedNum) {
            invertedNum = invertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == invertedNum || x == invertedNum / 10; 
    }
}
```

### Runtime 7ms
```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
	        return false;
        }

        int y = x;
        int z = 0;
        while(y > 0){
            z = z * 10 + y % 10;
            y = y / 10;
        }	

        return x == z;
    }
}
```

</details>

<details>
<summary>Memory 상위권</summary>

## Memory 39.9 MB
```java
class Solution {
             public static boolean isPalindrome (int x ){

        if(x<0)
            return false ;
        
        // converting the int x to a String 
        String str = String.valueOf(x);

        // Pointers pointing to the beginning
        // and the end of the string
        int leftPointer = 0, rightPointer = str.length() - 1;

        // While there are characters to compare
        while (leftPointer < rightPointer) {

            // If there is a mismatch
            if (str.charAt(leftPointer) != str.charAt(rightPointer))
                return false;

            // Increment first pointer and
            // decrement the other
            leftPointer++;
            rightPointer--;
        }

        // Given string is a palindrome
        return true;
    }

}
```
</details>