class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> min;
    int mini;

    public MinStack() {
        minStack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        if(min.isEmpty()){
            min.push(val);
            mini=val;
        }else{
            if(val>mini){
                min.push(mini);
            }else{
                mini=val;
                min.push(mini);
            }
        }
    }
    
    public void pop() {

        minStack.pop();
        min.pop();

    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
