class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        long min_Diff=Integer.MAX_VALUE;
        for(int i=0;i+m-1<n;i++){
            long diff=a.get(i+m-1)-a.get(i);
            min_Diff= Math.min(diff,min_Diff);
            
        }
        return min_Diff;
    }
}
