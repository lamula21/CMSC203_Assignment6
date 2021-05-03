

public class Coffee extends Beverage {

	boolean extra_shot;
	boolean extra_syrup;
	
	public Coffee(String name, SIZE size, boolean extra_shot, boolean extra_syrup) {
		super(name, TYPE.COFFEE, size);
		this.extra_shot = extra_shot;
		this.extra_syrup = extra_syrup;
	}

	@Override
	public String toString() {
		String info = "";
		
		if (extra_shot) {
			info = "Beverage Name: "+ getBevName()  + 
					"\nBeverage Size: " + getSize() + 
					"\nBeverage Price: " + calcPrice() +
					 " with extra shot";}
		
		else if (extra_syrup) {
			info = "Beverage Name: "+ getBevName()  + 
				"\nBeverage Size: " + getSize() + 
				"\nBeverage Price: " + calcPrice() +
				" with extra syrup";}
		
		else if (extra_syrup && extra_shot ) {
			info = "Beverage Name: "+ getBevName()  + 
				"\nBeverage Size: " + getSize() + 
				"\nBeverage Price: " + calcPrice() +
				" with extra syrup and extra shot";}
		else 
			info = "Beverage Name: "+ getBevName()  + 
			"\nBeverage Size: " + getSize() + 
			"\nBeverage Price: " + calcPrice();
	
		return info;
		
	}
	
	
	
	@Override
	public double calcPrice() {
	
		double price = 0.0;
		
		if ( getSize() == SIZE.SMALL )
		{
			
			if (extra_shot)
				price += 0.50;
			if (extra_syrup)
				price += 0.50;
			
			price += getBASE_PRICE();
				
		}
		else if ( getSize() == SIZE.MEDIUM ) {
			
			if (extra_shot)
				price += 0.50;
			if (extra_syrup)
				price += 0.50;
			
			price += getMEDIUM_PRICE();
		}
			
		else if ( getSize() == SIZE.LARGE  ) {
			
			if (extra_shot)
				price += 0.50;
			if (extra_syrup)
				price += 0.50;


			
			price += getLARGE_PRICE();
		}
			
		return price;
	}
	

	public boolean equals( Coffee a) {
		
		boolean status;
		
		if ( extra_shot == a.extra_shot && extra_syrup == a.extra_syrup && super.equals(a) )
			status = true;
		else 
			status = false;
		
		return status;
	}

	public boolean getExtraShot() {
		
		return extra_shot;
	}

	public boolean getExtraSyrup() {
		
		return extra_syrup;
	}

	public double getBasePrice() {
		
		return getBASE_PRICE();
	}
	
}
