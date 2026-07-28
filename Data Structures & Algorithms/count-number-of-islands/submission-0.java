class Solution {

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        
    }

    private void bfs(int row, int col, int[][] visited, char[][] grid){
        visited[row][col] =1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        while(!queue.isEmpty()){
            int rows = queue.peek().first;
            int cols = queue.peek().second;
            queue.remove();
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};
            for(int i=0;i<4;i++){
                int nrow = rows+delRow[i];
                int ncol = cols+delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    queue.add(new Pair(nrow,ncol));
                }
            }
        }
    }




    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(visited[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row,col,visited,grid);
                }
            }
        }
        return count;
    }
}
