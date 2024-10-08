package templates;

import java.util.Arrays;

public class FenwickTreeDemo {

    public static class FenwickTree {
        int N;
        long[] BIT;

        FenwickTree(int n) {
            this.N = n + 1;
            BIT = new long[N];
            Arrays.fill(BIT, 0);
        }

        public void build(long[] a, int n) {
            for (int i = 0; i < n; i++) {
                update(i, a[i]);
            }
        }

        public long _getsum(int idx) {
            idx++;
            long sum = 0;
            while (idx > 0) {
                sum += BIT[idx];
                idx -= (-idx & idx);
            }
            return sum;
        }

        public long query(int l, int r) {
            return _getsum(r) - _getsum(l - 1);
        }

        public void update(int idx, long val) {
            idx++;
            while (idx < N) {
                BIT[idx] += val;
                idx += (-idx & idx);
            }
        }
    }

    // Fenwick tree applications

    public static int[] smallerRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int MAX = 10000;
        FenwickTree fw = new FenwickTree(2 * MAX);
        for (int i = n - 1; i >= 0; i--) {
            int key = nums[i] + MAX;
            int cnt = (int) fw.query(0, key - 1);
            ans[i] = cnt;
            fw.update(key, 1);
        }
        return ans;
    }

    public static int[] smallerLeft(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int MAX = 10000;
        FenwickTree fw = new FenwickTree(2 * MAX);
        for (int i = 0; i < n; i++) {
            int key = nums[i] + MAX;
            int cnt = (int) fw.query(0, key - 1);
            ans[i] = cnt;
            fw.update(key, 1);
        }
        return ans;
    }

    public static int[] largerRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int MAX = 10000;
        FenwickTree fw = new FenwickTree(2 * MAX);
        for (int i = n - 1; i >= 0; i--) {
            int key = nums[i] + MAX;
            int cnt = (int) fw.query(key + 1, 2 * MAX - 1);
            ans[i] = cnt;
            fw.update(key, 1);
        }
        return ans;
    }

    public static int[] largerLeft(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int MAX = 10000;
        FenwickTree fw = new FenwickTree(2 * MAX);
        for (int i = 0; i < n; i++) {
            int key = nums[i] + MAX;
            int cnt = (int) fw.query(key + 1, 2 * MAX - 1);
            ans[i] = cnt;
            fw.update(key, 1);
        }
        return ans;
    }
}
