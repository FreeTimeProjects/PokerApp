package players;

import enums.ActivityType;
import exceptions.PlayerIsOutOfMoneyException;
import java.util.ArrayList;
import java.util.List;
import main.Card;
import main.Role;

/**
 *
 * @author Zsolt
 */
public abstract class Player {

    protected String name;
//    money
    protected Double token;
    protected List<Role> roles;
    protected List<Card> cards;
    protected boolean isActive;

    /**
     * constructor for Player
     *
     * @param name name of the player
     * @param token token(/money), that the player has
     */
    public Player(String name, Double token) {
        this.name = name;
        this.token = token;
        roles = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getToken() {
        return token;
    }

    public void setToken(Double token) {
        this.token = token;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Returns a Decision object, what the player does before the flop,
     * after he/it get it's cards.
     *
     * @return the decision, that player made
     */
    public abstract Decision preFlop();
    
    /**
     * Returns a Decision object, what the player does after the flop.
     * 
     * @return the decision, that player made
     */
    public abstract Decision flop();
    
    /**
     * Returns a Decision object, what the player does after the turn.
     *
     * @return the decision, that player made
     */
    public abstract Decision turn();

    /**
     * TODO
     *
     * @param role
     */
    public void addRole(Role role) {
        this.roles.add(role);
    }

    /**
     * TODO
     *
     * @param role
     */
    public void removeRole(Role role) {
        this.roles.remove(role);
    }
    
    /**
     * This method removes all role-s and returns if player had role or not.
     * 
     * @return true if player had minimun one role, else with false
     */
    public boolean removeAllRole() {
        boolean hadRole = !this.roles.isEmpty();
        this.roles.clear();
        return hadRole;
    }

    /**
     * TODO
     *
     * @return
     */
    public boolean hasRole() {
        return !roles.isEmpty();
    }

    /**
     * TODO
     *
     * @param role
     * @return
     */
    public boolean hasExactRole(Role role) {
        return this.roles.contains(role);
    }

    /**
     *
     * @param bet
     * @return
     */
    public Double getBlindBet(Double bet) {
        if (this.token >= bet) {
            this.token -= bet;
            return bet;
        } else {
            throw new PlayerIsOutOfMoneyException("Player: " + this.name
                    + " is out of money!");
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public List<Card> giveBackCards() {
        List<Card> ret = this.cards;
        this.cards.clear();
        return ret;
    }
}
