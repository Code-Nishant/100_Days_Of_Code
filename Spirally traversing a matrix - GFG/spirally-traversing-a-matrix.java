//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(matrix.length==0){
            return list;
        }
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        int direction=0;
        
        int left=0,right=col-1,top=0,bottom=row-1;
        
        while(left<=right&&top<=bottom){
            if(direction==0){
                for(int i=left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
                direction=1;
                top++;
            }
            else if(direction==1){
                for(int i=top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
                direction=2;
                right--;
            }
            else if(direction==2){
               for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                } 
                direction=3;
                bottom--;
            }
            else if(direction==3){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                direction=0;
                left++;
            }
        }
        return list;
    }
}
