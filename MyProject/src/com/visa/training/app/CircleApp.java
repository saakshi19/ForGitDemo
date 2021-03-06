package com.visa.training.app;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Circle {
	double radius;
	Circle(double radius){
		this.radius=radius;
	}
	Circle(){}
	String getShapeName() {
		return "Circle";
	}
	double computeArea(Object o) {
		Circle c = (Circle)o;
		return (3.14*c.radius*c.radius);
	}
	double getRadius(Object o) {
		Circle c = (Circle)o;
		return c.radius;
	}
}

public class CircleApp{
	public static void main(String args[])
	{
		//part 1
		List<Circle> al = new ArrayList<>();
		Random random = new Random();
		int i=0;
		double r = random.nextDouble();
		while(r>=0.01)
		{
			r = random.nextDouble();
			al.add(new Circle(r));
		}
		Circle c = new Circle();
		System.out.println("Number of elements: "+al.size());
		Iterator it = al.iterator();
		while(it.hasNext()) {
			System.out.println("Element: "+ c.computeArea(it.next()));
		}
		
		
		//part 2
		it= al.iterator();
		while(it.hasNext()) {
			r = c.getRadius(it.next());
			if(r<0.5) {
				it.remove();
			}
		}
		System.out.println(al.size());
		/*
		 * Circle c[]=new Circle[3]; 
		 * for(int i=0;i<3;i++) { c[i]=new Circle(1);
		 * System.out.println(c[i].computeArea()); }
		 */
	}
}
