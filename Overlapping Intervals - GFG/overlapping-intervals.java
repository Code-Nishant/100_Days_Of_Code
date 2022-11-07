//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        //base case
        int k=0;
        int count=0;

        Arrays.sort(Intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int[][]ans=new int[Intervals.length][Intervals[0].length];

        for(int i=0;i<Intervals.length-1;i++){
            if(Intervals[i+1][0]<=Intervals[i][1]&&Intervals[i+1][1]>=Intervals[i][1]){
              Intervals[i+1][0]=Intervals[i][0];
            }
            else if(Intervals[i+1][0]<=Intervals[i][1]&&Intervals[i+1][1]<Intervals[i][1]){
                Intervals[i+1][0]=Intervals[i][0];
                Intervals[i+1][1]=Intervals[i][1];
            }
            else{
                count++;
                ans[k][0]=Intervals[i][0];
                ans[k++][1]=Intervals[i][1];
            }
        }
        count++;
        ans[k][0]=Intervals[Intervals.length-1][0];
        ans[k++][1]=Intervals[Intervals.length-1][1];
        ans=Arrays.copyOf(ans,count);
        return ans;
    }
}