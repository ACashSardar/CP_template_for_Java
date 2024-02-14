package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public static void dijkstra(List<List<Node>> graph, int n, int u, int v) {
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.wt - b.wt == 0 ? a.v - b.v : a.wt - b.wt);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000000);
        dist[u] = 0;
        q.add(new Node(u, u, 0));
        while (!q.isEmpty()) {

        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(2).add(6);
        graph.get(6).add(2);
        graph.get(2).add(4);
        graph.get(4).add(2);
        int[] vis = new int[n + 1];
        System.out.println("DFS");
        dfs(1, graph, vis);
        Arrays.fill(vis, 0);
        System.out.println("BFS");
        bfs(graph, n);
    }
}
