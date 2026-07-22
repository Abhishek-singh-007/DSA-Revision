class Solution {

    boolean isMatchUtil(String pattern, String text, int i, int j, Boolean[][] dp) {

        if (i < 0 && j < 0) return true;

        if (i < 0 && j >= 0) return false;

        if (j < 0 && i >= 0) return isAllStars(pattern, i);

        if (dp[i][j] != null) return dp[i][j];

        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return dp[i][j] = isMatchUtil(pattern, text, i - 1, j - 1, dp);
        }

        if (pattern.charAt(i) == '*') {
            return dp[i][j] =
                    isMatchUtil(pattern, text, i - 1, j, dp) ||
                    isMatchUtil(pattern, text, i, j - 1, dp);
        }

        return dp[i][j] = false;
    }

    boolean isAllStars(String pattern, int i) {
        for (int k = 0; k <= i; k++) {
            if (pattern.charAt(k) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[p.length()][s.length()];

        return isMatchUtil(p, s, p.length() - 1, s.length() - 1, dp);
    }
}