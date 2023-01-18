package leetcode.easy.p0009;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test0009 {
    Solution s= new Solution();
    int x;
    boolean result;

    @Test
    public void test_01() {
        x = 121;
        result = s.isPalindrome(x);
        System.out.println(result);

        Assertions.assertEquals(true, result);
    }

    @Test
    public void test_02() {
        x = 1221;
        result = s.isPalindrome(x);
        System.out.println(result);

        Assertions.assertEquals(true, result);
    }

    @Test
    public void test_03() {
        x = 1231;
        result = s.isPalindrome(x);
        System.out.println(result);

        Assertions.assertEquals(false, result);
    }

    @Test
    public void test_04() {
        x = 1;
        result = s.isPalindrome(x);
        System.out.println(result);

        Assertions.assertEquals(true, result);
    }

    @Test
    public void test_05() {
        x = 0;
        result = s.isPalindrome(x);
        System.out.println(result);

        Assertions.assertEquals(true, result);
    }

}
