/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node,Node> map = new HashMap<>();

    private Node dfs(Node node){
        if(node==null) return null;
        // if the neighbour node is cloned then return the clone 
        if(map.containsKey(node)){
            return map.get(node);
        }
        //create clone 
        Node clone = new Node(node.val);
        //Store immediately in map to avoid infinite recursion
        map.put(node,clone);
        //clone all neighbor
        for(Node neighbor:node.neighbors){
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return dfs(node);


    }
}