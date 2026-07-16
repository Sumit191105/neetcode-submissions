class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a , b , res;
        for(String ch : tokens){
            if(ch.equals("+")){
                a = stack.pop();
                b = stack.pop();
                res = b+a;
                stack.push(res);
            }else if(ch.equals("-")){
                a = stack.pop();
                b = stack.pop();
                res = b-a;
                stack.push(res);
            }else if(ch.equals("*")){
                a = stack.pop();
                b = stack.pop();
                res = b*a;
                stack.push(res);
            }else if(ch.equals("/")){
                a = stack.pop();
                b = stack.pop();
                res = b/a;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.peek();
    }
}
