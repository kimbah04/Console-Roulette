/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleroulette;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kinah
 */
public class Players {
    private List<Player> playerList;
    private List<Bet> bets;
    
    public void addPlayers(String name, double totalWins, double totalBets)
         {
         playerList = playerList == null? new ArrayList<>():playerList;
         playerList.add(new Player(name, totalWins, totalBets));
         }
    public boolean playerExists(String playerName) {
     Player player = playerList.stream().filter(r-> { return r.getName().equals(playerName); })
    .findFirst()
    .orElse(null);
     return player != null;        
    }
   
   public void addBet(Bet bet)
         {
         bets = bets == null? new ArrayList<>():bets;
         bets.add(bet);
         }
   public List<Bet> getBets()
         {
         return bets;
         }
   public List<Player> getPlayers()
         {
         return playerList;
         }
}
