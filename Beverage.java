

public abstract class Beverage {
	private String name;
	private TYPE beverageType;
	private SIZE beverageSize;
	private final double BASE_PRICE= 2.0;
	private final double MEDIUM_PRICE = 3.0;
	private final double LARGE_PRICE = 4.0;
	
	public Beverage ( String name, TYPE type, SIZE size)
	{
		this.name = name;
		beverageType = type;
		beverageSize = size;
	
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return "Beverage Name: "+ name + "\nBeverage Size: " + beverageSize;
	}
	
	public boolean equals( Beverage otherBeverage) {
		
		boolean status;
		
		if ( this.name.equals(otherBeverage.name) && this.beverageType.equals(otherBeverage.beverageType) 
				&& this.beverageSize.equals(otherBeverage.beverageSize))
				status = true;
		else
			status = false;
		
		return status;
	}
	
	
// Setter and Getters
	public String getBevName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TYPE getType() {
		return beverageType;
	}

	public void setBeverageType(TYPE beverageType) {
		this.beverageType = beverageType;
	}

	public SIZE getSize() {
		return beverageSize;
	}

	public void setBeverageSize(SIZE beverageSize) {
		this.beverageSize = beverageSize;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getMEDIUM_PRICE() {
		return MEDIUM_PRICE;
	}

	public double getLARGE_PRICE() {
		return LARGE_PRICE;
	}



	
	
}
