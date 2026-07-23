class Solution {
    private Map<String, Boolean> dp;
    public boolean solve(String s, Set<String> m) {
        if (s.length() == 0) {
            return true;
        }
        if (dp.containsKey(s))
            return dp.get(s);
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(0, i + 1);
            if (m.contains(r)) {
                if (solve(s.substring(i + 1), m)){
                    dp.put(s,true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return solve(s, m);
    }
}