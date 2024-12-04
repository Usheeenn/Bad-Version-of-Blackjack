import java.util.Random;
import java.util.Scanner;

public class blackjack 
{
    public static void main(String[] args)
    {
        Random randomNumber = new Random();
        Scanner keyboard = new Scanner(System.in);

        //Variables
        double bet;
        double wallet = 100;
        String repeat, draw;
        int playerDrawCard;
        int playerWin, dealerWin;

        System.out.println("Welcome to Blackjack! You start with $100");

        //Main Loop
        do{
            //Input 
            System.out.println("*Player's turn*");
            System.out.println("You have $" + wallet );

                if(wallet > 0)//Checking if wallet is empty 
                {
                    System.out.print("\nEnter your bet: ");
                    bet = keyboard.nextDouble();
                    wallet -= bet;
                    keyboard.nextLine();
                }

                else
                {
                    bet = 0;
                    System.out.println("You have no money left!");
                    System.out.println("Your bets will now equal zero");
                }

              /*  if(bet > wallet)//Checking if bet is greater then wallet
                {
                    System.out.println("Your bet is too high!");
                    System.out.println("Your bets will now only  equal zero");
                    
                    
                    System.out.print("\nEnter your bet: ");
                    bet = keyboard.nextDouble();
                    wallet -= bet;
                    keyboard.nextLine();
                } */


            int playerCard, playerCardTotal = 0; // Variables Inside Loop

            for(int i = 1; i <= 2; i++)
            {
                playerCard = randomNumber.nextInt(10) + 1;
                playerCardTotal += playerCard;
                
                System.out.println("Your cards are: " + playerCard);
            }

            System.out.println("Your total is: " + playerCardTotal);//Total

            //Draw Card
            do{
                System.out.print("Would you like to 'hit' or 'stand'? ");
                draw = keyboard.nextLine();

                if(draw.equalsIgnoreCase("hit"))
                {
                    playerDrawCard = randomNumber.nextInt(10) + 1;
                    playerCardTotal += playerDrawCard;
                    System.out.println("You drew " + playerDrawCard);
                    System.out.println("Your new total is: " + playerCardTotal);
                }

                if(playerCardTotal > 21)
                {
                    draw = "Stand";
                    System.out.println("You went over 21");
                }

            }while(draw.equalsIgnoreCase("Hit"));
           
            
            //Dealer
            System.out.println("\n*Dealer's turn*");

            int dealerCard, dealerCardTotal = 0;

            for(int i = 1; i <= 2; i++)
            {
                dealerCard = randomNumber.nextInt(10) + 1;
                dealerCardTotal += dealerCard;

                System.out.println("Dealer drew " + dealerCard);
            }            

            System.out.println("Dealer's cards are: " + dealerCardTotal);

            while(dealerCardTotal < playerCardTotal && playerCardTotal <= 21)
            {
                dealerCard = randomNumber.nextInt(10) + 1;
                dealerCardTotal += dealerCard;
                System.out.println("Dealer drew " + dealerCard);
                System.out.println("Dealer's new total is: " + dealerCardTotal);

                if(dealerCardTotal > 21)
                {
                    System.out.println("Dealer has gone over 21!");
                }
            }


        

        //Winner
        if(playerCardTotal > 21 && dealerCardTotal > 21 )//Both Lose
        {
            System.out.println("You and the dealer both went bust");

            wallet = wallet + bet;
            System.out.println("Your wallet has: " + wallet);
        }

        else if(dealerCardTotal == playerCardTotal)//Draw
        {
            System.out.println("It's a draw?");
            wallet = wallet + bet;
            System.out.println("Your wallet has: " + wallet);
        }

        else if(playerCardTotal <= 21 && dealerCardTotal > 21)//Player Win
        {
            wallet = wallet + bet * 2;
            System.out.println("\nYou won!");
            System.out.println("Your wallet has " + wallet);
        }

        else if(dealerCardTotal > playerCardTotal && playerCardTotal < 21 && dealerCardTotal <= 21)//Player Lose
        {
            System.out.println("\nYou Lose!");
            System.out.println("Player Total is: " + playerCardTotal + " and Dealer Total is: " + dealerCardTotal);
            System.out.println("Your wallet has: " + wallet);
        }

        else if(playerCardTotal > 21 && dealerCardTotal <= 21)//Player Lose
        {
            System.out.println("\nYou Lose!");
            System.out.println("Player Total is: " + playerCardTotal + " and Dealer Total is: " + dealerCardTotal);
            System.out.println("Your wallet has: " + wallet);
        }

        



        //Repeat  
            System.out.print("\nWould you like to play again?: ");
            repeat = keyboard.nextLine();

        }while(repeat.equalsIgnoreCase("yes"));


        System.out.println("Your wallet has $" + wallet);
    }
}
