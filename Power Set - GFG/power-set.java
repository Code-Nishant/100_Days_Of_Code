//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
       List<String> ans=new ArrayList<>();
        if(s.length()==1)
        {
            ans.add(s);
            return ans;
        }
        int index=0;
        String str="";
        PossibleStrings(ans,index,str,s);
        ans.remove("");
        Collections.sort(ans);
        return ans;
    }
     static void PossibleStrings(List<String> ans,int index,String str,String s){
        if(index==s.length()){
            ans.add(str);
            return;
        }
        PossibleStrings(ans,index+1,str +s.charAt(index),s);
        PossibleStrings(ans,index+1,str,s);
        return;
    }

}