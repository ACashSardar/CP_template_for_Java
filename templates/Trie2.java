package templates;

public class Trie2 {

    public static class Node {
        Node[] child;
        int endCnt;
        int prefCnt;

        public Node() {
            this.child = new Node[26];
            this.endCnt = 0;
            this.prefCnt = 0;
        }
    }

    Node root;

    public Trie2() {
        this.root = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
            curr.prefCnt++;
        }
        curr.endCnt++;
    }

    public int countWordsEqualTo(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        return curr.endCnt;
    }

    public int countWordsStartingWith(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        return curr.prefCnt;
    }

    public void erase(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
            curr.prefCnt--;
        }
        curr.endCnt--;
    }
}
