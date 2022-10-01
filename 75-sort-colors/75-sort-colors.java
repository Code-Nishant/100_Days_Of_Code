class Solution {
    public void sortColors(int[] nums) {
        int len= nums.length;
        int one=0; int zero=0; int two=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]==1){
                one++;
            }
            if(nums[i]==2){
                two++;
            }
        }
        
        for(int i=0; i<zero;i++){
            nums[i]=0;
        }
        for(int i=zero; i<zero+one;i++){
            nums[i]=1;
        }
        for(int i=zero+one; i<len;i++){
        nums[i]=2;
        }
    }
}