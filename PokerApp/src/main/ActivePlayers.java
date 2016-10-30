package main;

import exceptions.NoRoleFoundAtPlayersException;
import exceptions.TooFewPlayersException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import players.Player;

/**
 *
 * @author Zsolt
 */
public class ActivePlayers {

    private static final Logger LOG = Logger.getLogger(ActivePlayers.class.getName());
    private List<Player> players;

    public ActivePlayers() {
        this.players = new ArrayList<>();
    }

    public ActivePlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayers(List<Player> players) {
        this.players = players;
    }

    public Player get(int index) {
        return players.get(index);
    }

    public void setRandomRoles() throws TooFewPlayersException {
//        TODO: rewrite to a real random role allocation
        if (this.players.size() > 1) {
            players.get(0).addRole(Role.DEALER);
            players.get(1).addRole(Role.SMALL_BLIND);

            if (this.players.size() == 2) {
                players.get(0).addRole(Role.BIG_BLIND);
            } else {
                players.get(2).addRole(Role.BIG_BLIND);
            }
        } else {
            throw new TooFewPlayersException("There are only "
                    + this.players.size() + " player!");
        }
    }

    public Player getPlayerByRole(Role role) {
        for (Player player : players) {
            if (player.hasExactRole(role)) {
                return player;
            }
        }
        throw new NoRoleFoundAtPlayersException("No role found for players: "
                + role.name());
    }
    
    public int getPlayerIndexByRole(Role role) {
        for (int i=0; i<this.players.size(); ++i) {
            if (players.get(i).hasExactRole(role)) {
                return i;
            }
        }
        throw new NoRoleFoundAtPlayersException("No role found for players: "
                + role.name());
    }
    
    public void setPlayerToDealer(int position) {
        for(Player player : this.players) {
            player.removeAllRole();
        }
        players.get(position).addRole(Role.DEALER);
        LOG.log(Level.INFO, "Player: {0} is now the DEALER", players.get(position).getName());
        this.nextPlayer(position).addRole(Role.SMALL_BLIND);
        LOG.log(Level.INFO, "Player: {0} is now the SB", this.nextPlayer(position).getName());
        this.nextPlayer(position+1).addRole(Role.BIG_BLIND);
        LOG.log(Level.INFO, "Player: {0} is now the BB", this.nextPlayer(position+1).getName());
    }
    
    public List<Player> getPlayers() {
        return this.players;
    }
    
    /**
     * This method returns a list, what's first element is the fromPosition-th
     * index of the list.
     * E.g: at preflop the turn starts from after BB position.
     * 
     * @param fromPosition must be between 0 and allPlayers.size
     * @return 
     */
    public List<Player> getPlayersFromPosition(int fromPosition) {
        List<Player> ret = new ArrayList<>();
        for(int i=fromPosition; i<this.players.size(); ++i) {
            ret.add(this.players.get(i));
        }
        for(int i=0; i<fromPosition; ++i) {
            ret.add(this.players.get(i));
        }
        return ret;
    }
    
    /**
     * This method returns the next player of a specific index
     * 
     * @param index
     * @return with Player object
     */
    public Player nextPlayer(int index) {
        if(index == this.players.size()-1) {
            return this.players.get(0);
        } else {
            return this.players.get(index + 1);
        }
    }
}
