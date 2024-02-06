//problem: https://leetcode.com/problems/sort-an-array/description/


class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    //use quick sort to sort the Array
    public static int[] quickSort(int[] arr, int start, int end){
        if(end - start + 1 <= 1){
            return arr;
        }

        //set the piviot as the last element in the Array
        //compare each element in the array with pivot and if less than pivlt, 
        //swap the value with the index(left pointer)
        int pivot = arr[end];
        //pointer for the left side 
        int left = start;

        for(int i = start; i<end; i++){
            if (arr[i] < pivot){
                int temp = arr[left];
                arr[left]=arr[i];
                arr[i]=temp;
                left++;
            }
        }

        //move pivot in between the elements smaller than it and bigger than int
        //which is the position of the left pointer
        arr[end]=arr[left];
        arr[left]=pivot;

        //sort the left part with quick sort again
        quickSort(arr, start, left-1);

        //sort the right part with quick sort again
        quickSort(arr, left+1, end);

    return arr;
    }
}
