package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleDetectionUndirectedGraph {

    public static void main(String[] args) {
        //No of vertex
        int N = 8;
//        int[][] edges = new int[][]{{0,1},{1,0},{1,4},{4,1},{1,5},{5,1},{0,2},{2,0},{2,6},{6,2},{2,3},{3,2},
//                {6,7},{7,6}, {3,7}, {7,3}};

        int[][] edges = new int[][]{{0,1}, {1,0},{1,2},{2,1},{3,5},{5,3},{4,5},{5,4},{6,7},{7,6}};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] stack = new boolean[N];
        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        Arrays.fill(parent, Integer.MAX_VALUE);

        for(int i=0; i<N; i++) {
            if(dfs(adj, i, stack, visited, parent)) {
                System.out.println("Cycle Detected");
                return;
            }
        }

        System.out.println("No Cycle Detected");
    }

    private static boolean dfs(List<List<Integer>> adj, int src, boolean[] stack, boolean[] visited,
                               int[] parent) {
        if(stack[src]) return true;

        if(visited[src]) return false;

        stack[src] = true;
        visited[src] = true;

        for(var adjN : adj.get(src)) {
            if(adjN != parent[src]) {
                parent[adjN] = src;
                if(dfs(adj, adjN, stack, visited, parent)) {
                    return true;
                }
            }
        }

        stack[src] = false;
        return false;
    }
}
