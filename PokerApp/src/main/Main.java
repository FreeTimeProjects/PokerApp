package main;

import exceptions.TooFewPlayersException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import players.Player;
import players.RealPlayer;

/**
 *
 * @author Zsolt
 */
public class Main {
    
    private Main() {
//        hidden default constructor
    }
    
    public static List<Player> init() {
        List<Player> players = new ArrayList<>();
        Player player1 = new RealPlayer("Adolf", new Double(500));
        Player player2 = new RealPlayer("Bormann", new Double(750));
        Player player3 = new RealPlayer("Conrad", new Double(1000));
        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;
    }
    
    public static void main(String[] args) {
        Quizmaster quizmaster = Quizmaster.getINSTANCE();
        try {
            quizmaster.playGame(init());
        } catch (TooFewPlayersException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
