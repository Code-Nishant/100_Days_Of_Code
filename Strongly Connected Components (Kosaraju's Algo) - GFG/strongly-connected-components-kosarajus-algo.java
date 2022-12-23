//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
         boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int u = 0; u < V; u++){
            if(!visited[u]){
                DFS(adj, u, st, visited);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i<V; i++){
            transpose.add(new ArrayList<>());
        }
        for(int u = 0; u < V; u++){
            visited[u] = false;
            for(int v : adj.get(u)){
                transpose.get(v).add(u);
            }
        }
      
        int ans = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            if(!visited[u]){
                revDFS(transpose, u, visited);
                ans++;
            }
        }
        return ans;
    }
    void DFS(ArrayList<ArrayList<Integer>> adj, int u,Stack<Integer> st, boolean visited[]) 
    { 	
        visited[u] = true;
        for(int v:adj.get(u)){
            if(!visited[v])
                DFS(adj, v, st, visited);
        }
        st.push(new Integer(u));
    }
    
    void revDFS(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[]) 
    { 	
        visited[u] = true;
        for(int v:adj.get(u)){
            if(!visited[v])
                revDFS(adj, v, visited);
        }
    }
}
