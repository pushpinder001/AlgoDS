package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordNegativeCycleDetection {
    static int[] bellmanFord(List<List<int[]>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Write your code here
        for (int i = 1; i <= V; i++) {
            for (int u = 0; u < V; u++) {
                for (var adjN : adj.get(u)) {
                    int v = adjN[0], w = adjN[1];
                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                        if (i == V) {
                            return new int[]{-1};
                        }
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        //No of vertex
        int N = 6;
        int[][] edges = new int[][]{{0, 1, 5}, {1, 2, 1}, {1, 3, 2}, {2, 4, 1}, {4, 3, -1}, {3, 5, 2}, {5, 4, -3}};
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            adj.get(src).add(new int[]{dest, wt});
        }

        int[] dist = bellmanFord(adj, 0);

        System.out.println(Arrays.toString(dist));
    }
}
