package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

// storing graph in Adjacency List

// sample input:
//    5 2 1 4 2 8 4 0 4 2 2 3 6 4 8 4 0 8 1 2 3 3 4 5 3 1 6 2 3 4 7 3 1 8 2 5 3 7

public class DijikstraAlgorithm {
    public static ArrayList<ArrayList<ArrayList<Integer>>> takeGraphInputAsAdjList(int v, Scanner sc){
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>(v);

        for(int i=0; i<v; i++){
            System.out.println("Enter total num of neigbours of V" + i);
            int neigbours = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(neigbours);
            System.out.println("Enter all the neighbours of V" + i +" with the weight separated by space");
            for(int j=0; j<neigbours; j++){
                ArrayList<Integer> edge = new ArrayList<>(2);
                edge.add(sc.nextInt());
                edge.add(sc.nextInt());
                list.add(edge);
            }
            adjList.add(list);
        }
        return adjList;
    }

    public static void printAdjList(ArrayList<ArrayList<ArrayList<Integer>>> adjList){
        for(int i=0; i<adjList.size(); i++){
            System.out.print(i + ": ");
            for(ArrayList<Integer> edge: adjList.get(i)){
                System.out.print("(" + edge.toString() + "), ");
            }
            System.out.println();
        }
    }

    public static int dijikstraAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adjList, int src, int dest) {
        int v = adjList.size();
        int[] distance = new int[v];
        distance[src] = 0;
        for(int i=0; i<v; i++){
            if(i != src){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++){
            int minVertex = findMinDistanceVertex(visited, distance);
            visited[minVertex] = true;
            // explore minVertex's unvisited neighbour
            for(ArrayList<Integer> neigbour : adjList.get(minVertex)){
                // each neigbour have name and weight/distance from that vertex
                if(!visited[neigbour.get(0)]){

                    int srcToNeigbourDistance = distance[minVertex] + neigbour.get(1); // src->minVertex + minVertex->Neigbour
                    if(srcToNeigbourDistance < distance[neigbour.get(0)]){
                        distance[neigbour.get(0)] = srcToNeigbourDistance;
                    }
                }
            }
        }

        return distance[dest];
    }

    // we can optimise it using min heap / priortiy queue from O(v) to O(logv)
    private static int findMinDistanceVertex(boolean[] visited, int[] distance) {
        int minVertex = -1;
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of vertex: ");
        int v = sc.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = takeGraphInputAsAdjList(v, sc);

        printAdjList(adjList);

        System.out.println(dijikstraAlgo(adjList, 2, 3));
    }
}
