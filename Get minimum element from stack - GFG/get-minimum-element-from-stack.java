//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> st= new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    if(st.isEmpty()){
	        return -1;
	        
	    }
	    else{
	        return minEle;
	    }
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	    if(st.isEmpty()){
	        return -1;
	    }
	    else if(st.peek()>=minEle){
	        return st.pop();
	    }
	    else{
	        int a = minEle;
	        minEle = 2*minEle-st.peek();
	        st.pop();
	        return a;
	    }
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	    if(st.isEmpty()){
	        minEle = x;
	        st.push(x);
	    }
	    else if(x>=minEle){
	        st.push(x);
	    }
	    else{
	        st.push(2*x-minEle);
	        minEle=x;
	    }
    }	
}