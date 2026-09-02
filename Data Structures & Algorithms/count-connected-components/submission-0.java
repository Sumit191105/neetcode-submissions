class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int node){
        visited[node] = true;
        for(int it:adj.get(node)){
            if(!visited[it]){
                dfs(adj,visited,it);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int components =0;
        for(int i =0;i<n;i++){
            if(!visited[i]){
                components++;
                dfs(adj,visited,i);
            }
        }
        return components;
    }
    /*public int countComponents(int n, int[][] edges){
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int count=1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                count++;
                q.add(it);
            }
        }
        return count;
    }*/
}
