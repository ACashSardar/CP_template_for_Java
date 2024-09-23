package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph {

    static class Node {
        int u, v, wt;

        Node(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static void dfs(int curr, List<List<Integer>> graph, int[] vis) {
        vis[curr] = 1;
        System.out.println(curr);
        for (int child : graph.get(curr)) {
            if (vis[child] == 1)
                continue;
            dfs(child, graph, vis);
            vis[child] = 1;
        }
    }

    public static void bfs(List<List<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] vis = new int[n + 1];
        vis[1] = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int curr = q.poll();
                System.out.print(curr + " ");
                for (int child : graph.get(curr)) {
                    if (vis[child] == 1)
                        continue;
                    q.add(child);
                    vis[child] = 1;
                }
            }
            System.out.println();
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int n, int src) {
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new Node(src, src, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int u = curr.v;
            for (Node child : graph.get(u)) {
                int v = child.v;
                int wt = child.wt;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    q.add(new Node(u, v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static int[][] floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1)
                    dist[i][j] = 99999999;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 99999999)
                    dist[i][j] = -1;
            }
        }
        return dist;
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

    public static void main(String[] args) {
        test_dfs();
        test_bfs();
        test_dijkstra();
    }

    public static void test_dfs() {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 4, 5 }, { 2, 6 }, { 2, 4 } };
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] vis = new int[n + 1];
        System.out.println("DFS");
        dfs(1, graph, vis);
    }

    public static void test_bfs() {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 4, 5 }, { 2, 6 }, { 2, 4 } };
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println("BFS");
        bfs(graph, n);
    }

    public static void test_dijkstra() {
        int n = 4;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] edges = { { 0, 1, 9 }, { 0, 2, 1 }, { 0, 3, 1 }, { 1, 3, 3 }, { 2, 3, 2 } };
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[0], edge[1], edge[2]));
            graph.get(edge[1]).add(new Node(edge[1], edge[0], edge[2]));
        }
        int[] dist = dijkstra(graph, n, 0);
        System.out.println("Dijkstra");
        for (int e : dist) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void test_floydWarshall() {

    }

}
