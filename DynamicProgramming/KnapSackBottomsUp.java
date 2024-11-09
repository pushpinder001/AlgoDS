import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n+1][maxWeight+1];

        int maxVal=0;

        for(int i=0; i<n; i++) {
            for(int wt=0; wt<=maxWeight; wt++) {
                if(wt + weight[i]<=maxWeight) {
                    dp[i+1][wt+weight[i]] = dp[i][wt]+value[i];
                }
                dp[i+1][wt] = Integer.max(dp[i+1][wt], dp[i][wt]);
                maxVal = Integer.max(maxVal, dp[i+1][wt]);
            }
        }

        return maxVal;
    }
}
