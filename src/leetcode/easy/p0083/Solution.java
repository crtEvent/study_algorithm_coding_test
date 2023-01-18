package leetcode.easy.p0083;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode tempNode = head;
        while(tempNode.next != null) {
            if(tempNode.val == tempNode.next.val) {
                tempNode.next = tempNode.next.next;
                deleteDuplicates(head);
            }
            if(tempNode.next == null) {
                return head;
            }

            tempNode = tempNode.next;
        }

        return head;
    }
}
