/**
   Author: Savaas Iqbal
   Purpose: 1. Even/Odd Counter
            2. Rock, Paper, Scissors Game
   Date: 11/20/2022
   
   */
   
   
import java.util.Scanner;
import java.util.Random; 
public class Chapter5Project {
   public static void main(String[] args){
   
    Scanner keyboard = new Scanner (System.in); //scanner object
    Random rand = new Random(); //random object
    
   // variables to store number of even and number of odd
   int numOdd = 0; 
   int numEven = 0; 
   int numGenerated = 0; 
   boolean evenOrOdd = true; 
   
   for(int i = 0; i <100 ; i++) {    // use loop to generate 100 random integers and use isEven method 
     numGenerated = rand.nextInt(100 + 1);   // random numbers 0 - 100
     evenOrOdd = isEven(numGenerated);
     if (evenOrOdd){ //if true --> if even     increments each time
        numEven +=1; 
     }
     else { //if false --> if odd
        numOdd +=1; 
     }
  }
      System.out.println("The number of odd numbers generated is " + numOdd);
      System.out.println("The number of even numbers generated is " + numEven);  //output how many
    
      //start of Rock, Paper, Scissors
      //declare variables before loop
      int userChoice = 0; 
      String userChoiceString = ""; 
      int computerChoice = 0; 
      String computerChoiceString = ""; 
      String winnerStatement = ""; 
      
      do{
      System.out.println("***");      
      showMenu(); //display menu ***METHOD 1***
      
      userChoice = keyboard.nextInt();//user input
      userChoiceString = convertChoice(userChoice); // converts user selected integer into rock, paper, or scissors  ***METHOD 2***
      
      computerChoice = rand.nextInt((3 - 1) + 1) + 1; //generate random number 1-3 
      computerChoiceString = convertChoice(computerChoice); //converts randomly selected integer into rock, paper, or scissors -- corresponds to number
      
      System.out.println("You have chosen " + userChoiceString + ". And the Computer has chosen " + computerChoiceString + "."); //displays what you have choosen and what the computer chooses
      // method to choose winner
      winnerStatement = chooseWinner(userChoiceString, computerChoiceString); // ***METHOD 3
      System.out.println(winnerStatement); //prints out who won
      } while(userChoiceString == computerChoiceString);
   }
   
   public static boolean isEven(int number){ //method determines if a number is even
      if (number % 2 == 0){
         //the number is even
         return true; //true if even
      }
      else {
       // the number is odd
       return false; // false if odd
      }
   
   }
   
   //Rock paper scissors game
   
   //menu, method displays choices for user input and instructions 
   public static void showMenu(){ 
      String userChoice_ = ""; 
      System.out.println("This is the beginning of the Rock, Paper, Scissors game."); 
      System.out.println("Rock beats scissors. Paper beats rock. Scissors beat paper."); //instructions
      System.out.println("Enter 1 for Rock.");
      System.out.println("Enter 2 for Paper.");
      System.out.println("Enter 3 for Scissors."); //choices
 
   }
   
   //convert number choice to rock, paper, scissors choice
   public static String convertChoice(int numChoice){
      if (numChoice == 1){
         return "Rock"; 
      }
      else if (numChoice ==2){
         return "Paper";
      }
      else
         return "Scissors";
   }
   
   //choose winner 
   public static String chooseWinner(String user, String computer){
      if (user == computer){ //if there is a tie
         return "There was a tie. You must now re-play computer.";
      }
      else if ((user == "Rock" && computer == "Paper") || (user == "Paper" && computer == "Scissors") || (user == "Scissors" && computer == "Rock")){
         return "Computer won. User lost."; //where user loses & computer wins
      }
      else {
         return "User won. Computer lost.";
      }
   }

}

/***  OUTPUT

The number of odd numbers generated is 49
 The number of even numbers generated is 51
 ***
 This is the beginning of the Rock, Paper, Scissors game.
 Rock beats scissors. Paper beats rock. Scissors beat paper.
 Enter 1 for Rock.
 Enter 2 for Paper.
 Enter 3 for Scissors.
 3
 You have chosen Scissors. And the Computer has chosen Scissors.
 There was a tie. You must now re-play computer.
 ***
 This is the beginning of the Rock, Paper, Scissors game.
 Rock beats scissors. Paper beats rock. Scissors beat paper.
 Enter 1 for Rock.
 Enter 2 for Paper.
 Enter 3 for Scissors.
 2
 You have chosen Paper. And the Computer has chosen Scissors.
 Computer won. User lost.


*/