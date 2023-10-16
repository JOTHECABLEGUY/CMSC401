//Jordan Dube
import java.util.*;
public class cmsc401 {
    private static final Scanner scanner = new Scanner(System.in);
    
    // Please use these methods to take inputs and write outputs.
    private static Integer readInt() {
        return scanner.nextInt();
    }
    
    private static String readString() {
        return scanner.next();
    }
    
    private static Integer[] readIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }
    
    private static void printInt(int a) {
        System.out.println(a);
    }
    
    private static void printString(String s) {
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        //get instruction from input
        String line = scanner.nextLine();
        //construct hashtable to store keys and values
        Hashtable<String, Integer> ht = new Hashtable<>();
        //declare a variable to store tokens from instruction line
        String[] splitLine;
        //variable to make print statements easier
        int result;
        //main loop that exits when the instruction is QUIT
        while (!line.equals("QUIT")) {
            //split the line, using a space char as a delimiter
            splitLine = line.split(" ");
            //checks if the hashtable already has value mapped to the left side variable
            if (ht.containsKey(splitLine[0])) {
                //prints error and exits if it does
                printString("ERROR");
                return;
            }
            //toggle variable to ensure that the left hand side of assignment statement is skipped
            int toggle = 0;
            //for each token in the split line, check if it is the left side variable
            for (String s: splitLine) {
                //if it is the left variable, set toggle to 1 so that the other tokens can be analyzed
                if(toggle == 0){
                    toggle = 1;
                } else {
                    //for the right side, check if the token starts with x. If it does, then it is a variable
                    if(s.contains("x")) {
                        //checks the hash table to see if the called variable has a value mapped to it
                        if (!(ht.containsKey(s))) {
                            //if the variable has not been assigned yet, print error and exit
                            printString("ERROR");
                            return;
                        }
                    }
                }
            }
            //if the length of the split line is 3, this means that the assignment is mapping an int to the left hand variable
            if(splitLine.length == 3){
                //stores the int in result
                result = Integer.parseInt(splitLine[2]);
                //puts the mapping into the hashtable
                ht.put(splitLine[0], result);
                //prints the value
                printInt(result);
                //if length is not 3, checks if the length is 5, which indicates variable arithmetic
            } else if(splitLine.length == 5){
                //switch case is dependent on the operator stored in the split line
                switch (splitLine[3]) {
                    case "+" : {
                        //if the token is +, then perform addition with the specified variables and print the result
                        result = ht.get(splitLine[2]) + ht.get(splitLine[4]);
                        //also makes a new entry in the hashtable
                        ht.put(splitLine[0], result);
                        printInt(result);
                        break;
                    }
                    case "-" : {
                        //if the token is -, then perform subtraction with the specified variables and print the result
                        result = ht.get(splitLine[2]) - ht.get(splitLine[4]);
                        //also makes a new entry in the hashtable
                        ht.put(splitLine[0], result);
                        printInt(result);
                        break;
                    }
                    case "*" : {
                        //if the token is *, then perform multiplication with the specified variables and print the result
                        result = ht.get(splitLine[2]) * ht.get(splitLine[4]);
                        //also makes a new entry in the hashtable
                        ht.put(splitLine[0], result);
                        printInt(result);
                        break;
                    }
                }
            }
            //updates the while-loop control variable to take in additional instructions
            line = scanner.nextLine();
        }
    }
}