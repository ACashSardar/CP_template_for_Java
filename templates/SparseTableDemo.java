package templates;

public class SparseTableDemo {

    static class SparseTable {

        public int[][] tab;

        SparseTable(int arr[], int n) {
            int LOG = log(n, 2);
            tab = new int[n][LOG + 1];
            for (int i = 0; i < n; i++)
                tab[i][0] = arr[i];
            for (int pow = 1; pow <= LOG; pow++) {
                for (int i = 0; i + (1 << pow) - 1 < n; i++) {
                    int minL = tab[i][pow - 1];
                    int minR = tab[i + (1 << (pow - 1))][pow - 1];
                    tab[i][pow] = Math.min(minL, minR);
                }
            }
        }

        public int query(int l, int r) {
            int LOG = log(r - l + 1, 2);
            int l2 = r - (1 << LOG) + 1;
            return Math.min(tab[l][LOG], tab[l2][LOG]);
        }

        public static int log(long a, long b) {
            return (int) (Math.log(a) / Math.log(b));
        }
    }
}
