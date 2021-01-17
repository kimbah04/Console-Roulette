/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleroulette;

/**
 *
 * @author kinah
 */
public class Bet {

    Bet(String playerName, String betOn, String betAmount) {
        this.playerName = playerName;
        this.betOnNumberType = (betOn.equals("EVEN") || betOn.equals("ODD"))?betOn:"";
        this.betOnNumber = (!betOn.equals("EVEN") && !betOn.equals("ODD"))?Integer.parseInt(betOn):0;
        this.betAmount = Double.parseDouble(betAmount);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getBetOnNumber() {
        return betOnNumber;
    }

    public void setBetOnNumber(int betOnNumber) {
        this.betOnNumber = betOnNumber;
    }

    public String getBetOnNumberType() {
        return betOnNumberType;
    }

    public void setBetOnNumberType(String betOnNumberType) {
        this.betOnNumberType = betOnNumberType;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public String getWinOrLose() {
        return winOrLose;
    }

    public void setWinOrLose(String winOrLose) {
        this.winOrLose = winOrLose;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }
    
    private String playerName;
    private int betOnNumber;
    private String betOnNumberType;
    private double betAmount;
    private String winOrLose;
    private double winnings;
}
