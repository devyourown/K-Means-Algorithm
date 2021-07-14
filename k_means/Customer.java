package k_means;

public class Customer { //R F M

	private int number;
	private int totalPrice; 
	private int totalAmount; //M
	int numOfGroup;
	double distance;
	boolean boy;
	int age;

	public Customer(int number, int totalPrice, int totalAmount, boolean men, int age) {
		this.number = number;
		this.totalAmount = totalAmount;
		this.totalPrice = totalPrice;
		boy = men;
		this.age = age;
	}
	
	public int getPrice() {
		return this.totalPrice;
	}
	
	public int getAmount() {
		return this.totalAmount;
	}

	public int getNumber() {
		return number;
	}
	
	public void putNumber(double dis, int num) {
		if(0.0 == this.distance) {
			this.distance = dis;
			this.numOfGroup = num;
		}
		if(this.distance > dis) {
			this.numOfGroup = num;
			this.distance = dis;
		}
	}

	public double getDistance() {
		return this.distance;
	}
	
	public int getNumOfGroup() {
		return this.numOfGroup;
	}
} 
