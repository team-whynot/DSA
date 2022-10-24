// https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE; 
        int currentsum=0;
        for(int n: nums){
            currentsum=Math.max(currentsum+n,n);
            maxsum=Math.max(maxsum,currentsum);
        }
        return maxsum;
    }
}
