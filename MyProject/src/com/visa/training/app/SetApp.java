package com.visa.training.app;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
		
	}
	
}


public class SetApp {
	private static void sortDemo() {
		String [] words = {"this","is","a","test","String"};
		List<String> wordList = Arrays.asList(words);
		Collections.sort(wordList,new StringLengthComparator());
		System.out.println(wordList);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Set<String> words = new HashSet<>();
		while(true) {
			System.out.println("Enter a word");
			String word;
			word = sc.next();
			if(!words.add(word)) {
				System.out.println("Duplicate word");
			}
			if(words.size()==10) {
				break;
			}
		}
		System.out.println("Words are: ");
		for(String word: words) {
			System.out.println(word);
		}
	}
	
}
