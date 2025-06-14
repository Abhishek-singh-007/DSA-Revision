class Solution {
    public int minMaxDifference(int num) {
        // This is the main function. It takes a number and finds the difference
        // between the largest and smallest numbers you can make by replacing digits.
        String s = String.valueOf(num); // Convert the number to a string so we can easily work with its digits
        return getMax(s) - getMin(s);   // Call helper functions to find max and min, then subtract
    }

    private int getMax(String s) {
        // This function finds the largest number you can make by replacing one digit with '9'.
        int n = s.length(); // Get the length of the string
        for (int i = 0; i < n; i++) {
            // Loop through each digit in the string
            char c = s.charAt(i); // Get the current digit
            if (c < '9') {
                // If the digit is less than '9', we can replace it to make a bigger number
                return Integer.parseInt(s.replace(c + "", "9")); // Replace all occurrences of the digit with '9' and return the new number
            }
        }
        return Integer.parseInt(s); // If all digits are '9', return the original number
    }

    private int getMin(String s) {
        // This function finds the smallest number you can make by replacing one digit with '0'.
        int n = s.length(); // Get the length of the string
        for (int i = 0; i < n; i++) {
            // Loop through each digit in the string
            char d = s.charAt(i); // Get the current digit
            if (d > '0') {
                // If the digit is greater than '0', we can replace it to make a smaller number
                return Integer.parseInt(s.replace(d + "", "0")); // Replace all occurrences of the digit with '0' and return the new number
            }
        }
        return Integer.parseInt(s); // If all digits are '0', return the original number
    }
}