import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;


class Alist{
    public static void main(String[] CmdLn) {
        try{
            File f = new File("lista.txt");
            System.out.println(f.exists());
            Scanner sc = new Scanner(f);
            ArrayList<String> klassLista = new ArrayList<String>();

            while(sc.hasNextLine()){    //Lägger till alla namn till listan
                klassLista.add(sc.nextLine());
            }/**
            System.out.println(klassLista.isEmpty());
            for(int u = 0; u < klassLista.size(); u++){
                System.out.println(klassLista.get(u));
            }**/
            sc.close();

            for(int i = 0; i < klassLista.size(); i++){ //ers'tter tab o space med EN space.
                String rem = klassLista.remove(i);
                rem  = rem.replaceAll("\\s+", " ");
                klassLista.add(i,rem);
            }

            sortListArray(klassLista);      //sorterar listan
            addToList(klassLista, "Anton Sixtenson");
            //addToList(klassLista, "Anton Sixtenson");
            //addToList(klassLista, "Konrad Olsson");
            System.out.println(" ");
            for(int j = 0; j < klassLista.size(); j++){
                System.out.println(klassLista.get(j));
            }
            System.out.println(" ");
            for(int k = 0; k < klassLista.size(); k++){
                System.out.println(klassLista.get(k));
            }
        }
       catch (FileNotFoundException e){System.out.println("File not found");}
    }
    public static boolean addToList(ArrayList<String> list, String name){
        boolean bool = false;
        if(list.contains(name)){
            System.out.println("name already exists");
        }
        else{
            for(int i = 0; i < list.size(); i++){
                if(name.compareTo(list.get(i)) < 0){
                    list.add(i,name);
                    bool = true;
                    break;
                }
            }
        }

    return bool;
    }
    public static ArrayList<String> sortListArray(ArrayList<String> list){
        for(int i = 0; i < list.size();i++){
            for(int j = i; j < list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

}
