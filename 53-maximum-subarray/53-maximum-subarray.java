class Solution {
    public int maxSubArray(int[] nums) {
        //using divide and conquor technique
        return max_Sum(nums,0,nums.length-1);
        
        
        
        
        
        
        
        // //brute force apporach---> time complexity- O(n^2)
        // int max_Sum=Integer.MIN_VALUE;
        // int current_Sum=0;
        // int len=nums.length;
        // for(int i=0;i<len;i++){
        //     current_Sum=0;
        //     for(int j=i;j<len;j++){
        //         current_Sum=current_Sum+nums[j];
        //         if(current_Sum>max_Sum){
        //             max_Sum=current_Sum;
        //         }
        //     }
        // }
        // return max_Sum;
        
        
        
        
        
        
        //kadane's algo----> time complexity-O(n)
        // int len=nums.length;
        // int max_Sum=0;
        // int current_Sum=0;
        // for(int i=0; i<len;i++){
        //     current_Sum=current_Sum+nums[i];
        //     if(current_Sum>max_Sum){
        //         max_Sum=current_Sum;
        //     }
        //     if(current_Sum<0){
        //         current_Sum=0;
        //     }
        // }
        // return max_Sum;
    }
    
    public int max_Sum(int arr[], int low, int high){
        int left_Sum;
        int right_Sum;
        int cross_Sums ;
        if(low==high){
            return arr[low];
        }
        else{
            int mid= (low+high)/2;
            left_Sum=max_Sum(arr, low,mid);
            right_Sum=max_Sum(arr, mid+1,high);
            cross_Sums= cross_Sum(arr,low,mid,high);
        }
        int max=0;
        if(left_Sum>cross_Sums){
            if(left_Sum>right_Sum){
                max=left_Sum;
            }
            else{
                max=right_Sum;
            }
        }
        else{
            if(cross_Sums>right_Sum){
                max=cross_Sums;
            }
            else{
                max=right_Sum;
            }
        }
        return max;
    }
     public int cross_Sum(int arr[], int low,int mid, int high){
         int sum=0;
         int l_Sum=Integer.MIN_VALUE;
         int r_Sum=Integer.MIN_VALUE;
         
         for(int i=mid;i>=low;i--){
             sum=sum+arr[i];
             if(sum>l_Sum){
                 l_Sum=sum;
             }
         }
         sum=0;
         for(int i=mid+1;i<=high;i++){
             sum=sum+arr[i];
             if(sum>r_Sum){
                 r_Sum=sum;
             }
         }
         return (r_Sum+l_Sum);
     }
    
}