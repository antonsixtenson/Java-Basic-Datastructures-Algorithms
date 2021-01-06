import java.util.*;


public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private AnyType [] list;
    private int count;

    public MyArrayList(){
        list = (AnyType []) new Object[10];
        count = 0;
    }

    public MyArrayList(int initialCapacity){
        list =(AnyType [])new Object[initialCapacity];
    }

    /*Appends the specified element to the end of this list.*/

    public boolean add(AnyType o){
        if(o == null){
            return false;
        }
        if(count == list.length){
            AnyType [] temp;
            temp = Arrays.copyOf(list, list.length*2);          //temp, ny array, kopia av list m dubble
            list = temp;                                        // dirigera list till temps minnesplats
        }
        list[count] = o;                                     // om length < count bara kast in object o
        count++;

        return true;

    }


    /** tests if the specified element is a component of this list*/
    public boolean contains(AnyType o){
        boolean cont = false;
        for(int i = 0; i < list.length; i++){
            if(list[i] == o){cont = true;}       // om den hittar samma, ändrar cont till true
        }
        if(o == null){cont = false;}
        return cont;                            // returnera booleska vrdet cont
    }
    /** returns the component at the specified index*/
    public AnyType get(int index){

        if(index < 0 || index >= count) {            //throws olika exceptions om index för stort/litet (JUnit klagade på detta)
    		throw new IndexOutOfBoundsException("out of bounds");
    	}
        else if(list[index] == null){           // eler om index i listan pekar mot null
            throw new NullPointerException("get contains null obj");
        }
        return list[index];

    }

    /** Search for the first occurrence of the given argument testing for the equality using
    equals method*/
    public int indexOf(AnyType o){
        for(int i = 0; i < list.length; i++){           // loopar igenom alla element
            if(o == list[i]){           // letar upp (om det finns) object som är lika med o
                return i;           //returnera index :-)
            }
        }
        return -1;
    }
    /** tests if this list has no components*/
    public boolean isEmpty(){
        boolean empty = true;
        int i = 0;
        while(list[i] != null){
            empty = false;                  //hittar den någon plats som INTE är null ändra emty till false
            i++;
        }
        return empty;
    }
    /** removes the first occurrence of the specified element in this list
    if the list contains the */
    public boolean remove(AnyType o){
        for (int i = 0; i < count; i++) {
            if(list[i].equals(o)) {                             //Hittar den ngt som equals o så ta bort
                for(int j = i; j < 	list.length-1; j++) {       //genom att flytta fram alla element
                    list[j] = list [j+1];
                }
                count--;                                    //och ta bort en plats
                return true;

            }
        }
        return false;
    }
    /** returns the number of components in this list*/
    public int size(){
        int i = 0;
        while(list[i] != null){                     // räknar inte med null objecten
            i++;
        }
        return i;
    }
    /** returns an array containing all elements in this list in the correct order*/
    public Object [] toArray(){
    	if(count == 0) {
    		return null;
    	}
        Object [] copy = new Object[list.length];
        copy = Arrays.copyOf(list, list.length);            //kopiera listan och längden till array copy (gör till array)
        return copy;
    }

    public Iterator<AnyType> iterator(){
     // return object ArrayListIterator
        return new ArrayListIterator<>(list, count);            //iterator är implementerat (nedärvt?) för ex arraylist men inte för MyArraylist
    }


    public static void main(String[] args){
        String st1 = "Ett";
        String st2 = "Tva";
        String st3 = "Tre";
        MyArrayList <String> lista = new MyArrayList<String>();
        lista.add(st1);
        lista.add(st2);
        lista.add(st3);
        lista.add("Räka1");
        lista.add("Räka2");
        lista.add("Räka3");
        lista.add("Räka4");
        lista.add("Räka5");
        lista.add("Räka6");
        lista.add("Räka7");
        lista.add("Räka8");
        lista.add("Räka9");
        lista.add("Räka10");
        lista.add("Räka11");
        lista.add("Räka12");


        System.out.println("Contains (Fyra): " + lista.contains("Fyra"));
  	    System.out.println("Index of (Räka2): " + lista.indexOf("Räka2"));
        System.out.println("Is Empty(?): " + lista.isEmpty());
 	    lista.remove("Räka7");
        System.out.println("Size (null = nothing): " + lista.size());
        int i = 0;
        for(int l =0; l < lista.size(); l++) {
            System.out.println(lista.get(i));
            i++;
        }
        Object [] array = new Object[lista.size()];
        array = lista.toArray();
        for(int j = 0; j < array.length; j++){
            System.out.println("To Array: "+ "(" + j + ") " + array[j]);
        }

        lista.remove(st1);
        lista.remove(st2);
        lista.remove(st3);
        lista.remove("Räka1");
        lista.remove("Räka2");
        lista.remove("Räka3");
        lista.remove("Räka4");
        lista.remove("Räka5");
        lista.remove("Räka6");
        lista.remove("Räka7");
        lista.remove("Räka8");
        lista.remove("Räka9");
        lista.remove("Räka10");
        lista.remove("Räka11");
        lista.remove("Räka12");
        System.out.println("har nu tagit bort alla element");
        System.out.println("emopty: (?) " + lista.isEmpty());
        //System.out.println("Iterator: " + lista.iterator());
       for(int j = 0; j < array.length; j++){
            System.out.println(array[j]);
        }

    }
}
