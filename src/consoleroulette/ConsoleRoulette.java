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
public class ConsoleRoulette {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Players players = new Players();
        ReadInput readInput = new ReadInput(players);
        readInput.getFileFirst();
        
         Thread t1 = new Thread() {

            @Override
            public void run() {                
             Play play = new Play();
             play.StartBetting(players); 
            }
        };
        Thread t2 = new Thread() {

            public void run() {
                readInput.getBets();
            }
        };
        t1.start();
        t2.start();
    }
    
}
