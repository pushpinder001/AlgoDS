package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDirectedGraph {

    private static boolean dfs(List<List<Integer>> adj, int src, boolean[] visited, boolean[] stack) {
        if(stack[src]) return true;

        if(visited[src]) return false;

        visited[src] = true;
        stack[src] = true;

        for(var adjN : adj.get(src)) {
            if(dfs(adj, adjN, visited, stack)) return true;
        }

        stack[src] = false;
        return false;
    }

    public static void main(String[] args) {
        //No of vertex
        int N = 6;
        int[][] edges = new int[][]{{0,1},{1,2},{1,5},{2,3},{4,0},{4,1}};

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] inStack = new boolean[N];
        boolean[] visited = new boolean[N];

        for(int i=0; i<N ;i++) {
            if(dfs(adj, i, visited, inStack)) {
                System.out.println("Cycle detected");
                return ;
            }
        }
        System.out.println("No Cycle detected");
    }
}
