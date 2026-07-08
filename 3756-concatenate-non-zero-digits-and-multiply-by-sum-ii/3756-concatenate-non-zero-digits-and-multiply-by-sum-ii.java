class Solution {
    static final int MOD = (int)1e9 + 7;

    int[] p, pre;
    int[][] st; // st[i] = {v, c}

    int[] merge(int[] a, int[] b) {
        return new int[]{(int)((1L * a[0] * p[b[1]] + b[0]) % MOD), a[1] + b[1]};
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        p = new int[n + 1]; pre = new int[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) p[i] = (int)(1L * p[i-1] * 10 % MOD);
        for (int i = 0; i < n; i++) pre[i+1] = pre[i] + s.charAt(i) - '0';

        st = new int[2 * n][2];
        for (int i = 0; i < n; i++)
            st[n + i] = s.charAt(i) == '0' ? new int[]{0, 0} : new int[]{s.charAt(i) - '0', 1};
        for (int i = n - 1; i > 0; i--)
            st[i] = merge(st[i << 1], st[i << 1 | 1]);

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0] + n, r = queries[qi][1] + n + 1;
            int[] L = {0, 0}, R = {0, 0};
            while (l < r) {
                if ((l & 1) == 1) L = merge(L, st[l++]);
                if ((r & 1) == 1) R = merge(st[--r], R);
                l >>= 1; r >>= 1;
            }
            int[] x = merge(L, R);
            ans[qi] = (int)(1L * x[0] * (pre[queries[qi][1] + 1] - pre[queries[qi][0]]) % MOD);
        }
        return ans;
    }
}