class Solution {
    public void rotate(int[][] matrix) {
        int len1=matrix.length;
        int len2=matrix[0].length;
        
        for(int i=0;i<len1;i++){
            for(int j=i;j<len2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<len1;i++){
            int low=0;int high=len1-1;
            while(low<high){
                int temp=matrix[i][low];
                matrix[i][low]=matrix[i][high];
                matrix[i][high]=temp;
                low++;
                high--;
            }
        }
    }
}