class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return findMedianSortedArrays(B, A); // Swapping to make A smaller
 
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? A[leftAsize - 1]
                    : Integer.MIN_VALUE; // checking overflow of indices
            int leftB
                    = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA
                    = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB
                    = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;
 
            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
        else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
        
        
        
        
        
//         int len1=nums1.length;
//         int len2=nums2.length;
        
//         // if(len1>len2){
//         //     return findMedianSortedArrays(nums2,nums1);
//         // }
        
//         int low=0;
//         int high=len1;
//         while(low<=high){
//             int mid1=(low+high)/2;
//             int mid2=((len2+len1+1)/2)-mid1;
            
//             int l1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
//             int l2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
//             int r1=(mid1==len1)?Integer.MAX_VALUE:nums1[mid1];
//             int r2=(mid2==len2)?Integer.MAX_VALUE:nums2[mid2];
            
//             if(l1>r2){
//                 high= mid1-1;
//             }
//             else if(l2>r1){
//                 low=mid1+1;
//             }
//             else{
//                 if((len1+len2)/2==0){
//                     return ((Math.min(l1,l2)+Math.max(r1,r2))/2);
//                 }
//                 else{
//                     Math.max(l1,l2);
//                 }
//             }
//         }
//         return 0.0;
    }
}