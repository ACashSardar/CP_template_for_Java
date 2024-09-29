package templates;

public class BitManipulation {

    // Faster than normal iteration over 64 bits
    public static int popcount(long n) {
        int cnt = 0;
        while (n > 0) {
            long rmsb = (-n & n);
            n ^= rmsb;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int pc = popcount(19);
        System.out.println(pc);
    }
}
