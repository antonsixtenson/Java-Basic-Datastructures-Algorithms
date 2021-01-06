import java.util.*;
import java.io.*;

public class SearchMethods{

    public static int linearSearch ( int [] a, int x){
        for(int i = 0; i < a.length; i++){
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch ( int [] a, int x){
        int left = 0;
        int right = a.length-1;
        //System.out.println("left: " + left + " right: " + right);
        while(left <= right){
            int mid = left + (( right - left ) / 2);
            if(a[mid] == x){
                return mid;
            }
            else if(x < a[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    static int [] createArray( int size, int min, int max){
        Random rand = new Random();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            int rN = rand.nextInt(max-min + 1) + min;
            array[i] = rN;
        }
        Arrays.sort(array);
        return array;
    }


    public static void main(String[] args) throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter("linearSearch.txt", true));
        PrintWriter writer2 = new PrintWriter(new FileWriter("binarySearch.txt", true));
        Random rand = new Random();
        int randVal = rand.nextInt(1000 + 1);
        int max = 1000000;
        int min = 0;
        int [] a = createArray(max, min, 1000);
        long time1 = System.currentTimeMillis();
        int index = linearSearch(a, randVal);
        long time2 = System.currentTimeMillis();
        long totTime1 = time2-time1;
        System.out.println("Linear Search, Time " + "(" + totTime1 + " ms)" + " index: " + index);
        writer.println("Size: " + (max) + "\n" + "T: " + totTime1);
        writer.close();
        long time3 = System.currentTimeMillis();
        int index2 = binarySearch(a, randVal);
        long time4 = System.currentTimeMillis();
        long totTime2 = time4-time3;
        writer2.println("Size: " + (max) + "\n" + "T: " + totTime2);
        writer2.close();
        System.out.println("Binary Search, Time " + "(" + totTime2 + " ms)" + " mid: " + index2);




    }
}
