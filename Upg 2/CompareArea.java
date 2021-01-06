import java.util.*;


public class CompareArea implements Comparator{

    public int compare(Object x, Object y){

        int a = ((Land)x).getArea();
        int b = ((Land)y).getArea();

        if(a < b){
            return -1;
        }

        else if(a == b){
            return 0;
        }

        else if(a > b){
            return 1;
        }
        else{
            System.out.println("error when comparing area");
            return 10;
        }
    }
    /**
    public static void main(String[] CmdLn){
        Land sweden = new Land("Sweden", "Stockholm", 10000000, 447435);
        Land denmark = new Land("Denmark", "Copenhagen", 6000000, 2245000);
    }**/
}
