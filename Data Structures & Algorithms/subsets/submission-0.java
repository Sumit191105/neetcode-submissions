class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0,nums, new ArrayList<>() );
        return ans;
    }

    private void backtracking(int start, int[] nums , List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            //1.Choose 
            curr.add(nums[i]);
            //2.Explore
            backtracking(i+1,nums,curr);
            //3.Unchoose
            curr.remove(curr.size()-1);
        }
    }
}
