

public class Smoothie extends Beverage {

	private int numb_fruits;
	private boolean protein;
	private final double EXTRA_PROTEIN = 1.50;
	private final double EXTRA_FRUIT = 0.50;
	
	public Smoothie(String name, SIZE size, int numb_fruits, boolean protein  ) {
		super(name, TYPE.SMOOTHIE, size);
		this.numb_fruits = numb_fruits;
		
		this.protein = protein;
	}
	
	
	@Override
	public String toString() {
		String info = "";
		
		if (protein) {
			info = "Beverage Name: "+ getBevName()  + 
					"\nBeverage Size: " + getSize() + 
					"\nBeverage Price: " + calcPrice() +
					"\nNumber of fruits: " + numb_fruits +
					 " with protein powder";}
		
		else {
			info = "Beverage Name: "+ getBevName()  + 
			"\nBeverage Size: " + getSize() + 
			"\nBeverage Price: " + calcPrice() +
			"\nNumber of fruits: " + numb_fruits +
			 " with no protein powder";
		}
	
		return info;
	}
	
	
	
	@Override
	public double calcPrice() {
	
		double price = 0.0;
		
		if ( getSize() == SIZE.SMALL) 
		{
			if (protein)
				price += EXTRA_PROTEIN;
			
			price += numb_fruits*EXTRA_FRUIT;

			price += getBASE_PRICE();
				
		}
		else if ( getSize() == SIZE.MEDIUM) {
			
			if (protein)
				price += EXTRA_PROTEIN;

			price += numb_fruits*EXTRA_FRUIT;
			
			price += getMEDIUM_PRICE();
		}
			
		else if ( getSize() == SIZE.LARGE)  {
			
			if (protein)
				price += EXTRA_PROTEIN;

			price += numb_fruits*EXTRA_FRUIT;
			
			price += getLARGE_PRICE();
		}
			
		return price;
	}
	

	public boolean equals( Smoothie a) {
		
		boolean status;
		
		if ( this.protein == a.protein && this.numb_fruits == a.numb_fruits && super.equals(a) )
			status = true;
		else 
			status = false;
		
		return status;
	}


	public double getBasePrice() {
		
		return getBASE_PRICE();
	}


	public int getNumOfFruits() {
		
		return numb_fruits;
	}


	public boolean getAddProtien() {
		
		return protein;
	}
}
