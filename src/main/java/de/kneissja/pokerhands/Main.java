package de.kneissja.pokerhands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.Hand;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Program entry point
 * @author kneissja
 */
public class Main {

    /**
     * Main method, must be run with two args
     * @param args expects two arguments.
     *             Each argument must consist of a comma separated list of card names.
     *             The card names must exactly match the names in {@link Card}.
     */
    public static void main(String... args) {
        if (args.length != 2) {
            System.err.println("Invalid number of arguments");
            return;
        }

        final String hand1Input = args[0];
        final Collection<Card> hand1Cards = parseCards(hand1Input);

        final String hand2Input = args[1];
        final Collection<Card> hand2Cards = parseCards(hand2Input);

        Hand highestPokerhand = new PokerHandsService().findHighestPokerhand(hand1Cards, hand2Cards);

        if (highestPokerhand == null) {
            System.out.println("Both hands are equal");
        } else {
            System.out.println("This hand is the highest: "+highestPokerhand);
        }

    }

    private static Collection<Card> parseCards(String input) {
        String[] cardStrings = input.split(",");

        try {
            return Arrays.stream(cardStrings).map(Card::valueOf).collect(Collectors.toList());
        } catch (final IllegalArgumentException e) {
            System.err.println("Invalid Input: "+input+", could not be parsed into Card Enum");
            throw e;
        }
    }
}
