# 0001. Two Sum
- [0001. Two Sum](https://leetcode.com/problems/two-sum/)
- 정수 배열과 target 이 주어졌을 때, 배열에서 두 숫자의 합이 target 이 되는 경우를 찾아라
- 두 수의 index 를 출력하라

## :o: 첫 번째 시도(Accepted, Runtime 262 ms, Memory 42.8 MB)
### :arrow_right: 요약: 이중 for 문 사용, O(n^2)

```java
public class Q1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        loopOut:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    break loopOut;
                }
            }
        }

        return solution;
    }
}
```
- 문제를 보자마자 바로 생각난 로직은 이중 for 문을 사용하여 배열의 값을 순서대로 비교하는 방식
- Big-O가 O(n^2)이므로 개선 필요함

## :x: 두 번째 시도(Wrong Answer)
### :arrow_right: 요약: 이중 for 문을 하나의 for 문으로 변경하기 -> maxIndex 잘못 설정함

```java
public class Q1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        int maxIndex = nums.length * 2; // 문제 부분
        for(int i = 0; i < maxIndex; i++) {
            int row = i / nums.length;
            int column = i % nums.length;
            if(row == column) {
                continue;
            }
            if(nums[row] + nums[column] == target) {
                solution[0] = row;
                solution[1] = column;
                break;
            }
        }

        return solution;
    }
}
```
### Wrong Case
```text
nums: [-1,-2,-3,-4,-5]
target: -8
Expected: [2,4]
Output: [0,0]
```
- 원래 이중 for 문이 돌아가는 횟수가 nums.length * nums.length 이므로 maxIndex = nums.length * nums.length 이어야 한다

## :o: 세 번째 시도(Accepted, Runtime 563 ms, Memory 42.3 MB)
### :arrow_right: 요약: for 문 하나만 사용, O(n)

```java
public class Q1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        int maxIndex = nums.length * nums.length;
        for (int i = 0; i < maxIndex; i++) {
            int row = i / nums.length;
            int column = i % nums.length;

            if (row == column) {
                continue;
            }
            if (nums[row] + nums[column] == target) {
                solution[0] = row;
                solution[1] = column;
                break;
            }
        }

        return solution;
    }
}
```
- 1차: Accepted, Runtime 262 ms, Memory 42.8 MB
- 3차: Accepted, Runtime 563 ms, Memory 42.3 MB
- Big-O는 O(n^2)에서 O(n)으로 줄어들었지만 더 느려졌다...
    - why?
    - :question: 입력값 개수가 적어서? -> Wrong Case 에서 둘 다 14번 째에서 결과 도출
        - Big-O 성능 비교 그래프를 보면 데이터가 작을 때는 O(n)가 더 느리게 나오긴 하는데 이유가 뭔지???
    - :question: row, column 연산 때문에?
    - :x: 만약 row, column 변수를 for 문 안에서 밖으로 때면 성능이 더 좋아질까? -> 테스트 해보니 똑같음

## 상위권 해답
<details>
<summary>Runtime 상위권 해답</summary>

### Runtime 0 ms
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]+nums[j-i]==target)
                    return new int[]{j-i,j};
            }
        }
        return new int[2];
        
    }
}
```

### Runtime 2 ms
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hMap.containsKey(diff) && hMap.get(diff) != i) {
                res[0] = i;
                res[1] = hMap.get(diff);
                break;
            }
        }

        return res;
    }
}
```

### Runtime 4 ms
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        // List<Integer> result = new ArrayList<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) { // i = 0;            i = 1;
            int remaining = target - nums[i]; // remaining = 7 ;     remaining = 2;
            if (record.keySet().contains(remaining)) { // false      true  
                // result.add(record.get(nums[i]));
                // result.add(i);
                result[0] = record.get(remaining);                  // 0
                result[1] = i;                                      // 1 
            } else {
                record.putIfAbsent(nums[i], i); // [2, 0]
            }
            
        }
        // int[] resultArray = result.stream().mapToInt(v -> v).toArray();
        return result;
    }
}

```
</details>
<details>

<summary>Memory 상위권 해답</summary>

### Memory 37.8 MB
```java
class Solution {

	public static int[] twoSum(int[] nums, int target) {
  		Map<Integer, Integer> hashmap = new HashMap<>();

      	for (int i = 0; i < nums.length; i++)
            hashmap.put(nums[i], i);

        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            twoSum[0] = i;
            int find = target - nums[i];
            int temp = hashmap.containsKey(find) ? hashmap.get(find) : -1;
            if (temp != -1 && temp != i) {
                twoSum[1] = temp;
                break;
            }
        }
        return twoSum;
    }
  
}
```

### Memory 40.6 MB
```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
```

### Memory 41 MB
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int x = 0; x < nums.length; x++){
            for(int y = x+1; y < nums.length; y++){
                if(nums[x]+nums[y] == target){
                    System.gc();
                    return new int[] {x, y};
                }
            }
        }
        return null;
    }
}
```

### Memory 41.1 MB
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0 ; i<nums.length ; i++){
            int needtofind = target - nums[i];
            for(int j=i+1; j<nums.length; j++){
                    if(nums[j] == needtofind){
                    int[] arr= new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    System.gc();
                    return arr;
                }

            }
        }
        return null;
    }
}
```
</details>