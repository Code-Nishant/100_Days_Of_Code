//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
          String s = "1";     

        

        while(n > 1){

        char ch=s.charAt(0);

        int count=0;

        String num="";

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == ch){

                count++;

                if(i == s.length()-1){

                    num += String.valueOf(count)+String.valueOf(ch);

             //       s=num;

             //       num="";

                }

            }

            else{

                num+=String.valueOf(count)+String.valueOf(ch);

                count=1;

                ch=s.charAt(i);

                if(i == s.length()-1){

                    num += String.valueOf(count)+String.valueOf(ch);

                }

                }

             }

             n--;

             s=num;            

        }

        return s;    
    }
}
