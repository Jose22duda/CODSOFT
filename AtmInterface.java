/*  |------Code by Joseph Vusumzi Duda------|
    |---------dudajoseph@gmail.com----------|
    |-----Task 3 for CodSoft Internship-----|
                                                   ATM INTERFACE
###################################################################################################################################
1. Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure of their transactions.
###################################################################################################################################
*/
import java.util.*;

// create a graphical user interface which represents the ATM Machine
public class AtmInterface {
   public static void main(String[] args){
      BankAccount account = new BankAccount();// create bank account object
      Scanner input = new Scanner(System.in); // create a scanner object
      while(true){ 
         // Print the menu of the ATM MACHINE
         System.out.println("|#####################################################|");
         System.out.println("|------------------JVD ATM MACHINE--------------------|");
         System.out.println("|#####################################################|");
         System.out.println("|     *Enter a number for choosing an option*         |");
         System.out.println("| 1.Withdraw                                          |");
         System.out.println("| 2.Deposit                                           |");
         System.out.println("| 3.Check Balance                                     |");
         System.out.println("| 4.Exit                                              |");
         System.out.println("|                                    jvd.banks@codsoft|");
         System.out.println("|#####################################################|");  
         try{
            // Tell user to enter a correct integer if they entered a number out of range
            System.out.print(">>");
            int choice_1 = input.nextInt();
            System.out.println();
            if (!(choice_1==1||choice_1==2||choice_1==3||choice_1==4)){
               System.out.println("[Number out of range.]");
               System.out.println("[Choose number between 1,2,3 & 4.]");
               System.out.println(); 
               continue;               
            } 
                   
            else if(choice_1==1) {
               while(true){
                  try{
                    System.out.println("[Enter withdrawal amount.]");
                    System.out.print(">>R");
                    double amount = input.nextDouble();
                    if (amount>0){
                        if(account.getBalance() ==0){System.out.println("[Balance is R0.00 .]");System.out.println();break;}                
                        else if(!(account.getBalance()>=10)){System.out.println("[Balance below R10.00 .]");continue;}                       
                        else if (account.getBalance()>=10&&account.getBalance()>=amount){
                           account.Withdraw(amount);
                           System.out.printf("[R%.2f successfully withdrawn. ]%n",amount);
                           System.out.println();
                           break;
                        } 
                        else{System.out.println("Insufficient Funds");break;}
                    }
                    else{System.out.println("[Enter amount greater than R0.00 .]");continue;}
                  }
                  // Tell user to enter an integer if they enter a string
                  catch(InputMismatchException e){
                    System.out.println("[Enter Valid amount.]");  
                    System.out.println();    
                    input.nextLine();
                    continue;
                  } 
               }            
            }
            
            else if(choice_1==2) {
               while(true){
                  try{
                    System.out.println("[Enter Deposit amount.]");
                    System.out.print(">>R");
                    double amount = input.nextDouble();
                    if (amount>0){                       
                        account.Deposit(amount);
                        System.out.printf("[R%.2f successfully Deposited. ]%n",amount);
                        System.out.println();
                        break;                      
                    }
                    else {System.out.println("[Enter amount greater than R0.00 .]");continue;}
                  }
                  // Tell user to enter an integer if they enter a string
                  catch(InputMismatchException e){
                    System.out.println("[Enter Valid amount.]");  
                    System.out.println();    
                    input.nextLine();
                    continue;
                  } 
               }             
            }
            
            else if(choice_1==3) {System.out.printf("[Bank balance is: R%.2f]%n",account.getBalance());System.out.println();continue; }
            
            else if(choice_1==4) {
               System.out.println("[Exited.]");
               System.exit(0);
            }
         }        
         // Tell user to enter an integer if they enter a string
         catch(InputMismatchException e){
            System.out.println("[Enter an integer.]");  
            System.out.println();    
            input.nextLine();
            continue;
        }        
     }
   }
}


// Create Bank Account class
class BankAccount{
    private double balance;
    
    //Create No argument constructor
    public BankAccount(){
       this.balance=0;
    }
    
    // Deposit Money Method
    public void Deposit(double amount){
       balance+=amount;
    }
    
    // Get balance
    public double getBalance(){
       return balance;
    }
    
    // Withdraw money
    public double Withdraw(double amount){
       balance-=amount;
       return amount;
    }
    
    // Close Account
    public void CloseAccount(){
       balance=0;
    }
}

