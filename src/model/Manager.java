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


package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;


public class Manager implements Serializable{
	
	private String name;
	private String fileRoot;
	private String fileFirst;
	private Player first;
	private Spectator root;
	
	
	public Manager() {
		name = "Gonzalo De Varona";
	}
	
	
	public String getFileRoot() {
		return fileRoot;
	}

	public void setFileRoot(String fileRoot) {
		this.fileRoot = fileRoot;
	}
	
	
	

	public String getFileFirst() {
		return fileFirst;
	}


	public void setFileFirst(String fileFirst) {
		this.fileFirst = fileFirst;
	}


	public Player getFirst() {
		return first;
	}


	public void setFirst(Player first) {
		this.first = first;
	}


	public Spectator getRoot() {
		return root;
	}


	public void setRoot(Spectator root) {
		this.root = root;
	}


	public boolean loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean done = false;
		
		File file = new File(getFileRoot());
		if (getFileFirst() != null) {
			File file2 = new File(getFileFirst());
			
			if (file.exists() && file2.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));
				
				addSpectator2Tree((Spectator) ois.readObject());
				setFirst((Player) ois.readObject());
				ois.close();
				ois2.close();
				done = true;
			}
		}
		
		return done;
	}
	
	public void addSpectator2Tree(Spectator thing) {
		
		if (root == null) {
			setRoot(thing);
		} else {
			root.addSpectator(thing);
			
		}
		
	}


	public void saveChanges() throws IOException, IOException {
		
//		File file = new File(getFileRoot());
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		oos.writeObject(getRoot());
//		oos.close();
		
		if (getFileFirst() != null) {
			
			File file2 = new File(getFileFirst());
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
			oos2.writeObject(getFirst());
			oos2.close();
		}
		
		
	}
	
	public boolean loadSpectatorsPlainText() throws FileNotFoundException, IOException {
		boolean status = false;
		int counter = 0;
		
		File file = new File(getFileRoot());
		
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		
		String[] words = new String[7];
		
		
		while (line != null) {
			++counter;
			
			words = line.split(";");
			
			
			String id = words[0];
			String name = words[1];
			String lastName = words[2];
			String email = words[3];
			String country = words[4];
			char gender = words[5].charAt(0);
			String photo = words[6];
			
			
			String[] dateArray = words[7].split("/");
			
			int day = Integer.parseInt(dateArray[1]);
			int month = ((Integer.parseInt(dateArray[0])) - 1);
			int year = Integer.parseInt(dateArray[2]);
			
			GregorianCalendar birthDate = new GregorianCalendar(year, month, day);
			Spectator spectator = new Spectator(id, name, lastName, email, country, gender, photo, birthDate);
		
			if (counter%2 == 0) {
				Player player = new Player(id, name, lastName, email, country, gender, photo, birthDate);
				addPlayer(player);
				
			}
			addSpectator2Tree(spectator);
			
			
			line = bufferR.readLine();
			
			status = true;
		}

		bufferR.close();
		reader.close();
		
			
		return status;
		
	}
	
	public String searchPlayer(String thing) {
		String info = "ERROR: Player not found.";
		Player match = getFirst();
		
		while(match != null) {
			if (match.getId().equalsIgnoreCase(thing)) {
				info = match.toString();
				match = null;
			} else {match = match.getNext();
			}
			
		}
		
		
		return info;
	}
	
	public String searchSpectator(String id) {
		String info = "";
		Spectator root1 = getRoot();
		if (root1 != null) {
			info += root1.searchSpectator(id);
		}
		if (info.equalsIgnoreCase("")) {
			info = "ERROR: Spectator not found";
		}
		return info;
		
	}
	
	
	public void addPlayer(Player newPlayer) {
		
		Player ls = getLastPlayer();
		if (ls != null) {
			ls.setNext(newPlayer);
		
		}else {
			setFirst(newPlayer);
		}
		
	}
	
	public Player getLastPlayer() {
		Player last = getFirst();
		if(last != null) {
			while(last.getNext() != null) {
				last = last.getNext();
			}
		}
		return last;
	}
	
	
} //end of class
