class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int curr = value(s.charAt(i));
            int next = (i < n - 1) ? value(s.charAt(i + 1)) : 0;
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        return result;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}