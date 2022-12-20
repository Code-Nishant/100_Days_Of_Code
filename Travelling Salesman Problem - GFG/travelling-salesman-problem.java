//{ Driver Code Starts
//Initial Template for Java

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
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int total_cost(int[][] cost)
    {
        // Code here 
        int n = cost.length;
        int min = Integer.MAX_VALUE;
        boolean vis[] = new boolean[n];
       
        return helper(0, vis, cost, n);
    }
    int helper(int indx, boolean vis[], int cost[][], int n) {
       int min = Integer.MAX_VALUE;
       vis[indx] = true;int calls = 0;
       for (int i=0; i<n; i++) {
           if (i != indx && !vis[i]) {
               calls++;
               int ans = cost[indx][i] + helper(i, vis, cost, n);
               min = Math.min(min, ans);
           }
       }
       vis[indx] = false;
       if (calls == 0) {
           return cost[indx][0];
       }
       return min;
   }
}