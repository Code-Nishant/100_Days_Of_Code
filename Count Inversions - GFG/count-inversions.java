//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int low = 0;
        int high = (int)(N-1);
        return mergeSort(arr,low,high);
    }
    public static long mergeSort(long []arr,int low,int high){
        long inv =0;
        if(low<high){
            int mid = (low+high)/2;
            inv+=mergeSort(arr,low,mid);
            inv+=mergeSort(arr,mid+1,high);
            inv+=merge(arr,low,mid,high);
        }
        return inv;
    }
    public static long merge(long []arr,int l,int m,int h){
        long inv = 0;
        long []left = new long[m-l+1];
        long []right = new long[h-m];

        for(int i =0;i<left.length;i++){
            left[i] = arr[l+i];
        }
        for(int i =0;i<right.length;i++){
            right[i] = arr[m+1+i];
        }
        int i =0,j=0,k=l;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++]= left[i++];
            }
            else{
                arr[k++]= right[j++];
                //here left[i]>right[j]
                //there is a case of inversion
                inv+= left.length-i;
            }
        }
        while(i<left.length){
            arr[k++]= left[i++];
        }
        while(j<right.length){
            arr[k++]= right[j++];
        }
        return inv;
    }
}