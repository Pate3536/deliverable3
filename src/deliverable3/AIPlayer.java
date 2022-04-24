/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deliverable3;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
class AIPlayer extends Player

{

    public ArrayList<Card> queries = new ArrayList<>();

    private int age = 0;

    @Override
    public void haveTurn()

    {

        boolean playing;

        do{

            Card book = checkForBooks();

            if(book != null)

                System.out.println("Your opponent got a book of " + book + "s...");

            if (hand.isEmpty())

            {

                System.out.print("Your opponent's hand is empty.");

                break;

            }

            Card req = aiMagic();

            System.out.println("Your opponent asks for cards by the name of " + req);

            playing = askFor(req);

            age++;

        } while(playing);

        System.out.println("Your opponent goes fishing.");

        fish();

    }

                //The AI's strategy is to first ask for things you asked for, since you have those things.

                //Failing that, it chooses at random.

    private Card aiMagic()

    {

        if (age>2)

        {

            queries.remove(queries.size()-1);

            age=0;                          

        }

        for(int i=queries.size()-1; i>-1; i--)

            if (hand.contains(queries.get(i)))

            {

                return queries.remove(i);

            }                           

        return hand.get(GoFish.rng.nextInt(hand.size()));

    }

}