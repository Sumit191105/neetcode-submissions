class Solution {
    public int maxArea(int[] heights) {
        int left = 0,right=heights.length-1;
        int amt = Integer.MIN_VALUE;
        while(left<right){
            int min= Math.min(heights[left],heights[right]);
            amt = Math.max(min*((right+1)-(left+1)),amt);
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return amt;
    }
}
