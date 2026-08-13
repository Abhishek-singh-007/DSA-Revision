class Solution {
    static class Node {
        int len, pref, suff, best;
        char left, right;

        Node(int len, int pref, int suff, int best, char left, char right) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.left = left;
            this.right = right;
        }
    }

    Node[] tree;
    char[] s;

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node(
            a.len + b.len,
            a.pref,
            b.suff,
            Math.max(a.best, b.best),
            a.left,
            b.right
        );

        if (a.right == b.left) {
            res.best = Math.max(res.best, a.suff + b.pref);

            if (a.pref == a.len)
                res.pref = a.len + b.pref;

            if (b.suff == b.len)
                res.suff = b.len + a.suff;
        }

        return res;
    }

    void build(int u, int l, int r) {
        if (l == r) {
            tree[u] = new Node(1, 1, 1, 1, s[l], s[l]);
            return;
        }

        int mid = (l + r) >> 1;

        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);

        tree[u] = merge(tree[u << 1], tree[u << 1 | 1]);
    }

    void update(int u, int l, int r, int pos, char c) {
        if (l == r) {
            s[pos] = c;
            tree[u] = new Node(1, 1, 1, 1, c, c);
            return;
        }

        int mid = (l + r) >> 1;

        if (pos <= mid)
            update(u << 1, l, mid, pos, c);
        else
            update(u << 1 | 1, mid + 1, r, pos, c);

        tree[u] = merge(tree[u << 1], tree[u << 1 | 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters,
                                   int[] queryIndices) {
        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; ++i) {
            update(1, 0, n - 1,
                   queryIndices[i],
                   queryCharacters.charAt(i));

            ans[i] = tree[1].best;
        }

        return ans;
    }
}