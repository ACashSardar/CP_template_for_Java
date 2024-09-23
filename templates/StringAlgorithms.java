package templates;

import java.util.ArrayList;
import java.util.List;

public class StringAlgorithms {

    /*** RABIN KARP ALGORITHM ***/

    public static long MOD = 1000000007;

    // DOUBLE HASHING (Safe)
    public static long[] computeDoubleHash(String s, int n, long BASE1, long BASE2) {
        long hash1 = 0, hash2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            hash1 = add(hash1, mul(s.charAt(i), binExpItr(BASE1, n - 1 - i)));
            hash2 = add(hash2, mul(s.charAt(i), binExpItr(BASE2, n - 1 - i)));
        }
        return new long[] { hash1, hash2 };
    }

    public static int rabinKarpDoubleHash(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        long BASE1 = 26, BASE2 = 27;
        long MAX_WT1 = binExpItr(BASE1, m), MAX_WT2 = binExpItr(BASE2, m);
        long[] patHash = computeDoubleHash(pat, m, BASE1, BASE2);
        long[] windowHash = null;
        for (int i = 0; i + m - 1 < n; i++) {
            if (i == 0) {
                windowHash = computeDoubleHash(txt, Math.min(n, m), BASE1, BASE2);
            } else {
                windowHash[0] = add(sub(mul(windowHash[0], BASE1), mul(txt.charAt(i - 1), MAX_WT1)),
                        txt.charAt(i + m - 1));
                windowHash[1] = add(sub(mul(windowHash[1], BASE2), mul(txt.charAt(i - 1), MAX_WT2)),
                        txt.charAt(i + m - 1));
            }
            if (windowHash[0] == patHash[0] && windowHash[1] == patHash[1]) {
                return i;
            }
        }
        return -1;
    }

    // SINGLE HASHING (Unsafe)
    public static long computeSingleHash(String s, int n, long BASE) {
        long hash = 0;
        for (int i = n - 1; i >= 0; i--) {
            hash = add(hash, mul(s.charAt(i), binExpItr(BASE, n - 1 - i)));
        }
        return hash;
    }

    public static int rabinKarpSingleHash(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        long BASE = 26;
        long MAX_WT = binExpItr(BASE, m);
        long patHash = computeSingleHash(pat, m, BASE);
        long windowHash = 0;
        for (int i = 0; i + m - 1 < n; i++) {
            if (i == 0) {
                windowHash = computeSingleHash(txt, Math.min(n, m), BASE);
            } else {
                // hash=hash*BASE-(S[i-1]*26^m)+S[i+m-1]
                windowHash = add(sub(mul(windowHash, BASE), mul(txt.charAt(i - 1), MAX_WT)),
                        txt.charAt(i + m - 1));
            }
            if (windowHash == patHash) {
                return i;
            }
        }
        return -1;
    }

    /*** KMP ALGORITHM ***/

    public static boolean kmpSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < m) {
            while (i > 0 && pat.charAt(i) != pat.charAt(j)) {
                i = lps[i - 1];
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                i++;
            }
            j++;
        }
        i = 0;
        j = 0;
        while (i < m && j < n) {
            if (i > 0 && pat.charAt(i) != txt.charAt(j))
                i = lps[i - 1];
            if (pat.charAt(i) == txt.charAt(j))
                i++;
            j++;
        }
        return i == m;
    }

    public static void kmpPos(String txt, String pat, List<Integer> ans) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < m) {
            while (i > 0 && pat.charAt(i) != pat.charAt(j)) {
                i = lps[i - 1];
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                i++;
            }
            j++;
        }
        i = 0;
        j = 0;
        while (i < m && j < n) {
            if (i > 0 && pat.charAt(i) != txt.charAt(j))
                i = lps[i - 1];
            if (pat.charAt(i) == txt.charAt(j))
                i++;
            if (i == m) {
                ans.add(j - m + 1);
                i = lps[i - 1];
            }
            j++;
        }
    }

    public static void main(String[] args) {
        String txt = "akadfakakacakkkakag";
        String pat = "aka";
        System.out.println(kmpSearch(txt, pat));
        List<Integer> list = new ArrayList<>();
        kmpPos(txt, pat, list);
        System.out.println(list);
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

}
