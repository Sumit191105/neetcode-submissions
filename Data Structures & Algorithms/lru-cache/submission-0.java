class LRUCache {
    // algo 
    /*
    Step 1. Create the node 
    Step 2. Create the map in which you gonna store the value 
    Step 3. initialise the global variables 
    Step 4. write the LRUCache fnc 
      

    */
   class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key , int value){
        this.key =key;
        this.value = value;
    }
   }
   private  int cap;
   private HashMap<Integer,Node> map;
   private Node head;
   private Node tail; 
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNodeAfterHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }
    
    public int get(int key) {
       if(!map.containsKey(key))return -1;
       else{
        Node node = map.get(key);
        remove(node);
        insertNodeAfterHead(node);
        return node.value;
       }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertNodeAfterHead(node);
        }else{
            if(map.size()==cap){
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            insertNodeAfterHead(newNode);
        }
    }

    
    
        
    
}

