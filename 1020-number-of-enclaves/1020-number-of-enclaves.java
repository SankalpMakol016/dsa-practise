class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        //first and last col 
        for(int i=0;i<n;i++){
            if(grid[i][0]==1&&visited[i][0]==0){
                dfs(i, 0, grid, visited, n, m);
            }
            if(grid[i][m-1]==1&&visited[i][m-1]==0){
                dfs(i, m-1, grid, visited, n, m);
            }
        }

        // first and last row
        for(int i=0;i<m;i++){
            if(grid[0][i]==1&&visited[0][i]==0){
                dfs(0, i, grid, visited, n, m);
            }
            if(grid[n-1][i]==1&&visited[n-1][i]==0){
                dfs(n-1, i, grid, visited, n, m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int row , int col , int[][] grid,int[][] visited,int n,int m){
        visited[row][col]=1;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1 && visited[nr][nc]==0){
                dfs(nr, nc, grid, visited, n, m);
            }
        }
    }
}