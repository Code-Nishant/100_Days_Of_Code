//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        int len=x.length();
        //stack object;
        Stack s=new Stack(len);
        
        for(int i=0;i<len;i++){
            char current= x.charAt(i);
            if(isOpening(current)){
                //push inside stack
                s.push(current);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else if(!isMatching(current,s.peek())){
                    return false;
                }
                else{
                    //pop
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }
    
    static boolean isOpening(char ch){
        if(ch=='('||ch=='{'||ch=='['){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean isMatching(char first, char second){
        if((first==')'&&second=='(')||(first=='}'&&second=='{')||(first==']'&&second=='[')){
            return true;
        }
        else{
            return false;
        }
    }
}
class Stack{
    static char arr[];
    public static int top;
    
    Stack(int len){
        arr=new char[len];
        top=-1;
    }
    
    public static boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void push(char ch){
        top=top+1;
        arr[top]=ch;
    }
    public static void pop(){
        top=top-1;
    }
    public static char peek(){
        return arr[top];
    }
}





















