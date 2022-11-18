//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Pair implements Comparable<Pair>{
    int count;
    char c;
    Pair(char c,int count){
        this.c=c;
        this.count=count;
    }
    
    public int compareTo(Pair obj){
        return obj.count-this.count;
    }
}

class Solution
{
	public static String rearrangeCharacters(String str) {
	
		//code here
		int len=str.length();
		PriorityQueue<Pair> q=new PriorityQueue<>();
		int[] arr=new int[26];
		int max=0;
		for(int i=0;i<len;i++){
		    char c=str.charAt(i);
		    arr[c-'a']++;
		    max=Math.max(arr[c-'a'],max);
		}
		
		if(max>len/2+1){
		    return "-1";
		}
		
		for(int i=0;i<26;i++){
		    if(arr[i]!=0){
		        q.offer(new Pair((char)(97+i),arr[i]));
		    }
		}
		StringBuilder sb=new StringBuilder();
		
		while(q.size()!=0){
		    Pair t1=q.poll(),t2=null;
		    if(q.size()!=0){
		        t2=q.poll();
		    }
		    if(sb.length()!=0 && sb.charAt(sb.length()-1)==t1.c) return "-1";
		    
		    sb.append(""+t1.c);
		    if(t2!=null){
		        sb.append(""+t2.c);
		    }
		    if(t1.count>1){
		        q.offer(new Pair(t1.c,t1.count-1));
		    }
		    if(t2!=null && t2.count>1){
		        q.offer(new Pair(t2.c,t2.count-1));
		    }
		 
		}
		
		
		return sb.toString();
		
	}
}