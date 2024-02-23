package templates;

import java.util.ArrayList;
import java.util.List;

public class StringAlgorithms {

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

}
