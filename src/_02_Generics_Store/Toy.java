package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Toy extends NonFood {
	public Toy() {
		this.classtype = "Toy";
		this.cost = 3;
		if(new Random().nextBoolean()) {
			this.item = "toy1.jpeg";
		}
		else {
			this.item = "toy2.jpeg";
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
