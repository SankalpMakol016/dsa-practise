class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(i, j, i, j, grid, visited, n, m);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int row,int col,int baserow,int basecol,char[][] grid,int[][] visited,int n,int m){
        visited[row][col]=1;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]=='1' && visited[nr][nc]==0){
                dfs(nr, nc, baserow, basecol, grid, visited, n, m);
            }
        }
    }
}