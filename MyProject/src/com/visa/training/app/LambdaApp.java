package com.visa.training.app;
import java.util.*;
import java.io.*;
import java.util.function.*;

interface TwoStringPredicate{
	public boolean isBetter(String s1, String s2);
}
interface TwoElementPredicate<T>{
	public <T> boolean isBetter(T first, T second);
}

class Better{
	public static String betterString(String s1, String s2,TwoStringPredicate condition) { 
		return (condition.isBetter(s1, s2)?s1:s2);
	}
	public static <T> T betterElement(T first, T second, TwoElementPredicate<T> condition) {
		return (condition.isBetter(first, second)?first:second);
		
	}
}

/*
 * interface Predicate<T>{ public <T> boolean test(List<T> x); }
 */
public class LambdaApp {
	
	public <T> List<T> allMatches(List<T> list, Predicate<T> condition){
		List<T> list1= new ArrayList<>();
		for(T t:list) {
			if(condition.test(t)) {
				list1.add(t);
			}
		}
		return list1;
	}
	
	public <T> List<T> transformedList(List<T> list, Function<T,T> func){
		List<T> result = new ArrayList<>();
		for(T t:list) {
			T t1= func.apply(t);
			result.add(t1);
		}
		return result;
	}
	
	public static void main(String args[]) {
		LambdaApp la = new LambdaApp();
		
		List<String> wordss = Arrays.asList("hello","hi");
		
		System.out.println(la.transformedList(wordss, s->s+"!"));
		
		System.out.println(la.allMatches(wordss, s->s.length()%2==0));
		System.out.println(la.allMatches(Arrays.asList(1,10,100),n-> n<50));
		
		
		System.out.println(Better.betterString("hello","hi",(s1,s2)->{return s1.length()>s2.length();}));
		//System.out.println(Better.betterElement("bvh", "cn", (s1,s2)->{return s1.length()<s2.length();}));
		
		String words[]= {"Hi","Hello","Bye","Good"};
		System.out.println("Lambda");
		Arrays.sort((words),(String s1,String s2)->{return s1.length()-s2.length();});
		for(int i=0;i<words.length;i++) {
			System.out.println(words[i]);
		}
		
		System.out.println("");
		
		//reverse length sorting 
		Arrays.sort(words,(String s1, String s2)->{return s2.length()-s1.length();});
		for(int i =0;i<words.length;i++) {
			System.out.println(words[i]);
		}
		
		//alphabetically by the first char only
		Arrays.sort(words,(String s1, String s2)->{return s1.charAt(0)-s2.charAt(0);});
		for(int i =0;i<words.length;i++) {
			System.out.println(words[i]);
		}
		System.out.println("");
		
		//string containing e comes first
		Arrays.sort(words,(String s1,String s2)->{return (s1.contains("e") && !s2.contains("e"))?-1:1;});
		for(int i =0;i<words.length;i++) {
			System.out.println(words[i]);
		}
		
		
	}

}
