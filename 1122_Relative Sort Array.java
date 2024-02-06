//problem: https://leetcode.com/problems/relative-sort-array/description/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //initialize the current index to put the element to 0
        int current = 0;
        //loop through arr2 to check if the element in arr2 is also in arr1

        for(int i=0; i<arr2.length; i++){
            //check if the current element in arr2 is in arr1, 
            //if so, put them to the current index of arr1 and shift other numbers to the right

            for(int j=0; j<arr1.length; j++){
                if(arr1[j]==arr2[i]){
                    int temp = arr1[current];
                    arr1[current]=arr1[j];
                    arr1[j]=temp;
                    current++;
                }

            }

        }
        System.out.println(current);
        //sort from current index to the last index in ascending order(Use bubble sort)
        for (int i=current; i<arr1.length; i++){
            for(int j = arr1.length-1; j>i; j--){
                //move the minimum number to the first position starting from current
                //-> compare the j's element and the element before it, swap them if j's element is smaller
                if(arr1[j]<arr1[j-1]){
                    //swap two elements
                    int temp = arr1[j-1];
                    arr1[j-1]=arr1[j];
                    arr1[j]=temp;
                }

            }

        }
        return arr1;
        
    }
}
