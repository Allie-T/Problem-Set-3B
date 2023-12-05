
/**
 * Rock Paper CROSSBLADES!!!!!
 *
 * Alicia Tang
 * October 6th 2023
 */
import java.util.Scanner;
public class RPC{
    public static final int DISQAUALIFIED = 0;
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int CROSSBLADES = 3;
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Human, let’s have an epic game of Rock, Paper, Crossblades! \n");
        
        System.out.print("You:");
        String humanAns = in.nextLine();
        humanAns = humanAns.toLowerCase();
        
        if(humanAns.length()>=50){
            int human = getMove(humanAns);
            int computer = computer(getMove(humanAns));
            
            System.out.println();
            System.out.println(result(computer));
            FinalResult(human, computer);
        }else{ 
            System.out.println();
            autoWin(getMove(humanAns)); 
            FinalResult(0, 0); 
        }
    }
    
     public static boolean check (String word, String response){ //checks the input of the person see which one they chose
        return response.length()>=word.length() && response.lastIndexOf(word) == response.length()-word.length();
    }
    
    public static int getMove (String word){ //confirms the input and set it to a number.
        int move = 0;
        if(check("rock", word)){
            move = ROCK;
        }else if (check("paper",word)){
            move = PAPER;
        }else if (check("crossblades",word)){
            move = CROSSBLADES;
        }
        return move; 
    }
    
    public static void autoWin(int human){
        String moveC = "";
        if(human == 0){
         System.out.println("You have failed to adhere to the ancient traditions of Rock, Paper,\n" +
         "Crossblades! You have lost by disqualification! Disgraceful!");
        }else{
            if(human == 1) moveC = "PAPER!";
            else if(human == 2) moveC = "CROSSBLADES!";
            else if(human == 3) moveC = "ROCK!";
            System.out.println( "Pathetic. You cannot hope to beat me without the passion of a thousand suns, \n"
            + "without the dedication of a Pleistocene glacier! I choose " + moveC); 
        }
        
     
    }
    
    public static int computer(int move){
        int ans = 0;
        if(move != 0){
            ans = (int)(Math.random()*2+1);
        }
        return ans;  
    }
    
    public static String result (int ans){
        String response = "";
        if(ans == 1) response = "ROCK!";
        if(ans == 2) response = "PAPER!";
        if(ans == 3) response = "CROSSBLADES!";
        if(ans == 0) return "You have failed to adhere to the ancient traditions of Rock, Paper,\n Crossblades! " + 
        "You have lost by disqualification! Disgraceful!";
        return "Me: Does he know my strategy? Two stones in a row... what are the chances? \n" +
        "Did he steal my notes? Did he follow me into the archives? No, stay the course: \n" +response; 
    }
    
    
    public static void FinalResult(int h, int c){  
      String result = "";
        if(h==c && h!=0 && c!=0) result = "Unbelievable! We have tied! *Eye twitches*";
        else if(h==1 && c==2 || h==2 && c==3 || h==3 && c==1) result = "As I predicted, I have won this battle. The kingdom is MINE!";
        else if(h==1 && c==3 || h==2 && c==1 || h==3 && c==2) result = "WHAT! How did you kno- *turns to stone*";  
        else if(h==0 && c==0) result = "As I predicted, I have won this battle. The kingdom is MINE!";
       System.out.println("\nResult: "+ result);
    }

   
}
