class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Tuple{
    int steps;
    int src;
    int dist;
    Tuple(int _steps, int _src , int _dist){
        this.steps = _steps;
        this.src = _src;
        this.dist = _dist;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i]=(int)(1e9);
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple node = q.poll();
            int steps = node.steps;
            int state = node.src;
            int cost = node.dist;
            if(steps>k) continue;
            for(Pair it : adj.get(state)){
                int adjState = it.first;
                int adjWt = it.second;
                if(cost+adjWt<dist[adjState] && steps<=k){
                    dist[adjState] = cost+adjWt;
                    q.add(new Tuple(steps+1,adjState,cost+adjWt));
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }
}
