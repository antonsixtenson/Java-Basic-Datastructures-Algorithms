import java.util.Arrays;

public class AddAtIndex{


    public static String addAtIndex( int [] a, int x, int index){
        int [] arrayShift = new int[a.length];
        if(index > a.length){
            System.out.println("Index out of range");
        }
        if(a[index] != 0){
            arrayShift[index] = x;
            for(int j = 0; j<index; j++){
                arrayShift[j] = a[j];
            }
            for(int i = index; i <a.length-1; i++){
                arrayShift[i+1] = a[i];

            }
        }
        String arrayStr = Arrays.toString(arrayShift);
        return arrayStr;

    }
    public static void main(String[] CmdLn){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(addAtIndex(arr, 0, 1));
    }

}
