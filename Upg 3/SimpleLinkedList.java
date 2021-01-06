import java.util.*;

/**
* Klassen SimpleLinkedList är en länkad lista som innehåller noder av objekt.
* Första noden i listan innehåller inget objekt.
*/

public class SimpleLinkedList{

    private ListNode header;

    public SimpleLinkedList( ) {
        header = new ListNode( null );
    }

    /**
    Skapar en ny ListNode  med ett nytt objekt och lägger den i listan
    */
    public void insert (String theobj){
        ListNode nynode = new ListNode(theobj);

        ListNode temp = header;
        while(temp.next != null){
            temp=temp.next;
        }

        temp.next=nynode;
    }


    /*
    Ta bort noden som innehåller respektive objekt
    */
    public void remove(String theobj) {
        ListNode node = header;

        while(node.next != null){
            if(node.next.element.equals(theobj)){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    /**
    Skriver ut innehållet i listan
    */
    public void print() {
        ListNode node = header.next;
        while(node != null){
            System.out.println(node.element);
            node = node.next;
        }
    }

    public void insert2(String theobj ) {
        ListNode nynode = new ListNode(theobj, header.next);
        header.next = nynode;
    }

    // Detta skall du göra
    public void insert3 ( String obj, int index ){
        ListNode newNode = new ListNode(obj);           //Nya noden med Stringen obj
        ListNode previous = header;                     // previous (temp) pekar först mot head
        int count = 0;                                  // counter för att hitta rätt index
        while(count < index){                           // loopa fram till rätt index
            previous = previous.next;                   //spara nästa i previous
            count++;
        }
        ListNode current = previous.next;               //vill sätta in den nya mellan current o previous
        newNode.next = current;                        // sätt in den
        previous.next = newNode;                        // nya noden



    }

    // Returnerar och tar bort ett objkt från lista
    public String remove( String obj, int index){
        ListNode previous = header;                  // temporär för att kunna loopa
        int count = 0;
        while(count < index){                       // loopa fram till index
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;            // håller next-noden för previous
        previous.next = current.next;                //"hoppa över" current
        current.next = null;                         // current pekar mot null

        return null;
    }

    //returnerar storleken på listan. Lägg till i klasssen  en variabel för detta
    // uppdatera variabeln när det är fallet

    public int size(){
        ListNode temp = header;
        int counter = 0;
        while(temp.next != null){
            temp = temp.next;
            counter++;
        }


        return counter;
    }
    public String toString(){
        ListNode temp = header;
        if(temp == null){
            return "";
        }
        String str = "";
        while(temp.next != null){
            temp = temp.next;
            str += temp.element;
            if(temp.next != null){
                str += ", ";
            }

        }
        return str;
    }






    public static void main ( String [] arg)
    {
        // testa metoderna från klassen SimpleLinkedList
        SimpleLinkedList klassLista=new SimpleLinkedList();

        klassLista.insert("Olle");
        klassLista.insert2("Nina");
        klassLista.insert2("Frans");
        klassLista.insert2("Rosa-Lina Liljegren");
        klassLista.insert2("Benne");
        klassLista.insert2("Natalie");
        // klassLista.print();
        // klassLista.remove("Nina");
        //klassLista.print();
        klassLista.insert3("Boris", 2);
        klassLista.print();
        System.out.println("Size: " + klassLista.size());
        System.out.println("-------------Boris--REMOVE--2--------------");
        klassLista.remove("Boris", 2);
        klassLista.print();
        System.out.println("Size: " + klassLista.size());
        System.out.println("ToString: " + klassLista.toString());
        /** klassLista.insert("Trump");
        klassLista.insert("Stig-Björn");
        klassLista.insert("Olle");**/
    }

}
