/*
Sample Input:
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output:
1 2 1
0 1 3
0 3 5
*/

package com.company;
import java.util.Scanner;
public class Prims {
    public static int findMinVertex(boolean[] visited,int[] weight){
        int myAns = -1;
        for(int i=0;i<weight.length;i++){
            if(!visited[i] && (myAns==-1 || weight[i]<weight[myAns])){
                myAns = i;
            }
        }
        return myAns;
    }
    public static void primsAlgo(int[][] adjM,int V){
        int[][] mst = new int[V][V];

        boolean[] visited = new boolean[V];

        int[] parent = new int[V];
        parent[0] = -1;

        int[] weight = new int[V];
        weight[0] = 0;
        for(int i=1;i<V;i++){
            weight[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<V;i++){
            int v = findMinVertex(visited,weight);
            visited[v] = true;
            for(int j=0;j<V;j++){
                if(adjM[v][j]>0 && !visited[j]){
                    if(weight[j]>adjM[v][j]){
                        parent[j] = v;
                        weight[j] = adjM[v][j];
                    }
                }
            }
        }
        for(int i=1;i<V;i++){
            if(parent[i]<i)
                System.out.println(parent[i]+" "+i+" "+weight[i]);
            else
                System.out.println(i+" "+parent[i]+" "+weight[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] adjMInput = new int[V][V];
        for(int i=0;i<E;i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int w = s.nextInt();
            adjMInput[v1][v2] = w;
            adjMInput[v2][v1] = w;
        }
        primsAlgo(adjMInput,V);
    }
}
