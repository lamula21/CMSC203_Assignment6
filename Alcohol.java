

public class Alcohol extends Beverage {

	
	private boolean inWeekend;
	private final double COST_INWEEKEND = 0.60;
	
	
	public Alcohol(String name, SIZE size, boolean inWeekend) {
		super(name, TYPE.ALCOHOL, size);
		
		this.inWeekend = inWeekend;
	}

	@Override
	public String toString() {
		String info = "";
		
		if (inWeekend) {
			info = "Beverage Name: "+ getBevName()  + 
					"\nBeverage Size: " + getSize() + 
					"\nBeverage Price: " + calcPrice() +
					 " is offered in the weekend";}
		
		else {
			info = "Beverage Name: "+ getBevName()  + 
			"\nBeverage Size: " + getSize() + 
			"\nBeverage Price: " + calcPrice() +
			 " is not offered in the weekend";
		}
	
		return info;
	}
	
	
	
	@Override
	public double calcPrice() {
	
		double price = 0.0;
		
		if ( super.getSize() == SIZE.SMALL) 
		{
			if (inWeekend)
				price += COST_INWEEKEND;
			
			price += getBASE_PRICE();
				
		}
		else if ( super.getSize() == SIZE.MEDIUM)  {
			
			if (inWeekend)
				price += COST_INWEEKEND;
			
			price += getMEDIUM_PRICE();
		}
			
		else if ( super.getSize() == SIZE.LARGE ) {
			
			if (inWeekend)
				price += COST_INWEEKEND;
			
			price += getLARGE_PRICE();
		}
			
		return price;
	}
	

	public boolean equals( Alcohol a) {
		
		boolean status;
		
		if ( this.inWeekend == a.inWeekend && super.equals(a) )
			status = true;
		else 
			status = false;
		
		return status;
	}

	public double getBasePrice() {
		
		return getBASE_PRICE();
	}
}
