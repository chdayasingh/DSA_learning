package Recursion;

public class TowerOfHanoi {

//    Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
//            1) Only one disk can be moved at a time.
//            2) A disk can be moved only if it is on the top of a rod.
//            3) No disk can be placed on the top of a smaller disk.
//    Print the steps required to move n disks from source rod to destination rod.
//    Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

    public static void towerOfHanoi(int disc, char src, char destn, char aux){
        if(disc == 0){
            return;
        }
        // Hypothesis
        // Ask recursion to place Top(n-1) disc from source to aux using destination
        towerOfHanoi(disc-1, src, aux, destn);
        // now we can place last disc to destination
        System.out.println(src + " " + destn);
        // Hypothesis
        // Ask recursion to place Top(n-1) disc from aux to destination using source
        towerOfHanoi(disc-1, aux, destn, src);
    }

    public static void main(String[] args) {
        towerOfHanoi(3, 'a', 'c', 'b');
    }
}
