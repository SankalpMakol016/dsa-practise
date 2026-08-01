class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Stack<Integer> st = new Stack<>();
        // Previous Less Element (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            prevLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        // Next Less Element (smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nextLess[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            ans = (ans + (left * right % mod) * arr[i]) % mod;

        }
        return (int) ans;
    }
}
