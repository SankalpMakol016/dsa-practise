class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[N];
        for(int i=2*N-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%N]){
                st.pop();
            }
            if(i<N){
                if(st.isEmpty()){
                    st.push(nums[i%N]);
                    ans[i]=-1;
                } 
                else{
                    ans[i]=st.peek();
                    st.push(nums[i%N]);
                }
            }else{
                if(st.isEmpty()) st.push(nums[i%N]);
                else st.push(nums[i%N]);
            }
        }
        return ans;
    }
}