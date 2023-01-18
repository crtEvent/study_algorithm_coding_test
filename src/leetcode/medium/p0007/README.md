# 0007. Reverse Integer
- <a href="https://leetcode.com/problems/reverse-integer/" target="_blank">0007. Reverse Integer</a>
- 부호가 있는 32자릿수의 정수가 주어지면 숫자를 거꾸로 출력하기

## :x: 첫 번째 시도(Runtime Error, NumberFormatException)
### :arrow_right: 요약: StringBuilder 의 reverse 기능 사용 -> 반전된 숫자가 클 때 에러

```java
public class Q2_Reverse_Integer {

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder solutionSb = new StringBuilder();

        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            solutionSb.append('-');
        }

        return Integer.parseInt(solutionSb.append(sb.reverse()).toString());
    }
}
```
- StringBuilder 로 부호를 제거하고 reverse 한 다음 다시 부호를 붙여주는 방식
- 입력값이 1534236469 일때 이를 반전하면 9646324351 로 int 의 범위를 초과하여 에러

## :o: 두 번째 시도(Accepted, Runtime 2 ms, Memory 39.9 MB)
### :arrow_right: 요약: StringBuilder 의 reverse 기능 사용 + int 범위 설정 추가

```java
public class Q2_Reverse_Integer {

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder solutionSb = new StringBuilder();

        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            solutionSb.append('-');
        }

        try {
            return Integer.parseInt(solutionSb.append(sb.reverse()).toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
```
- 예외 처리하여 int 의 범위를 초과하였을 때 0을 반환


## 상위권 해답
<details>
<summary>Runtime 상위권 해답</summary>

### Runtime 1 ms
```java
class Solution {
    public int reverse(int x) {
        long rem=0;
        int digit;
        
        while(x!=0)
        {
            digit = x%10;
            rem = rem*10+digit;
            x = x/10;
        }
        
        if(rem>2147483647 || rem<-2147483648)
        return 0;
        
        return (int)rem;
    }
}
```
- 입력값을 10으로 나눈 나머지(1의 자리)를 구해 결과(rem)에 더해가는 방식
```text
x = 123 일때
1. 
    digit = x%10 = 123 % 10 =  3
    rem = rem*10+digit = 0 * 10 + 3 = 3
    x = x/10 = 123/10 = 12
2.
    digit = x%10 = 12 % 10 = 2
    rem = rem*10+digit = 3 * 10 + 2 = 32
    x= x/10 = 12/10 = 1
3.
    digit = x%10 =  1 % 10 = 1
    rem = rem*10+digit = 32 * 10 + 1 = 321
    x= x/10 = 1/10 = 0
4. x = 0 이므로 while 문 탈출
```

</details>

<details>
<summary>Memory 상위권 해답</summary>

### Memory 36.2 MB
```java
class Solution {
    public int rev(int n)
    {
        long r=0;
        int temp=n;
        int l=0;
        while(temp!=0)
        {
            l=l+1;
            temp=temp/10;
        }
        while(n!=0)
        {
            r=r+(long)(Math.pow(10,l-1))*(n%10);
            n=n/10;
            l=l-1;
            if(r>Integer.MAX_VALUE)
            return 0;
        }
        return (int)r;
    }
    
    public int reverse(int x) {
        if(x <= Integer.MIN_VALUE)
            return 0;
        else if(x>=0)
            return rev(x);
        else
            return (-1)*rev(-x);
        
    }
}
```

### Memory 36.6 MB
```java
class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while(x != 0) {
            int digit = x % 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return reversed;
    }
}
```

</details>