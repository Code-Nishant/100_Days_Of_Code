//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
        Map<Integer,Integer> ladderMap = new HashMap<>();
        int[] slarr = new int[30];
        Arrays.fill(slarr, 0);
        int k=0; int t=0;
        for (int i=0;i<N;i++) {
            k = arr[2*i];
            t = arr[(2*i)+1];
            if (k < t) {
                ladderMap.put(k-1,t-1);
            }
        }
        
        int dice_cntr = 1;
        int turn_cntr = 1;
        for (int i=1;i<30;i++) {
            if (dice_cntr > 6) {
                dice_cntr = 1;
                turn_cntr++;
            }
            if (ladderMap.get(i) != null) {
                if (slarr[ladderMap.get(i)] == 0)
                    slarr[ladderMap.get(i)] = turn_cntr;
            }
            if (slarr[i] > 0) {
                if (slarr[i] < turn_cntr) {
                    turn_cntr = slarr[i] + 1;
                    dice_cntr = 0;
                }
            } else {
                slarr[i] = turn_cntr;
            }
            dice_cntr++;
        }
        
        return slarr[29];
    }
}