class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] arr = new int[128];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int curr = s.charAt(r);
            while (arr[curr] > 0) {
                arr[s.charAt(l)]--;
                l++;
            }
            arr[curr]++;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}