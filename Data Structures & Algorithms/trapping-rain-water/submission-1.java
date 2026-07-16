class Solution {
    public int trap(int[] height) {
        int ans =0;
        for(int i=0;i<height.length;i++){
            int leftMax=height[i];
            int rightMax=height[i];
            for(int j=i;j>=0;j--){
                leftMax=Math.max(leftMax,height[j]);
            }
            for(int j=i;j<height.length;j++){
                rightMax=Math.max(rightMax,height[j]);
            }
            int water = Math.min(leftMax,rightMax)-height[i];
            ans+=water;
        }
        return ans;
    }
}
