package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Shortest path between all pair of vertexes
Uses Dp (Best Proff and intution Mit ocw)
Complexity(O(v^3))
**/
public class FloydWarshallAlgorithm {


    public static void main(String[] args) {
        //No of vertex
        int N = 4;
        int[][] edges = new int[][]{{0, 3, 15}, {3, 0, 1}, {2, 3, 2}, {0, 1, 3}, {0, 2, 6}, {1, 2, -2}};

        int[][] dist = new int[N][N];

        for(int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i]=0;
        }

        for(var edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            dist[src][dest] = wt;
        }

        for(int k=0; k<N; k++) {
            for(int u=0; u<N; u++) {
                for(int v=0; v<N; v++) {
                    if(dist[u][k] != Integer.MAX_VALUE &&
                            dist[k][v] != Integer.MAX_VALUE &&
                            dist[u][v] > dist[u][k] + dist[k][v]) {
                        dist[u][v] = dist[u][k] + dist[k][v];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dist));
    }
}
