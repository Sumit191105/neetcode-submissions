class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtracking(0,nums,target,new ArrayList<>());
        return ans;
    }
    private void backtracking(int start,int[] nums,int target,List<Integer> current){
       if(start==nums.length){
        if(target==0) ans.add(new ArrayList<>(current));
        return;
       }
       if(nums[start]<=target){
        current.add(nums[start]);
        backtracking(start,nums,target-nums[start],current);
        current.remove(current.size()-1);
       }
       backtracking(start+1,nums,target,current);
    }
}
