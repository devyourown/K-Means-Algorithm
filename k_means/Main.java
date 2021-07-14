package k_means;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	static Group group; 

	public static int getRandomPrice(int max) {
		return (int) (Math.random() * 700) + max;
	}
	
	public static int getRandomPrice() {
		return (int) (Math.random() * 3000) + 500;
	}

	public static int getRandomAmount(int max) {
		return (int)(Math.random() * 500) + max;
	}
	
	public static int getRandomAmount() {
		return (int)(Math.random() * 2500) + 100;
	}
	
	public static boolean getRandomSex() {
		if((int)(Math.random() * 100) + 1 > 50) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int getRandomAge() {
		return (int)(Math.random() * 30) + 10;
	}
	
	public static int getRandomAge(int i) {
		return (int)(Math.random() * 10) + i;
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Customer Service");
		final NumberAxis yAxis = new NumberAxis(1, 3000, 100);  
	    final NumberAxis xAxis = new NumberAxis(500, 4000, 200);  
	    /*xAxis.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent mouseEvent) {
	            if(mouseEvent.isDragDetect()) {
	            
	            }
	          }
	     });*/
	    xAxis.setLabel("Price");
	    yAxis.setLabel("Amount");
	    
	    final ScatterChart<Number,Number> scatterChart = 
	            new ScatterChart<Number,Number>(xAxis,yAxis);
	    scatterChart.setTitle("Customer's Infomation");
	    
	    XYChart.Series series1 = new XYChart.Series();  
	    series1.setName("Melon");
	    
	    for(int i=0; i<group.melon.size(); i++) {
	    	Customer c = group.melon.get(i);
	    	series1.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount(),c));
	    }
	    
	    XYChart.Series series2 = new XYChart.Series();  
	    series2.setName("Mango");
	    
	    for(int i=0; i<group.mango.size(); i++) {
	    	Customer c = group.mango.get(i);
	    	series2.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount()));
	    }
	    
	    XYChart.Series series3 = new XYChart.Series();  
	    series3.setName("Grape");
	    
	    for(int i=0; i<group.grape.size(); i++) {
	    	Customer c = group.grape.get(i);
	    	series3.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount()));
	    }
	    
	    XYChart.Series series4 = new XYChart.Series();  
	    series4.setName("Orange");
	    
	    for(int i=0; i<group.orange.size(); i++) {
	    	Customer c = group.orange.get(i);
	    	series4.getData().add(new XYChart.Data<>(c.getPrice(), c.getAmount()));
	    }
	    
	    XYChart.Series series5 = new XYChart.Series();  
	    series5.setName("Last_Point");
	    
	    for(int i=0; i<4; i++) {
	    	series5.getData().add(new XYChart.Data<>(K_means.dis[i][0], K_means.dis[i][1]));
	    }
	    
	    scatterChart.getData().addAll(series1, series2, series3, series4, series5);
	    
	    final ChoiceBox<String> cb = new ChoiceBox<String>(FXCollections.observableArrayList(
			    "sex", "age", "collection")
		);
	    
	    HBox hb = new HBox();
	    VBox vb = new VBox();
	    Label label = new Label("range");
	    TextArea ta = new TextArea();
	    label.setPadding(new Insets(10, 10, 10, 10));
	    vb.getChildren().addAll(cb, label, ta);
	    hb.getChildren().addAll(scatterChart, vb);
	    hb.setSpacing(20);
	    hb.setAlignment(Pos.CENTER);
	    hb.setPadding(new Insets(10, 0, 0, 10));
	 
	    cb.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
        	  scatterChart.getData().removeAll();
        	  if(new_value.intValue() == 0) {
        		  while(scatterChart.getData().size() != 0) {
            		  scatterChart.getData().remove(0);  
        		  }
        		  XYChart.Series seriesMen = group.groupingByMen();
        		  XYChart.Series seriesWomen = group.groupingByWomen();
        		  seriesMen.setName("men"); seriesWomen.setName("women");
        		  scatterChart.getData().addAll(seriesMen, seriesWomen);
        		  String menString = group.printMan();
        		  String womenString = group.printWomen();
        		  ta.setText(menString + "\n" + womenString);
        		  
        	  } else if(new_value.intValue() == 1) {
        		  while(scatterChart.getData().size() != 0) {
            		  scatterChart.getData().remove(0);  
        		  }
        		  XYChart.Series series10 = group.groupingByAge(10);
        		  series10.setName("10대");
        		  XYChart.Series series20 = group.groupingByAge(20);
        		  series20.setName("20대");
        		  XYChart.Series series30 = group.groupingByAge(30);
        		  series30.setName("30대");
        		  scatterChart.getData().addAll(series10, series20, series30);
        		  String teenager = group.printAges(10);
        		  String ages20 = group.printAges(20);
        		  String ages30 = group.printAges(30);
        		  ta.setText(teenager + "\n" + ages20 + "\n" + ages30);
        	  } else if(new_value.intValue() == 2) {
        		  if(scatterChart.getData().size() == 5) 
        			  return;
        		  while(scatterChart.getData().size() != 0) {
            		  scatterChart.getData().remove(0);  
        		  }
        		  scatterChart.getData().addAll(series1, series2, series3, series4, series5);
        	  }
          }
        });
	    
	    Scene scene  = new Scene(new javafx.scene.Group());
        primaryStage.setScene(scene);
        primaryStage.setTitle("K_MEANS_ALGORITHM");
        primaryStage.show();
        
  
	    ((javafx.scene.Group)scene.getRoot()).getChildren().add(hb);
	}
	
	public static void main(String[] args){

		Customer customers[] = new Customer[50]; 
		
		for(int i=1; i<=50; i++) {
			customers[i-1] = new Customer(i, getRandomPrice(), getRandomAmount(),
					getRandomSex(), getRandomAge());
		}

		group = new Group(K_means.algorithm(customers));
		group.stampGrade();
		
	
		launch(args);
	}
}
