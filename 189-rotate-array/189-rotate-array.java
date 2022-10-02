class Solution {
    public void rotate(int[] nums, int k) {
        // while(k>0){
        //     int temp= nums[nums.length-1];
        //     for(int i=nums.length-1; i>0; i--){
        //         nums[i]=nums[i-1];
        //     }
        //     nums[0]=temp;
        //     k--;
        // }
        //time limit exceed
        
        //using reversal algorithms
        
        int len =nums.length;
        k=k%len;
        
        reverse(nums, 0, len-1-k);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
        
    }
    public void reverse(int nums[], int low, int high){
        while(low<high){
            int temp= nums[low];
            nums[low]= nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}