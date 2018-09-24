package main;

import model.Cookie;
import model.Icecream;

// helper class that prints menu. 
public class MenuPrinter {
 
	public void printMenu(CustomArrayListImpl icecreamArray, CustomHashTableImpl cookieTable) {
		System.out.println("*************************Menu*****************************");
		System.out.println("***********************Ice creaams**************************");
		System.out.println("Name \t\t\t\t\t\t cost");
		System.out.println("-------------------------------------------------------");
		for(Iterator iter = icecreamArray.getIterator(); iter.hasNext(); ){
			Icecream icecream = (Icecream) iter.next();
			System.out.println(icecream.getName());
			System.out.println(icecream.getDescription() + " \t $"+ icecream.getCost());
		}
		
		System.out.println("************************Cookies***************************");
		System.out.println("Name \t\t\t\t\t\t cost");
		System.out.println("-------------------------------------------------------");
		for(Iterator iter = cookieTable.getIterator(); iter.hasNext();) {
			Cookie cookie = (Cookie) iter.next();
			System.out.println(cookie.getName());
			System.out.println(cookie.getDescription() + " \t $"+ cookie.getCost());
		}
		
	}
	
}