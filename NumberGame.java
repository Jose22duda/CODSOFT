/*  |------Code by Joseph Vusumzi Duda------|
    |---------dudajoseph@gmail.com----------|
    |-----Task 1 for CodSoft Internship-----|
                                                A NUMBER GAME
###################################################################################################################################
1. Generate a random number within a specified range.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guessis correct, too high, or too low.
4. Display the user's score, which can be based on the number of attempts taken or rounds won.
####################################################################################################################################
*/
import java.util.*;

public class NumberGame{
    public static void main(String[] args) {         
            
        // Create Scanner object
        Scanner input = new Scanner(System.in);   
        
        while(true){ 
           // Print the menu of the Game
           System.out.println("|#####################################################|");
           System.out.println("|-------------WELCOME TO THE NUMBER GAME--------------|");
           System.out.println("|-----------------MAIN MENU---------------------------|");
           System.out.println("|#####################################################|");
           System.out.println("|     *Enter a number for choosing an option*         |");
           System.out.println("| 1.Game instructions                                 |");
           System.out.println("| 2.Play Game                                         |");
           System.out.println("| 3.Exit Game                                         |");
           System.out.println("|                                    jvd.games@codsoft|");
           System.out.println("|#####################################################|");  
           
           try{ 
             // Tell user to enter a correct integer if they entered a number out of range
             System.out.print(">>");
             int choice_1 = input.nextInt();
             System.out.println();
             if (!(choice_1==1||choice_1==2||choice_1==3)){
                System.out.println("[Number out of range.]");
                System.out.println("[Choose number between 1,2 & 3.]");
                System.out.println(); 
                continue;
                
             }
             else if(choice_1==1) {
                  while(true){
                    // Print the instructions of the Game
                    System.out.println("|#####################################################|");
                    System.out.println("|----------INSTRUCTIONS FOR THE NUMBER GAME-----------|");
                    System.out.println("|#####################################################|");
                    System.out.println("| Random integers will be generated from 1 to 10.     |");
                    System.out.println("| There are 2 levels of difficulty.                   |");
                    System.out.println("|                                                     |");
                    System.out.println("|           Easy level:                               |");
                    System.out.println("| Number of trials for guessing are infinite.         |");
                    System.out.println("| A player can decide to quit this level anytime.     |");
                    System.out.println("| There is no winning in this level.                  |");
                    System.out.println("|                                                     |");
                    System.out.println("|           Difficult level:                          |");
                    System.out.println("| Number of trials will randomly range from 5 trials  |");
                    System.out.println("| -to 10 trials.                                      |");
                    System.out.println("| If a player quits the game before number of trials  |");
                    System.out.println("| -are finished, this results in a lose.              |");
                    System.out.println("| A correct guess results in a point for the player.  |");
                    System.out.println("| A wrong guess results in a point for the computer.  |");
                    System.out.println("| The number of points will determine a win, draw     |");
                    System.out.println("|-and loss.                                           |");
                    System.out.println("|#####################################################|");
                    System.out.println("|     *Enter a number after reading instructions*     |");
                    System.out.println("| 1.Back to Menu                                      |");
                    System.out.println("| 2.Exit Game                                         |");
                    System.out.println("|                                    jvd.games@codsoft|");
                    System.out.println("|#####################################################|"); 
                    
                    try{ 
                       // Tell user to enter a correct integer if they entered a number out of range
                       System.out.print(">>");
                       int choice_2 = input.nextInt();
                       System.out.println();
                       if (!(choice_2==1||choice_2==2)){
                         System.out.println("[Number out of range.]");
                         System.out.println("[Choose number between 1 & 2.]");
                         System.out.println(); 
                         continue;
                         
                       }
                       // Return to main menu
                       else if(choice_2==1){break;}
                       // Exit the Game
                       else if(choice_2==2){
                          System.out.println("[Game Exited.]");
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
             // Play the Game
             else if(choice_1==2) {
                 // Create a Random object
                 Random random = new Random();
                 while(true){ 
                   // Print the menu of the Game mode
                   System.out.println("|#####################################################|");
                   System.out.println("|-------------WELCOME TO THE NUMBER GAME--------------|");
                   System.out.println("|-----------------GAME MODE---------------------------|");
                   System.out.println("|#####################################################|");
                   System.out.println("|     *Enter a number for choosing an option*         |");
                   System.out.println("| 1.Easy Level                                        |");
                   System.out.println("| 2.Difficult Level                                   |");
                   System.out.println("| 3.Exit Game                                         |");
                   System.out.println("|                                    jvd.games@codsoft|");
                   System.out.println("|#####################################################|");
                   try{ 
                      // Tell user to enter a correct integer if they entered a number out of range
                      System.out.print(">>");
                      int choice_3 = input.nextInt();
                      System.out.println();
                      if (!(choice_3==1||choice_3==2||choice_3==3)){
                         System.out.println("[Number out of range.]");
                         System.out.println("[Choose a number between 1,2 & 3.]");
                         System.out.println(); 
                         continue;
                
                      }
                        // Easy Level
                      else if(choice_3==1){
                          int points = 0; // initialize point to back zero
                          int guesses= 0; // initialize number of  guesses back to zero
                            while (true){
                               System.out.println("[Guess the number:]");
                               System.out.println("[Enter 0 to quit level.]");
                               try{ 
                                  // Tell user to enter a correct integer if they entered a number out of range
                                  System.out.print(">>");
                                  int guess = input.nextInt();
                                  System.out.println();
                                  if (guess>10||guess<0){
                                    System.out.println("[Number out of range.]");
                                    System.out.println("[Choose number from 1 to 10.]");
                                    System.out.println(); 
                                    continue;
                                   }
                                  //Quit level
                                   else if(guess==0){
                                      String result="";
                                      int computer_score=guesses-points;
                                      if(computer_score==points){result+="IT\'S A DRAW!";}
                                      else if(computer_score<points){result+="YOU WIN!";}
                                      else if(computer_score>points){result+="YOU LOSE!";}
                                      System.out.println("|#####################################################|");
                                      System.out.println("|-------------WELCOME TO THE NUMBER GAME--------------|");
                                      System.out.println("|-----------------EASY LEVEL--------------------------|");
                                      System.out.println("|#####################################################|");
                                      System.out.println("|          SCORE BOARD                                |");
                                      System.out.printf("| Number of valid guesses:%2d                          |%n",guesses);
                                      System.out.printf("| Computer Score         :%2d                          |%n",computer_score);
                                      System.out.printf("| Your Score             :%2d                          |%n",points);
                                      System.out.printf("| Your Result            :%15s             |%n",result);
                                      System.out.println("|                                    jvd.games@codsoft|");
                                      System.out.println("|#####################################################|");
                                      System.out.println();
                                      break;
                                  }
                                  
                                  // Compare guessed number and random number
                                  else{
                                    guesses++;
                                    int randint=random.nextInt(10)+1;
                                    if(randint==guess){System.out.println("[Previous guess was Correct.]");System.out.println();points++;}
                                    else if (guess>randint){System.out.println("[Previous guess was Too High.]");System.out.println();}
                                    else if (guess<randint){System.out.println("[Previous guess was Too Low.]");System.out.println();}
                                       continue;
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
                      // Difficult Level                    
                      else if(choice_3==2){  
                         int points = 0; // initialize point to back zero
                         int guesses= 0; // initialize number of  guesses back to zero
                          int trials =random.nextInt(5)+5;  
                          int loop= trials-guesses;        
                          while(true){
                            try{ 
                               // Tell user to enter a correct integer if they entered a number out of range
                               System.out.println("You have "+loop+" trials left.");
                               System.out.println("This is trial "+(guesses+1)+'.');
                               System.out.println("[Guess the number.]");
                               System.out.println("[Enter 0 to quit level.]");
                               System.out.print(">>");
                               int guess = input.nextInt();
                               System.out.println();
                               if (guess>10||guess<0){
                                 System.out.println("[Number out of range.]");
                                 System.out.println("[choose number from 1 to 10.]");
                                 System.out.println(); 
                                 continue;
                               }
                               //Quit level
                               else if(guess==0 && (guesses<loop)){
                                   String result="YOU LOSE!";
                                   System.out.println("|#####################################################|");
                                   System.out.println("|-------------WELCOME TO THE NUMBER GAME--------------|");
                                   System.out.println("|---------------DIFFICULT LEVEL-----------------------|");
                                   System.out.println("|#####################################################|");
                                   System.out.println("|          SCORE BOARD                                |");
                                   System.out.println("|You quit before all trials were finished.            |");
                                   System.out.printf("| Your Result            :%15s             |%n",result);
                                   System.out.println("|                                    jvd.games@codsoft|");
                                   System.out.println("|#####################################################|");
                                   System.out.println();
                                   break;
                               }     
                               // Compare guessed number and random number
                               else{
                                 guesses++;
                                 loop--;
                                 String message="";
                                 int randint=random.nextInt(10)+1;
                                 if(randint==guess){
                                    System.out.println("[Previous guess was Correct.]");
                                    System.out.println();
                                    points++;
                                 }
                                 else if (guess>randint){
                                    System.out.println("[Previous guess was Too High.]");  
                                    System.out.println();                                  
                                 }
                                 else {
                                   System.out.println("[Previous guess was Too Low.]"); 
                                   System.out.println();                                 
                                 }
                                 if(loop==0){
                                   
                                    String result="";
                                    int computer_score=guesses-points;
                                    if(computer_score==points){result+="IT\'S A DRAW!";}
                                    else if(computer_score<points){result+="YOU WIN!";}
                                    else if(computer_score>points){result+="YOU LOSE!";}
                                    System.out.println("|#####################################################|");
                                    System.out.println("|-------------WELCOME TO THE NUMBER GAME--------------|");
                                    System.out.println("|---------------DIFFICULT LEVEL-----------------------|");
                                    System.out.println("|#####################################################|");
                                    System.out.println("|          SCORE BOARD                                |");
                                    System.out.printf("| Number of valid guesses:%2d                          |%n",guesses);
                                    System.out.printf("| Computer Score         :%2d                          |%n",computer_score);
                                    System.out.printf("| Your Score             :%2d                          |%n",points);
                                    System.out.printf("| Your Result            :%15s             |%n",result);
                                    System.out.println("|                                    jvd.games@codsoft|");
                                    System.out.println("|#####################################################|");
                                    System.out.println();
                                    break;    
                                 }
                                 
                                 else{continue;}
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
                       // Exit the Game
                       else if(choice_3==3){
                          System.out.println("[Game Exited.]");
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
             // Exit the Game
             else if(choice_1==3) {
                System.out.println("[Game Exited.]");
                break;
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

      