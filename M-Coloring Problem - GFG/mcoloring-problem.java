//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[]=new int[n];
        if(solve(graph,0,m,n,color)) return true;
        
        return false;
    }
    
     public boolean solve(boolean graph[][],int node,int m, int v,int color[]){
         
        // Base case
        
        if(node==v){
            
        return true;
        }
        
        // trying all the possible combination of the m
        
        for(int i=1; i<=m;i++){
            
        if(isValid(graph,i,color,node)) {
            color[node]=i;
            
            if(solve(graph,node+1,m,v,color)) {
                return true;
            }
            else {
                color[node]=0;
            }
            
            
        }    
            
        }
        return false;
         
        }
     
     public boolean isValid(boolean graph[][],int col,int color[],int node ){
         
         // take out the respective vertices for the vertex
         
        for(int i=0; i<graph[node].length;i++){
            if(graph[node][i]==true) {
                if(color[i]==col) return false;
            }
        }
         
         return true;
     }
}