import java.util.*;

// Java template for leetcode problems
public class Solution {

    public static long[] fact;
    public static boolean[] isPrime;
    public static List<Long> listOfPrimes;
    public static long MOD = 1000000007, INF = Long.MAX_VALUE >> 1;
    public static int[] dir4V = { 1, 0, -1, 0 }, dir4H = { 0, 1, 0, -1 };
    public static int[] dir8V = { 1, 0, -1, 0, -1, 1, 1, -1 }, dir8H = { 0, 1, 0, -1, -1, 1, -1, 1 };
    /*-----------------------------------------------------------------------------------------------*/

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {

        return 0;
    }

    public static class Node {
        int u, v;
        long wt;

        Node(int u, int v) {
            this.u = u;
            this.v = v;
            this.wt = -INF;
        }

        Node(int u, int v, long wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return wt == -INF ? "[" + u + "-" + v + "] " : "[" + u + "-" + v + "," + wt + "] ";
        }
    }

    public static <T> List<List<T>> getAdjList(int n) {
        List<List<T>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());
        return adjList;
    }

    public static <T extends Comparable<T>> int compare(int i, int j, List<T> list) {
        return list.get(i).compareTo(list.get(j));
    }

    public static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int e : arr)
            list.add(e);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
    }

    public static void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long e : arr)
            list.add(e);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
    }

    public static void swap(int l, int r, int[] arr) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

    public static void swap(int l, int r, long[] arr) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

    public static <T> void swap(int l, int r, List<T> list) {
        T temp = list.get(l);
        list.set(l, list.get(r));
        list.set(r, temp);
    }

    public static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r)
            swap(l++, r--, arr);
    }

    public static void reverse(long[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r)
            swap(l++, r--, arr);
    }

    public static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    public static <T> void sort(T[] arr, Comparator<? super T> cmp) {
        List<T> list = new ArrayList<>();
        for (T e : arr)
            list.add(e);
        Collections.sort(list, cmp);
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
    }

    public static long add(long a, long b) {
        return (a + b) % MOD;
    }

    public static long sub(long a, long b) {
        if (a < b)
            return (MOD + a - b) % MOD;
        return (a - b) % MOD;
    }

    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static long div(long a, long b) {
        a = a % MOD;
        long inv_b = binExp(b, MOD - 2);
        return mul(a, inv_b);
    }

    public static long binExp(long a, long b) {
        long ans = 1;
        for (int i = 0; i < 62; i++) {
            long bit = (b >> i) & 1L;
            if (bit == 1L) {
                ans = mul(ans, a);
            }
            a = mul(a, a);
        }
        return ans;
    }

    public static void fillFact() {
        int LIMIT = 2000001;
        fact = new long[LIMIT];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < LIMIT; i++) {
            fact[i] = mul(fact[i - 1], i);
        }
    }

    public static long nCr(int n, int r) {
        return div(fact[n], mul(fact[n - r], fact[r]));
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (b < a)
            return gcd(a % b, b);
        return gcd(b % a, a);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long log(long a, long b) {
        return (long) (Math.log(a) / Math.log(b));
    }

    public static double log_precise(long a, long b) {
        return Math.log(a) / Math.log(b);
    }

    public static double log_precise(double a, double b) {
        return Math.log(a) / Math.log(b);
    }

    public static long ceil(long a, long b) {
        return a % b == 0 ? a / b : (1 + a / b);
    }

    public static void sieve(int size) {
        isPrime = new boolean[size + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= size; j += i) {
                isPrime[j] = false;
            }
        }
        listOfPrimes = new ArrayList<>();
        for (int i = 2; i <= size; i++) {
            if (isPrime[i])
                listOfPrimes.add((long) i);
        }
    }

    public static int popcount(long n) {
        int cnt = 0;
        while (n > 0) {
            n ^= (-n & n);
            cnt++;
        }
        return cnt;
    }

    public static long allXOR(long n) {
        if (n % 4 == 0)
            return n;
        else if (n % 4 == 1)
            return 1;
        else if (n % 4 == 2)
            return n + 1;
        return 0;
    }

    public static long[][] mulMatrix(long[][] a, long[][] b) {
        int n = a.length, m = a[0].length, h = b.length, w = b[0].length;
        if (m != h)
            return null;
        long[][] c = new long[n][w];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < m; k++) {
                    c[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }

}
