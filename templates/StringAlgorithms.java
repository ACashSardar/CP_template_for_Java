package templates;

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

    public static int[] kmpPos(String txt, String pat) {
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
        if (i != m)
            return new int[0];
        int r = j - 1;
        int l = r - n + 1;
        return new int[] { l, r };
    }

    public static void main(String[] args) {
        String txt = "abxabcabcaby";
        String pat = "abcaby";
        System.out.println(kmpSearch(txt, pat));
    }

}
