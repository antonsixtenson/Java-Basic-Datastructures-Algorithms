import java.util.*;

public class CompareName implements Comparator{

    public int compare(Object x, Object y) {
        String a = ((Land)x).getName();
        String b = ((Land)y).getName();
        int result = a.compareTo(b);
        return result;
    }
}
