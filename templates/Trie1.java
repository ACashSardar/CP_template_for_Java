package templates;

class Trie1 {

    public static class Node {
        Node[] child;
        boolean end;

        public Node() {
            this.child = new Node[26];
            this.end = false;
        }
    }

    Node root;

    public Trie1() {
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
        }
        curr.end = true;
    }

    public boolean search(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                return false;
            }
            curr = curr.child[ch - 'a'];
        }
        return curr.end;
    }

    public boolean startsWith(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                return false;
            }
            curr = curr.child[ch - 'a'];
        }
        return true;
    }

    public boolean checkIfAllPrefixPresent(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            curr = curr.child[ch - 'a'];
            if (curr.end == false)
                return false;
        }
        return true;
    }
}
