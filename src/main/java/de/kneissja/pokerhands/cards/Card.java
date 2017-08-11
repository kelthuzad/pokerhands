package de.kneissja.pokerhands.cards;

/**
 * Enum for all poker cards
 * @author kneissja
 */
public enum Card {
    CLUBS_2(Cardsuit.CLUBS, 2),
    CLUBS_3(Cardsuit.CLUBS, 3),
    CLUBS_4(Cardsuit.CLUBS, 4),
    CLUBS_5(Cardsuit.CLUBS, 5),
    CLUBS_6(Cardsuit.CLUBS, 6),
    CLUBS_7(Cardsuit.CLUBS, 7),
    CLUBS_8(Cardsuit.CLUBS, 8),
    CLUBS_9(Cardsuit.CLUBS, 9),
    CLUBS_10(Cardsuit.CLUBS, 10),
    CLUBS_JACK(Cardsuit.CLUBS, 11),
    CLUBS_QUEEN(Cardsuit.CLUBS, 12),
    CLUBS_KING(Cardsuit.CLUBS, 13),
    CLUBS_ACE(Cardsuit.CLUBS, 14),

    DIAMONDS_2(Cardsuit.DIAMONDS, 2),
    DIAMONDS_3(Cardsuit.DIAMONDS, 3),
    DIAMONDS_4(Cardsuit.DIAMONDS, 4),
    DIAMONDS_5(Cardsuit.DIAMONDS, 5),
    DIAMONDS_6(Cardsuit.DIAMONDS, 6),
    DIAMONDS_7(Cardsuit.DIAMONDS, 7),
    DIAMONDS_8(Cardsuit.DIAMONDS, 8),
    DIAMONDS_9(Cardsuit.DIAMONDS, 9),
    DIAMONDS_10(Cardsuit.DIAMONDS, 10),
    DIAMONDS_JACK(Cardsuit.DIAMONDS, 11),
    DIAMONDS_QUEEN(Cardsuit.DIAMONDS, 12),
    DIAMONDS_KING(Cardsuit.DIAMONDS, 13),
    DIAMONDS_ACE(Cardsuit.DIAMONDS, 14),

    HEARTS_2(Cardsuit.HEARTS, 2),
    HEARTS_3(Cardsuit.HEARTS, 3),
    HEARTS_4(Cardsuit.HEARTS, 4),
    HEARTS_5(Cardsuit.HEARTS, 5),
    HEARTS_6(Cardsuit.HEARTS, 6),
    HEARTS_7(Cardsuit.HEARTS, 7),
    HEARTS_8(Cardsuit.HEARTS, 8),
    HEARTS_9(Cardsuit.HEARTS, 9),
    HEARTS_10(Cardsuit.HEARTS, 10),
    HEARTS_JACK(Cardsuit.HEARTS, 11),
    HEARTS_QUEEN(Cardsuit.HEARTS, 12),
    HEARTS_KING(Cardsuit.HEARTS, 13),
    HEARTS_ACE(Cardsuit.HEARTS, 14),

    SPADES_2(Cardsuit.SPADES, 2),
    SPADES_3(Cardsuit.SPADES, 3),
    SPADES_4(Cardsuit.SPADES, 4),
    SPADES_5(Cardsuit.SPADES, 5),
    SPADES_6(Cardsuit.SPADES, 6),
    SPADES_7(Cardsuit.SPADES, 7),
    SPADES_8(Cardsuit.SPADES, 8),
    SPADES_9(Cardsuit.SPADES, 9),
    SPADES_10(Cardsuit.SPADES, 10),
    SPADES_JACK(Cardsuit.SPADES, 11),
    SPADES_QUEEN(Cardsuit.SPADES, 12),
    SPADES_KING(Cardsuit.SPADES, 13),
    SPADES_ACE(Cardsuit.SPADES, 14);

    private Cardsuit suit;
    private int value;

    /**
     * @return the suit of the card
     */
    public Cardsuit getSuit() {
        return suit;
    }

    /**
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    Card(final Cardsuit suit, final int value) {
        this.suit = suit;
        this.value = value;
    }
}
