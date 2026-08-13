class Solution {

    List<String> ans = new ArrayList<>();
    private void combinations(String p , String up , List<String> ans ){
        if(up.isEmpty()){
            ans.add(p);
            return;
        }
        int digit = up.charAt(0)-'0';
        for(int i=((digit-1)*3)-3;i<(digit*3)-3;i++){
            char ch = (char)('a'+i);
            combinations(p+ch,up.substring(1),ans);
        }
    }


    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return ans;
        combinations("",digits,ans);
        return ans;
    }
}