package com.visa.training.app;
import java.io.*;

class Rectangle {
	int radius;
	Rectangle(int radius){
		this.radius=radius;
	}
	String getShapeName() {
		return "Circle";
	}
	double computeArea() {
		return (3.14*this.radius*this.radius);
	}
}

public class RectangleApp{
	public static void main(String args[])
	{
		Rectangle c[]=new Rectangle[3];
		for(int i=0;i<3;i++)
		{
			c[i]=new Rectangle(1);
			System.out.println(c[i].computeArea());
		}
	}
}
