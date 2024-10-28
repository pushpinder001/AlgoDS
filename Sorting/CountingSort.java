package sorting;

import java.util.Arrays;

public class CountingSort {
    private static int[] sort(int[] input) {
        int len = input.length;
        int[] output = new int[len];

        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int val : input) {
            minVal = Integer.min(minVal, val);
            maxVal = Integer.max(maxVal, val);
        }

        int[] count = new int[maxVal-minVal+1];
        for(int val : input) {
            count[val-minVal]++;
        }


        for(int i=maxVal-minVal; i>=0; ) {
            if(count[i]!=0) {
                output[len-1] = i+minVal;
                count[i]--;
                len--;
            } else {
                i--;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 2, -9, 4, 5, 3, 0};

        int[] output = sort(arr);

        System.out.println(Arrays.toString(output));
    }
}
