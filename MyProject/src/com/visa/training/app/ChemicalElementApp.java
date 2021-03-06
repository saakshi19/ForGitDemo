package com.visa.training.app;
import java.io.*;

class ChemicalElement {
	int atomicNumber;
	String symbolicName;
	String fullName;
	static boolean metals[]= new boolean[200];
	ChemicalElement(int atomicNumber, String symbolicName, String fullName) {
		this.atomicNumber=atomicNumber;
		this.symbolicName=symbolicName;
		this.fullName=fullName;
	}
	public boolean isAlkaliMetal() {
		switch(atomicNumber) {
		case 3:
		case 11:
		case 19:
		case 37:
		case 55:
		case 87: return true;
		default: return false;
		}
	}
	public boolean isTransitionMetal() {
		//21 to 31, 39 to 48, 72 to 80, and 104 to 112
		return (((atomicNumber>=21 && atomicNumber<=31) || (atomicNumber>=39 && atomicNumber<=48) ||(atomicNumber>=72 && atomicNumber<=80) || (atomicNumber>=104 && atomicNumber<=112))?true:false);
		
	}
	public boolean isMetal() {
	//13, 49, 50, 81, 82, 83, 113, 114, 115, or 116
		
		metals[13]=metals[49]=metals[50]=metals[81]=metals[82]=metals[83]=metals[113]=metals[114]=metals[115]=metals[116]=true;
		if(metals[atomicNumber]==true)
			return true;
		return false;
	}
	public boolean equals(Object o) {
		ChemicalElement other = (ChemicalElement)o;
		if(other.atomicNumber == atomicNumber) {
			return true;
		}
		return false;
	}
		
	
}
public class ChemicalElementApp{
	public static void main(String[] args) {
		ChemicalElement c[]=new ChemicalElement[5];
		c[0]=new ChemicalElement(8,"O","Oxygen");
		c[1]=new ChemicalElement(30,"Zn","Zinc");
		c[2]=new ChemicalElement(31,"Ga","Gallium");
		c[3]=new ChemicalElement(19,"K","Potassium");
		c[4]=new ChemicalElement(1,"H","Hydrogen");
		for(int i=0;i<5;i++) {
			System.out.println(c[i].isAlkaliMetal());
			System.out.println(c[i].isMetal());
			System.out.println(c[i].isTransitionMetal());
		}
		ChemicalElement c1 = new ChemicalElement(8,"O","Oxyygen");
		for(int i=0;i<5;i++)
		{
			if(c[i].equals(c1)) {
				System.out.println("It's a match!");
			}
			if(c[i]==c1) {
				System.out.println("Reference comparison. It is a match!");
			}
			else
			{
				System.out.println("Reference comparison! Duh!");
			}
			
		}
	}
}
