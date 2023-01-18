package leetcode.medium.p0007;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test0007 {
    Solution s = new Solution();
    int input, result;

    @Test
    public void test_01() {
        input =123;
        result = s.reverse(input);
        System.out.println(result);

        Assertions.assertEquals(321, result);
    }

    @Test
    public void test_02() {
        input =-123;
        result = s.reverse(input);
        System.out.println(result);

        Assertions.assertEquals(-321, result);
    }

    @Test
    public void test_03() {
        input = 120;
        result = s.reverse(input);
        System.out.println(result);

        Assertions.assertEquals(21, result);
    }

    @Test
    public void test_04() {
        input = 1534236469;
        result = s.reverse(input);
        System.out.println(result);

        Assertions.assertEquals(0, result);
    }
}