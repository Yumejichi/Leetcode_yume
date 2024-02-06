class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //set the result as an empty array
        int[] result = new int[m+n];

        //using merge sort algorithm to merge two arrays 
        //initialize the index i, j, k to track array num1, array num2, 
        //and the result
        //loop untill the k reach the sum of the m+n
        int i = 0;
        int j=0; 
        int k = 0;
        while(k<m+n){
            //if the i reaches the number of the index we want to consider, 
            //then just keep adding elements in array2
            if(i==m){
                result[k]=nums2[j];
                j++;
            } 
            //if the j reaches the array2's length,
            //then the left of elements in nums1(till m) should be considered
            else if(j==n){
                result[k]=nums1[i];
                i++;
            }
            //if not the above two situations, when nums1's element<=nums2's current element, 
            //add num1's element to result'
            else if (nums1[i]<=nums2[j]){
                result[k]=nums1[i];
                i++;
            }
            //otherwise, add nums2's current element to the result
            else{
                result[k]=nums2[j];
                j++;
            }
            //in the end, increment k
            k++;

        }
        
        //change each value in nums1 to the value in result
        for(int x=0; x<m+n; x++){
            nums1[x]=result[x];
        }
    }
}
