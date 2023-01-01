class Solution{
   static int minimumNumberOfSwaps(String S){
       int swap=0;
       int count=0;
       for(int i=0;i<S.length();i++){
           if(S.charAt(i)=='['){
               count--;
           }
           if(S.charAt(i)==']'){
               count++;
               if(count>0){
                   swap+=count;
               }
           }
       }
       return swap;
       // code here
   }
}
