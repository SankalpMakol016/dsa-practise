class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        //first and last col 
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'&&visited[i][0]==0){
                dfs(i, 0, board, visited, n, m);
            }
            if(board[i][m-1]=='O'&&visited[i][m-1]==0){
                dfs(i, m-1, board, visited, n, m);
            }
        }

        // first and last row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'&&visited[0][i]==0){
                dfs(0, i, board, visited, n, m);
            }
            if(board[n-1][i]=='O'&&visited[n-1][i]==0){
                dfs(n-1, i, board, visited, n, m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    void dfs(int row , int col , char[][] board,int[][] visited,int n,int m){
        visited[row][col]=1;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]=='O'&& visited[nr][nc]==0){
                dfs(nr, nc, board, visited, n, m);
            }
        }
    }
}