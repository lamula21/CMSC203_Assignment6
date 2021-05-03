import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

	int orderNum;
	int orderTime;
	DAY orderDay;
	Customer customer;
	ArrayList<Beverage> beverageList;
	
	public Order ( int orderTime, DAY orderDay, Customer customer ) {
		
		this.orderNum = genRandom();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		
		beverageList = new ArrayList<>();
	}
	
	
	
	/**
	 * 
	 * @param day the day of the week
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	 public boolean isWeekend() {
		boolean isWeekend;
		 if ( orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY )
			 isWeekend = true;
		 else 
			 isWeekend = false;
		 return isWeekend;
	}

	 
////////// CHECK
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	@Override
	 public Beverage getBeverage(int itemNo) {
		
		 
		 Beverage a = getBeverage().get(itemNo);
		 
		 if (  beverageList.get(itemNo) == null ) 
			 return null;
		
		 
		
		return a;
	}
	 
	 
	 
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void  addNewBeverage(
				String bevName,
				SIZE size,
				boolean extraShot,
				boolean extraSyrup) {
		
		Coffee a = new Coffee ( bevName, size, extraShot, extraSyrup  );
		beverageList.add(a);
		
	}
	
	
	
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void  addNewBeverage( String bevName,
								SIZE size) {
		boolean isWeekend = false;
		if ( orderDay.equals(DAY.SATURDAY) || orderDay.equals(DAY.SUNDAY) )
			isWeekend = true;
		
		Alcohol a = new Alcohol(bevName, size, isWeekend);
		beverageList.add(a);
	}
	
	
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	@Override
	public void  addNewBeverage( String bevName,
				SIZE size,
				int numOfFruits,
				boolean addPRotien) {
		
		Smoothie a = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverageList.add(a);
	}
	
	
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() {
		
		double orderTotal = 0.0;
		
		for (int i = 0; i < getBeverage().size(); i++)
			orderTotal += getBeverage().get(i).calcPrice();
		
		
		return orderTotal;
	}
	
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		
		int numOfBeveType = 0;
		
		for (int i = 0; i < getBeverage().size(); i++) {
			if ( getBeverage().get(i).getType() == type )
				numOfBeveType++;
		}
		
		return numOfBeveType;
	}
	
	public int genRandom() {
		
		int number;
		
		Random num = new Random();
		
		number = num.nextInt(80000) + 10000;
		
		return number;
	
	}

	
	@Override
	public int compareTo(Order a) {
		
		int status;
		
		if ( this.orderNum == a.orderNum )
			status = 1;
		else if ( this.orderNum > a.orderNum )
			status = 0;
		else 
			status = -1;
		
		return status;
	}
	
	@Override
	public String toString() {
		
		String beverageListString="";
		
		for (int i= 0; i< getBeverage().size(); i++)
			beverageListString += getBeverage().get(i).toString() + "\n\n";
		
		String info= "Order Number: " + getOrderNum() +
					"\nOrder Time: " + getOrderTime() +
					"\nDay: " + getOrderDay() +
					"\nCustomer Name: " + getCustomer().getName() + 
					"\nCustomer Age: " + getCustomer().getAge() +
					"\nOrder Total: " + calcOrderTotal()+
					"\nBeverage List: " + beverageListString;
		
		return info;
	}

	
	
	
	
	
	// Getters and Setters
	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer.getName(), customer.getAge());
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Beverage> getBeverage() {
		return beverageList;
	}

	public void setBeverage(ArrayList<Beverage> beverage) {
		this.beverageList = beverage;
	}



	public int getTotalItems() {
		
		return beverageList.size();
	}



	public int getOrderNo() {
		
		return orderNum;
	}


	

	
	
	
	
	
	
	
	
}


