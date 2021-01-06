public class RecursiveTest{

    public static void recursive(int n){
        if(n >= 1){
            recursive(n-1);
        }
        System.out.println(n);
    }

    public static void main(String[] args){
        int n = 100;
        recursive(n);
    }
}
