package _02_Generics_Store;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * The Cart class is a Bounded Type Generic class
 * 
 * <T extends Food> means we can only create a Cart with objects part of the 
 * Food class
 */

@SuppressWarnings("unchecked")
public class Cart<T extends NonFood> {
    private T[] cart;
    public Cart() {
        cart = (T[]) new NonFood[5];
    }

    // Adds an item to the cart
    public void add(T item) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = item;
                return;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Your cart is full!\nNo more than 5 items");
    }
    public void remove(String item) {
    	for(int i = length()-1; i >= 0; i--) {
    		if(cart[i].getClassType().equalsIgnoreCase(item)) {
    			cart[i] = null;
    			for(int j = i+1; j < cart.length; j++) {
    				cart[j-1] = cart[j];
    				cart[j] = null;
    			}
    			break;
    		}
    	}
    }
    public void clear() {
    	cart = (T[]) new NonFood[5];
    }
    public int getCost() {
    	int cost = 0;
    	for(int i = 0; i < length(); i++) {
    		cost+=cart[i].getItemCost();
    	}
    	return cost;
    }
    public String getValue(int index) {
    	return cart[index].getClassType() + ": $" + cart[index].getItemCost();
    }

    // Displays everything currently in the cart
    public void showCart() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                panel.add(cart[i].getNonFood());
            }
        }
        frame.pack();

    }

    public int length() {
    	int i = 0;
    	while(i < cart.length && cart[i] != null) {
    		i++;
    	}
        return i;
    }
    public String[] printList() {
    	String[] array = new String[length()];
    	for(int j = 0; j < length(); j++) {
    		array[j] = cart[j].getClassType();
    	}
    	return array;
    }
}
