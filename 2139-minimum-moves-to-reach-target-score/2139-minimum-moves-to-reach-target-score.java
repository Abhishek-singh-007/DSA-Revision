class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while (target > 1) {
            // No doubles left
            if (maxDoubles == 0) {
                moves += target - 1;
                break;
            }
            // Even -> divide
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            }
            // Odd -> subtract 1
            else {
                target--;
            }
            moves++;
        }
        return moves;
    }
}