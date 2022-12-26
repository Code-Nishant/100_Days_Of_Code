class Solution {

    int isPalindrome(String S) {

        for(int i=0,j=S.length()-1;i<S.length() && j>i;i++)

        {

            if(S.charAt(i)==S.charAt(j))

            {

                j--;

            }

            else{

                return 0;

            }

        }

        return 1;

    }

};
