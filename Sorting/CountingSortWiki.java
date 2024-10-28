package sorting;

import java.util.Arrays;

public class CountingSortWiki {
    private static int[] sort(int[] input) {
        int minVal = Integer.MAX_VALUE,  maxVal = Integer.MIN_VALUE;

        for(int num : input) {
            minVal = Integer.min(minVal, num);
            maxVal = Integer.max(maxVal, num);
        }

        int[] count = new int[maxVal-minVal+1];

        for(int num : input) {
            count[num-minVal]++;
        }
        for(int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        int[] output = new int[input.length];
        for(int num : input) {
            output[count[num]-1] = num+minVal;
            count[num]--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 2, -9, 4, 5, 3, 0};

        int[] output = sort(arr);

        System.out.println(Arrays.toString(output));
    }
}
