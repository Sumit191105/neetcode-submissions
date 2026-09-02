class Solution {
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if(m!=n-1) return false;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        int start =0;
        visited[start]= true;
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it : adj.get(curr)){
                if(!visited[it]){
                    visited[it]=true;
                    count++;
                    q.add(it);
                }
            }
        }
        return count==n?true:false;
    }
}
