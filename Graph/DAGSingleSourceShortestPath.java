package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAGSingleSourceShortestPath {
    private static int dfs(List<List<int[]>> adj, int src, int[] dist) {
        if(dist[src]!= Integer.MAX_VALUE) return dist[src];

        for(var adjN : adj.get(src)) {
            int v = adjN[0], w = adjN[1];
            int dV = dfs(adj, v, dist);
            dist[src] = Integer.min(dist[src], w + dV);
        }

        return dist[src];
    }

    private static int[] singleSourceShortestPath(List<List<int[]>> adj) {
        int N = adj.size();
        List<List<int[]>> revAdj = new ArrayList<>();
        for(int i=0; i<N; i++) revAdj.add(new ArrayList<>());

        for(int i=0; i<N ;i++) {
            for(var adjN :  adj.get(i)) {
                int v = adjN[0], w = adjN[1];
                revAdj.get(v).add(new int[]{i, w});
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for(int i=1; i<N; i++) {
            dfs(revAdj, i, dist);
        }

        return dist;
    }

    public static void main(String[] args) {
        //No of vertex
        int N = 6;
        int[][] edges = new int[][]{{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = singleSourceShortestPath(adj);

        System.out.println(Arrays.toString(dist));
    }
}
