package k_means;

import java.util.ArrayList;

import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

public class Group {

	public ArrayList<Customer> orange = new ArrayList<>();
	public ArrayList<Customer> mango = new ArrayList<>();
	public ArrayList<Customer> melon = new ArrayList<>();
	public ArrayList<Customer> grape = new ArrayList<>();
	
	public Group() {
		
	}
	
	public Group(Customer[] customer) {
		for(int i=0; i<customer.length; i++) {
			switch(customer[i].getNumOfGroup()) {
				case 1:
					mango.add(customer[i]);
					break;
				case 0:
					orange.add(customer[i]);
					break;
				case 2:
					melon.add(customer[i]);
					break;
				case 3:
					grape.add(customer[i]);
					break;
			}
		}
	}

	public void stampGrade() {

		System.out.println("Grape : ");
		
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			System.out.print(c.getNumber() + "("+ c.getPrice() + ", " + c.getAmount() + ")" +" ");
		}

		System.out.println("\nMango : ");

		for(int i=0; i<mango.size(); i++) {

			Customer c = mango.get(i);
			System.out.print(c.getNumber() + "("+ c.getPrice() + ", " + c.getAmount() + ")" +" ");

		}

		System.out.println("\nMelon : ");

		for(int i=0; i<melon.size(); i++) {

			Customer c = melon.get(i);
			System.out.print(c.getNumber() + "("+ c.getPrice() + ", " + c.getAmount() + ")" +" ");

		}

		System.out.println("\nOrange : ");

		for(int i=0; i<orange.size(); i++) {

			Customer c = orange.get(i);
			System.out.print(c.getNumber() + "("+ c.getPrice() + ", " + c.getAmount() + ")" +" ");

		}

	}
	
	//���� �з�;
	public XYChart.Series<Number, Number> groupingByMen() {
		XYChart.Series men = new XYChart.Series<>();
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(c.boy) {
				men.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(c.boy) {
				men.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(c.boy) {
				men.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(c.boy) {
				men.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		
		return men;
	}
	
	//���� �з�
	public XYChart.Series<Number, Number> groupingByWomen() {
		XYChart.Series women = new XYChart.Series<>();
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(!c.boy) {
				women.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(!c.boy) {
				women.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(!c.boy) {
				women.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(!c.boy) {
				women.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		
		return women;
	}
	
	//���� �з�
	public XYChart.Series<Number, Number> groupingByAge(int age) {
		XYChart.Series ages = new XYChart.Series<>();
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(c.age >= age && c.age < age+10) {
				ages.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(c.age >= age && c.age < age+10) {
				ages.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(c.age >= age && c.age < age+10) {
				ages.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(c.age >= age && c.age < age+10) {
				ages.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
			}
		}
		
		return ages;
	}
	
	public String printMan() {
		String man = "���� : ";
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(c.boy) {
				man = man.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(c.boy) {
				man = man.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(c.boy) {
				man = man.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(c.boy) {
				man = man.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		
		return man;
	}
	
	public String printWomen() {
		String women = "���� : ";
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(!c.boy) {
				women = women.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(!c.boy) {
				women = women.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(!c.boy) {
				women = women.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(!c.boy) {
				women = women.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		
		return women;
	}
	
	public String printAges(int age) {
		String ageString = age + "�� : ";
		for(int i=0; i<orange.size(); i++) {
			Customer c = orange.get(i);
			if(c.age >= age && c.age < age+10) {
				ageString = ageString.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<mango.size(); i++) {
			Customer c = mango.get(i);
			if(c.age >= age && c.age < age+10) {
				ageString = ageString.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<melon.size(); i++) {
			Customer c = melon.get(i);
			if(c.age >= age && c.age < age+10) {
				ageString = ageString.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		for(int i=0; i<grape.size(); i++) {
			Customer c = grape.get(i);
			if(c.age >= age && c.age < age+10) {
				ageString = ageString.concat(" (" + c.getNumber() + ": " + c.getPrice() + ", " + c.getAmount() + ")");
			}
		}
		
		return ageString;
	}
}
