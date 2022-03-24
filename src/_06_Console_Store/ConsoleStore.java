package _06_Console_Store;

import java.util.Arrays;
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
	int balance = 20;
	String input = "";
	
	Scanner keyboard = new Scanner(System.in);
	
    public static void main(String[] args) {
    	ConsoleStore c = new ConsoleStore();
    	do {
    	c.store();
    	}
    	while(c.checkOut() == false);
    	c.cart.showCart();
    }
    public boolean checkOut() {
    	if(balance - cart.getCost() < 0) {
    		System.out.println("You cannot afford the items in your cart, would you like to return them?");
    		if(keyboard.next().equalsIgnoreCase("Y")) {
    			cart.clear();
    		} 
    		return false;
    	} else {
    		printReceipt();
    		keyboard.close();
    		return true;
    	}
    	
    }
    public void printReceipt() {
    	System.out.println("Thank you for shopping!");
    	System.out.println("Items:");
    	for(int i = 0; i < cart.length(); i++) {
    		System.out.println(cart.getValue(i));
    	}
    	System.out.println("Total Cost: $" + cart.getCost() + "\nBalance Remaining: $" + (balance - cart.getCost()));
    }
    public void store() {
    	do {
    		System.out.println("Your currently have $" + (balance - cart.getCost()) + " remaining. What would you like to do? (Add: A, Remove: R, Check Cart: C, Check Out: Y)"); 
    		input = keyboard.next();
    		if(input.equalsIgnoreCase("A")) {
    			System.out.println("What would you like to buy? (Chair: $10, Clothing: $5, Toy: $3, Toothbrush: $1)");
    			addCart(keyboard.next());
    		} else if(input.equalsIgnoreCase("R")) {
    			System.out.println("What item would you like to remove?");
    			removeItem(keyboard.next());
    		} else if(input.equalsIgnoreCase("C")) {
    			view();
    		}
    	} while(!input.equalsIgnoreCase("Y"));
    }
    public void addCart(String input) {
    	NonFood thing = input.equalsIgnoreCase("Clothing") ? new Clothing() : new Toy();
    	cart.add(thing);
    }
    public void removeItem(String input) {
    	cart.remove(input);
    }
    public void view() {
    	System.out.println("You currently have " + cart.length() + " items, for a total cost of $" + cart.getCost() + ".\nItems:");
    	System.out.println(Arrays.deepToString(cart.printList()));
    }
    
}
