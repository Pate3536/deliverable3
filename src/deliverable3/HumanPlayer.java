/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deliverable3;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
class HumanPlayer extends Player

{

    @Override
    public void haveTurn()

    {

        Scanner scn = new Scanner(System.in);

        boolean playing = true;

        do{

            Card book = checkForBooks();

            if(book != null)

                System.out.println("You got a book of " + book + "s!");

            if (hand.size() == 0)

            {

                System.out.print("Your hand is empty, you must "); //"Go fish!"

                break;

            }

            else

            {

                System.out.print("Your hand:");

                for(Card c: hand)

                    System.out.print(c + " ");

                System.out.println();

            }

            System.out.println("Ask opponent for what card?");

            Card req;

            try{

                req = Card.valueOf(scn.next().toUpperCase());

            }

            catch(IllegalArgumentException e){

                System.out.println("Card not present in this deck. Try again:");

                continue;

            }

            if(!hand.contains(req))

            {

              System.out.println("You may not ask for a card you have none of. Try again:");

                continue;

            }

            System.out.println("You ask for a " + req);

            playing = askFor(req);

        } while(playing);

        System.out.println("Go fish!");

        fish();

    }

}