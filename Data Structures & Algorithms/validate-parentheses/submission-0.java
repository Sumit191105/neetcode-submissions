class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty()){
                if(c==stack.peek()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return !stack.isEmpty();
    }
}
