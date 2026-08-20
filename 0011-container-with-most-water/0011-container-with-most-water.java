class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length - 1;
        int ans = 0;
        while(i<j){
            int base = j-i;
            int h = Math.min(height[i],height[j]);
            int area = base * h ;
            ans = Math.max(ans,area);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
        
    }
}