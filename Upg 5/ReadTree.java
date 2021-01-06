import java.util.*;
import java.io.*;

public class ReadTree{

    public static void main(String[] args) throws IOException {
        TreeSet<String> ts = new TreeSet<String>();
        Scanner file = new Scanner(new File("input.txt"));
        while(file.hasNext()){
            ts.add(file.next());
        }
        Iterator<String> itr = ts.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
