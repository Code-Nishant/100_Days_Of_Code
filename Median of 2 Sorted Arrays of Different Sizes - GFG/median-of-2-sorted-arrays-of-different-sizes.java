//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int nums1[], int nums2[]) 
    {
        // Your Code Here
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2)
            return medianOfArrays(len1,len2,nums2, nums1);
 
        int low = 0;
        int high = len1;

 
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;
            
            int l1= (mid1 > 0) ? nums1[mid1 - 1]: Integer.MIN_VALUE;
            int l2= (mid2 > 0) ? nums2[mid2 - 1]: Integer.MIN_VALUE;
            int r1= (mid1 < len1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2= (mid2 < len2) ? nums2[mid2] : Integer.MAX_VALUE;
 
            
            if (l1 <= r2 && l2 <= r1) {
                if ((len1 + len2) % 2 == 0)
                    return (Math.max(l1, l2)
                            + Math.min(r1, r2))
                            / 2.0;
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else
                low = mid1 + 1;
        }
        return 0.0;
        
        
        // int len1=nums1.length;
        // int len2=nums2.length;
        
        // if(len1>len2){
        //     return medianOfArrays(len1,len2,nums2,nums1);
        // }
        
        // int low=0;
        // int high=len1;
        // while(low<=high){
        //     int mid1=(low+high)/2;
        //     int mid2=((len2+len1+1)/2)-mid1;
            
        //     int l1=(mid1<0)?Integer.MIN_VALUE:nums1[mid1-1];
        //     int l2=(mid2<0)?Integer.MIN_VALUE:nums2[mid2-1];
        //     int r1=(mid1>len1)?Integer.MAX_VALUE:nums1[mid1];
        //     int r2=(mid2>len2)?Integer.MAX_VALUE:nums2[mid2];
            
        //     if(l1>r2){
        //         high= mid1-1;
        //     }
        //     else if(l2>r1){
        //         low=mid1+1;
        //     }
        //     else{
        //         if((len1+len2)/2==0){
        //             return ((Math.min(l1,l2)+Math.max(r1,r2))/2);
        //         }
        //         else{
        //             Math.max(l1,l2);
        //         }
        //     }
        // }
        // return 0.0;
    }
}