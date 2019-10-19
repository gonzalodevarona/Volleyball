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

import java.util.GregorianCalendar;

public class Spectator extends Person  implements Comparable<Spectator>{
	
	Spectator left;
	Spectator right;

	public Spectator(String id, String firstName, String lastName, String email, String country, char gender, String photo,
			GregorianCalendar birthDate) {
		super(id, firstName, lastName, email, country, gender, photo, birthDate);
		this.left = null;
		this.right = null;
	}
	public Spectator() {
		super();
	}

	public Spectator getLeft() {
		return left;
	}

	public void setLeft(Spectator left) {
		this.left = left;
	}

	public Spectator getRight() {
		return right;
	}

	public void setRight(Spectator right) {
		this.right = right;
	}

	@Override
	public int compareTo(Spectator other) {
		int value = 0;
		
		if (getId().compareTo(other.getId()) > 0) {
			value = 1;
		}
		
		if (getId().compareTo(other.getId()) < 0) {
			value = -1;
		}
		
		return value;
	}
	
	public void addSpectator(Spectator thing) {
		if (compareTo(thing)<0) {
			if (right != null) {
				right.addSpectator(thing);
			} else {
				setRight(thing);
			}
			
		} 
		if (compareTo(thing)>0){
			if (left != null) {
				left.addSpectator(thing);
			} else {
				setLeft(thing);
			}
		} 
		
	}
	
	public String searchSpectator(String thing) {
		String n = "";
		
			if (thing.compareTo(getId()) == 0) {
				n += toString();
			} else if (thing.compareTo(getId()) > 0 && getRight() != null) {
				n += getRight().searchSpectator(thing);
			} else if(getLeft() != null){
				n += getLeft().searchSpectator(thing);
			} 
			
		
		return n;
	}
	
	
	public String toString() {
		String info = "SPECTATOR \n \n";
		info += super.toString();
		
		return info;
	}
	
	
	
	public Spectator searchByCountry(String countryR, Spectator inMatter) {
		
		
		if (getCountry().equalsIgnoreCase(countryR)) {
			if (inMatter == null) {
				inMatter = new Spectator();
				inMatter.setFirstName(this.firstName);
				inMatter.setLastName(this.lastName);
			} else {
				Spectator temp = new Spectator();
				temp.setFirstName(this.firstName);
				temp.setLastName(this.lastName);
				inMatter.addSpectator(temp);
			}
		}
			

		
		if (getLeft() != null) {
			getLeft().searchByCountry(countryR, inMatter);
		}
		if (getRight() != null) {
			getRight().searchByCountry(countryR, inMatter);
		}
		
		
		return inMatter;
		
	}
	public String countryTree() {
		String info = getFirstName()+"\n";
		
		if (getLeft() != null ) {
		info += getLeft().getFirstName();
		}
		if (getRight() != null) {
			info += getRight().getFirstName();
		}
	
		info += "\n";
	
		if (getLeft() != null ) {
			info += getLeft().countryTree();
		}
		if (getRight() != null) {
			info += getRight().countryTree();
		}

		
		
		return info;
	}
	
	
	
} //end of class
