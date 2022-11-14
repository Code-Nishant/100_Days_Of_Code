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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int tm=0;
        int drow[]={-1,0,+1,0};
        int dcol[]={0,+1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().r;
            int col=q.peek().c;
            int time=q.peek().t;
            tm=Math.max(time,tm);
            q.poll();
            for(int i=0;i<4;i++){
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0 && r<n && c>=0 && c<m && vis[r][c]==0&& grid[r][c]==1){
                    q.add(new Pair(r,c,time+1));
                    vis[r][c]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh){
            return -1;
        }
        return tm;
    }
}
class Pair{
    int r,c,t;
    public Pair(int _r,int _c,int _t){
        r=_r;
        c=_c;
        t=_t;
    }
}