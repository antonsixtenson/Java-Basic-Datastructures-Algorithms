import java.util.Arrays;
import java.util.Random;

public class Uppgift6{
    public static void main(String[] CmdLn){
        Sort sort = new Sort();
        Random rand = new Random();
        int randNum1 = rand.nextInt(25) + 1;
        int randNum2 = rand.nextInt(25) + 1;
        int [] a = new int[randNum1];
        int [] b = new int[randNum2];
        for(int i = 0; i < a.length; i++){  //Fyll array a
            int randNum3 = rand.nextInt(100) + 1;
            a[i] = randNum3;
        }
        for(int j = 0; j < b.length; j++){  // Fyller array b
            int randNum4 = rand.nextInt(100) + 1;
            b[j] = randNum4;
        }
        int [] merged = sort.mergeArrays(a, b);
        System.out.println("array a: " + Arrays.toString(a));
        System.out.println("array b: " + Arrays.toString(b));
        System.out.println("array merged: " + Arrays.toString(merged));
        System.out.println("Sorted: " + sort.isSorted(merged));
    }

}
