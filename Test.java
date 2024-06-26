import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public static void bridge(int u, int par, List<List<Integer>> graph, int[] vis, int time, int[] low,
            Set<String> set) {
        vis[u] = 1;
        low[u] = time;
        int mini = Integer.MAX_VALUE;
        for (int v : graph.get(u)) {
            if (vis[v] == 1) {
                if (v == par)
                    continue;
                if (low[v] > low[u]) {
                    set.add(u + "_" + v);
                } else {
                    mini = Math.min(mini, low[v]);
                }
                continue;
            }
            bridge(v, u, graph, vis, time + 1, low, set);
            if (low[v] > low[u]) {
                set.add(u + "_" + v);
            } else {
                mini = Math.min(mini, low[v]);
            }
        }
        low[u] = mini;
    }

    static int isBridge(int n, List<List<Integer>> graph, int c, int d) {
        Set<String> set = new HashSet<>();
        int[] low = new int[n + 1];
        int[] vis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (vis[i] != 1) {
                bridge(i, -1, graph, vis, 1, low, set);
            }
        }
        String key1 = c + "_" + d;
        String key2 = d + "_" + c;
        return (set.contains(key1) || set.contains(key2)) ? 1 : 0;
    }
}