package com.visa.training.app;
import java.io.*;
import java.util.Scanner;

public class DOWFinder {
	public String findDOW(int day, int month, int year) {
		String weekday="";
		int days = (year-1900) * 365;
		days = days + (year-1900)/4;
		if(year%4==0) {
			if(month ==1 || month ==2)
			{
				days=days-1;
			}
		}
		
		int monthDays[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int i;
		for(i=0;i<month-1;i++)
		{
			days+=monthDays[i];
		}
		days+=day;
		String weekdays[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int j=days%7;
		weekday=weekdays[j];
		return weekday;
	}
	
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		int day=sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		DOWFinder dow = new DOWFinder();
		System.out.println(dow.findDOW(day,month,year));
	}
	
}
