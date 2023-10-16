

// Jordan Dube
import java.util.*;
public class cmsc401 {
    private static final int lowBound = -1;
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
    private static int findSecMax(Integer[] a){
        int max = a[0];
        int secMax =lowBound;
        
        for(int num:a){
            if(num > max){
                secMax = max;
                max = num;
                
            }
            else if(num < max && num > secMax){
                secMax = num;
            }
        }
        return secMax;
    }
    public static void main(String[] args) {
        //final long startTime = System.currentTimeMillis();
        printString("Enter Array Size: ");
        // reading an Integer
        int a = readInt();
        // writing int output
        //printInt(a);
        // reading a String
        //String s = readString();
        // writing string output
        //printString(s);
        printString("Enter elements of Array separated by spaces");
        // reading an Integer Array (you should provide the size)
        Integer[] listOfIntegers = readIntegerArray(a);
        // write your code here
        int b = findSecMax(listOfIntegers);
        printInt(b);
        
        //final long endTime = System.currentTimeMillis();
    
        //printString("Total execution time: " + (endTime - startTime));
        
    }
}
