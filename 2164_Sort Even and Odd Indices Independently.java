//problem: https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/


class Solution {
    private void sort(List<Integer> arr){
        for (int i=0; i<arr.size(); i++){
            int min = arr.get(i);
            int minIndex=i;
            //find the smallest number in the array and swap with the i's element
            for(int j = i+1; j<arr.size(); j++){
                if(arr.get(j)<min){
                    min=arr.get(j); 
                    minIndex = j;               
                }
            }
            //swap them
            int temp = arr.get(i);
            arr.set(i,min);
            arr.set(minIndex,temp);
        }
    }
    public int[] sortEvenOdd(int[] nums) {
        //set even and odd arrays separately
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int result[]=new int[nums.length];
        
        //check the numbers is even or odd
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }


        //then sort each part of them 
        sort(even);
        sort(odd);

        int m = 0;
        int n = odd.size()-1;
        for(int k = 0; k<nums.length; k++){
            if(k%2==0){
                result[k]=even.get(m);
                m++;
            }else{
                result[k]=odd.get(n);
                n--;
            }
        }

        return result;
    }

 
        
}
