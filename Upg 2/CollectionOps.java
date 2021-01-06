import java.util.*;

public class CollectionOps{
    public static <T> void print(Collection<T> l){
        for(T a : l)
            System.out.printf("%s ", a);
        System.out.println();
    }
    public static <T> List<T> reverse(List<T> l){
        T temp;
        for(int i = 0; i < l.size()/2; i++){            // behöver bara loopa genom hälften
            temp = l.get(i);                            // temp sparar första objectet
            l.set(i, l.get(l.size()-i-1));             // om index är < 0 så går den "bakåt" till sista -i element
            l.set(l.size()-i-1, temp);                  // set till temp
        }
        return l;
    }


    public static void main(String[] args){
        ArrayList<String> strAL = new ArrayList<String>();
        strAL.add("a");
        strAL.add("b");
        strAL.add("c");
        print(strAL);
        print(reverse(strAL));
    }

}
