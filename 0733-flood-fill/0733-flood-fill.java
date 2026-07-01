class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            ans[i] = image[i].clone();
        }

        int inicol = ans[sr][sc];
        if(inicol==color){
            return image;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});

        ans[sr][sc]=color;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nr<rows &&
                    nc>=0 && nc<cols &&
                    ans[nr][nc]==inicol
                ){
                    ans[nr][nc]=color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return ans;
    }
}