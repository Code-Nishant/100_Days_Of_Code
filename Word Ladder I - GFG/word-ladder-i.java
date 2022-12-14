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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        int levels=1;
        Set<String> set=new HashSet<>();
        Set<String> vis=new HashSet<>();
        for(String a : wordList) set.add(a);
        vis.add(startWord);
        Queue<String> q=new ArrayDeque<>();
        q.add(startWord);
        
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String temp=q.remove();
                if(temp.equals(targetWord)) return levels;
                char arr[]=temp.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char og=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String transition=String.valueOf(arr);
                        if(set.contains(transition) && !vis.contains(transition)){
                            vis.add(transition);
                            q.add(transition);
                        }
                    }
                    arr[j]=og;
                }
            }
            levels++;
        }
        return 0;
    }
}