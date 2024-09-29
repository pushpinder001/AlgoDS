package sorting;

/**
Finding duplicate element from 1 to n
**/
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 324, 34, 5, 6, 0, -1};

        int idx=0;

        while(idx<arr.length) {
            if(arr[idx]>=1 && arr[idx]<=arr.length && idx+1!= arr[idx] ) {
                if(arr[idx] == arr[arr[idx]-1]) {
                   break;
                } else {
                    int temp = arr[idx];
                    arr[idx] = arr[arr[idx]-1];
                    arr[temp-1] = temp;
                }
            } else {
                idx++;
            }
        }

        if(idx == arr.length) {
            System.out.println("-1");
        } else {
            System.out.println(arr[idx]);
        }

    }
}
