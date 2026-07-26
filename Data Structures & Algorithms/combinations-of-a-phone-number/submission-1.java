class Solution {

    List<String> ans = new ArrayList<>();
    
    private void solve(int idx , String digits, List<String> ans , StringBuilder temp , HashMap<Character,String> map){
        if(idx>=digits.length()){
            ans.add(temp.toString()); // base case;
            return;
        }
        char ch = digits.charAt(idx);
        String data = map.get(ch);
        for(int i=0;i<data.length();i++){
            temp.append(data.charAt(i));
            solve(idx+1,digits,ans,temp,map);
            temp.deleteCharAt(temp.length()-1);
        }

    }


    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return ans;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder temp = new StringBuilder();
        solve(0,digits,ans,temp,map);
        return ans;
    }
}