package sorting;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    private static int partition(int[] nums, int l, int r) {
        int partitionIdx = r;

        int idx = l;

        for(int i=l; i<r; i++) {
            if(nums[i] < nums[partitionIdx]) {
                //Swap i and idx
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, partitionIdx);
        return idx;
    }

    private static void quickSortHelper(int[] nums, int l, int r) {
        if(l>=r) {
            return;
        }

        int partitionIdx = partition(nums, l, r);
        quickSortHelper(nums, l, partitionIdx-1);
        quickSortHelper(nums, partitionIdx+1, r);
    }

    private static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 2, -9, 4, 5, 3, 0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
