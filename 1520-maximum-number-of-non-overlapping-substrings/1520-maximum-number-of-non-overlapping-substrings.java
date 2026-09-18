class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == n) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Build all valid intervals
        for (int ch = 0; ch < 26; ch++) {
            if (last[ch] == -1) {
                continue;
            }

            int start = first[ch];
            int end = last[ch];

            boolean valid = true;

            for (int i = start; i <= end; i++) {
                int current = s.charAt(i) - 'a';

                // Character appeared before our starting point
                if (first[current] < start) {
                    valid = false;
                    break;
                }

                // Include all occurrences of this character
                end = Math.max(end, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[1] - a[0], b[1] - b[0]);
        });

        List<String> answer = new ArrayList<>();

        int previousEnd = -1;

        // Greedily select non-overlapping intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > previousEnd) {
                answer.add(s.substring(start, end + 1));
                previousEnd = end;
            }
        }

        return answer;
    }
}