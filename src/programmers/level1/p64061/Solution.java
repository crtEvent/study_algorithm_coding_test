package programmers.level1.p64061;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>((int) Math.pow(board.length, 2));

        for(int i = 0; i < moves.length; i++) {
            int pickUpPosition = (int) moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                int stuffedToy = board[j][pickUpPosition];
                board[j][pickUpPosition] = 0;
                if (stuffedToy == 0) {
                    continue;
                }
                if (!basket.isEmpty()) {
                    int peek = basket.get(basket.size() - 1);
                    if (peek == stuffedToy) {
                        basket.remove(basket.size()-1);
                        answer += 2;
                        break;
                    }
                }
                basket.add(stuffedToy);
                break;
            }
        }

        return answer;
    }
}
