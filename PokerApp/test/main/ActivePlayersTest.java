/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import exceptions.TooFewPlayersException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import players.Player;
import players.RealPlayer;

/**
 *
 * @author Zsolt
 */
public class ActivePlayersTest {
    
    List<Player> list = new ArrayList<Player>();
    ActivePlayers players = new ActivePlayers();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list.add(new RealPlayer("A", 1000.0));
        list.add(new RealPlayer("B", 1000.0));
        list.add(new RealPlayer("C", 1000.0));
        list.add(new RealPlayer("D", 1000.0));
        list.add(new RealPlayer("E", 1000.0));
        this.players.addPlayers(list);
        try {
            players.setRandomRoles();
        } catch (TooFewPlayersException ex) {
            Logger.getLogger(ActivePlayersTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void testStaticRoleGeneralization() {
         Assert.assertEquals(players.getPlayerByRole(Role.DEALER), players.get(0));
     }
     
     @Test
     public void testSetPlayerToDealer() {
         int pos = 1;
         players.setPlayerToDealer(pos);
         Assert.assertEquals(players.getPlayerByRole(Role.BIG_BLIND), players.get(pos+2));
//         The 4th player
         players.setPlayerToDealer(3);
         Assert.assertEquals(players.getPlayerByRole(Role.BIG_BLIND), players.get(0));
     }
}
