
public class Customer {

	private String name;
	private int age;
	
	public Customer( String name, int age ) {
		this.name = name;
		this.age = age;
	}
	
	public Customer ( Customer person) {
		
		this.name = person.name;
		this.age = person.age;
		
	}
	
	/**
	 * Checks the information of the class
	 * @return the name and age of the Customer.
	 */
	public String toString() {

		return "Customer: " + name + "\nAge: " + age ;
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

