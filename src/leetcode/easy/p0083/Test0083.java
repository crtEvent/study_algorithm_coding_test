package leetcode.easy.p0083;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test0083 {
    Solution s = new Solution();
    StringBuilder sb = new StringBuilder();
    ListNode head, sortedNode, tempNode;
    @Test
    public void test_01() {
        sb.setLength(0);

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        deleteDup();
        Assertions.assertEquals("1,2,", sb.toString());

    }

    @Test
    public void test_02() {
        sb.setLength(0);

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        deleteDup();
        Assertions.assertEquals("1,2,3,", sb.toString());

    }

    @Test
    public void test_03() {
        sb.setLength(0);

        head = new ListNode(1);
        head.next = new ListNode(1);

        deleteDup();
        Assertions.assertEquals("1,", sb.toString());

    }

    @Test
    public void test_04() {
        sb.setLength(0);

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        deleteDup();
        Assertions.assertEquals("1,", sb.toString());

    }

    @Test
    public void test_05() {
        sb.setLength(0);

        head = null;

        deleteDup();
        Assertions.assertEquals("", sb.toString());

    }

    private void deleteDup() {
        sortedNode = s.deleteDuplicates(head);
        tempNode = sortedNode;

        while(tempNode != null) {
            String printNode = tempNode.val + ",";
            sb.append(printNode);
            System.out.print(printNode);
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
