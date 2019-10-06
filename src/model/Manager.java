/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB IV
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 6 OCTOBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/


package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Manager {
	
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
		
		File file = new File(getFileRoot());
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(getRoot());
		oos.close();
		
		File file2 = new File(getFileFirst());
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
		oos2.writeObject(getFirst());
		oos2.close();
		
	}
	
	public void searchPlayer(String id) {
		
	}
	
	public void searchSpectator(String id) {
		
	}
	
	public void assignPlayers() {
		
	}
	
	public void dragSpectatorToPlayer() {
		
	}
	
	
} //end of class
