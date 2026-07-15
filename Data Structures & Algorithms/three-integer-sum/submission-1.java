class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left =i+1,right=nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==-nums[i]){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(right>left && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum<-nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
