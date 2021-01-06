import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public class Item implements Comparable <Item>{
    public Date delivered;   // utlnd datum, null nr Item inte r utlnad
    public final String RFIDNR;
    public String name;

    public Item(String thename, String number) {
        name = thename;
        RFIDNR = number;
        delivered=null;
    }

    public void setDeliverDate(Date d) {
        delivered = d;
    }

    public Date getDeliverDate() {
        return delivered;
    }

    public String getItemNumber() {
        return RFIDNR;
    }

    public String getItemName() {
        return name;
    }


    public int compareTo( Item other) {
        return name.compareTo(other.name);              //Tjuvlösning, ändrar i mån av tid
    }

    public boolean equals( Object other){
        Item obj = (Item)other;
        if(this.getItemNumber() == obj.getItemNumber()){
            return true;
        }
        else{
            return false;
        }
    }
        // Detta gr du frdig. Vi sger att tv objekt r lika om de har samma RFIDNR


    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if( delivered==null)
        return RFIDNR + " "+ name+ " "+ "på lager";
        else
        return RFIDNR + " "+ name+ " "+ df.format(delivered);
    }

    // See a simple program example to understand how Date class works;
    public static void main (String [] arg)
    {

        Calendar calendar = Calendar.getInstance();

        Date newDate = calendar.getTime();

        // Skapa item- object
        Item itm= new Item ( "Termometer", "1111111111");
        Item itm1= new Item ( "Skosnören", "1111111112");

        // Gr item-obj utlånad
        itm.setDeliverDate(newDate);

        System.out.println( itm);
        System.out.println(itm1);


    }

}
