//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean[] vis = new boolean[v];
        int[] dis = new int[v]; //discovery time
        int[] low = new int[v]; //low value
        ArrayList < int[] > ans = new ArrayList < > ();
        // for (int i = 0; i < v; i++)
        //     if (!vis[i])
        //         findBridge(i, adj, low, dis, vis, -1, ans, 0);
                
                 findBridge(c, adj, low, dis, vis, -1, ans, 0);
        for (int[] i: ans) {
            int a = i[0], b = i[1];
            if ((a == c && b == d) || (a == d && b == c)) return 1;
        }
        return 0;
    }
    static void findBridge(int node, ArrayList < ArrayList < Integer >> adj, int[] low, int[] dis,
        boolean[] vis, int parent, ArrayList < int[] > ans, int time) {
        vis[node] = true;
        dis[node] = low[node] = time++;
        for (int nbr: adj.get(node)) {
            if (nbr == parent) continue;
            if (!vis[nbr]) {
                findBridge(nbr, adj, low, dis, vis, node, ans, time);
                low[node] = Math.min(low[node], low[nbr]);
                if (dis[node] < low[nbr]) {
                    ans.add(new int[] {node,nbr} );
                }
            } else {
                low[node] = Math.min(low[node], dis[nbr]);
            }
        }
    }
}