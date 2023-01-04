class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        long count=0;
        for(int i=0; i<n-2; i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                long val=arr[i]+arr[j]+arr[k];
                if(val<(long)sum)
                {
                    count+=k-j;
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        
        return count;
    }
}
