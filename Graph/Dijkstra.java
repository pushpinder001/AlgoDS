package graph;

import java.util.*;

/**
 * Works if graph has non-negative wt cycle
 * Take path u has quick implementation details
 */
public class Dijkstra {

    private static int[] singleSourceShortestPath(List<List<int[]>> adj, int src) {
        int N = adj.size();

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});
        dist[0] = 0;

        while(!pq.isEmpty()) {
            int u = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();

            for(var adjNode : adj.get(u)) {
                int v = adjNode[0], w = adjNode[1];
                if(d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        //No of vertex
        int N = 4;
        int[][] edges = new int[][]{{0, 1, 3}, {1, 2, 5}, {0, 3, 1}, {3, 2, 2}};
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

        int[] dist = singleSourceShortestPath(adj, 0);

        System.out.println(Arrays.toString(dist));
    }
}
