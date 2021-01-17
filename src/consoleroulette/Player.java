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
public class Player {
    private String name;
    private double totalWins;
    private double totalBets;

    Player(String name, double totalWins, double totalBets) {
       this.name = name;
       this.totalBets = totalBets;
       this.totalWins = totalWins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(double totalWins) {
        this.totalWins = totalWins;
    }

    public double getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(double totalBets) {
        this.totalBets = totalBets;
    }
}
