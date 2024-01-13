import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main implements Runnable {

    public static void main() throws IOException {

    }

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
        new Thread(null, new Main(), "akashsardar383@gmail.com", 1 << 30).start();
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
            if (s.length() > 1) {
                throw new IOException("Invalid Character!");
            }
            return s.charAt(0);
        }

        public String readString() throws IOException {
            return this.br.readLine();
        }

        public int[] readArray(int n) throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            if (strArr.length != n) {
                throw new IOException("Invalid array size!");
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            return arr;
        }

        public long[] readLongArray(int n) throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            if (strArr.length != n) {
                throw new IOException("Invalid array size!");
            }
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(strArr[i]);
            }
            return arr;
        }

        public String[] readStringArray() throws IOException {
            return this.br.readLine().split(" ");
        }

        public List<Integer> readList() throws IOException {
            String[] strArr = this.br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++) {
                list.add(Integer.parseInt(strArr[i]));
            }
            return list;
        }
    }

    public static void print(String s) {
        pw.print(s);
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
}
