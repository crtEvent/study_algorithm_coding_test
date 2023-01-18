package leetcode.easy.p0001;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        int maxIndex = nums.length * nums.length;
        int row;
        int column;
        for(int i = 0; i < maxIndex; i++) {
            row = i / nums.length;
            column = i % nums.length;

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
