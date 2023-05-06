package SearchingAndSorting;

import Array.ArrayUse;

import java.util.ArrayList;

public class Recursion3 {

    // Top - down approach
    // Bottom - up approach
    public static String[] findSubsequence(String str) {
        if(str.length() == 0){
            String[] output =  {""};
            return output;
        }
        // Hypothesis
        String[] smallOutput = findSubsequence(str.substring(1));

        String[] output = new String[smallOutput.length * 2];

        // coping smallOutput elems to new output
        for(int i=0; i<smallOutput.length; i++){
            output[i] = smallOutput[i];
        }

        // forming new elems by concatenating firstchar to each item of smallOutput and inserting to the output
        char firstChar = str.charAt(0);
        for(int i=smallOutput.length, j=0; i<output.length; i++, j++){
            String ans = firstChar + smallOutput[j];
            output[i] = ans;
        }

        return output;
    }

    public static String[] findSubsequence2(String str){
        if(str.length() == 0){
            String[] output = {""};
            return output;
        }

        String[] smallOutput  = findSubsequence2(str.substring(0, str.length()-1));

        String[] output = new String[smallOutput.length * 2];

        // coping smallOutput elems to new output
        for(int i=0; i<smallOutput.length; i++){
            output[i] = smallOutput[i];
        }

        // forming new elems by concatenating lastChar to each item of smallOutput and inserting to the output
        char lastChar = str.charAt(str.length()-1);

        for(int i=smallOutput.length, j=0; i<output.length; i++, j++){
            String ans = smallOutput[j] + lastChar;
            output[i] = ans;
        }

        return output;
    }


    // In printing methods we are using a additional parameter/argument for output so far;
//    xyz , yz , z , ''
    public static void printSubsequence(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        // we choose not to include first character
        printSubsequence(input.substring(1), output);
        // we choose to include first character in the output
        printSubsequence(input.substring(1), output + input.charAt(0));

    }

//    xyz, xy, x, ''
    public static void printSubsequence2(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }

        printSubsequence2(input.substring(0, input.length()-1), output);
        printSubsequence2(input.substring(0, input.length()-1), input.charAt(input.length()-1) + output);

    }



    // this method is created for keypad method
    private static String[] singleDigit(int n){
        if(n < 2 || n > 9){
            System.exit(0);
        }
        if(n == 2){
            return new String[]{"a", "b", "c"};
        }
        else if(n == 3){
            return new String[]{"d", "e", "f"};
        }
        else if(n == 4){
            return new String[]{"g", "h", "i"};
        }else if(n == 5){
            return new String[]{"j", "k", "l"};
        }else if(n == 6){
            return new String[]{"m", "n", "o"};
        }else if(n == 7){
            return new String[]{"p", "q", "r", "s"};
        }else if(n == 8){
            return new String[]{"t", "u", "v"};
        }
        else{
            return new String[]{"w", "x", "y", "z"};
        }
    }
    public static String[] keypad(int n){
        if(n < 10){
            String[] output = singleDigit(n);
            return output;
        }

        String[] smallOutput = keypad(n/10);
        int lastDigit = n%10;
        String[] lastDigitChars = singleDigit(lastDigit);

        String[] output = new String[smallOutput.length * lastDigitChars.length];

        int k = 0;
        for(int i=0; i<smallOutput.length; i++){
            for(int j=0; j<lastDigitChars.length; j++){
                output[k] = smallOutput[i] + lastDigitChars[j];
                k++;
            }
        }
        return output;
    }

    public static void printKeypad(int n, String output){
        if(n == 0){
            System.out.println(output);
            return;
        }
        String[] digitOptions = singleDigit(n%10);

        for(int i=0; i<digitOptions.length; i++){
            printKeypad(n/10, digitOptions[i] + output);
        }
    }


    public static int[][] giveSubsetOfArray(int[] input, int startIndex){
        if(startIndex == input.length){
            return new int[1][0];
        }

        int[][] smallOutput = giveSubsetOfArray(input, startIndex+1);

        // new output will have double num of rows than smallOutput
        int[][] output = new int[smallOutput.length * 2][];

        // copy smallOutput all jagged arrays to output
        int k = 0; // rows count for output
        for(int i=0; i<smallOutput.length; i++){
            output[k] = new int[smallOutput[i].length];
            for(int j=0; j<smallOutput[i].length; j++){
                output[k][j] = smallOutput[i][j];
            }
            k++;
        }
        // filling new rows of output by taking a row of smalloutput and concating the firstelem to it
        for(int i=0; i<smallOutput.length; i++){
            output[k] = new int[smallOutput[i].length+1];
            output[k][0] = input[startIndex];
            for(int j=0; j<smallOutput[i].length; j++){
                output[k][j+1] = smallOutput[i][j];
            }
            k++;
        }

        return output;
    }

    public static void printSubsetOfArray(int[] input, int startIndex, int[] output){
        if(startIndex == input.length){
            for(int i: output){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        printSubsetOfArray(input, startIndex+1, output);

        int[] newOutput = new int[output.length + 1];
        for(int i=0; i < output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[newOutput.length - 1] = input[startIndex];

        printSubsetOfArray(input, startIndex+1, newOutput);

    }


    public static void main(String[] args) {
        String str = "xyz";
//        String[] arr = findSubsequence(str);
//        String[] arr = findSubsequence2(str);

//        String[] arr = keypad(3292);
//
//        for(String i : arr){
//            System.out.println(i);
//        }

//        printSubsequence(str, "");
//        System.out.println();
//        printSubsequence2(str, "");

//        printKeypad(3292, "");

//        int[][] subsets = giveSubsetOfArray(new int[]{1, 2, 3}, 0);
//        for(int[] row : subsets){
//            for(int col: row){
//                System.out.print(col + " ");
//            }
//            System.out.println();
//        }

//        printSubsetOfArray(new int[]{1, 2, 3}, 0, new int[]{});
    }

}
