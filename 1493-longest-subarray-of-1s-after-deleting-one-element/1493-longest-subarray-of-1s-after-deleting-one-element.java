class Solution {
    public int longestSubarray(int[] nums) {
       int extra = 0;
        int left =0;
        int maxones = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=1) extra++;
            while(extra>1){
                if(nums[left]!=1) extra--;
                left++;
            }
            maxones = Math.max(maxones, right-left+1);
        }
        return maxones-1; 
    }
}