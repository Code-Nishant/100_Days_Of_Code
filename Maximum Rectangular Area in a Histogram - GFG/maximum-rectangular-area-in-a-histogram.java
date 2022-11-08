//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long next[]=new long[hist.length];
        long prev[]=new long[hist.length];
        
        long area=Integer.MIN_VALUE;
        next=nextSmaller(hist,n);
        prev=prevSmaller(hist,n);
        
        for(int i=0;i<n;i++){
            long len=hist[i];
            
            if(next[i]==-1){
                next[i]=n;
            }
            long bre= next[i]-prev[i]-1;
            
            long newArea= len*bre;
            area=Math.max(area, newArea);
        }
        return area;
        
    }
    public static long[] nextSmaller(long hist[],long n){
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        long ans[]=new long[hist.length];
        
        for(int i=hist.length-1;i>=0;i--){
            while(s.peek()!=-1 && hist[s.peek()]>=hist[i]){
                s.pop();
            }
            ans[i]=s.peek();
            s.push(i);
        }
        return ans;
    }
    public static long[] prevSmaller(long hist[],long n){
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        long ans[]=new long[hist.length];
        
        for(int i=0;i<hist.length;i++){
            while(s.peek()!=-1 && hist[s.peek()]>=hist[i]){
                s.pop();
            }
            ans[i]=s.peek();
            s.push(i);
        }
        return ans;
    }
        
}



