//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long mod = (long)1e9+7;
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        if(n == 1) {
    		ArrayList<Long> ans = new ArrayList<>();
    		ans.add(Long.valueOf(1));
    		return ans;
    	}else {
    		ArrayList<Long> nthRowOfPascalTriangle = nthRowOfPascalTriangle(n - 1);
    		ArrayList<Long> temp = new ArrayList<>();
    		temp.add(Long.valueOf(1));
    		int s = nthRowOfPascalTriangle.size();
    		int i = 0;
    		while((i + 1) < s) {
    			temp.add((nthRowOfPascalTriangle.get(i) + nthRowOfPascalTriangle.get(i + 1)) % mod);
    			i++;
    		}
    		temp.add(Long.valueOf(1));
    		return temp;
    	}
    }
}