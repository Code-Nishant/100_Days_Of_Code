class Solution {
    public List<List<Integer>> generate(int numRows) {
       if(numRows==0){
           return new ArrayList();
       } 
        List<List<Integer>> pascal=new ArrayList();
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(j==0||j==i-1){
                    row.add(1);
                }
                else{
                    row.add((pascal.get(i-2).get(j))+(pascal.get(i-2).get(j-1)));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}