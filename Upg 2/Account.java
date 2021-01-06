//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
import java.util.*;

   public class Account implements Comparable<Account>
   {
      private double balance;
      private String acctNum;

   //----------------------------------------------
   //Constructor -- initializes balance, owner, and account number
   //----------------------------------------------
      public Account(String number, double initBal)
      {
         balance = initBal;
         acctNum = number;
      }

   //----------------------------------------------
   // Checks to see if balance is sufficient for withdrawal.
   // If so, decrements balance by amount; if not, prints message.
   //----------------------------------------------
      public String withdraw(double amount)
      {
         String info="Insufficient funds";
         if (balance >= amount){
            balance=balance- amount;
            info= "Succeeded, the new balance is : "+ balance ;
         }

         return info;
      }

   //----------------------------------------------
   // Adds deposit amount to balance.
   //----------------------------------------------
      public String deposit(double amount)
      {
         String info=""  ;
         if( amount<0)
            info = " Wrong amount";
         else{
            balance=balance+ amount;
            info=" Succeeded, the new balance is: " + balance;
         }

         return info;
      }

   //----------------------------------------------
   // Returns balance.
   //----------------------------------------------
      public double getBalance()
      {
         return balance;
      }


   //----------------------------------------------
   // Returns a string containing the name, account number, and balance.
   //----------------------------------------------
      public String toString()
      {
         return  " Numer: "+ acctNum+ " Balance: " + balance;           // returnera värdena med kort beskrivande text
      }

   //----------------------------------------------
   // Returns accoutn number.
   //----------------------------------------------

      public String getAcctNum()
      {
         return acctNum;
      }

      public boolean equals(Object other){
        // detta skall du gra
         return true;
      }



      public static void main ( String [] arg){
            //ArrayList <Account> lista =new ArrayList<Account>();
          MyArrayList <Account> mylist = new MyArrayList<Account>();
          Iterator <Account> iterate = mylist.iterator();
          Random rand = new Random();
          mylist.add( new Account ("212", 2000));
          mylist.add( new Account ("213", 3000));
          mylist.add( new Account ("214", 4000));
          mylist.add( new Account ("215", 5000));
          for(int i = 0; i < mylist.size(); i++){
              System.out.println(mylist.get(i));
          }
          for(int i = 0; i < mylist.size()-1; i++){

              Account acc = iterate.next();
              System.out.println(acc.deposit(rand.nextInt(5000 - 1000 + 1) + 1000));
          }
            // System.out.println(konto.deposit(300));
            //VARFÖR FUNGERAR INTE Collections.sort()? Collections hanterar inte object av typen MyArrayList(?)
            //Har formodligen ngt att gora med "implements"(??)
            // Ja! implementerat för ex. ArrayList men inte för MyArrayList
      }
      @Override
      public int compareTo(Account o) {
          return (int)this.getBalance() - (int)o.getBalance();
      }
   }
