package k_means;

public class K_means {
	private static final int K = 5;
	private static final double RANGE = 4.5F;
	static int[][] rand = new int[K][2]; 
	public static int[][] dis = new int[K][2]; 
	
	public static Customer[] algorithm(Customer[] customer) {
		double sum = 0.0;
		for(int i=0; i<K; i++) {
			rand[i][0] = (int)(Math.random() * 3000) + 500; //price
			rand[i][1] = (int)(Math.random() * 2000) + 1; //amount
		}
		
		while(check()) {
			distance(customer); 
			rand = calculate(customer); 
			distance(customer);
			dis = calculate(customer);
		}
		for(int i=0; i<K; i++) { 
			System.out.println("customer : " + dis[i][0] + " : " + dis[i][1]);
		}
		return customer;
	}
	
	private static boolean check() {
		int error = 0;
		for(int i=0; i<K; i++) {
			if(Math.abs(dis[i][0] - rand[i][0]) > RANGE) 
				error++;
			if(Math.abs(dis[i][1] - rand[i][1]) > RANGE) 
				error++;
		}
		return error >= 1 ? true : false;
	}
	
	private static int[][] calculate(Customer[] customers) {
		int distances[][] = new int[K][2];
		double sumOfPrice = 0.0;
		double sumOfAmount = 0.0;
		int count = 0;
		for(int i=0; i<K; i++) {
			for(int j=0; j<customers.length; j++) {
				if(customers[j].getNumOfGroup() == i) {
					count++;
					sumOfPrice += customers[j].getPrice();
					sumOfAmount += customers[j].getAmount();
				}
			}
			distances[i][0] = (int) (sumOfPrice / count);
			distances[i][1] = (int) (sumOfAmount / count);
			sumOfPrice = 0;
			sumOfAmount = 0;
			count = 0;
		}
		
		return distances;
	}
	
	
	private static void distance(Customer[] customer){
		int distance = 0;
		for(int i=0; i<K; i++) {
			for(int j=0; j<customer.length; j++) {
				
				int d1 = Math.abs(rand[i][0] - customer[j].getPrice());
			    int d2 = Math.abs(rand[i][1] - customer[j].getAmount());
			    distance = (d1*d1) + (d2*d2);
				
			    customer[j].putNumber(Math.sqrt(distance), i);
			}
		}
	
     }
}
