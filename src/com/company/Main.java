package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private String style = "-fx-background-color: #333333;-fx-border-width: 2px;-fx-border-color:#042440;-fx-font-size: 2em;-fx-background-radius: 0.5em;-fx-border-radius: 0.5em;";

	//Car car = new Car(2020, "lexus", "nx", "suv", 99884, 2300 ,"available");

	CarsInvnetory carsInvnetory = new CarsInvnetory();
	EmployeeList employeeList = new EmployeeList();


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Lab 18");
		primaryStage.setScene(updatecarstatus());
		primaryStage.show();

	}

	//public Scene mainMenu() {

	//}

//	public Scene custmormenu() {

	//}

	//public Scene createacount() {

//	}

	//public Scene login() {

	//}

	//public Scene bookcar() {

//	}

	//public Scene bookedscene() {

//	}

	///public Scene rentalmangermenu() {

	//}

	//public Scene carlsitforrentalmanger() {

	//}

	//public Scene carlsitforreceptensssdsds() {

	//}

	public Scene updatecarstatus() {
		StackPane pane = new StackPane();


		ObservableList<String> stat =
				FXCollections.observableArrayList();
		ComboBox status = new ComboBox(stat);

		Button confirm = new Button("CONFIRM");

		ObservableList<Car> carslist2 = FXCollections.observableArrayList();
		for (int i = 0; i < carsInvnetory.getCarlist().size(); i++) {
			carslist2.add(carsInvnetory.getCarlist().get(i));
		}
		ComboBox<Car> combobox = new ComboBox<>();
		combobox.setPromptText("choose the car");
		combobox.setItems(carslist2);
		combobox.setOnAction(e -> {
			System.out.println(combobox.getValue());

			confirm.setOnAction(p -> {
						combobox.getValue().setStatus((String) status.getValue());
						try {
							PrintWriter pwriter = new PrintWriter((new FileWriter("cars")));
							for (int i = 0; i < carslist2.size(); i++) {
								pwriter.println(carslist2.get(i));
							}
							pwriter.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
				});

		stat.add("Available");
		stat.add("Reserved");
		Text update = new Text("Update:");

		HBox hBox = new HBox(update,status);
		hBox.setSpacing(10);

		VBox vBox = new VBox(combobox,hBox,confirm);
		Scene scene = new Scene(pane);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(Background(scene),vBox);

		return scene;

	}

	//public Scene carlsitforcustomer() {

//	}

	public Scene updatecarprice() {

		ObservableList<Car> carslist2 = FXCollections.observableArrayList();
		for (int i = 0; i < carsInvnetory.getCarlist().size(); i++) {
			carslist2.add(carsInvnetory.getCarlist().get(i));
		}

		Label currentprice = new Label();
		TextField newpricetextfield = new TextField();
		Button confirm = new Button("confirm");

		ComboBox<Car> combobox = new ComboBox<>();
		combobox.setPromptText("choose the car");
		combobox.setItems(carslist2);
		combobox.setOnAction(e -> {
			System.out.println(combobox.getValue());
			currentprice.setText("current price: " + combobox.getValue().getPrice());

			confirm.setOnAction(p -> {
				combobox.getValue().setPrice(newpricetextfield.getText());
				currentprice.setText("current price: " + combobox.getValue().getPrice());
				try {
					PrintWriter pwriter = new PrintWriter((new FileWriter("cars")));
					for (int i = 0; i < carslist2.size(); i++) {
						pwriter.println(carslist2.get(i));
					}
					pwriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		});

		Label updatecarprice = new Label("update car price");

		Label newprice = new Label("new price: ");

		newpricetextfield.setFont(Font.font("Times", 20));
		newpricetextfield.setMaxSize(130, 30);
		newpricetextfield.setMinSize(130, 30);

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(newprice, newpricetextfield);

		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(updatecarprice, combobox, currentprice, hbox, confirm);

		StackPane stackpane = new StackPane();
		Scene scene = new Scene(stackpane);
		stackpane.getChildren().addAll(Background(scene), vbox);

		return scene;
	}

//	public Scene hrmenu() {

	//}

	public Scene addemploye() {
		StackPane pane = new StackPane();
		//----------------------------------- texts
		Text name = new Text("Full name: ");
		Text iD = new Text("ID: ");
		Text title = new Text("Title: ");
		Text birth = new Text("Birth date: ");
		Text email = new Text("Email: ");
		VBox leftBox = new VBox(name,iD,title,birth,email);
		leftBox.setSpacing(21);
		//-----------------------------------------


		TextField namefield = new TextField();
		TextField idfield = new TextField();
		TextField titlefield = new TextField();
		TextField emailfield = new TextField();

		//--------------------------
		ObservableList<String> days =
				FXCollections.observableArrayList();
		for (int i = 1; i < 32; i++) {
			days.add(String.valueOf(i));
		}
		ObservableList<String> months =
				FXCollections.observableArrayList();
		for (int i = 1; i < 13; i++) {
			months.add(String.valueOf(i));
		}
		ObservableList<String> years =
				FXCollections.observableArrayList();
		for (int i = 1950; i < 2020; i++) {
			years.add(String.valueOf(i));
		}

		ComboBox day = new ComboBox(days);
		ComboBox month = new ComboBox(months);
		ComboBox year = new ComboBox(years);

		HBox comboBox = new HBox(day,month,year);
		comboBox.setSpacing(8);
		//-----------------------------------------
		Button add = new Button("Add");
		add.setOnAction(e->{
			String date = year.getValue()+"/"+month.getValue()+"/"+day.getValue();
			Employee employee = new Employee(namefield.getText(),String.valueOf(ageCalculator(date)), emailfield.getText(), idfield.getText(), titlefield.getText());
			employeeList.getEmbloyeelist().add(employee);
			try {
				PrintWriter pwriter = new PrintWriter((new FileWriter("employee")));
				for (int i = 0; i < employeeList.getEmbloyeelist().size(); i++) {
					pwriter.println(employeeList.getEmbloyeelist().get(i));
				}
				pwriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		Button cancel = new Button("Cancel");
		HBox buttonBox = new HBox(add,cancel);
		buttonBox.setSpacing(100);
		//-----------------------------------------
		VBox rightBox = new VBox(namefield,idfield,titlefield,comboBox,emailfield,buttonBox);
		rightBox.setSpacing(10);

		FlowPane flowPane = new FlowPane(leftBox,rightBox);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setHgap(5);

		Scene scene = new Scene(pane);
		pane.getChildren().addAll(Background(scene),flowPane);

		return scene;
	}



	//public Scene removeemploye() {

	//}

	//public Scene inventorymenu() {

//	}

	//public Scene addcar() {

	//}

	//public Scene removecar() {

//	}

	public ImageView Background(Scene scene) {
		Image background = new Image("file:menu.jpg");
		ImageView viewBackground = new ImageView(background);
		viewBackground.fitHeightProperty().bind(scene.heightProperty());
		viewBackground.fitWidthProperty().bind(scene.widthProperty());
		return viewBackground;
	}

	public int ageCalculator(String s)  {
		try {


			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date d = sdf.parse(s);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			LocalDate l1 = LocalDate.of(year, month, date);
			LocalDate now1 = LocalDate.now();
			Period diff1 = Period.between(l1, now1);
			return diff1.getYears();

		}catch (ParseException e) {
			System.out.println("Error");
		}
		return 0;

	}

}
