public class SegmentTree {
    int[] seg;

    public SegmentTree(int size) {
        seg = new int[size + 1];
    }

    // T.C : O(N)
    public void build(int ind, int lo, int hi, int[] arr) {
        if (lo == hi) {
            seg[ind] = arr[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(2 * ind + 1, lo, mid, arr);
        build(2 * ind + 2, mid + 1, hi, arr);
        seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    // T.C : O(Log(N))
    // l, r for query
    public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
        // case 1: complete overlap
        if (lo >= l && hi <= r) {
            return seg[ind];
        }
        // case 3: no overlap
        else if (hi < l || lo > r) {
            return Integer.MIN_VALUE;
        }
        // partial overlap
        int mid = lo + (hi - lo) / 2;
        int left = query(2 * ind + 1, lo, mid, l, r, arr);
        int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
        return Math.max(left, right);
    }

    // T.C : O(Log(N))
    public void update(int ind, int lo, int hi, int i, int val, int[] arr) {
        if (lo == hi) {
            seg[ind] = arr[i] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (i <= mid) {
            update(2 * ind + 1, lo, mid, i, val, arr);
        } else {
            update(2 * ind + 2, mid + 1, hi, i, val, arr);
        }
        seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public static void main(String[] args) {
        // ----index: 0, 1, 2, 3, 4, 5, 6, 7, 8
        int[] arr = { 6, 2, 1, 4, 7, 3, 8, 9, 5 };
        int n = arr.length;
        SegmentTree st = new SegmentTree(4 * n);
        st.build(0, 0, n - 1, arr);
        int l = 0, r = 5;

        // Before update
        int ans = st.query(0, 0, n - 1, l, r, arr);
        System.out.println(ans);

        // After update
        st.update(0, 0, n - 1, 2, 16, arr);
        ans = st.query(0, 0, n - 1, l, r, arr);
        System.out.println(ans);
    }

}
