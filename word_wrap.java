class Solution

{

    public int solve(int nums[],int k,int i,int n,int dp[][])

    {

        if(i==nums.length)

        return 0;

        if(dp[i][n]!=-1)

        return dp[i][n];

        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;

        if(n+nums[i]<k)

        {

        if(n==0)    

        x=solve(nums,k,i+1,n+nums[i],dp);

        if(n!=0)

        x=solve(nums,k,i+1,n+nums[i]+1,dp);

        }

        if(n!=0)

        y=solve(nums,k,i,0,dp)+(int)Math.pow((k-n),2);

        return dp[i][n]=Math.min(x,y);

    }

    public int solveWordWrap (int[] nums, int k)

    {

        int dp[][]=new int[nums.length][k+1];

        for(int i=0;i<nums.length;i++)

        Arrays.fill(dp[i],-1);

        return solve(nums,k,0,0,dp);

        // Code here 

    }

}
