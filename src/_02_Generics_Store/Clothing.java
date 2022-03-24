package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Clothing extends NonFood{
	public Clothing() {
		this.classtype = "Clothing";
		this.cost = 5;
		if(new Random().nextBoolean()) {
			this.item = "clothing1.jpeg";
		}
		else {
			this.item = "clothing2.jpeg";
		}
	}

	@Override
	public JLabel getNonFood() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
	public String getClassType() {
		return this.classtype;
	}
	public int getItemCost() {
		return this.cost;
	}
}
