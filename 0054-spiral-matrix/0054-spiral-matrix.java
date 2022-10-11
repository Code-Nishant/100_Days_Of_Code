import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list=new ArrayList<Integer>();
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