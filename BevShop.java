import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {

	
	private int orderNum = 0;
	private int numAlcohol_Ordered = 0;
	private final int MAX_ALCOHOL_ORDER = 3;
	private final int MINIMUM_AGE = 21;
	private Order currentOrder;
	ArrayList<Order> orderList = new ArrayList<>();
	
	
	
	public String toString() {
		
		String info = "";
		
		for (int i= 0; i < orderList.size(); i++)
			info += orderList.get(i).toString() + "\n\n";
		
		info += "Total Monthly Sale: " + totalMonthlySale();
		
		return info;
	}
	
	
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) {
		boolean status;
		if ( time >= 8 && time <=23 )
			status = true;
		else
			status = false;
		
		return status;
	}
	

	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
		
		boolean status;
		
		if ( numAlcohol_Ordered < MAX_ALCOHOL_ORDER )
			status = true;
		else 
			status = false;
		
		return status;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public  boolean validAge(int age) {
		boolean status;
		
		if ( age > MINIMUM_AGE )
			status = true;
		else 
			status = false;
		
		return status;
	}
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	@Override
	public void startNewOrder(int time,
						 	DAY day,
						 	String customerName,
						 	int customerAge) {
		
		
		Customer customer = new Customer (customerName, customerAge);
		Order newOrder = new Order( time, day, customer );
		currentOrder = newOrder;
		orderNum++;
		orderList.add(currentOrder);
		
	}
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder( String bevName,
									SIZE size,
									boolean extraShot,
									boolean extraSyrup ) {
		
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
		
	}
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	@Override
	public void  processAlcoholOrder( String bevName,
									SIZE size ) {
		
		currentOrder.addNewBeverage(bevName, size);
		numAlcohol_Ordered++;
		
	}
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder( String bevName,
									SIZE size,
									int numOfFruits,
									boolean addProtien) {
		
		
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo) {
		
		int orderIndex = 0;
		
		for (int i=0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNum() == orderNo)
				orderIndex = i;
		}
		
		return orderIndex;

	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		
		double orderTotal = 0.0;
		
		for (int i=0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNum() == orderNo)
				orderTotal = orderList.get(i).calcOrderTotal();
		}
		
		return orderTotal;
		
		}
	
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale() {
		
		double allOrderTotal = 0.0;
		
		for (int i=0; i < orderList.size(); i++) 
				allOrderTotal += orderList.get(i).calcOrderTotal();
		
		
		return allOrderTotal;
		
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	@Override
	public  void sortOrders() {
	
		Collections.sort(orderList);
	}
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index) {
	
		Order order;
		
		order = orderList.get(index);
			
		return order;
	
	}

	public boolean isMaxFruit(int i) {
		
		boolean status;
		if ( i > MAX_FRUIT )
			status = true;
		else
			status = false;

		return status;
	}

	public Order getCurrentOrder() {
		
		return currentOrder ;
	}


	public int getNumOfAlcoholDrink() {
		
		return numAlcohol_Ordered;
	}


	public int totalNumOfMonthlyOrders() {
		
		return orderList.size();
	}





	public int getMaxOrderForAlcohol() {
		
		return MAX_ALCOHOL_ORDER;
	}


	public int getMinAgeForAlcohol() {
		
		return MINIMUM_AGE;
	}



	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	
}
