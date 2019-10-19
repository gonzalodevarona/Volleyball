package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import model.Spectator;

class TestSpectator {
	
	Spectator spectator;
	
	public void setupStage() {
		spectator = new Spectator("2", "Squid", "Bob", "asaakira@hotmail.com", "Japan", 'F', "apicture", new GregorianCalendar(2015,2,2));
		Spectator spectator1 = new Spectator("1", "Esperanza", "Gomez", "egomezxx@hotmail.com", "Colombia",'F', "apicture", new GregorianCalendar(1992,3,2));
		Spectator spectator2 = new Spectator("3", "Lana", "Rhoades", "lrohadesxx@hotmail.com", "USA",'F', "apicture", new GregorianCalendar(1999,2,2));
		
		spectator.addSpectator(spectator1);
		spectator.addSpectator(spectator2);
	}
	
	public void setupStage1() {
		spectator = new Spectator("2", "Squid", "Bob", "asaakira@hotmail.com", "Japan", 'F', "apicture", new GregorianCalendar(2015,2,2));
		Spectator spectator2 = new Spectator("3", "Lana", "Rhoades", "lrohadesxx@hotmail.com", "USA", 'F', "apicture", new GregorianCalendar(1999,2,2));

		spectator.addSpectator(spectator2);
	}
	
	public void setupStage2() {
		spectator = new Spectator("2", "Squid", "Bob", "asaakira@hotmail.com", "Japan", 'F', "apicture", new GregorianCalendar(2015,2,2));
		Spectator spectator1 = new Spectator("1", "Esperanza", "Gomez", "egomezxx@hotmail.com", "Colombia", 'F',"apicture", new GregorianCalendar(1992,3,2));
		
		spectator.addSpectator(spectator1);
		
	}
	
	public void setupStage3() {
		spectator = new Spectator("2", "Squid", "Bob", "asaakira@hotmail.com", "Japan", 'F', "apicture", new GregorianCalendar(2015,2,2));
	}

	@Test
	void testSearch() {
		setupStage();
		String s = spectator.searchSpectator("1");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	
	@Test
	void testSearch1() {
		setupStage1();
		String s = spectator.searchSpectator("3");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	@Test
	void testSearch2() {
		setupStage2();
		String s = spectator.searchSpectator("1");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	@Test
	void testSearch3() {
		setupStage3();
		String s = spectator.searchSpectator("2");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	@Test
	void testAdd() {
		setupStage();
		
		Spectator spectator1 = new Spectator("6", "Johnny", "Sins", "jsinsxx@hotmail.com", "USA", 'M',"apicture", new GregorianCalendar(1992,3,2));
		spectator.addSpectator(spectator1);
		String s = spectator.searchSpectator("6");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	@Test
	void testAdd1() {
		setupStage1();
		
		Spectator spectator1 = new Spectator("6", "Johnny", "Sins", "jsinsxx@hotmail.com", "USA", 'M',"apicture", new GregorianCalendar(1992,3,2));
		spectator.addSpectator(spectator1);
		String s = spectator.searchSpectator("6");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	@Test
	void testAdd2() {
		setupStage2();
		
		Spectator spectator1 = new Spectator("6", "Johnny", "Sins", "jsinsxx@hotmail.com", "USA", 'M',"apicture", new GregorianCalendar(1992,3,2));
		spectator.addSpectator(spectator1);
		String s = spectator.searchSpectator("6");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	
	
	@Test
	void testAdd3() {
		setupStage3();
		
		Spectator spectator1 = new Spectator("6", "Johnny", "Sins", "jsinsxx@hotmail.com", "USA", 'M',"apicture", new GregorianCalendar(1992,3,2));
		spectator.addSpectator(spectator1);
		String s = spectator.searchSpectator("6");
		if (s.equalsIgnoreCase("")) {
			fail();
		}
		
	}
	

} //end of class