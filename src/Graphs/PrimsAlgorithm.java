package Graphs;

import java.util.Arrays;
import java.util.Scanner;

// Sample Input
//5 7
//0 1 4
//0 2 8
//1 3 6
//1 2 2
//2 3 3
//2 4 9
//3 4 5

public class PrimsAlgorithm {
    public static int[][] createAdjMatrix(int vertex, int edges, Scanner sc){
        int[][] adjMatrix = new int[vertex][vertex];

        for(int i=0; i<edges; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
        return adjMatrix;
    }
    public static void primsAlgo(int v, int e, int[][] adjMatrix) {
        boolean visited[] = new boolean[v];
        int parent[] = new int[v];
        parent[0] = -1;
        int weight[] = new int[v];
        weight[0] = 0;

        for(int i=1; i<weight.length; i++){
            weight[i] = Integer.MAX_VALUE;
        }

        // iterating v times
        for(int i=0; i<v; i++){
            // finding unvisited minimum weight vertex
            int minVertex = minWeightVertex(weight, visited);
            visited[minVertex] = true;

            // exploring unvisited neighbour of minVertex
            for(int j=0; j<v; j++){
                if(adjMatrix[minVertex][j] > 0 && !visited[j]){
                    if(adjMatrix[minVertex][j] < weight[j]){
                        // update weight and parent
                        weight[j] = adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(parent));
        System.out.println("Edges after converting Graph to MST");
        for(int i=1; i< parent.length; i++){
            System.out.print("(" + parent[i] + ", " + i + ", " + adjMatrix[i][parent[i]] + ") ");
        }
        System.out.println();
    }
    private static int minWeightVertex(int[] weight, boolean[] visited) {
        int minWeight = Integer.MAX_VALUE;
        int minV = -1;
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && weight[i] < minWeight){
                minWeight = weight[i];
                minV = i;
            }
        }
        return minV;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjMatrix = createAdjMatrix(v, e, sc);

        for(int[] i : adjMatrix){
            System.out.println(Arrays.toString(i));
        }
        primsAlgo(v, e, adjMatrix);
    }
}
