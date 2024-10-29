package graph;

import java.util.*;

public class DAGSingleSourceShortestPathTopological {

    private static List<Integer> getTopologicalSort(List<List<int[]>> adj) {
        int[] inDegree = new int[adj.size()];
        for(int i=0; i<adj.size(); i++) {
            for(var nei : adj.get(i)) {
                int v = nei[0];
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adj.size(); i++) {
            if(inDegree[i]==0) {
                queue.offer(i);
            }
        }

        List<Integer> topologicalSort = new ArrayList<>();

        while(!queue.isEmpty()) {
            int u = queue.poll();
            topologicalSort.add(u);
            for(var nei : adj.get(u)) {
                int v = nei[0];
                inDegree[v]--;
                if(inDegree[v]==0) {
                    queue.offer(v);
                }
            }
        }

        return topologicalSort;
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

        List<Integer> topologicalSort = getTopologicalSort(adj);

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;

        for(var u : topologicalSort) {
            if(dist[u]!=Integer.MAX_VALUE) {
                for(var nei: adj.get(u)) {
                    int v = nei[0], w = nei[1];
                    dist[v] = Integer.min(dist[v], dist[u]+w);
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }
}
