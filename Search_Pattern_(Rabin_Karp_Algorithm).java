class Solution

{

 ArrayList<Integer> search(String pat, String s)

    {

     ArrayList<Integer>list=new ArrayList<>();   // your code here

        int l1=s.length();  int l2=pat.length();

      for(int i=0;i<l1-l2+1;i++){

           String str=s.substring(i,i+l2);

           if(str.equals(pat))

           list.add(i+1);

        }

        if(list.isEmpty())

           list.add(-1);

             return list;

    }

}
