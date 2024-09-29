package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Finding first 3 elements
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 2, -9, 4, 5, 3, 0, -1};
        int k = 3;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int val : arr) {
            minVal = Integer.min(minVal, val);
            maxVal = Integer.max(maxVal, val);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0; i<=maxVal-minVal; i++) {
            buckets.add(new ArrayList<>());
        }

        for(int val : arr) {
            buckets.get(val-minVal).add(val-minVal);
        }

        int[] ans = new int[k];
        int idx=0;
        boolean flag = false;
        for(int i=0; i<=maxVal-minVal; i++) {
            for(var it : buckets.get(i)) {
                ans[idx++] = it+minVal;
                if(idx == k) {
                    flag = true;
                    break;
                };
            }
            if(flag)break;
        }

        System.out.println(Arrays.toString(ans));
    }
}
