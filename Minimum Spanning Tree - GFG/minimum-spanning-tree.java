//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int ans = 0;
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for(int i=0;i<V;i++){
            int mini = Integer.MAX_VALUE;
            int node = 0;
            for(int j=0;j<V;j++){
                if(mst[j] == false && key[j] < mini){
                    mini=key[j];
                    node = j;
                }
            }
            ans += mini;
            mst[node] = true;
            for(int k=0;k<adj.get(node).size();k++){
                if((mst[adj.get(node).get(k).get(0)] == false) && (key[adj.get(node).get(k).get(0)] > adj.get(node).get(k).get(1))){
                    key[adj.get(node).get(k).get(0)] = adj.get(node).get(k).get(1);
                }
            }
        }
        return ans;
    }
}
