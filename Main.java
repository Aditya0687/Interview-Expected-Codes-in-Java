package com.company;
import java.util.*;
public class Main {
    public static class Edge implements Comparable<Edge>
    {
        int v1;
        int v2;
        int weight;
        public Edge(int v1,int v2,int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static Edge[] kruskalsAlgo(Edge[] edges,int[] parent,int V) {
        Edge mst[] = new Edge[V-1];
        int count = 0 ;
        int i = 0 ;
        while (count!=V-1){
            Edge cE = edges[i++];
            int v1Parent = findParent(cE.v1,parent);
            int v2Parent = findParent(cE.v2,parent);
            if(v1Parent!=v2Parent){
                //INCLUDE THE CURRENT EDGE
                mst[count] = cE;
                parent[v1Parent] = v2Parent;
                count++;
            }
        }

        return mst;
    }

    public static int findParent(int v,int[] parent) {
        if(v==parent[v]){
            return v;
        }
           return findParent(parent[v],parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Edge[] edges = new Edge[E];
        for(int i=0;i<E;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            Edge edge = new Edge(v1,v2,weight);
            edges[i] = edge;
        }
        Arrays.sort(edges);
        int[] parents = new int[V];
        for(int j =0 ;j<V;j++){
            parents[j] = j;
        }
        Edge[] res = kruskalsAlgo(edges,parents,V);
        for (Edge re : res) {
            System.out.println(re.v1 + " " + re.v2 + " " + re.weight);
        }
    }
}

