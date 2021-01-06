//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
//
//              !!!OBS!!!
//      Denna klassen innehåller den första account-uppgiften
//          (SORTERINGS UPPGIFTEN)
//      Den andra som bara heter "Account.java" innehåller de andra
//      mvh Anton Sixtenson


import java.util.*;

   public class AccountOne implements Comparable<Account>
   {
      private double balance;
      private String acctNum;

   //----------------------------------------------
   //Constructor -- initializes balance, owner, and account number
   //----------------------------------------------
      public AccountOne(String number, double initBal)
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
         return  " Numer: "+ acctNum+ " Balance: " + balance;
      }

   //----------------------------------------------
   // Returns accoutn number.
   //----------------------------------------------

      public String getAcctNum()
      {
         return acctNum;
      }

      public boolean equals(Object other){
        //Förstår inte om denna metoden är något som skall göras??
        return true;
      }




      public static void main(String [] args){

          ArrayList <Account> lista =new ArrayList<Account>();
          Account a= new Account ( "1111111111", 1000);
          lista.add(a );
          lista.add( new Account ( "1111111112", 2000));
          lista.add( new Account ("1111111113", 3000));
          lista.add( new Account ("1111111114", 4000));
          lista.add( new Account ("1111111115", 5000));

          lista.get(1).deposit(4000);

          Account konto= lista.get(1);
          System.out.println("Osorterad: " + lista);
          Collections.sort(lista);
          System.out.println("Sorterad: " + lista);
            // System.out.println(konto.deposit(300));

            //Ja, listan sorterades precis så som jag hade tänkt mig. (Så jag ville)

            System.out.println(konto.toString());
            

      }
      @Override
      public int compareTo(Account o) {
          return (int)this.getBalance() - (int)o.getBalance();
      }
   }
