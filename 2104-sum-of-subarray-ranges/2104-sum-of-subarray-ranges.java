class Solution {
    public long subArrayRanges(int[] nums) {
        long max = sumSubarrayMaxs(nums);
        long min = sumSubarrayMins(nums);
        long ans = max-min;
        return ans; 
        
    }
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextless = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            prevLess[i] =  st.isEmpty() ? -1:st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextless[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long left = i-prevLess[i];
            long right = nextless[i] -i;
            ans = ans+(left*right * (long)arr[i]);
        }
        return ans;
    }
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] prevmax = new int[n];
        int[] nextmax = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            prevmax[i] =  st.isEmpty() ? -1:st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nextmax[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long left = i-prevmax[i];
            long right = nextmax[i] -i;
            ans = ans+(left*right * (long)arr[i]);
        }
        return ans;
    }
}