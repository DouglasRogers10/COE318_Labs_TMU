package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House holds:");
        for (Card c: game.getHouseCards().getCards())
        {
            System.out.println(c);
        }
        
        System.out.println();
    
        System.out.println("You hold: ");
        for (Card c: game.getYourCards().getCards())
        {
            System.out.println(c);
        }
    
        System.out.println();
        
    }
    

  @Override
    public boolean hitMe() {
        System.out.print("Another card (y/n)? ");
        String input = user.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

  @Override
    public void gameOver() {
       System.out.println("Game over\n");
       
       System.out.println("House holds:");
       
       for (Card c: game.getHouseCards().getCards())
       {
           System.out.println(c);
       }
       
       System.out.println();
       
       System.out.println("You hold:");
       
       for (Card c: game.getYourCards().getCards())
       {
           System.out.println(c);
       }
       
       System.out.println();
       
       int yourScore = game.score(game.getYourCards());
       int houseScore = game.score(game.getHouseCards());
       
       System.out.println("Your score: " + yourScore + ", House score: " + houseScore);
       
       if (yourScore > 21)
       {
           System.out.println("The House wins");
       }
       else if (houseScore > 21)
       {
           System.out.println("You win");
       }
       else if (yourScore > houseScore)
       {
           System.out.println("You win");
       }
       else
       {
           System.out.println("The house wins");
       }
       
    }
    

}