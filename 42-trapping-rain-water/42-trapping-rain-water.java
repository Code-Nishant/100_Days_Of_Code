class Solution {
    public int trap(int[] height) {
        //precalculation
        int len= height.length;
        int max=0;
        int left_Check[]=new int[len];
        int right_Check[]=new int[len];
        int ans=0;
        left_Check[0]=height[0];
        right_Check[len-1]=height[len-1];
        
        for(int j=1;j<len;j++){
                left_Check[j]=max(left_Check[j-1],height[j]);
            }
        for(int j=len-2;j>=0;j--){
                right_Check[j]=max(right_Check[j+1],height[j]);
            }
        for(int j=0;j<len;j++){
            max=max+min(left_Check[j],right_Check[j])-height[j];
        }
        
        return max;
        
        //brute force apporach
//         int len= height.length;
//         int max=0;
        
//         for(int i=1;i<len-1;i++){
//             int check_Left=height[i];
//             for(int j=0;j<i;j++){
//                 check_Left=max(check_Left,height[j]);
//             }
//             int check_Right=height[i];
//             for(int j=i;j<len;j++){
//                 check_Right=max(check_Right,height[j]);
//             }
//             max=max+min(check_Right,check_Left)-height[i];
//         }
        
//         return max;
    }
    public int min(int a, int b){
        int min= 0;
        if(a<b){
            min=a;
        }
        else{
            min=b;
        }
        return min;
    }
    public int max(int a, int b){
        int max= 0;
        if(a<b){
            max=b;
        }
        else{
            max=a;
        }
        return max;
    }
}