/**
https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
**/
class Solution {
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
       int MAX_VALUE = 100_000_000;
       int[] dist = new int[V];
       Arrays.fill(dist, MAX_VALUE);
       dist[src]=0;
       
        // Write your code here
        for(int i=1; i<=V; i++) {
            for(var edge : edges) {
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(dist[u]!= MAX_VALUE && dist[v] > dist[u] +w) {
                    if(i == V) {
                        return new int[]{-1};
                    }
                    dist[v] = dist[u]+w;
                }
            }
        }
        
        return dist;
    }
}
