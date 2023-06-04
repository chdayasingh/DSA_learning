package Backtracking;

import java.util.Scanner;

public class RatMaze {

    //    Utility methods
    private static int[][] take2DArrayInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns : ");
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        return arr;
    }
    public static void print2DAray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // move to next line after each row
        }
    }


//    check there exist a path or not
    public static boolean isPathExist(int[][] maze, int si, int sj, int di, int dj){
        // to prevent taking step that we alredy cover
        int[][] path = new int[maze.length][maze.length];
        boolean ans = ratInAMaze(maze, path, si, sj, di, dj);
        return ans;
    }

    // No backtracking needed for path exist
    public static boolean ratInAMaze(int[][] maze, int[][] path, int i, int j, int di, int dj){
        // Base Case, if cell in invalid or blocked cell or we already cover
        if(i < 0 || i >= maze.length || j<0 || j>=maze.length || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }

        //if we are here that means we can take this step and search for destination
        path[i][j] = 1;

        // if we reached destination
        if(i== di && j==dj){
            return true;
        }

//        Try to take top, right, down, left step
        if(ratInAMaze(maze, path, i-1, j, di, dj) ||
                ratInAMaze(maze, path, i, j+1, di, dj) ||
                ratInAMaze(maze, path, i+1, j, di, dj) ||
                ratInAMaze(maze, path, i, j-1, di, dj)){
            return true;
        }
        return false;
    }




//    print all available paths
    public static void printAllPaths(int[][] maze, int si, int sj, int di, int dj){
        int[][] path = new int[maze.length][maze.length];
        printAllPathsHelper(maze, path, si, sj, di, dj);
    }

    private static void printAllPathsHelper(int[][] maze, int[][] path, int i, int j, int di, int dj){
        // Base Case, if cell in invalid or blocked cell or we already cover
        if(i < 0 || i >= maze.length || j<0 || j>=maze.length || maze[i][j] == 0 || path[i][j] == 1){
            return;
        }

        //if we are here that means we can take this step and search for destination
        path[i][j] = 1;

        // if we reached destination
        if(i== di && j==dj){
            System.out.println("-------Valid Path-----");
            print2DAray(path);
            System.out.println("----------------------");
            // reset the path for this coordinate
            path[i][j] = 0;
            return;
        }

//      take top, right, down, left step
        printAllPathsHelper(maze, path, i-1, j, di, dj);
        printAllPathsHelper(maze, path, i, j+1, di, dj);
        printAllPathsHelper(maze, path, i+1, j, di, dj);
        printAllPathsHelper(maze, path, i, j-1, di, dj);

        // reset the path for this coordinate
        path[i][j] = 0; // Backtracking step
    }


    public static void main(String[] args) {
        int[][] maze = {{1,1,0},
                        {1,1,0},
                        {1,1,1}};
//        int[][] maze = take2DArrayInput();
//        boolean pathExist = isPathExist(maze, 0,0, maze.length-1, maze.length-1);
//        System.out.println(pathExist);

        printAllPaths(maze, 0,0, maze.length-1, maze.length-1);
//        printAllPaths(maze, 0,0, 2, 1);
    }

}
