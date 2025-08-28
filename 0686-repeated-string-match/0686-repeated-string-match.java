class Solution {
    public int repeatedStringMatch(String a, String b) {
        int la = a.length(), lb = b.length();
        // build repeated string s: make it length >= lb, then add one more 'a' to cover overlap
        StringBuilder sb = new StringBuilder();
        while (sb.length() < lb) sb.append(a);
        sb.append(a); // one extra repeat to allow overlap
        String s = sb.toString();

        int pos = rabinKarp(s, b);
        if (pos == -1) return -1;

        // compute minimal repeats needed to cover (pos .. pos+lb-1)
        return (pos + lb + la - 1) / la;
    }

    // Rabin-Karp: return first index of pattern in text, or -1
    private int rabinKarp(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m > n) return -1;

        final long MOD = 1_000_000_007L;
        final long BASE = 256L;

        // highestPow = BASE^(m-1) % MOD
        long highestPow = 1;
        for (int i = 0; i < m - 1; i++) highestPow = (highestPow * BASE) % MOD;

        // initial hashes
        long pHash = 0, tHash = 0;
        for (int i = 0; i < m; i++) {
            pHash = (pHash * BASE + pattern.charAt(i)) % MOD;
            tHash = (tHash * BASE + text.charAt(i)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (pHash == tHash) {
                // verify to avoid false positive due to hash collision
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) return i;
            }
            // roll the hash: remove text[i], add text[i+m]
            if (i < n - m) {
                tHash = (tHash - (text.charAt(i) * highestPow) % MOD + MOD) % MOD; // remove leading
                tHash = (tHash * BASE + text.charAt(i + m)) % MOD; // add trailing
            }
        }
        return -1;
    }
}
