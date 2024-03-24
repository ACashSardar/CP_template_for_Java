package templates;

class Trie3 {
    public static class Node {
        Node[] child;
        boolean end;

        Node() {
            this.child = new Node[2];
            this.end = false;
        }
    }

    Node root;

    public Trie3() {
        this.root = new Node();
    }

    public void insert(int elem) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (elem >> i) & 1;
            if (curr.child[bit] == null)
                curr.child[bit] = new Node();
            curr = curr.child[bit];
        }
        curr.end = true;
    }

    public int searchOther(int elem) {
        int ans = 0;
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (elem >> i) & 1;
            int bit_inv = bit ^ 1;
            if (curr.child[bit_inv] != null) {
                curr = curr.child[bit_inv];
                ans |= (bit_inv << i);
            } else {
                curr = curr.child[bit];
                ans |= (bit << i);
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        Trie3 trie = new Trie3();
        for (int e : nums)
            trie.insert(e);
        int ans = 0;
        for (int e : nums)
            ans = Math.max(ans, e ^ trie.searchOther(e));
        return ans;
    }
}