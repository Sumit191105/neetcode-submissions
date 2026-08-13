class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left =1,right=nums.length-1;
        while(left<right){
            int i=left-1;
            int sum = nums[left]+nums[right];
            if(sum==-nums[i]){
                ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                i++;
                left++;
                right--;
            }else if(sum<-nums[i]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
