import java.util.*;

public class CompareInhab implements Comparator{

    public int compare(Object x, Object y){
        int a = ((Land)x).getInhab();
        int b = ((Land)y).getInhab();

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
            System.out.println("error when comparing inhabitants");
            return 10;
        }
    }

}
