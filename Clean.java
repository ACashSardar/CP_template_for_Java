/*------------Coder: AKASH SARDAR, Language: JAVA-21,64-BIT-----------*/

import java.io.*;
import java.util.*;

public class Clean implements Runnable {

    public static boolean MULTIPLE_TEST_CASES = true;
    public static boolean DISPLAY_EXECUTION_TIME = false;
    public static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    public static long[] fact;
    public static boolean[] isPrime;
    public static List<Long> listOfPrimes;
    public static long MOD = 1000000007, INF = Long.MAX_VALUE >> 1;
    public static int[] dir4V = { 1, 0, -1, 0 }, dir4H = { 0, 1, 0, -1 };
    public static int[] dir8V = { 1, 0, -1, 0, -1, 1, 1, -1 }, dir8H = { 0, 1, 0, -1, -1, 1, -1, 1 };
    /*
     * ----------------------------------MAP shortcuts------------------------------
     * One method to rule them all-> map.merge(key, val, (old, new)->old + new);
     * Calc Freq: map.merge(e, 1, (u, v) -> u + v);
     * map.getOrDefault(Key, 500) -> If Key isn't present default Value is returned.
     * map.putIfAbsent(Key, 200) -> Does not update Value if Key is already present.
     * for (var itr : map.entrySet()) { long K = itr.getKey(), V = itr.getValue(); }
     */

    public static void FastJavaCode() throws IOException {

    }

    /*** ---------------PRECOMPUTE INSIDE RUN METHOD--------------- ***/
    @Override
    public void run() {
        // Run Sieve(), FillFact() etc.

        try {
            int Coffee = MULTIPLE_TEST_CASES ? readInteger() : 1, Tea = 0;
            while (Coffee-- > 0 && Tea < INF) {
                long start = System.currentTimeMillis();
                FastJavaCode();
                long end = System.currentTimeMillis();
                long diff = end - start;
                if (!ONLINE_JUDGE && DISPLAY_EXECUTION_TIME && diff >= 0) {
                    print("Time taken: " + (diff) + " ms.\n");
                }
                flush();
                Tea++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*** ------------------DON'T CHANGE ANYTHING------------------- ***/
    public static void main(String[] args) throws IOException {
        new Thread(null, new Clean(), "Akash_Sardar_13-12-2000", 1 << 30).start();
    }

    /*** ----------------------JAVA FAST I/O----------------------- ***/

    public static FastReader fastReader = new FastReader(System.in);
    public static PrintWriter fastWriter = new PrintWriter(System.out);

    /*** --------------------FOR READING INPUTS-------------------- ***/

    public static class FastReader {
        private BufferedReader br;
        private StringTokenizer tk;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            tk = null;
        }

        public String next() {
            while (tk == null || !tk.hasMoreTokens()) {
                try {
                    tk = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return tk.nextToken();
        }
    }

    public static int readInteger() {
        return Integer.parseInt(fastReader.next());
    }

    public static long readLong() {
        return Long.parseLong(fastReader.next());
    }

    public static double readDouble() {
        return Double.parseDouble(fastReader.next());
    }

    public static String readString() {
        return fastReader.next();
    }

    public static int[] readArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = readInteger();
        return arr;
    }

    public static long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = readLong();
        return arr;
    }

    public static double[] readDoubleArray(int n) throws IOException {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = readDouble();
        return arr;
    }

    public static String[] readStringArray(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = readString();
        return arr;
    }

    /*** -------------------FOR PRINTING RESULTS------------------- ***/

    public static void print(String s) {
        fastWriter.print(s);
    }

    public static <K, V> void debug(Map<K, V> map) {
        map.forEach((key, val) -> print(key + " : " + val + "\n"));
    }

    public static void debug(int... args) {
        for (int e : args)
            print(e + " ");
        print("\n");
    }

    public static void debug(long... arr) {
        for (long e : arr)
            print(e + " ");
        print("\n");
    }

    public static void debug(boolean... arr) {
        for (boolean e : arr)
            print(e + " ");
        print("\n");
    }

    public static void debug(char... arr) {
        for (char e : arr)
            print(e + " ");
        print("\n");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void debug(List list) {
        list.forEach(e -> print(e + " "));
        print("\n");
    }

    public static void debug(Object obj) {
        print(obj.toString() + "\n");
    }

    public static void YES() {
        print("YES\n");
    }

    public static void NO() {
        print("NO\n");
    }

    public static void flush() {
        fastWriter.flush();
    }

    /*** ---------------------UTILITY FUNCTIONS--------------------- ***/

    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
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
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void swap(int l, int r, long[] arr) {
        long temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
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
        return (a * b) % MOD;
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
}