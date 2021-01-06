import java.io.*;
import java.util.*;
import java.lang.*;

public class Land{
    private String name, capital, inhabitants, area;

    public Land(String name, String capital, String inhabitants, String area){
        this.name = name;
        this.capital = capital;
        this.inhabitants = inhabitants;
        this.area = area;
    }
    public String getName(){
        return name;
    }

    public int getInhab(){
        int x = Integer.parseInt(inhabitants);
        return x;
    }

    public int getArea(){
        int x = Integer.parseInt(area);
        return x;
    }

    public String toString(){
        return "Name: " + name + " Capital: " + capital + " Inhabitants: " + inhabitants + " Area: " + area;
    }

    public static void main(String[] CmdLn) throws IOException{

        ArrayList <Land> countries = new ArrayList <Land>();
        String country, capital, inhabitants, area;
        Scanner file = new Scanner(new File("europa.txt"));
        Scanner s = new Scanner(System.in);
        String throwAway = file.nextLine();             //bättre att edit i txt filen egentligen
        while(file.hasNext()){                          //spara all (rätt) data temporärt i de olika variablerna
            country = file.next();
            inhabitants = file.next();
            area = file.next();
            capital = file.next();
            Land temp = new Land(country, capital, inhabitants, area);          //Skapa ett nytt object av typ land m, datan
            countries.add(temp);                                        //add till listan
        }
        file.close();


        PrintWriter output = null;
        System.out.println("sortera efter (?): ");
        String input = s.nextLine().toLowerCase();

        String [] countrySortMatch = "countries land country länder".split(" ");
        String [] areaSortMatch = "area storlek kvadratkilometer".split(" ");
        String [] inhabSortMatch = "inhabitants residents invånare befolkning citizen habitant roomer occupant denizen".split(" ");

            //om du skriver in ett ord som matchar något i den arrayen, så exekvera överrensstämmande if-sats
        if(Arrays.asList(countrySortMatch).contains(input)){        // gör ovanstående mha contains

            Collections.sort(countries, new CompareName());
		    output = new PrintWriter(new FileOutputStream("europeSortedByName.txt", true));
        }
        else if(Arrays.asList(areaSortMatch).contains(input)){

            Collections.sort(countries, new CompareArea());
            output = new PrintWriter(new FileOutputStream("europeSortedByArea.txt", true));
        }

        else if(Arrays.asList(inhabSortMatch).contains(input)){

            Collections.sort(countries, new CompareInhab());
            output = new PrintWriter(new FileOutputStream("europeSortedByInahbitants.txt", true));
        }
        Iterator iterate = countries.iterator();
        while(iterate.hasNext()) {
            output.println(iterate.next());
        }
        output.close();
        s.close();




    }

}
