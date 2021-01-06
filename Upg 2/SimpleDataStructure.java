import java.util.*;
public class SimpleDataStructure{
    private String [] friends;
    //private String []doubleFriends;
    private int counter;
    public SimpleDataStructure(){
        friends = new String[5];
        counter=0;
    }

    public boolean addSort(String namn){
        if(counter == friends.length){
            String [] dblArr = new String[friends.length*2];      //Ny temporär array m. dubble size
            for(int i = 0; i < friends.length; i++){            // kopiera arrayen friends till temp
                dblArr[i] = friends[i];
            }
            friends = dblArr;                     // variabeln friends leder till samma ställe som temp
        }
        friends[counter] = namn;
        counter++;
        //String [] temp = Arrays.copyOf(friends, friends.length);
        for(int i = 0; i < friends.length-1; i++){				// bubblesort (hela listan) mha compareTo
            for(int j = 0; j < friends.length-1; j++){
                if(friends[j] != null && friends[j+1] != null && friends[j].compareToIgnoreCase(friends[j+1])>0){
                    String tempr = friends[j];
                    friends[j] = friends[j+1];
                    friends[j+1] = tempr;
                }
            }
        }
        return true;
    }
    /** returns the name at the specified index*/

    /*Appends the other friend name to the end of this list.*/
    public boolean add(String other){
        if(counter == friends.length){
            String [] temp = new String[friends.length*2];      //Ny temporär array m. dubble size
            for(int i = 0; i < friends.length; i++){            // kopiera arrayen friends till temp
                temp[i] = friends[i];
            }
            friends = temp;                     // variabeln friends leder till samma ställe som temp
        }
        friends[counter] = other;
        counter++;

        return true;
    }
    /** returns the name at the specified index*/
    public String get(int index){           //metoden kraschar pga index out of bounds
        if(index > friends.length){         //om index > arr längd så returnera sista elementet
            return friends[friends.length-1];
        }
        else{
            return friends[index];
        }
    }
/** removes the first occurrence of the specified element
in this list if the list contains the name*/
    public boolean remove(String name){
        for(int i=0;i<counter; i++){
            if(friends[i].equals(name)){
                friends[i]=null;
                String temp = "";
                for(int j = i; j < friends.length-1; j++){      //Bubble-sort null till sistaplatsen
                    temp = friends[j+1];
                    friends[j+1] = friends[j];
                    friends[j] = temp;
                }
                return true;
            }
        }
        return false;
    }
/** prints all names in the array friends*/
    public void printFriends(){
        for(int i=0;i<friends.length; i++){
            //System.out.println(friends[i]);
            if(friends[i] != null){
                System.out.println(friends[i]);
            }
        }
    }


        public static void main( String [] arg){
            SimpleDataStructure myfriends = new SimpleDataStructure();
            //String [] names = {"Anton", "Sara", "Tina", "Daniel", "Bengt-Åke Hansén"};
            String [] names = {"Anton", "Sara", "Örnemo", "Daniel", "Bengt-Åke Hansén", "Jalle", "Charlott", "Brivio", "My", "Humle", "Törja"};
            for(int i = 0; i < names.length; i++){
                myfriends.addSort(names[i]);
            }
            //System.out.println("get: " + myfriends.get(13));
            /**
            myfriends.remove("Daniel");
            myfriends.remove("Brivio");
            myfriends.remove("Anton");
            **/
            myfriends.printFriends();
        }
}
