package sorting;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] nums, int l, int r, int mid) {
        int[] temp = new int[r-l+1];
        int idx=0;

        int p1 = l, p2=mid+1;
        while(p1 <=mid || p2 <=r) {
            if(p1 <=mid && p2 <=r) {
                if(nums[p1]<=nums[p2]) {
                    temp[idx++] = nums[p1++];
                } else {
                    temp[idx++] = nums[p2++];
                }
            } else if(p1 <=mid) {
                temp[idx++] = nums[p1++];
            } else {
                temp[idx++] = nums[p2++];
            }
        }

        for(int i=0; i<r-l+1; i++) {
            nums[l+i] = temp[i];
        }
    }

    private static void mergeSortHelper(int[] nums, int l, int r) {
        if(r <= l) {
            return;
        }
        int mid = (l+r)/2;
        mergeSortHelper(nums, l, mid);
        mergeSortHelper(nums, mid+1, r);
        merge(nums, l, r, mid);
    }

    private static void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 2, -9, 4, 5, 3, 0};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
