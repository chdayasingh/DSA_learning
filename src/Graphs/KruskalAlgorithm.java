package Graphs;

import java.util.*;

// Using Edge List to store Graph
// Input format:
//6 11
//0 1 1
//0 2 5
//1 3 3
//1 2 6
//2 3 10
//2 4 8
//3 4 7
//2 5 9
//3 5 6
//4 5 2
//0 3 4

class Edge{
    int v1, v2;
    int weight;

    Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}

public class KruskalAlgorithm {
    public static Edge[] takeGraphInputInEdgeList(int e, Scanner sc){
        Edge[] edges = new Edge[e];
        // Taking edge input
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            edges[i] = new Edge(v1, v2, weight);
        }
        return edges;
    }

    public static void printGraph(int v, Edge[] edges){
        // printing vertexes
        System.out.println("Vertexes: " + v + " Edges: " + edges.length);
        for(int i=0; i<v; i++){
            System.out.print("v" + i + " ");
        }
        System.out.println();
        // printing all edges of the graph
        for(Edge curr : edges){
            System.out.print("(" + curr.v1 + ", " + curr.v2 + ", " + curr.weight + ") ");
        }
        System.out.println();
    }

    public static int findParent(int v, int[] parent){
        if(v == parent[v]){
            return v;
        }
        return findParent(parent[v], parent);
    }

    public static Edge[] giveMST(int v, Edge[] edges) {
        // sort the edge list in increasing order
        Arrays.sort(edges, (a, b) -> a.weight-b.weight);

//        printGraph(v, edges);

        // picking edge one by one from the edges and concluding that, it should include in our MST or not
        // To detect cycle - we are using find and union algorithm
        Edge[] mstEdges = new Edge[v-1]; // A MST will contain v-1 edges

        int[] parent = new int[v];   // index - represent vertex , value - represent its parent
        for(int i=0; i<v; i++){
            parent[i] = i;
        }

        int count = 0;
        for (int i=0; count < v-1; i++){
            Edge currEdge = edges[i];
            int v1 = currEdge.v1;
            int v2 = currEdge.v2;
            // finding parent of v1 and v2;
            int pv1 = findParent(v1, parent);
            int pv2 = findParent(v2, parent);

            if(pv1 != pv2){
                // including the edge in MST
                mstEdges[count] = currEdge;
                count++;
                // updating the parent of either vertex to another vertex
                parent[v2] = pv1;
            }
        }
        return mstEdges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // num of vertexes, 0 to v-1
        int e = sc.nextInt(); // num of edges
        Edge[] edges = takeGraphInputInEdgeList(e, sc);

        System.out.println("Input Graph");
        printGraph(v, edges);
        edges = giveMST(v, edges);
        System.out.println("\nAfter converting Graph to MST");
        printGraph(v, edges);
    }

}
