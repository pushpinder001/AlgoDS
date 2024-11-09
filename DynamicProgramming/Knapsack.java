import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapSackHelper(int[] weight, int[] value, int n, int maxWeight, 
        int[][] memo) {
        if(maxWeight<0) {
            return Integer.MIN_VALUE;
        }

        if(memo[n][maxWeight]!=-1) {
            return memo[n][maxWeight];
        }

        int ans = Integer.MIN_VALUE;
        ans = knapSackHelper(weight, value, n-1, maxWeight-weight[n-1], memo) + value[n-1];
        ans = Integer.max(ans, knapSackHelper(weight, value, n-1, maxWeight, memo));

        //System.out.println(ans);
        return memo[n][maxWeight] = ans;
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] memo = new int[n+1][maxWeight+1];
        for(int i=1; i<=n; i++) {
            Arrays.fill(memo[i], -1);
        }
        Arrays.fill(memo[0], 0);

        return knapSackHelper(weight, value, n, maxWeight, memo);
    }
}
