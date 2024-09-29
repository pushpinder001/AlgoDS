package sorting;

//This is a max heap
public class Heap {
    //Build heap from array
    //Add element to heap
    //delete element from heap
    //get max element
    private static int DEFAULT_SZ = 100;
    private int[] arr;
    int idx=-1;

    public Heap() {
        this(null);
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    private void heapify(int idx) {
        if(idx == 0) return;

        int parent = (idx-1)/2;
        if(arr[idx] > arr[parent]) {
            swap(arr, idx, parent);
            heapify(parent);
        }
    }

    public Heap(int[] nums) {
        arr = new int[DEFAULT_SZ];
        if(nums != null) {
            for (int num : nums) {
                arr[++idx] = num;
                heapify(idx);
            }
        }
    }

    public Integer peek() {
        return idx==-1?null : arr[0];
    }

    public void offer(int num) {
        arr[idx++] = num;
        heapify(idx);
    }

    public Integer poll() {
        if(idx == -1) {
            return null;
        }
        //Swap top with last element and decrement counter
        swap(arr, idx, 0);

        int curIdx=0;
        while(curIdx<idx) {
            int child1Idx = 2*curIdx+1;
            int child2Idx = 2*curIdx+2;
            int maxElementIdx = curIdx;
            if(child1Idx < idx && arr[child1Idx] > arr[maxElementIdx]) {
                maxElementIdx = child1Idx;
            }
            if(child2Idx < idx && arr[child2Idx] > arr[maxElementIdx]) {
                maxElementIdx = child2Idx;
            }

            if(maxElementIdx == curIdx) {
                break;
            }
            swap(arr, curIdx, maxElementIdx);
            curIdx = maxElementIdx;
        }

        idx--;
        return arr[idx];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 2, -9, 4, 5, 3, 0};

        Heap heap = new Heap(nums);
        heap.poll();
        System.out.println(heap.peek());
    }
}
