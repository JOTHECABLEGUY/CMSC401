//Jordan Dube
//import for scanner
import java.util.*;
//main class
public class cmsc401 {
    //scanner for input
    private static final Scanner scanner = new Scanner(System.in);
    
    // Please use these methods to take inputs and write outputs.
    //read integer from the scanner
    private static Integer readInt() {
        return scanner.nextInt();
    }
    //read a string from the scanner
    private static String readString() {
        return scanner.next();
    }
    //read an integer array of size elements
    private static Integer[] readIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }
    //print the given integer
    private static void printInt(int a) {
        System.out.println(a);
    }
    //print the given string
    private static void printString(String s) {
        System.out.println(s);
    }
    //bottom up approach to the largest sum problem
    //takes in a storage array (for answers to subproblems)
    // and a number n of the integer we want to split (also serves as index of the result array)
    private static int bottomUp( int n, int[] result){
        //need to start at 2 to avoid repetitive 0s
        for(int i = 2; i <= n; i++){
            //int to store a really low number
            int q = Integer.MIN_VALUE;
            //need to start at 1 to avoid invalid indices
            for(int j = 1; j <= i; j++){
                //calculates the maximum product using the -infinity and the product of j and the result of the
                //subproblem which is stored at result[i-j]
                q = Math.max(q, j*result[i-j]);
            }
            //stores the answer to the current subproblem that was just calculated
            // in the result array to be used in later iterations
            result[i] = q;
        }
        //on the cases where n = 2 or n = 3, the result that gets output is 1 larger than the expected outcome,
        // so these checks serve to correct the aforementioned errors
        if(n == 2){ result[n] = 1; }
        else if(n == 3){ result[n] = 2; }
        //returns the max product of the given integer
        return result[n];
    }
    
    public static void main(String[] args) {
        //capture input from user
        int input = readInt();
        //instantiate array of size input + 1 to allow the function to return r[n]
        int[] r = new int[input + 1];
        //base cases to prevent 0s from messing up the output
        r[0] = 1;
        r[1] = 1;
        //capture output of the method using O(n(n+1)/2) ~~ O(n^2)
        int a = bottomUp(input , r);
        //print result
        printInt(a);
    }
}