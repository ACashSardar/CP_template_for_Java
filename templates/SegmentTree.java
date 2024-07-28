package templates;

public class SegmentTree {

    static class SegTree {

        int[] seg;

        public SegTree(int size) {
            seg = new int[size + 1];
        }

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

        public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
            if (lo >= l && hi <= r) {
                return seg[ind];
            } else if (hi < l || lo > r) {
                return 0;
            }
            int mid = lo + (hi - lo) / 2;
            int left = query(2 * ind + 1, lo, mid, l, r, arr);
            int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
            return left + right;
        }

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
            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }
    }

    static class SegTreeMax {

        int[] seg;

        public SegTreeMax(int size) {
            seg = new int[size + 1];
        }

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

        public int query(int ind, int lo, int hi, int l, int r, int[] arr) {
            if (lo >= l && hi <= r) {
                return seg[ind];
            } else if (hi < l || lo > r) {
                return Integer.MIN_VALUE;
            }
            int mid = lo + (hi - lo) / 2;
            int left = query(2 * ind + 1, lo, mid, l, r, arr);
            int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
            return Math.max(left, right);
        }

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
    }

    /*** LAZY PROPAGATION (RANGE UPDATE) ***/

    static class SegTreeLazy {

        int[] seg;
        int[] lazy;

        public SegTreeLazy(int size) {
            seg = new int[size + 1];
            lazy = new int[size + 1];
        }

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

        public void update(int ind, int lo, int hi, int l, int r, int val, int[] arr) {
            if (lazy[ind] != 0) {
                seg[ind] += (hi - lo + 1) * lazy[ind];
                if (lo != hi) {
                    lazy[2 * ind + 1] += lazy[ind];
                    lazy[2 * ind + 2] += lazy[ind];
                }
                lazy[ind] = 0;
            }
            if (hi < l || lo > r) {
                return;
            }
            if (lo >= l && hi <= r) {
                seg[ind] += (hi - lo + 1) * val;
                if (lo != hi) {
                    lazy[2 * ind + 1] += val;
                    lazy[2 * ind + 2] += val;
                }
                return;
            }
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
            if (lo >= l && hi <= r) {
                return seg[ind];
            } else if (hi < l || lo > r) {
                return 0;
            }
            int mid = lo + (hi - lo) / 2;
            int left = query(2 * ind + 1, lo, mid, l, r, arr);
            int right = query(2 * ind + 2, mid + 1, hi, l, r, arr);
            return left + right;
        }
    }

    public static void main(String[] args) {
        // ----index: 0, 1, 2, 3, 4, 5, 6, 7, 8
        int[] arr = { 6, 2, 1, 4, 7, 3, 8, 9, 5 };
        int n = arr.length;
        SegTreeMax st = new SegTreeMax(4 * n);
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
