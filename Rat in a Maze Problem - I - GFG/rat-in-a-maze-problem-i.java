//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
         ArrayList<String> result = new ArrayList<>();
        findPathHelper(m, 0, 0, result, n, "");
        return result.size() > 0 ? result : new ArrayList<>(List.of("-1"));
    }
     private static void findPathHelper(int[][] maze, int row, int col, ArrayList<String> result, int n, String sb) {
        if(row == n - 1 && col == n - 1 && maze[n-1][n-1] == 1) {
            result.add(sb);
            return;
        }
        if(row >= maze.length || row < 0 || col >= maze[0].length || col < 0 || maze[row][col] != 1) {
            return;
        }
        maze[row][col] += 100;
        findPathHelper(maze,row + 1, col, result, n, sb + 'D');
        findPathHelper(maze,row - 1, col, result, n, sb + 'U');
        findPathHelper(maze,row, col + 1, result, n, sb + 'R');
        findPathHelper(maze,row, col - 1, result, n, sb + 'L');
        maze[row][col] -= 100;
    }
}