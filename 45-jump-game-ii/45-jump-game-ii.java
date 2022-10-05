
class Solution {
    public int jump(int[] nums) {
        int len=nums.length;
        int jump[]= new int[len];
        jump[0]=0;
        for(int i=1;i<len;i++){
            jump[i]=Integer.MAX_VALUE;
        }
            
        for (int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(i<=j+nums[j]&&jump[j]!= Integer.MAX_VALUE){
                    jump[i]=Math.min(jump[i],jump[j]+1);
                }
            }
        }
        return jump[len-1];
    }
}