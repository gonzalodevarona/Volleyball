package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class TestManager {
	
	Manager manager;
	
	public void setupStage() {
		manager = new Manager();
		
	}
	
	public void setupStage1() {
		manager = new Manager();
		Player player1 = new Player("1", "Esperanza", "Gomez", "egomezxx@hotmail.com", "Colombia",'F', "apicture", new GregorianCalendar(1992,3,2));
		Player player2 = new Player("3", "Lana", "Rhoades", "lrohadesxx@hotmail.com", "USA",'F', "apicture", new GregorianCalendar(1999,2,2));
		Player player3 = new Player("2", "Squid", "Bob", "asaakira@hotmail.com", "Japan", 'F', "apicture", new GregorianCalendar(2015,2,2));
		Player player4 = new Player("6", "Johnny", "Sins", "jsinsxx@hotmail.com", "USA", 'M',"apicture", new GregorianCalendar(1992,3,2));
		manager.addPlayer(player1);
		manager.addPlayer(player2);
		manager.addPlayer(player3);
		manager.addPlayer(player4);
	}

	@Test
	void testSearch() {
		setupStage();
		String s = manager.searchPlayer("2");
		assertTrue(s.equalsIgnoreCase("ERROR: Player not found."));
		//message changes if and only if the method found the player
		
	}
	
	@Test
	void testSearch1() {
		setupStage1();
		String s = manager.searchPlayer("2");
		assertTrue(s.contains("Squid"));
		
	}
	
	@Test
	void testSearchByCountry() {
		setupStage();
		String s = manager.searchPlayersByCountry("USA");
		assertTrue(s.contains("Lana") == false);
		
	}
	
	@Test
	void testSearchByCountry1() {
		setupStage1();
		String s = manager.searchPlayersByCountry("USA");
		assertTrue(s.contains("Lana") && s.contains("Sins"));
		
	}

} //end of class
