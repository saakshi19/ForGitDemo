package com.visa.training.app;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map <String,String> m = new HashMap<>();
	
		m.put("E1234","Steve Jobs");
		m.put("E2345","Bill Gates");
		m.put("E3456","Larry Ellison");
		m.put("E4567","Jeff Bezos");
		m.put("E8765","Mark Zuckerberg");
		m.put("E6789","Larry Page");
		while(true) {
			System.out.println("Enter employee number ");
			String s = sc.next();
			if (s.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println(m.get(s));
		}
	}

}
