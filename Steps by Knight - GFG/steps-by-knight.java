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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Node{
    int row;
    int col;
    int  time;
    Node( int row, int col, int time) {
        this.row= row;
        this.col = col;
        this.time= time;
    }
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int [][]  visited = new int[N][N];
        int [][] Matrix = new int[N][N];
        int TargetRow= TargetPos[0]-1;
        int TargetCol = TargetPos[1]-1;
        if(TargetRow == KnightPos[0]-1 && TargetCol == KnightPos[1]-1) return 0; 
        Node node= new Node(KnightPos[0]-1, KnightPos[1]-1, 0);
        Queue<Node> queue= new LinkedList<>();
        int delRow [] = {-2, -2, -1, 1, 2, 2, 1, -1};
        int delCol [] = {-1, 1, 2, 2, 1, -1, -2, -2};
        queue.add(node);
        visited[KnightPos[0]-1][KnightPos[1]-1] = 1;

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            // System.out.println("row is "+ row + " col is "+ col + " time is "+ time);

            queue.remove();
            int NRow= 0, NCol = 0;
            
            for(int i=0; i<8; i++){
                NRow = row + delRow[i];
                NCol = col + delCol[i];
                if(NRow >=0 && NRow < N && NCol >= 0 && NCol < N && visited[NRow][NCol] == 0){
                    // System.out.println("NRow is "+ NRow + " NCol is "+ NCol);
                    if(NRow == TargetRow && NCol == TargetCol){ return time+1;}
                    Node newnode= new Node(NRow, NCol , time + 1);
                    queue.add(newnode);
                    visited[NRow][NCol] = 1;
                }

            }

        }
        return -1;
    }
}