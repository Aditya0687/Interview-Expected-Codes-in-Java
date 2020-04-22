package com.company;
import java.util.Scanner;
public class Main {
    private static void dfsTravel(int[][] adjMatrix,int cV,boolean[] visited){
        System.out.print(cV+" ");
        visited[cV] = true;
        for(int i=0;i<adjMatrix.length;i++){
            if(adjMatrix[cV][i]==1 && visited[i]==false){
                dfsTravel(adjMatrix,i,visited);
            }
        }
    }
    private static void dfsTraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        dfsTravel(adjMatrix,0,visited);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjMatrix = new int[n][n];
        for(int i=0;i<e;i++){
            int v1  = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        dfsTraversal(adjMatrix);
    }
}
