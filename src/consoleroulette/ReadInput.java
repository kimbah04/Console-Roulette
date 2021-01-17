/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleroulette;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author kinah
 */
public class ReadInput {
private String filename;    
Players players;

    ReadInput(Players players) {
       this.players = players;
    }
    public void getFileFirst()
         {
         System.out.println("Enter file path to read");
         Scanner in = new Scanner(System.in); 
         this.filename = in.nextLine(); //C:\\testing.txt
         if(this.filename != null && !this.filename.isEmpty())
            {
            readFile();
            }
         }
    private void readFile()
         {
         if(Files.exists(Paths.get(this.filename))) 
            {
            BufferedReader reader;
           
		try {
			reader = new BufferedReader(new FileReader(this.filename));
			String line = reader.readLine();
			while (line != null) {
                                 line = line.replaceAll("  ", " ");
                                 String[] playerArray = line.split(" ");
                                 players.addPlayers(playerArray[0],
                                         ((playerArray.length > 2 )?Double.parseDouble(playerArray[1]): 0.0), 
                                         ((playerArray.length > 2)?Double.parseDouble(playerArray[2]):0.0));
                                // read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
            }
         else
            {
            System.out.println("Error file does not exist");
            this.getFileFirst();
            }
         }
   public void getBets()
         {
          System.out.println("Enter player's bet");
          Scanner in = new Scanner(System.in); 
          String betString = in.nextLine(); //C:\\testing.txt
          betString = betString.replaceAll("  ", " ");
          String[] betArray = betString.split(" ");
          if(players.playerExists(betArray[0]))
             {
             players.addBet(new Bet(betArray[0], betArray[1], betArray[2]));               
             this.getBets();
             }
          else
             {
             System.out.println("Player is not the list of submitted players");
             }
          
         }
}
