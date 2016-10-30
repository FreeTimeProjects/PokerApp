package main;

import enums.CardColour;
import enums.CardType;

/**
 *
 * @author Zsolt
 */
public class Card {
    private CardType cardType;
    private CardColour cardColour;

    public Card(CardType cardType, CardColour cardColour) {
        this.cardType = cardType;
        this.cardColour = cardColour;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardColour getCardColour() {
        return cardColour;
    }

    public void setCardColour(CardColour cardColour) {
        this.cardColour = cardColour;
    }
}
