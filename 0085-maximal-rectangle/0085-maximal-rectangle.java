class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefix = new int[n][m];
        int maxarea = 0;

        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1') sum++;
                if(matrix[i][j]=='0') sum = 0;
                prefix[i][j] = sum; 
            }
        }
        for(int i=0;i<n;i++){
            maxarea = Math.max(maxarea,largestRectangleArea(prefix[i]));
        }
        return maxarea;
    }
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