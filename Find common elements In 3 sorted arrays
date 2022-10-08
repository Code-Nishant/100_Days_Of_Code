class Solution
{
    ArrayList<Integer> commonElements(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3) 
    {
        int i = 0, j = 0, k = 0;
        int prev1, prev2, prev3;
        ArrayList<Integer> arr=new ArrayList<Integer> ();
        prev1 = prev2 = prev3 = Integer.MIN_VALUE;
 
        while (i < n1 && j < n2 && k < n3) {
            while (i < n1 && ar1[i] == prev1)
                i++;
            while (j < n2 && ar2[j] == prev2)
                j++;
            while (k < n3 && ar3[k] == prev3)
                k++;
 
            if (i < n1 && j < n2 && k < n3) {
                if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                    arr.add(ar1[i]);
                    prev1 = ar1[i];
                    prev2 = ar2[j];
                    prev3 = ar3[k];
                    i++;
                    j++;
                    k++;
                }
                else if (ar1[i] < ar2[j]) {
                    prev1 = ar1[i];
                    i++;
                }
                else if (ar2[j] < ar3[k]) {
                    prev2 = ar2[j];
                    j++;
                }
                else {
                    prev3 = ar3[k];
                    k++;
                }
            }
        }
        if(arr.size()==0){
            return new ArrayList<Integer>();
        }
        else{
        return arr;
        }
    }
}
