/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleroulette;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author kinah
 */
public class Play {
 private Players players;  
  public void StartBetting(Players players)
      {
      this.players = players;    
       try {
        while (true) {    
            Thread.sleep(30 * 1000);
            if(players.getBets().size() >= players.getPlayers().size())
              {
              processBet();
              }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
      
      }

    private void processBet() {
        Random rand = new Random(); 
        final int randomNumber  =  rand.nextInt(37); 
        final String evenOrOdd = randomNumber % 2 == 0? "EVEN":"ODD";
        System.out.println("Number: "+randomNumber);
        System.out.format("%32s%15s%15s%15s\n", "Player", "Bet", "Outcome", "Winnings");
        players.getBets().stream().forEach(bet->{
         if(bet.getBetOnNumber() > 0)
            {
            bet.setWinOrLose(bet.getBetOnNumber() == randomNumber?"WIN":"LOSE");
            bet.setWinnings(bet.getWinOrLose().equals("WIN")? (bet.getBetAmount() * 36): 0.0);
            
            }
         else
            {           
            bet.setWinOrLose(bet.getBetOnNumberType().equals(evenOrOdd)?"WIN":"LOSE");
            bet.setWinnings(bet.getWinOrLose().equals("WIN")? (bet.getBetAmount() * 2): 0.0);
            }
        System.out.format("%32s%15s%15s%15f\n", bet.getPlayerName(), (bet.getBetOnNumber() > 0?bet.getBetOnNumber(): bet.getBetOnNumberType()), bet.getWinOrLose(), bet.getWinnings());
        });
        
       System.out.println(  );  
       
      System.out.format("%32s%15s%15s\n", "Player", "Total Win", "Total Bet");
      players.getPlayers().stream().forEach(line->{
      double totalBets = line.getTotalBets();
      double totalWins = line.getTotalWins();
      List<Bet> bets = players.getBets().stream().filter(b->{ return b.getPlayerName().equals(line.getName()); }).collect(Collectors.toList());
      totalBets += bets.size();
      totalWins += bets.stream().mapToDouble(r-> r.getWinnings() ).sum();
      System.out.format("%32s%15f%15f\n", line.getName(), totalWins, totalBets);
      
      
      });
        
    }
    
    
}
