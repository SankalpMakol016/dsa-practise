class Solution {
    class pair{
        int row;
        int col;
        int dist;
        pair(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new pair(i, j, 0));
                }
            }
        }

        int[] dr={-1,0,1,0};
        int[] dc = {0,1,0,-1};
    
        while(!q.isEmpty()){
            pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int d = curr.dist;
            dist[row][col]=d;
            for(int i=0;i<4;i++){
                int r = row + dr[i];
                int c = col + dc[i];
                if(r>=0&&c>=0 && r<n&&c<m && !visited[r][c]){
                    visited[r][c]= true;
                    q.offer(new pair(r, c, d+1));
                }
            }
        }
        return dist;
    }
}