//problem: https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        //since the nums[i] contains eithe 0, 1 or 2, we can use bucket sort

        //first, create an array to store each ocurrences of them:
        //since the index is same as the element, each count relates to each index's(element in nums) occurence
        int[] count = {0, 0, 0};

        //then count the occurence for each 0/1/2 in the array:
        for(int i =0; i<nums.length; i++){
            count[nums[i]] += 1;
        }

        //replace the original array:
        //a variable to track the current index to be replaced
        int current=0;
        //outer loop should be the lengh of the array count(for each 0, 1, 2, add each for the count of occurence)
        for(int i =0; i<count.length; i++){
            //use an inner loop to replace the exact counts of the occurence of the number:
            for(int j=0; j<count[i]; j++){
                nums[current]=i;
                current++;

            }

        }
    }
}
