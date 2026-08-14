class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.get(c) > 2) {
                char left = s.charAt(i);
                count.put(left, count.get(left) - 1);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}