package leetcode.easy.p0009;

import java.util.ArrayList;
import java.util.List;

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
