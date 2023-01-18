# 0083. Remove Duplicates from Sorted List
- <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/" target="_blank">0083. Remove Duplicates from Sorted List</a>
- 정렬된 List 에서 중복된 node 를 제거하라

## :x: 첫 번째 시도(Runtime Error)
### :arrow_right: 요약: Linked List 원리 활용 -> null이 입력 되었을때 처리 X

```java
public class Q3_Remove_Dup_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.val == tempNode.next.val) {
                tempNode.next = tempNode.next.next;
            }
            if (tempNode.next == null) {
                return head;
            }

            tempNode = tempNode.next;
        }

        return head;
    }
}
```
- intelliJ에선 잘 돌아가고 leetcode Test Case 에서도 통과 하였으나
- `while (tempNode.next != null)`에서 NullPointerException 발생

## :x: 두 번째 시도(Wrong Answer)
### :arrow_right: 요약: null이 입력 되었을때 처리 O -> 값이 3개 이상 중복일 때 처리 X

```java
public class Q3_Remove_Dup_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.val == tempNode.next.val) {
                tempNode.next = tempNode.next.next;
            }
            if (tempNode.next == null) {
                return head;
            }

            tempNode = tempNode.next;
        }

        return head;
    }
}
```
- 입력된 head 가 null일 경우를 처리함
- 입력된 Node 중에 중복된 값이 3개 이상일 경우 에러
```text
입력값: [1,1,1]
기대값: [1]
출력값: [1,1]
```


## :o: 세 번째 시도(Accepted, Runtime 1 ms, Memory 41.7 MB)
### :arrow_right: 요약: 값이 3개 이상 중복일 때 처리 O

```java
public class Q3_Remove_Dup_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.val == tempNode.next.val) {
                tempNode.next = tempNode.next.next;
                deleteDuplicates(head);
            }
            if (tempNode.next == null) {
                return head;
            }

            tempNode = tempNode.next;
        }

        return head;
    }
}
```
- 처음 중복된 값을 찾았을 때 중복값을 제거하고 다시 처음부터 중복값을 찾도록 재귀함수로 작동하도록 함
