//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        boolean vis[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( vis[i][j]== false && grid[i][j]=='1'){
                    cnt++;
                    bfs(vis,i,j,grid);
                }
            }
        }
        return cnt;
    }
    public void bfs(boolean vis[][],int row,int col,char[][] grid){
        vis[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;

        for(int delr=-1;delr<=1;delr++){
            for(int delc=-1;delc<=1;delc++){
                int nrow=row+delr;
                int ncol=col+delc;
                if(nrow>=0 && nrow< n && ncol>=0 && ncol<m && vis[nrow][ncol]==false&& grid[nrow][ncol]=='1'){
                         bfs(vis,nrow,ncol,grid);
                }
            }
        }
    }
}