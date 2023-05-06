package Graphs;

public class CNProblem {

//    Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA”

//    Sample Input 1:
//    2 11
//    CXDXNXNXNXA
//    XOXIXGXIXJX
//    Sample Output 1:
//    1
    public static void main(String[] args) {
        String[] graph = {"CXDXNXNXNXA", "XOXIXGXIXJX"};
        System.out.println(solve(graph, 2, 11));
    }

    static int[][] used;
    static String word = "CODINGNINJA";
    // all 8 direction from north east to east (clockwise)
    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public static int solve(String[] Graph, int N, int M){
        used = new int[N][M];

        int found = 0;

        for(int i=0; i<N; i++){
            for(int j=0; i<M; j++){
                if(Graph[i].charAt(j) == 'C'){
                    // from this position try to form CODINGNINJA
                    found = DFS(Graph, i, j, 1);
                    // if we found the word from i,j pos
                    if(found == 1){
                        return found;
                    }
                }
            }
        }
        return found;
    }

    private static int DFS(String[] Graph, int i, int j, int index) {
        // if we form all chars of words
        if(index == word.length()){
            return 1;
        }
        // mark the position as used because control only enter in DFS if found the required char
        used[i][j] = 1;

        // try to move to all 8 direction to form the remaining letter of word
        for(int x = 0; x<8; x++){
            int newI = i + dir[x][0];
            int newJ = j + dir[x][1];

//            if pos is valid and have required character and its unused
            if(isValidPoint(Graph, newI, newJ)  && Graph[newI].charAt(newJ) == word.charAt(index) && (used[newI][newJ] != 1)){
                int smallAns = DFS(Graph, newI, newJ, index+1);
                if(smallAns == 1){
                    return smallAns;
                }
            }
        }

        // free that pos
        used[i][j] = 0;

        return 0;
    }

    private static boolean isValidPoint(String[] Graph, int newI, int newJ) {
        if(newI < 0 || newJ < 0 || newI >= Graph.length || newJ >= Graph[newI].length()){
            return false;
        }
        return true;
    }



}
