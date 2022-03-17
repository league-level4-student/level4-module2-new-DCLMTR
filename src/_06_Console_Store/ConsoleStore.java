package _06_Console_Store;

import java.util.Scanner;

import _02_Generics_Store.Candy;
import _02_Generics_Store.Cart;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Food;
import _02_Generics_Store.NonFood;
import _02_Generics_Store.Toy;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */
	Cart<NonFood> cart = new Cart<NonFood>();
	
	
    public static void main(String[] args) {
    	int balance = 20;
    	String input = "";
    	ConsoleStore c = new ConsoleStore();
    	Scanner keyboard = new Scanner(System.in);
    	do {
    		System.out.println("Your currently have $" + balance + " remaining. What would you like to do? (Add: A, Remove: R, Check Cart: C)"); 
    		input = keyboard.next();
    		if(input.equalsIgnoreCase("A")) {
    			System.out.println("What would you like to buy? (Clothing: $5, Toy: $3)");
    			c.addCart(keyboard.next());
    		} else if(input.equalsIgnoreCase("R")) {
    			
    		} else if(input.equalsIgnoreCase("C")) {
    			c.view();
    		}
    		System.out.println("Would you like to check out?");
    	} while(!keyboard.next().equalsIgnoreCase("y"));
    	System.out.println("Goodbye");
    	keyboard.close();
    }
    
    public void addCart(String input) {
    	NonFood thing = input.equalsIgnoreCase("Clothing") ? new Clothing() : new Toy();
    	cart.add(thing);
    }
    public void removeItem(String input) {
    	
    }
    public void view() {
    	cart.showCart();
    	System.out.println("You currently have " + cart.length() + " items, for a total cost of " + cart.getCost() + ".");
    }
    
}
