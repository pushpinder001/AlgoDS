package graph;

import java.util.*;

/**
 * Works if graph has non-negative wt cycle
 * Take path u has quick implementation details
 */
public class Dijkstra {

    private static int[] singleSourceShortestPath(List<List<int[]>> adj, int src) {
        int N = adj.size();

        int[] distArr = new int[N];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});
        distArr[0] = 0;

        while(!pq.isEmpty()) {
            int node = pq.peek()[0];
            int nodeDist = pq.peek()[1];
            pq.poll();

            for(var adjNode : adj.get(node)) {
                if(nodeDist + adjNode[1] < distArr[adjNode[0]]) {
                    distArr[adjNode[0]] = nodeDist + adjNode[1];
                    pq.offer(new int[]{adjNode[0], nodeDist + adjNode[1]});
                }
            }
        }

        return distArr;
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
