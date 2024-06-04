import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main implements Runnable {

    public static long MOD = 1000000007;

    public static void main() throws IOException {
        int n = fr.readInteger();
        int[] a = fr.readArray(n);
        List<Integer> list = new ArrayList<>();
        for (int e : a)
            list.add(e);
        List<Integer> ans = new ArrayList<>();
        while (list.size() > 0) {
            Collections.sort(list);
            int maxi = list.get(list.size() - 1);
            while (list.size() > 0 && list.get(list.size() - 1) == maxi) {
                ans.add(list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            for (int i = 0; i < list.size(); i++)
                list.set(i, list.get(i) & maxi);
        }
        for (int e : ans)
            print(e + " ");
        print("\n");
    }

    @Override
    public void run() {
        try {
            boolean hasTestCases = true;
            int tc = hasTestCases ? fr.readInteger() : 1;
            for (int tt = 1; tt <= tc; tt++) {
                main();
                flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(null, new Main(), "__AkashSardar__", 1 << 30).start();
    }

    private static FastReader fr = new FastReader();
    private static PrintWriter pw = new PrintWriter(System.out);

    static class FastReader {

        private BufferedReader br;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int readInteger() throws NumberFormatException, IOException {
            return Integer.parseInt(this.br.readLine());
        }

        public long readLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.br.readLine());
        }

        public double readDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(this.br.readLine());
        }

        public char readCharacter() throws IOException {
            String s = this.br.readLine();
            if (s.length() > 1)
                throw new IOException("Invalid Character");
            return s.charAt(0);
        }

        public String readString() throws IOException {
            return this.br.readLine();
        }

        public int[] readArray(int n) throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            if (strArr.length != n)
                throw new IOException("Invalid array size");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(strArr[i]);
            return arr;
        }

        public long[] readLongArray(int n) throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            if (strArr.length != n)
                throw new IOException("Invalid array size");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(strArr[i]);
            return arr;
        }

        public String[] readStringArray() throws IOException {
            return this.br.readLine().split(" ");
        }

        public List<Integer> readList() throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++)
                list.add(Integer.parseInt(strArr[i]));
            return list;
        }
    }

    public static void print(String s) {
        pw.print(s);
    }

    public static <K, V> void debug(Map<K, V> map) {
        for (var itr : map.entrySet())
            print(itr.getKey() + " : " + itr.getValue() + "\n");
        print("\n");
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

    public static void flush() {
        pw.flush();
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

    public static long sqrtFloor(long a) {
        long lo = 0;
        long hi = 1000000000L;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= a)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo - 1;
    }
}
