/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB IV
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 12 OCTOBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/


package ui;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;


public class Main {
	
	private Scanner reader;
	private Manager manager;
	
	public Main() {
		
		manager = new Manager();
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main execute = new Main();
		execute.menu();
		
	
	}

	public void showMenuOptions(){
		System.out.println("");
		System.out.println("");
		System.out.println("1. Search spectator by ID.");
		System.out.println("2. Search player by ID");
		System.out.println("3. Search spectators by country");
		System.out.println("4. Search players by country");
		System.out.println("5. QUIT PROGRAM.");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
	}
	
	public void menu(){
		int userInput = 0;
		

		System.out.println("");
		System.out.println("");

		//WELCOME 	
		System.out.println("M''MMM''MMM''M          dP                                         "); 
		System.out.println("M  MMM  MMM  M          88                                         ");
		System.out.println("M  MMP  MMP  M .d8888b. 88 .d8888b. .d8888b. 88d8b.d8b. .d8888b.   ");
		System.out.println("M  MM'  MM' .M 88ooood8 88 88'    ` 88'  `88 88'`88'`88 88ooood8");
		System.out.println("M  `' . '' .MM 88.  ... 88 88.  ... 88.  .88 88  88  88 88.  ...   ");
		System.out.println("M    .d  .dMMM `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'   TO VOLLEYsoft");
		System.out.println("MMMMMMMMMMMMMM                                                     ");
		System.out.println("                                                                   ");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Please type the spectator's relative path:");
		System.out.println("Hint for relative path: data/Base.csv");
		System.out.println();
		System.out.print("Answer: "); String path4This = reader.nextLine();
		path4This = path4This.trim();
		System.out.println();
		System.out.println();
		System.out.println();
		
		if (path4This.equalsIgnoreCase("data/Base.csv")) {

			
			
			try {
				System.out.println("Please wait a few seconds... LOADING %");
				System.out.println();
				
				if (manager.loadSpectatorsPlainText()) {
					System.out.println("File was successfully loaded thru reading plain text!");
					
				} else {
					System.out.println("ERROR: File was not loaded");
				}
				
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		

			while (userInput != 5){

				showMenuOptions();

				System.out.println("--------------------------------------");
				System.out.print("| Type the number of your selection: ");
				try {
					userInput = reader.nextInt();
					reader.nextLine();
					System.out.println("--------------------------------------");
		
					switch (userInput) {
		
						//SEARCH SPECTATOR
						case 1: 
							searchSpectator();
							break;
		
						//SEARCH PLAYER
						case 2: 
							searchPlayer();
							break; 
		
		
						//SEARCH SPECTATORS BY COUNTRY
						case 3: 
							searchSpectatorsByCountry(); 
							break;
							
						//SEARCH PLAYERS BY COUNTRY
						case 4: 
							searchPlayersByCountry(); 
							break;
							
							//QUIT PROGRAM
						case 5: 
							theGoodbye(); 
							break;
							
		
						default:
							System.out.println();
							System.out.println("Please type a number between 1 and 5");
							System.out.println();
							break;
						
					}
				} catch(InputMismatchException e){
					System.out.println();
					System.out.print("ERROR: Wrong data type.");
					reader.nextLine();
					System.out.println();
				}
				
			}
		} else {
			System.out.println("");
			System.out.println("ERROR: Invalid path.");
			System.out.println("");
			}
		
		
	}
		
	
	
	
	

	public void searchSpectator() {
		try {
			System.out.println("Please type the ID of the spectator: "); String stuff = reader.nextLine();
			System.out.println();
			
			if (!(stuff.equalsIgnoreCase(""))) {
			
				long first1 = System.nanoTime();
				System.out.println();
				System.out.println(manager.searchSpectator(stuff));
				System.out.println();
				long second2 = System.nanoTime();
				long finalT2 = second2- first1;
				System.out.println("Time for searching a clan in nanoseconds: "+finalT2);
				System.out.println();
			} else {
				System.out.println("");
				System.out.println("ERROR: Invalid ID");
				System.out.println("");
				}
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	
	public void searchPlayer() {
		try {
			System.out.println("Please type the ID of the player: "); String stuff = reader.nextLine();
			
			if (!(stuff.equalsIgnoreCase(""))) {
				
				long first1 = System.nanoTime();
				System.out.println();
				System.out.println(manager.searchPlayer(stuff));
				System.out.println();
				long second2 = System.nanoTime();
				long finalT2 = second2- first1;
				System.out.println("Time for searching a player in nanoseconds: "+finalT2);
				System.out.println();
			
			} else {
					System.out.println("");
					System.out.println("ERROR: Invalid ID.");
					System.out.println("");
					}
				
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	
	public void searchPlayersByCountry() {
		try {
			System.out.println("Please type the country of the players: "); String stuff = reader.nextLine();
			
			if (!(stuff.equalsIgnoreCase(""))) {
				
				long first1 = System.nanoTime();
				System.out.println();
				System.out.println(manager.searchPlayersByCountry(stuff));
				System.out.println();
				long second2 = System.nanoTime();
				long finalT2 = second2- first1;
				System.out.println("Time for searching players from "+stuff+" in nanoseconds: "+finalT2);
				System.out.println();
			
			} else {
					System.out.println("");
					System.out.println("ERROR: Invalid country.");
					System.out.println("");
					}
				
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	public void searchSpectatorsByCountry() {
		try {
			System.out.println("Please type the country of the spectators: "); String stuff = reader.nextLine();
			
			if (!(stuff.equalsIgnoreCase(""))) {
				
				long first1 = System.nanoTime();
				System.out.println();
				System.out.println(manager.searchSpectatorsByCountry(stuff));
				System.out.println();
				long second2 = System.nanoTime();
				long finalT2 = second2- first1;
				System.out.println("Time for searching spectators from "+stuff+" in nanoseconds: "+finalT2);
				System.out.println();
			
			} else {
					System.out.println("");
					System.out.println("ERROR: Invalid country.");
					System.out.println("");
					}
				
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	

		public void theGoodbye() {
			
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("THANK YOU FOR USING VOLLEYsoft");
			System.out.println("");
		}
		
		
		
	

}//end of class

