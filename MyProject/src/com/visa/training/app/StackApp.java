package com.visa.training.app;
import java.io.*;
import java.util.Random;


public class StackApp {
	
	public static void main(String args[]) {
		FixedArrayStack f = new FixedArrayStack(5);
		StackUser s = new StackUser();
		s.fill(f);
		s.empty(f);
		
	}
}

interface Stack{
	public void push(Object element);
	public Object pop();
}

class StackUser{
	FixedArrayStack f= new FixedArrayStack(10);
	public void fill(Stack s) {
		Random r=new Random();
		
		for(int i=0;i<10;i++) {
			Integer o=new Integer(r.nextInt(10)+1);
			f.push(o);
		}
		
	}
	public void empty(Stack s) {
		for(int i=0;i<10;i++) {
			Integer o = (Integer)f.pop();
		}
	}
}

class FixedArrayStack implements Stack{
	Object a[];
	int top;
	int size;
	
	FixedArrayStack(int size){
		this.size=size;
		a=new Object[this.size];
		top=-1;
	}
	
	public void push(Object o) {
		++top;
		try{
			a[top]=o;
		}
		catch(Exception e) {
			System.out.println("Stack is full");
			return;
		}
		System.out.println("Pushed!");
		
	}
	
	public Object pop() {
		Object popped = a[top];
		try{
			top--;
		}
		catch(Exception e) {
			System.out.println("Stack empty");
		}
		return popped;
	}
}
