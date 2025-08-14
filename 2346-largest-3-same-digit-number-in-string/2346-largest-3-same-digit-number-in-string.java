class Solution {
    public String largestGoodInteger(String num) {
        if (num.length() < 3) return "";

        char maxDigit = 0; 
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(i));
            }
        }

        if (maxDigit == 0) return "";
        return String.valueOf(maxDigit).repeat(3);
    }
}