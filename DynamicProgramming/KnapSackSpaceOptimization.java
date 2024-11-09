import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] dp = new int[maxWeight+1];

        int maxVal=0;

        for(int i=0; i<n; i++) {
            for(int wt=maxWeight; wt>=0; wt--) {
                if(wt + weight[i]<=maxWeight) {
                    dp[wt+weight[i]] = Integer.max(dp[wt+weight[i]], dp[wt]+value[i]);
                }
            }
        }

        for(int i=0; i<=maxWeight; i++) {
            maxVal = Integer.max(maxVal, dp[i]);
        }

        return maxVal;
    }
}
