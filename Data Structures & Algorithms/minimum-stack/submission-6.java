class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> min;
    int mini;
    int fucku;

    public MinStack() {
        minStack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            min.push(Math.min(val,min.peek()));
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
