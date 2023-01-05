class Solution 

{ 

 public static long[] productExceptSelf(int nums[], int n) 

 { 

        // code here

        long product=1;

        int flag=0;

        long [] ans = new long[n];

        for(int i=0;i<n;i++){

            if(nums[i]==0){

                flag++;

                continue;

            }

            product*=nums[i];

        }

        if(flag==1){

            for(int i=0;i<n;i++){

                if(nums[i]==0){

                    ans[i]=product;

                }else{

                    ans[i]=0;

                }

            }

        }

        if(flag>1){

            for(int i=0;i<n;i++){

                ans[i]=0;

            }

        }

        if(flag==0){

            for(int i=0;i<n;i++){

                ans[i]=product/nums[i];

            }

        }

        return ans;

        

 } 

} 
