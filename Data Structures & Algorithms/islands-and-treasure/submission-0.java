class Solution {
   class Node{
    int first;
    int second;
    int third;
    Node(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
   }

   private void bfs(int[][] grid,Queue<Node> queue){
    int n = grid.length;
    int m = grid[0].length;
    int delRow[] = {-1,0,+1,0};
    int delCol[] = {0,+1,0,-1};
    while(!queue.isEmpty()){
        int row = queue.peek().first;
        int col = queue.peek().second;
        int steps =queue.peek().third;
        queue.remove();
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==2147483647){
                queue.add(new Node(nrow,ncol,steps+1));
                grid[nrow][ncol]=steps+1;
            }
        }

    }
   }


    public void islandsAndTreasure(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      Queue<Node> queue = new LinkedList<>();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==0){
                queue.add(new Node(i,j,0));
            }
        }
      }
      bfs(grid,queue);
      return; 
    }
}
