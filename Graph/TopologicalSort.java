package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Kahn's Algorithm
 */
public class TopologicalSort {

    private static List<Integer> getTopologicalSort(List<List<Integer>> adj) {
        int N = adj.size();
        int[] inDegree = new int[N];

        for(int i=0; i<N; i++) {
            for(var adjN :  adj.get(i)) {
                inDegree[adjN]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(inDegree[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalSort = new ArrayList<>();
        while(!queue.isEmpty()) {
            int top = queue.poll();
            topologicalSort.add(top);
            for(var adjN : adj.get(top)) {
                inDegree[adjN]--;
                if(inDegree[adjN]==0) {
                    queue.offer(adjN);
                }
            }
        }

        return topologicalSort;
    }

    public static void main(String[] args) {
        //No of vertex
        int N = 4;
        int[][] edges = new int[][]{{1, 0}, {2, 0}, {3, 1}};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> topologicalSort = getTopologicalSort(adj);

        System.out.println(topologicalSort);
    }
}
