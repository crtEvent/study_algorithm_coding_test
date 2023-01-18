package leetcode.easy.p0001;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test0001 {
    Solution s = new Solution();
    int[] nums, result, expected;
    int target;

    @Test
    public void test_01() {
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        expected = new int[]{0,1};
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void test_02() {
        nums = new int[]{3,2,4};
        target = 6;
        result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        expected = new int[]{1,2};
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void test_03() {
        nums = new int[]{3,3};
        target = 6;
        result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        expected = new int[]{0,1};
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void test_04() {
        nums = new int[]{-1,-2,-3,-4,-5};
        target = -8;
        result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        expected = new int[]{2,4};
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
