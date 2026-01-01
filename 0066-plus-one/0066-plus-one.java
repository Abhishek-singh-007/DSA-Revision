class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and go backwards
        for (int i = n - 1; i >= 0; i--) {
            // Add 1 to the current digit
            digits[i]++;

            // If the digit becomes 10, set it to 0
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // We added 1 successfully, no carry-over, so return the array
                return digits;
            }
        }

        // If we reach here, it means all digits were 9
        // Create a new array with one extra digit
        int[] newDigits = new int[n + 1];

        // Set the first digit to 1 (the carry-over)
        newDigits[0] = 1;

        // The rest of the digits are already 0 by default, so return the new array
        return newDigits;
    }
}