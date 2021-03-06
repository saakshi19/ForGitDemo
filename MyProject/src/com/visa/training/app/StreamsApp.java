package com.visa.training.app;
import java.io.*;
import java.util.*;


public class StreamsApp {
	public static void main(String args[]) {
		
		//adding two spaces in front of a words WITHOUT map
		List<String> words = Arrays.asList("hi","hello","Bye","Goodbye");
		words.stream().forEach(s->s=" __ "+s);
		words.forEach(s->System.out.println(s));
		System.out.println();
		
		//using method reference 
		words.stream().map(s->"_"+s).forEach(System.out::println);
		System.out.println();
		
		//operations using map
		words.stream().map(s-> s.replace("i", "eye")).forEach(System.out::println);
		System.out.println();
		
		//filter
		words.stream().filter(s->s.length()<7).forEach(System.out::println);
		System.out.println();
		
		//reduce operation and concatenate operation
		System.out.println(words.stream().reduce("",(s1,s2)->s1.toUpperCase()+(s2.toUpperCase())));
		
		//Reduce using map and concat
		System.out.println(words.stream().map(s->s.toUpperCase()).reduce("", (s1,s2)->s1.concat(s2)));
		
		//concate words with commas in between them
		System.out.println(words.stream().reduce((s1,s2)->s1.concat(","+s2)).get());
		
		//Large array of doubles
		double[] list= new Random().doubles(10).toArray();
		
	}
}
