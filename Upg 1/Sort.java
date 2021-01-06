import java.util.Arrays;



public class Sort{
    public static int[] mergeArrays( int [] a , int [] b) {
        if (a == null || b == null){throw new NullPointerException("Input array/s: null");}
        int[] c = new int[a.length+b.length];
        for(int k = 0; k < a.length; k++){
            c[k] = a[k];
        }
        for(int m = 0; m < b.length; m++){
            c[a.length+m] = b[m];
        }

        int temp = 0;

        for(int i = 0; i < c.length-1; i++){
            for(int j = 0; j < c.length-1-i; j++){  //(length - 1 - i) i - minus element som redan sorterats
                if(c[j] > c[j+1]){                  // Bubble-sortering
                    temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
        return c;

    }
    public static boolean isSorted(int[] array){
        boolean right = false;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] < array[i+1]){
                right = true;
            }
            else{
                right = false;
            }
        }
        return right;
    }

    public static void main(String[] CmdLn){
        int [] a = {3, 1, 2, 8, 9};
        int [] b = {4, 7, 5};
        //int [] c = {3, 4, 1};
        int [] array = mergeArrays(a, b);
        String arrayStr = Arrays.toString(array);
        System.out.println(arrayStr);
        System.out.println("Sorted : " + isSorted(array));
        //System.out.println(isSorted(c));
    }
}
