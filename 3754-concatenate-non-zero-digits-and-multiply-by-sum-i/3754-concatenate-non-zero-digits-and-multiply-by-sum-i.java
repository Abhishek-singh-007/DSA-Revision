class Solution {
    public long sumAndMultiply(int n) {

        long newNum = 0;
        long sum = 0;

        String s = String.valueOf(n);

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                newNum = newNum * 10 + digit;
                sum += digit;
            }
        }

        return newNum * sum;
    }
}