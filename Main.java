package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] maze = {{1,1,0},{1,1,0},{0,1,1}};
        int n = maze.length;
        int[][] path = new int[n][n];
        printPath(maze,0,0,path);
    }

    private static boolean ratInMazeSolve(int[][] maze) {
        int n = maze.length;
        int[][] path = new int[n][n];
        return mazeSolver(maze,0,0,path);
    }

    private static boolean mazeSolver(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 ||path[i][j]==1){
            return false;
        }
        path[i][j] = 1;
        if(i==n-1 && j==n-1) {
            return true;
        }
        boolean top =  mazeSolver(maze,i-1,j,path);
        boolean right = mazeSolver(maze,i,j+1,path);
        boolean down = mazeSolver(maze,i+1,j,path);
        boolean left = mazeSolver(maze,i,j-1,path);
        return top || right || down || left;
    }

    private static void printPath(int[][] maze, int i, int j, int[][] path) {
        int n = maze.length;
        if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 ||path[i][j]==1){
            return;
        }
        path[i][j] = 1;

        if(i==n-1 && j==n-1) {
            for (int r=0;r<n;r++){
                for(int c=0;c<n;c++) {
                    System.out.print(path[r][c] + " ");
                }
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }
        //Top
        printPath(maze,i-1,j,path);
        //Right
        printPath(maze,i,j+1,path);
        //Down
        printPath(maze,i+1,j,path);
        //Left
        printPath(maze,i,j-1,path);
        path[i][j] = 0;
    }
}
