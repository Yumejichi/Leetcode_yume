//problem: https://leetcode.com/problems/powx-n/description/
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Example 2:

// Input: x = 2.10000, n = 3
// Output: 9.26100
// Example 3:

// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

// Constraints:

// -100.0 < x < 100.0
// -231 <= n <= 231-1
// n is an integer.
// Either x is not zero or n > 0.
// -104 <= xn <= 104

class Solution {
    public double myPow(double x, int n) {


        //if n < 0, then the fraction of the result of product should be returned 
        if(n<0){
            return 1/helper(x, n);
        }

        return helper(x, n);
    }

    //add a function that recursively multiply itself 
    private double helper(double x, int n){
       //base case:
        //when n = 0, return 1
        //when x = 0, return 0
        if(x == 0){
            return 0;
        }
        //when n = 0, return 1
        if(n == 0){
            return 1;
        }
        
        //do the calculation for half numbers of n(n/2) as result,
        //and then just calculate the result *result-> this would be the result
        double result = helper(x, n/2);
        result = result * result;

        //if n is odd, then multiply another x -> result * result * x
        if(n%2 != 0){
            return result * x;
        }
        return result;

    }
}
