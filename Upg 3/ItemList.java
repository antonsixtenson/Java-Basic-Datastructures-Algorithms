
import java.util.*;

/**
* Klassen ItemList är en länkad lista som innehåller noder av Item-objekt.
* Första noden i listan ( header) innehåller inget objekt.
*/

public class ItemList{
    private Node header;
    int size;

    public ItemList( ) {
        header = new Node( null );
    }

    /**
    Skapar ett ny Node-objekt med ett nytt Item objekt och lägger den i listan.
    ökar värdet av variabel size;
    */
    public void add(Item newItem) {
        Node ny = new Node(newItem, header.next);
        header.next = ny;
        size++;
    }

    /**
    Skapar ett ny Node objekt med ett nytt Item-objekt och lägger den i listan på plats index,
    ökar värdet av variabel size;
    */
    public void addAt( Item newItem, int index){
        Node newNode = new Node(newItem);           //Nya noden med Stringen obj
        Node previous = header;                     // previous (temp) pekar först mot head
        int count = 0;                                  // counter för att hitta rätt index
        while(count < index){                           // loopa fram till rätt index
            previous = previous.next;                   //spara nästa i previous
            count++;
        }
        Node current = previous.next;               //vill sätta in den nya mellan current o previous
        newNode.next = current;
        previous.next = newNode;
        size++;

    }

    public void addSort(Item itm){
        Node in = new Node(itm);
        Node node = header;
        if(node.next == null){      //om nästa är null, bara släng in i next
            node.next = in;
        }
        else{
            while(node.next != null){
                if(node.next.itm.compareTo(itm) < 0){       //om compareTo är mindre än noll
                    Node temp = new Node(itm, node.next);  //sätt itm före
                    node = temp;                                //för in i listan
                }
                node = node.next;
            }
            node.next = in;
            size++;
            return;
        }
    }


    /**
    Returnerar true om det finns ett Item-objekt vars RFIDNR är lika med metodens parametern id
    */
    public boolean find(String id) {
        Node temp = header;
        boolean x = false;
        while(temp.next != null){
            if(temp.next.itm.getItemNumber().toLowerCase().equals(id)){     //jämför här
                x = true;
            }
            temp = temp.next;
        }
        return x;
    }

    /**
    Ta bort noden som innehåller Item- objektet med viss id*/
    public Item remove(String id) {//remove loopar igenom den länkade listan
        id = id.toLowerCase();
        Node node = header;
        while(node.next != null){
            if(node.next.itm.getItemNumber().toString().toLowerCase().equals(id)){      //matchar id något item
                node.next = node.next.next;                                 // så länkas nästa till näst-nästa (hoppar över itemet)
                break;
            }
            node = node.next;
        }
		size--;
        return null;
    }

    /**
    Räknar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR
    */

    public int countObjects(String name) {
        name = name.toLowerCase();
        Node node = header;
        int i = 0;
        while(node.next != null){
            if(node.next.itm.name.toString().toLowerCase().equals(name)){   //Här jämför den RFID nr
                node = node.next;
                i++;            //Om samma, i+1
            }
            else{node = node.next;}
        }
        return i;
    }


    /**
    Skriver ut innehållet i listan
    */
    public void printList() {
        Node node = header;
        while(node != null){            //Loopa igenom fram till det är null
            System.out.println(node.itm);
            node = node.next;
        }
    }

    /**
    Returnera true om listan är tom annars false
    */
    public boolean isEmpty(){
        Node temp = header;
        if(temp.next == null){
            return true;
        }
        else{
            return false;
        }

    }


    /**
    Returnera antlet element i listan
    */
    public int size(){
/**        Node temp = header;
        int counter = 0;
        while(temp.next != null){
            temp = temp.next;
            counter++;
        }**/
    return size;
    }
    public static void main(String[] args){
        ItemList namn = new ItemList();
        namn.add( new Item("Solstolar", "00000001"));
        Item nuts = new Item("Nötter", "00000002");
        Item conds = new Item("Dammsugarpåsar", "00000003");
        Item snus = new Item("Snus", "00000004");
        Item biskvi = new Item("Päronbiskvi", "00000005");
        namn.add( new Item("Lätt mousserat vitt vin", "00000007"));
        namn.add(nuts);
        namn.add(conds);
        namn.add(snus);
        namn.addAt(biskvi, 3);
        namn.add( new Item("Snus", "00000006"));
        namn.printList();
        System.out.println("Size: " + namn.size());
        namn.remove("00000007");
        System.out.println("--------REMOVED VIN---------");
        namn.printList();
        System.out.println("Size: " + namn.size());
        System.out.println("Empty: " + namn.isEmpty());
        System.out.println("Count snus: " + namn.countObjects("snus") );
        System.out.println("Find (Solstolar): " + namn.find("00000001"));
    }
}
