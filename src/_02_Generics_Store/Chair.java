package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Chair extends NonFood {
	public Chair() {
		this.classtype = "Chair";
		this.cost = 10;
		if(new Random().nextBoolean()) {
			this.item = "chair1.jpeg";
		}
		else {
			this.item = "chair2.jpeg";
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
