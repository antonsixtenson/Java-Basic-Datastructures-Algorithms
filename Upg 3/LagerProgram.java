import java.util.*;
import java.io.*;

public class LagerProgram{
    static Scanner scan = new Scanner(System.in);
    static ItemList inStore =new ItemList();
    static ItemList outStore=new ItemList();
    static long nr=111;
    public static void main(String[] args){
        printMenu();
        int choice = scan.nextInt();
        scan.nextLine();

        while (choice != 0){
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
            scan.nextLine();
        }
    }

    public static String getRFID(){
        return ""+ nr++;

    }

    public static void dispatch(int choice)
    {
        int loc;


        switch(choice){
            case 0:
            System.out.println("EXIT");
            PrintWriter output = null;
            try{
                output = new PrintWriter(new FileOutputStream("Lager.txt", true));
            }
            catch(IOException ex){System.out.println("Error while trying to save to file, I/O Exception");}
            System.exit(0);
            break;

            case 1:{
                System.out.println("what type of store would you like to setup?");
                System.out.println("[1] Tools | [2] Medical");
                String inputItm = "";
                Scanner userInput = new Scanner(System.in);
                String ch = userInput.nextLine();
                if(ch.equals("1")){
                    try{
                        Scanner filescan = new Scanner(new File("Verktyg.txt"));//om valet = 1, läser filescan in verktyg.txt
                        while( filescan.hasNext()){
                            inputItm = filescan.nextLine();
                            inStore.addSort(new Item(inputItm,  getRFID()));
                        }
                    }

                    catch(IOException ex){System.out.println("File not found");}

                }
                else if(ch.equals("2")){
                    try{
                        Scanner filescan = new Scanner(new File("Medisinskutr.txt"));//Annars läs medicinskutr
                        while( filescan.hasNext()){
                            inputItm = filescan.nextLine();
                            inStore.addSort(new Item(inputItm,  getRFID()));
                        }

                    }

                    catch(IOException ex){System.out.println("File not found");}

                }
                else{System.out.println("Invalid input");}
                System.out.println("You'r store is now installed, print items? [y/n]");//ist för att printa varje gång
                Scanner pCh = new Scanner(System.in);
                String printChoice = pCh.nextLine();
                if(printChoice.equals("y")){inStore.printList();}
                if(printChoice.equals("n")){break;}
                break;
            }



            case 2:{	//låna item funktion, tar bort från inStore. adderar till outStore
                Calendar cal = Calendar.getInstance();
                //Date outTime = cal.getTime();
                inStore.printList();
                System.out.println("What item would you like to borrow?");
                System.out.print("> ");
                String borrowNr = scan.nextLine();
                Item borrowItm = inStore.remove(borrowNr);
                //System.out.println("ITEM print: " + borrowItm.toString());
                //Item testItm = new Item("test", "001");
                //outStore.addSort(testItm);
                outStore.addSort(borrowItm);// VARFÖR fungerar inte denna? SVAR: tydligen fel i grundprogrammet

                outStore.printList();
                System.out.println("Item borrowed at:"); // borrowItm.getDeliverDate()
                break;
            }
            case 3:{//Återlämningsfunktionen, gör tvärtom gentemot ovan
                outStore.printList();
                System.out.println("Return which item? ");
                System.out.println("> ");
                String returnNr = scan.nextLine();
                Item returnItm = outStore.remove(returnNr);
                inStore.addSort(returnItm);
                inStore.printList();
                break;
            }

            case 4:{
                inStore.printList();
                break;
            }
            case 5:{
                outStore.printList();
                break;
            }

            case 6:{		//Sök funktionen
                System.out.println("What item are you searching for? ");
                String in = scan.nextLine();
                System.out.println("Found: " + inStore.find(in)); //Använder find metoden i itemlist
                break;
            }




            default:
            System.out.println("Sorry, invalid choice");
        }
    }

    //----------------------------
    // Skriver ut användar meny
    //----------------------------
    public static void printMenu()
    {
        System.out.println("\n  Welcome");
        System.out.println("   ====");
        System.out.println("0: Exit");
        System.out.println("1: Setup Store");
        System.out.println("2: Borrow Item");
        System.out.println("3: Return Item" );
        System.out.println("4: Print items in store");
        System.out.println("5: Print borrowed items");
        System.out.println("6: Search Item");
        System.out.print("\nEnter your choice: ");
    }



}

/* Exempel hur man läser från fil.
try{
Scanner filescan=new Scanner(new File("Verktyg.txt"));
while( filescan.hasNext())
System.out.println( filescan.next());
}

catch(IOException ex){System.out.println("Filen finns inte");
*/
