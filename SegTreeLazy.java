
// For range sum
public class SegTreeLazy {
    int[] seg;
    int[] lazy;

    public SegTreeLazy(int size) {
        seg = new int[size + 1];
        lazy = new int[size + 1];
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
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    // Range Update
    public void update(int ind, int lo, int hi, int l, int r, int val, int[] arr) {
        if (lazy[ind] != 0) {
            seg[ind] += (hi - lo + 1) * lazy[ind];
            if (lo != hi) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }
        // no overlap
        if (hi < l || lo > r) {
            return;
        }
        // complete overlap
        if (lo >= l && hi <= r) {
            seg[ind] += (hi - lo + 1) * val;
            if (lo != hi) {
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }
        // partial overlap
        int mid = lo + (hi - lo) / 2;
        update(2 * ind + 1, lo, mid, l, r, val, arr);
        update(2 * ind + 2, mid + 1, hi, l, r, val, arr);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
        if (lazy[ind] != 0) {
            seg[ind] += (hi - lo + 1) * lazy[ind];
            if (lo != hi) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }
        // complete overlap
        if (lo >= l && hi <= r) {
            return seg[ind];
        }
        // no overlap
        else if (hi < l || lo > r) {
            return 0;
        }
        // partial overlap
        int mid = lo + (hi - lo) / 2;
        int left = query(2 * ind + 1, lo, mid, l, r, arr);
        int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
        return left + right;
    }
}
