//Link to the problem: https://leetcode.com/problems/sort-list/description/
//Problem: 148. Sort List

// Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
// A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
// Note that points on the edge of a vertical area are not considered included in the area.

 

// Example 1:
// Input: points = [[8,7],[9,9],[7,4],[9,7]]
// Output: 1
// Explanation: Both the red and the blue area are optimal.

// Example 2:
// Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
// Output: 3
 

// Constraints:
// n == points.length
// 2 <= n <= 105
// points[i].length == 2
// 0 <= xi, yi <= 109


//solution:
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        //sort the array with first element for each of the first element for each two-dimension array:
        //use merge sort to do this just for first element for each problem:
        int len = points.length;
        sort(points, 0, len-1);

        //calculate the widest vertical area 
        // After sort the array, it should be the minimum of the difference of each array's [0]'s elemets
        int max = points[1][0] - points[0][0];
        for(int i =1; i<len-1; i++){
            if(points[i+1][0]-points[i][0] > max){
                max = points[i+1][0]-points[i][0];
            }
        }
        return max;
    
    }
    public static int[][] sort(int[][] arr, int l, int h){
        if(l<h){
            int mid = (l+h)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, h);
            merge(arr, l, mid, h);
        }
        return arr;

    }

    public static void merge(int[][] arr, int l, int mid, int h){
        //merge the array from l to mid, and the array from mid+1 to high
        int[][] tempLeft = new int[mid-l+1][2];
        int[][] tempRight = new int[h-mid][2];

        //copy the array in to the left part and right part to the temporary array
        for(int i=0; i<(mid-l+1); i++){
            tempLeft[i] = arr[i+l];
        }
        for(int i=0; i<(h-mid); i++){
            tempRight[i] = arr[mid+1+i];
        }

        //pointers to track the first array, second array, and the merged array
        int i = 0;
        int j = 0; 
        int k = l;

        //merge two temporary arrays into the corresponding part of the original array.
        while(k<=h+1){
            if(i<(mid-l+1) && j<(h-mid) && tempLeft[i][0]<=tempRight[j][0]){
                // arr[k][0] = tempLeft[i][0];
                // arr[k][1] = tempLeft[i][1];
                arr[k] = tempLeft[i];
                i++;
            }else if(j<(h-mid) && i<(mid-l+1) && tempRight[j][0] <= tempLeft[i][0]){
                // arr[k][0] = tempRight[j][0];
                // arr[k][1] = tempRight[j][1];
                arr[k] = tempRight[j];
                j++;
            }else if(j>=(h-(mid+1)+1) && i<(mid-l+1)){
                // arr[k][0] = tempLeft[i][0];
                // arr[k][1] = tempLeft[i][1];
                arr[k] = tempLeft[i];
                i++;
            }else if(j<(h-mid) && i>=(mid-l+1)){
                // arr[k][0] = tempRight[j][0];
                // arr[k][1] = tempRight[j][1];
                arr[k] = tempRight[j];
                j++;
            }
            else{
                //none
            }
            k++;

        }
        
    }
}
