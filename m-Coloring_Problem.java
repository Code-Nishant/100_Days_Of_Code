

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
