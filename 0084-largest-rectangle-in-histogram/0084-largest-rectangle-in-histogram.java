class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxarea = 0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n||heights[st.peek()]>=heights[i])){
                int height = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1:st.peek();

                int width = nse-pse-1;
                maxarea = Math.max(maxarea,height*width);
            }
            st.push(i);
        }
        return maxarea;
    }
}