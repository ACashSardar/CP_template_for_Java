package templates;

import java.util.Arrays;

public class DSU {

    static class DisjointSet {

        private int[] size, parent;

        public DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int findUPar(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUPar(parent[node]);
        }

        public void unionBysize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
}
