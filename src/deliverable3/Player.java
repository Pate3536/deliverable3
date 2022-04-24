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
abstract class Player

{

    protected ArrayList<Card> hand = new ArrayList<>();

    private int numBooks;

    public Player()

    {

        for(int i=0;i<8;i++)

            fish();

    }

    public boolean hasGiven(Card cType)

    {

        return hand.contains(cType);

    }

    public ArrayList<Card> giveAll(Card cType)

    {

        ArrayList<Card> x = new ArrayList<>();

       for(int i=0;i<hand.size();i++)           

            if (hand.get(i) == cType)

              x.add(hand.get(i));

        for (Card x1 : x) {
            hand.remove(cType);
        }

        return x;

  }

    protected boolean askFor(Card cType)

    {

        int tmp = 0;

        if (this instanceof HumanPlayer)

            tmp = 1;

        Player other = GoFish.Players[tmp];

                if (tmp==1)

            ((AIPlayer) other).queries.add(cType);

        //                               //

        if (other.hasGiven(cType))

        {

            for(Card c: other.giveAll(cType))

                hand.add(c);

            return true;

        }

        else

        {

            return false;

        }

    }

    protected final void fish()

                    {

                        if (GoFish.deckSize() > 0)

                                hand.add(GoFish.draw());

                        else

                                System.out.println("But that's impossible since the deck is empty.");

    }

    public int getNumBooks()

    {

        return numBooks;

    }

    protected Card checkForBooks()

    {

        for(Card c: hand)

        {

            int num = 0;

            for(Card d: hand)

              if (c == d)

                  num++;

            if (num == 4)

            {

                for(int i=0;i<4;i++)

                    hand.remove(c);

                numBooks++;

                return c;

            }

        }

        return null;

    }

    public abstract void haveTurn();

}