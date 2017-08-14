##Implementation of a poker card rating

Rates poker card hands and determines the highest hand.

###Run tests 
**mvn test**

###Create executable jar 
**mvn install**

###Run jar 
Run the jar and specify the cards as two comma separated lists:
<br>
`java -jar pokerhands-1.0-SNAPSHOT.jar h1card1,h1card2,h1card3,h1card4,h1card5 h2card1,h2card2,h2card3,h2card4,h2card5` 
<br>
**The card names must match the names specified in [de.kneissja.pokerhands.cards.Card](src/main/java/de/kneissja/pokerhands/cards/Card.java).**
<br>
Example:
<br>`java -jar pokerhands-1.0-SNAPSHOT.jar CLUBS_2,CLUBS_3,CLUBS_4,CLUBS_5,CLUBS_6 SPADES_6,DIAMONDS_JACK,HEARTS_10,CLUBS_9,CLUBS_KING`