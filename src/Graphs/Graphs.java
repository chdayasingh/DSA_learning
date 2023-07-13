package Graphs;

import java.util.*;

public class Graphs {
    //    space complex - O(V^2)
    public static int[][] createAdjMatrix(int vertex, int edges, Scanner sc){
        int[][] adjMatrix = new int[vertex][vertex];

        for(int i=0; i<edges; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        return adjMatrix;
    }

    public static void printAdjMatrix(int[][] adjMatrix){
        for(int i=0; i<adjMatrix.length; i++){
            for(int j=0; j<adjMatrix.length; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //    TC = O(v^2)
    public static void dfTraversal(int[][] adjMatrix){
        // creating a visited boolean array to keep track that the vertex is visited or not
        boolean[] visited = new boolean[adjMatrix.length];

        System.out.print("Depth First Traversal : ");

        // by writing only one call of dfs from 0 might be not print all vertices in case of disconnected graphs because it might happen disconnected component not call
//        dfTraversal(adjMatrix, visited, 0);

//        to work for disconnected graph
        for(int i=0; i<adjMatrix.length; i++){
            if(!visited[i]){
                dfTraversal(adjMatrix, visited, i);
                System.out.println();
            }
        }

//        System.out.println();
    }

    // Helper function for dfTraversal
    private static void dfTraversal(int[][] adjMatrix, boolean[]visited, int currentVertex){
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true; // after printing the vertex , mark that visited

        // finding the neighbour of current vertex by traversing that row in adj matrix
        for(int j=0; j< adjMatrix.length; j++){
            if(adjMatrix[currentVertex][j] == 1 && !visited[j]){
                // if j is the neighbour and its unvisited then call recursion on neighbour
                dfTraversal(adjMatrix, visited, j);
            }
        }
    }

    public static void dfTraversalIterative(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        System.out.print("Depth First Traversal (Iterative): ");

        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    int currentVertex = stack.pop();
                    if (!visited[currentVertex]) {
                        System.out.print(currentVertex + " ");
                        visited[currentVertex] = true;

                        for (int j = adjMatrix.length - 1; j >= 0; j--) {
                            if (adjMatrix[currentVertex][j] == 1 && !visited[j]) {
                                stack.push(j);
                            }
                        }
                    }
                }
            }
        }

        System.out.println();
    }


    //    TC = O(v^2)
    public static void bfTraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        System.out.print("Breadth first Traversal : ");

        Queue<Integer> pendingVertex = new LinkedList<>();
        // below for loop only for traversing all the element in case of disconnected graph
        for(int i=0; i< adjMatrix.length; i++){
            if(!visited[i]){
                pendingVertex.add(i);
                visited[i] = true;

                while (!pendingVertex.isEmpty()){
                    int currentVertex = pendingVertex.poll();
                    System.out.print(currentVertex + " ");
                    // finding the neighbour of current vertex by traversing that row in adj matrix
                    for(int j=0; j< adjMatrix.length; j++){
                        if(adjMatrix[currentVertex][j] == 1 && !visited[j]){
                            // if j is the neighbour of currentVertex and its unvisited
                            // then add to the queue and marked as visited (so that this vertex will not repeat in queue)
                            pendingVertex.add(j);
                            visited[j] = true;
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    // Has Path between two vertices using DFS and BFS

    public static boolean hasPathDFS(int[][] adjMatrix, int sv, int ev){
        boolean[] visited = new boolean[adjMatrix.length];

        return hasPathDFS(adjMatrix, visited, sv, ev);
    }

    private static boolean hasPathDFS(int[][] adjMatrix, boolean[] visited, int sv, int ev) {
        visited[sv] = true;

        // checking direct path between starting vertex and ending vertex
        if(adjMatrix[sv][ev] == 1) return true;

        // finding the neighbour of current vertex by traversing that row in adj matrix
        for(int j=0; j<adjMatrix.length; j++){
            if(adjMatrix[sv][j] == 1 && !visited[j]){
                // if the neighbour has path to ev then return true else check for other neighbour has path to ev or not
                if(hasPathDFS(adjMatrix, visited, j, ev)){
                    return true;
                }
            }
        }
        // if all neighbour doesn't have path to ev then
        return false;
    }

    public static boolean hasPathBFS(int[][] adjMatrix, int sv, int ev){

        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> pendingVertex = new LinkedList<>();

        pendingVertex.add(sv);
        visited[sv] = true; // mark the sv as visited

        while (!pendingVertex.isEmpty()){
            int currentVertex = pendingVertex.poll();
            if(adjMatrix[currentVertex][ev] == 1) return true;

            for(int j=0; j< adjMatrix.length; j++){
                if(adjMatrix[currentVertex][j] == 1 && !visited[j]){
                    pendingVertex.add(j);
                    visited[j] = true;
                }
            }
        }
        return false;
    }


//    getPath - from starting vertex start traversing (in DFS or BFS) if we reach to end vertex then return the path(in arraylist) else return null

    // working- getting path in string and then converting to arraylist, sending path till now to recursion and getting actual path
    public static ArrayList<Integer> getPathUsingDFS1(int[][] adjMatrix, int sv, int ev){
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[adjMatrix.length];

        String pathInString = getPathUsingDFS1helper(adjMatrix, visited, sv, ev, "");

        // convert path from string to ArrayList in reverse order
        for(int i=pathInString.length()-1; i>=0; i--){
            char ch = pathInString.charAt(i);
            path.add(Character.getNumericValue(ch));
        }
        return path;
    }

    private static String getPathUsingDFS1helper(int[][] adjMatrix, boolean[] visited, int sv, int ev, String str){
        visited[sv] = true;
        str = str + sv;

        if(adjMatrix[sv][ev] == 1) return str + ev;

        for(int j=0; j<adjMatrix.length; j++){
            if(adjMatrix[sv][j] == 1 && !visited[j]){
                // ask unvisited neighbour to give path to ev
                String ans = getPathUsingDFS1helper(adjMatrix, visited, j, ev, str);
                // if neighbour gives the path then return it else ask from another unvisited neighbour
                if(!ans.isEmpty()){
                    return ans;
                }
            }
        }
        // if all unvisited neighbour doesn't have path to ev then
        return "";
    }

    // improved
    public static ArrayList<Integer> getPathUsingDFS2(int[][] adjMatrix, int sv, int ev){
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[adjMatrix.length];

        return getPathUsingDFS2helper(adjMatrix, visited, sv, ev);
    }

    private static ArrayList<Integer> getPathUsingDFS2helper(int[][] adjMatrix, boolean[] visited, int sv, int ev) {
        visited[sv] = true;

        // sv and ev are same then we found the path ,return arraylist with adding ev to it
        // or we can check there is direct path between sv and ev , in this case we need to add both into the arraylist
        if(sv == ev){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(ev);
            return ans;
        }
        // checking sv's unvisited neighbour has path to ev or not, if yes then add sv to path and return it
        for(int j=0; j<adjMatrix.length; j++){
            if(adjMatrix[sv][j] == 1 && !visited[j]){
                ArrayList<Integer> smallAns = getPathUsingDFS2helper(adjMatrix, visited, j, ev);
                if(smallAns != null){
                    smallAns.add(sv);
                    return smallAns;
                }
            }
        }
        // we all the unvisited neigbour have no path to ev then return null
        return null;
    }

    public static ArrayList<Integer> getPathUsingBFS(int[][] adjMatrix, int sv, int ev){
        // algo -
        // start bfs from sv
        // if we get ev during bfs then stop bfs
        // note path using map ( which we are creating while doing bfs)

        boolean[] visited = new boolean[adjMatrix.length];

        Queue<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.add(sv);
        visited[sv] = true;

        // maintaing map to keep track to parentvertex of vertex {(sv, -1), ......} // this will helps us to rebuild path when we reach to ev during bfs
        // format - (vertex -> parentvertex)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sv, -1);

        while (!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            if (adjMatrix[currentVertex][ev] == 1){
//                visited[ev] = true; // optional
                map.put(ev, currentVertex);
                break;
            }
            for(int j=0; j<adjMatrix.length; j++){
                if(adjMatrix[currentVertex][j] == 1 && !visited[j]){
                    pendingVertices.add(j);
                    visited[j] = true;
                    map.put(j, currentVertex);
                }
            }
        }
        // if we reach to ev then path found and we need to rebuild the path using map
        if(map.containsKey(ev)){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(ev);
            int v = ev;
            while(map.get(v) != -1){
                v = map.get(v);
                path.add(v);
            }
            return path;
        }
        // if we don't reach to ev then path not found
        return null;
    }


    public static boolean isConnectedNaive(int[][] adjMatrix){
//        connected graph - if there is path exist between every two vertexes
//        Naive approach - choose a source vertex like 0, and try to find the path between 0 and other vertices
//        if all path exist its means connected else disconnected
//        Here, we are doing lot of work

        for(int i=1; i<adjMatrix.length; i++){
            if(!hasPathDFS(adjMatrix, 0, i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isConnected(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        // doing df traversal and mark the vertex visited if we traverse to it
        isConnectedHelper(adjMatrix, visited, 0);

//        checking the visited array, if all are visited its means connected else disconnected
        for(boolean i: visited){
            if(!i){
                return false;
            }
        }
        return true;
    }

    // DFS Function
    private static void isConnectedHelper(int[][] adjMatrix, boolean[] visited, int currentVertex) {
        visited[currentVertex] = true;

        // finding the neighbour of current vertex by traversing that row in adj matrix
        for(int j=0; j< adjMatrix.length; j++){
            if(adjMatrix[currentVertex][j] == 1 && !visited[j]){
                // if j is the neighbour and its unvisited then call recursion on neighbour
                isConnectedHelper(adjMatrix, visited, j);
            }
        }
    }


//  count the number of connected groups of islands
//  A group of islands is said to be connected if we can reach from any given island to any other island in the same group
    public static int numConnected(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];

        // count the num of times dfs called (this will count the num of connected component in the graph)
        int count = 0;

        for(int i=0; i<adjMatrix.length; i++){
            if(!visited[i]){
                // DFS traversal
                isConnectedHelper(adjMatrix, visited, i);
                count++;
            }
        }
        return count;
    }


    public static void displayMenu(int[][] adjMatrix, Scanner sc) {
        int choice;
        do {
            System.out.println("\n----- Graph Operations Menu -----");
            System.out.println("1. Print Adjacency Matrix");
            System.out.println("2. Add Edge");
            System.out.println("3. Depth-First Traversal Recursive");
            System.out.println("4. Depth-First Traversal Iterative");
            System.out.println("5. Breadth-First Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----Adjacency_Matrix------");
                    printAdjMatrix(adjMatrix);
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    int source = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int destination = sc.nextInt();
                    adjMatrix[source][destination] = 1;
                    adjMatrix[destination][source] = 1;
                    break;
                case 3:
                    dfTraversal(adjMatrix);
                    break;
                case 4:
                    dfTraversalIterative(adjMatrix);
                    break;
                case 5:
                    bfTraversal(adjMatrix);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }


    public static void main(String[] args) {
        System.out.println("Take input for Graph called: \nFor Hard code input, copy below input and paste - \n10 11\n0 1 0 2 0 3 1 4 1 5 1 9 2 4 2 6 2 7 3 6 3 8");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertex , no. of edges (separate by space) and give input");
        int v = sc.nextInt();
//        System.out.println("Enter no. of edges");
        int e = sc.nextInt();
        int[][] adjMatrix = createAdjMatrix(v, e, sc);

        displayMenu(adjMatrix, sc);

        // eg input1 - 6 5 0 1 0 2 0 3 1 4 2 5
        // eg input2 - 7 7 0 4 0 2 0 3 4 5 2 1 3 6 5 1
        // 6 7 0 1 0 2 0 3 1 4 2 5 1 3 2 3


//        System.out.println("----Adjacency_Matrix------");
//        printAdjMatrix(adjMatrix);
//
//        dfTraversal(adjMatrix);


//        bfTraversal(adjMatrix);
//        System.out.println(hasPathBFS(adjMatrix, sc.nextInt(), sc.nextInt()));

//        System.out.println(getPathUsingDFS1(adjMatrix, sc.nextInt(), sc.nextInt()).toString());
//        eg input- 6 6 0 1 1 4 4 5 1 2 2 3 0 3
//        sv = 0, ev = 5
//        System.out.println(getPathUsingDFS2(adjMatrix, sc.nextInt(), sc.nextInt()).toString());

//        System.out.println(getPathUsingBFS(adjMatrix, sc.nextInt(), sc.nextInt()).toString());

//        System.out.println(isConnectedNaive(adjMatrix));
//        System.out.println(isConnected(adjMatrix));

//        System.out.println(numConnected(adjMatrix));
    }
}
