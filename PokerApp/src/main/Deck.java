package main;

import enums.CardColour;
import enums.CardType;
import enums.DeckType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Zsolt
 */
public class Deck {

    private static DeckType deckType;
    private static List<Card> cards;

    public Deck(DeckType type) {
        deckType = type;
        initialize();
    }

    private static void generateDeck() {
        for (CardColour colour : CardColour.values()) {
            for (CardType type : CardType.values()) {
                cards.add(new Card(type, colour));
            }
        }
    }

    private static void initialize() {
        switch (deckType) {
            case MASTER:
                cards = new ArrayList<>(52);
                generateDeck();
                break;
            case PLAYER:
                cards = new ArrayList<>(2);
                break;
            case TABLE:
                cards = new ArrayList<>(5);
                break;
            default:
                cards = new ArrayList<>();
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

//    le kell ellenőrizni!
    public Card getRandomCard() {
        Random rand = new Random();
        return cards.remove(rand.nextInt(52));
    }
}
