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
		if (compareTo(thing)>0) {
			if (right != null) {
				right.addSpectator(thing);
			} else {
				setRight(thing);
			}
			
		} else if (compareTo(thing)<0){
			if (left != null) {
				left.addSpectator(thing);
			} else {
				setLeft(thing);
			}
		} else {
			
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
	
	
	
	public String searchByCountry(String countryR) {
		String info = "";
		
		if (getCountry().equalsIgnoreCase(countryR)) {
			info += getFirstName();
			
			
			
		}  if (getLeft() != null) {
			info += getLeft().searchByCountry(countryR);
		
		} if (getRight() != null) {
			info += getRight().searchByCountry(countryR);
			
		}
		
		
		
		return info;
	}
	
	
	
} //end of class
