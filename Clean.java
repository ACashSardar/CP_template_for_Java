/*------------Coder: AKASH SARDAR, Language: JAVA-21,64-BIT-----------*/

import java.io.*;
import java.util.*;

public class Clean implements Runnable {

    public static boolean MULTIPLE_TEST_CASES = true;

    /*** ----------------------MY CONSTANTS------------------------ ***/
    public static long[] fact;
    public static long MOD = 1000000007, MOD2 = 1000000009;
    public static int[] dir4V = { 1, 0, -1, 0 }, dir4H = { 0, 1, 0, -1 };
    public static int[] dir8V = { 1, 0, -1, 0, -1, 1, 1, -1 }, dir8H = { 0, 1, 0, -1, -1, 1, -1, 1 };

    /*** ---------------------WRITE CODE HERE---------------------- ***/
    public static void Akash() throws IOException {

    }

    /*** ------------------DON'T CHANGE ANYTHING------------------- ***/
    public static void main(String[] args) throws IOException {
        new Thread(null, new Main(), "Thread-1", 1 << 30).start();
    }

    @Override
    public void run() {
        try {
            int tc = MULTIPLE_TEST_CASES ? readInteger() : 1;
            for (int t = 1; t <= tc; t++) {
                Akash();
                flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*** ----------------------JAVA FAST I/O----------------------- ***/

    public static FastReader fastReader = new FastReader(System.in);
    public static PrintWriter fastWriter = new PrintWriter(System.out);

    /*** --------------------FOR READING INPUTS-------------------- ***/

    public static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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

    public static void debug(int[] arr) {
        for (int e : arr)
            print(e + " ");
        print("\n");
    }

    public static void debug(long[] arr) {
        for (long e : arr)
            print(e + " ");
        print("\n");
    }

    public static void debug(boolean[] arr) {
        for (boolean e : arr)
            print(e + " ");
        print("\n");
    }

    public static void debug(char[] arr) {
        for (char e : arr)
            print(e + " ");
        print("\n");
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

    public static void reverse(long[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];
            l++;
            r--;
        }
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
        long inv_b = binExpItr(b, MOD - 2);
        return mul(a, inv_b);
    }

    public static long binExp(long a, long b) {
        if (b == 0)
            return 1;
        long half = binExp(a, b / 2);
        long temp = mul(half, half);
        if (b % 2 == 0)
            return temp;
        return mul(a, temp);
    }

    public static long binExpItr(long a, long b) {
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

    public static int popcount(long n) {
        int cnt = 0;
        while (n > 0) {
            n ^= (-n & n);
            cnt++;
        }
        return cnt;
    }
}