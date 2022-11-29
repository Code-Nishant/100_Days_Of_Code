//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    List<Node> res = obj.printAllDups(root);
		    for(int i = 0;i<res.size();i++){
		        preorder(res.get(i));
		        System.out.println();
		    }
		    
		}
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution{
   class Pair{
        Node n;
        int count;
        Pair(Node n,int count){
           this.n = n;
           this.count = count;
        }
    }
    Map<String,Pair> map = new TreeMap<>((a,b)->a.compareTo(b));
    public List<Node> printAllDups(Node root)
    {
        List<Node> ans = new ArrayList<>();
       
        getDup(root);
        for(Map.Entry<String,Pair> entry : map.entrySet()){
            if(entry.getValue().count > 1){
                ans.add(entry.getValue().n);
            }
        }
        Collections.sort(ans,(a,b)->(a.data - b.data));
        return ans;
    }
    
    String getDup(Node root){
        if(root == null)return "$";
        String s = root.data+" ";
        s += getDup(root.left)+" ";
        s += getDup(root.right)+ " ";
        if(map.containsKey(s)){
            Pair curr = map.get(s);
            curr.count++;
            map.put(s,curr);
        }else{
            map.put(s,new Pair(root,1));
        }
        return s;
    }
    
}