package templates;

public class TreeAncestor {
    int n;
    int[][] dp;

    public TreeAncestor(int n, int[] par) {
        this.n = n;
        int LOG = (int) log(n, 2) + 1;
        dp = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            dp[i][0] = par[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][j - 1] != -1)
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                else
                    dp[i][j] = -1;
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int ans = node;
        for (int i = 0; i < 32; i++) {
            if (((k >> i) & 1) > 0) {
                if (ans != -1)
                    ans = dp[ans][i];
            }
        }
        return ans;
    }

    public long log(long a, long b) {
        return (long) (Math.log(a) / Math.log(b));
    }
}