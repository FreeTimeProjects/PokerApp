package main;

import enums.DeckType;
import exceptions.TooFewPlayersException;
import java.util.ArrayList;
import players.Player;
import java.util.List;

/**
 *
 * @author Zsolt
 */
public class Quizmaster {
    
    private static final Quizmaster INSTANCE = new Quizmaster();
//    equals the amount of Big Blind bet
    private Double minBet;
    private Deck deck;
    private Double pot = 0.0;
    private ActivePlayers players;
    private List<Card> tableCards;

    private Quizmaster() {
        players = new ActivePlayers();
        tableCards = new ArrayList<>();
    }

    public static Quizmaster getINSTANCE() {
        return INSTANCE;
    }

    /**
     * The Quizmaster controls:
     *  1 - Sits down the players to the table, make the Deck,
     * sets the bigBlind, hands out the 3 Buttons
     * 
     * TODO
     * 
     * @param players
     * @throws TooFewPlayersException 
     */
    public void playGame(List<Player> players) throws TooFewPlayersException {
        initialize(players);
        firstBet();
        handOutCards();
        preFlop();
        flop();
        preTurn();
        turn();
        preRiver();
        river();
        showdown();
    }

    /**
     * This method initializes the Quizmaster object, gives out randomly the
     * Small/Big Blind buttons, and sets the min bet.
     * 
     * @param players
     * @throws TooFewPlayersException 
     */
    private void initialize(List<Player> players) throws TooFewPlayersException {
        this.deck = new Deck(DeckType.MASTER);
        this.players.addPlayers(players);
        this.players.setRandomRoles();
        this.minBet = 1.0;
        this.pot = 0.0;
    }
    
    /**
     * This method makes the Small+Big Blinds to pay their blinds.
     */
    private void firstBet() {
        Player smallBlind = this.players.getPlayerByRole(Role.SMALL_BLIND);
        Player bigBlind = this.players.getPlayerByRole(Role.BIG_BLIND);
        pot += smallBlind.getBlindBet(minBet/2);
        pot += bigBlind.getBlindBet(minBet);
    }
    /**
     * This method hands out 2 random cards to each player from the deck.
     * There will be deleted thoose cards from the deck.
     */
    private void handOutCards() {
        for(Player player : this.players.getPlayers()) {
            player.addCard(this.deck.getRandomCard());
            player.addCard(this.deck.getRandomCard());
        }
    }

    /**
     * The player after BB starts the preflop bid
     */
    private void preFlop() {
        players.get(players.getPlayerIndexByRole(Role.BIG_BLIND)+1).preFlop();
//        this is not correct (should use nextPlayer() instead of +1)
        for(Player player : players.getPlayersFromPosition(players.getPlayerIndexByRole(Role.BIG_BLIND)+1)) {
            player.preFlop();
        }
//        TODO
    }

    private void flop() {
        for(int i=0; i<3; ++i) {
            this.tableCards.add(deck.getRandomCard());
        }
    }

    private void preTurn() {
//        TODO
    }

    private void turn() {
        this.tableCards.add(deck.getRandomCard());
    }

    private void preRiver() {
//        TODO
    }

    private void river() {
        this.tableCards.add(deck.getRandomCard());
    }
    
    private void showdown() {
//        TODO
    }
    
}
