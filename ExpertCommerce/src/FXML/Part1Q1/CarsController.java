package FXML.Part1Q1;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.Vector;

import com.jfoenix.controls.JFXListView;

import expertSystem.Clause;
import expertSystem.Condition;
import expertSystem.Rule;
import expertSystem.RuleBase;
import expertSystem.RuleVariable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CarsController implements Initializable {

    @FXML
    private TextArea rules;

    @FXML
    private TextArea result;

    @FXML
    private JFXListView<String> listVariable;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ChoiceBox<String> goal;

    @FXML
    private Button search;

    @FXML
    private Button knows,exit;

    @FXML
    private TextArea base;

    @FXML
    private ChoiceBox<String> type;

    static RuleBase currentRuleBase ;
    static RuleBase vehicles ;

    Map<String,List<String>> variables = new HashMap<String,List<String>>();
    Map<String,Object> knowledges = new HashMap<String,Object>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//System.out.println("problem here");
		goal.setItems(FXCollections.observableArrayList("Bicycle","Tricycle","Motorcycle",
				"sports_cars","sedan","MiniVan","SUV","sports_utility_vehicule"));
		type.setItems(FXCollections.observableArrayList("forward chain","backward chain"));
		this.listVariable.setItems(FXCollections.observableArrayList("num_wheels","motor"
				,"size","num_doors"));
		List<String> namesList ;
		namesList = Arrays.asList("2","3","4");
		variables.put("num_wheels", namesList);
		namesList = Arrays.asList("yes","no");
		variables.put("motor", namesList);
		namesList = Arrays.asList("small","medium","large");
		variables.put("size", namesList);
		namesList = Arrays.asList("2","4");
		variables.put("num_doors", namesList);
		base.setText("");

		vehicles = new RuleBase("Vehicles Rule Base");
		vehicles.setDisplay(result);
		initVehiclesRuleBase(vehicles);
		currentRuleBase = vehicles;
		currentRuleBase.displayRules(rules);
		currentRuleBase.displayVariables(base);
		currentRuleBase.reset();

	}

	public void initVehiclesRuleBase(RuleBase rb) {
		rb.goalClauseStack = new Stack() ; // goals and subgoals
		rb.variableList = new Hashtable() ;

		RuleVariable vehicle = new RuleVariable("vehicle") ;
		vehicle.setLabels("Bicycle Tricycle MotorCycle Sports_Car Sedan MiniVan Sports_Utility_Vehicle") ;
		vehicle.setPromptText("What kind of vehicle is it?");
		rb.variableList.put(vehicle.name,vehicle) ;

		RuleVariable vehicleType = new RuleVariable("vehicleType") ;
		vehicleType.setLabels("cycle automobile") ;
		vehicleType.setPromptText("What type of vehicle is it?") ;
		rb.variableList.put(vehicleType.name, vehicleType) ;

		RuleVariable size = new RuleVariable("size") ;
		size.setLabels("small medium large") ;
		size.setPromptText("What size is the vehicle?") ;
		rb.variableList.put(size.name,size) ;

		RuleVariable motor = new RuleVariable("motor") ;
		motor.setLabels("yes no") ;
		motor.setPromptText("Does the vehicle have a motor?") ;
		rb.variableList.put(motor.name,motor) ;

		RuleVariable num_wheels = new RuleVariable("num_wheels") ;
		num_wheels.setLabels("2 3 4") ;
		num_wheels.setPromptText("How many wheels does it have?");
		rb.variableList.put(num_wheels.name,num_wheels) ;

		RuleVariable num_doors = new RuleVariable("num_doors") ;
		num_doors.setLabels("2 3 4") ;
		num_doors.setPromptText("How many doors does it have?") ;
		rb.variableList.put(num_doors.name,num_doors) ;

		// Note: at this point all variables values are NULL
		Condition cEquals = new Condition("=") ;
		Condition cNotEquals = new Condition("!=") ;
		Condition cLessThan = new Condition("<") ;

		// define rules
		rb.ruleList = new Vector() ;
		Rule Bicycle = new Rule(rb, "bicycle",
		new Clause(vehicleType,cEquals, "cycle") ,
		new Clause(num_wheels,cEquals, "2"),
		new Clause(motor, cEquals, "no"),
		new Clause(vehicle, cEquals, "Bicycle")) ;

		Rule Tricycle = new Rule(rb, "tricycle",
		new Clause(vehicleType,cEquals, "cycle") ,
		new Clause(num_wheels,cEquals, "3"),
		new Clause(motor, cEquals, "no"),
		new Clause(vehicle, cEquals, "Tricycle")) ;

		Rule Motorcycle = new Rule(rb, "motorcycle",
		new Clause(vehicleType,cEquals, "cycle") ,
		new Clause(num_wheels,cEquals, "2"),
		new Clause(motor,cEquals, "yes"),
		new Clause(vehicle,cEquals, "Motorcycle")) ;

		Rule SportsCar = new Rule(rb, "sportsCar",
		new Clause(vehicleType,cEquals, "automobile") ,
		new Clause(size,cEquals, "small"),
		new Clause(num_doors,cEquals, "2"),
		new Clause(vehicle,cEquals, "sports_cars")) ;

		Rule Sedan = new Rule(rb, "sedan",
		new Clause(vehicleType,cEquals, "automobile") ,
		new Clause(size,cEquals, "medium"),
		new Clause(num_doors,cEquals, "4"),
		new Clause(vehicle,cEquals, "sedan")) ;

		Rule MiniVan = new Rule(rb, "miniVan",
		new Clause(vehicleType,cEquals, "automobile") ,
		new Clause(size,cEquals, "medium"),
		new Clause(num_doors,cEquals, "3"),
		new Clause(vehicle,cEquals, "MiniVan")) ;

		Rule SUV = new Rule(rb, "SUV",
		new Clause(vehicleType,cEquals, "automobile") ,
		new Clause(size,cEquals, "large"),
		new Clause(num_doors,cEquals, "4"),
		new Clause(vehicle,cEquals, "SUV")) ;

		Rule sports = new Rule(rb, "sports_utility_vehicule",
				new Clause(vehicleType,cEquals, "automobile") ,
				new Clause(size,cEquals, "large"),
				new Clause(num_doors,cEquals, "4"),
				new Clause(vehicle,cEquals, "sports_utility_vehicule")) ;

		Rule Cycle = new Rule(rb, "Cycle",
		new Clause(num_wheels,cLessThan, "4") ,
		new Clause(vehicleType,cEquals, "cycle")) ;

		Rule Automobile = new Rule(rb, "Automobile",
		new Clause(num_wheels,cEquals, "4") ,
		new Clause(motor,cEquals, "yes"),
		new Clause(vehicleType,cEquals, "automobile")) ;
	}

	@FXML void addKnowledge(){
		String name = listVariable.getSelectionModel().getSelectedItem();
		String value = choice.getValue();

		RuleVariable rvar =
				(RuleVariable)currentRuleBase.variableList.get(name);
		rvar.setValue(value) ;
		base.appendText(rvar.name + " set to "+ value+"\n");
	}

	@FXML
	public void valueVariable(){
		//System.out.println("value variable");
		choice.getItems().clear();
		String varName = listVariable.getSelectionModel().getSelectedItem();
		RuleVariable rvar =
				(RuleVariable)currentRuleBase.variableList.get(varName);
		Enumeration labels = rvar.labels.elements();

		while (labels.hasMoreElements()) {
			choice.getItems().add(((String)labels.nextElement()));
		}

	}

	@FXML
	public void exit(){
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Parts.fxml"));
		Parent roote;
		try {
			roote = loader.load();
			Scene scene = new Scene(roote);
			rootStage.setScene(scene);
		    rootStage.show();
		    rootStage.setResizable(false);
		    exit.getScene().getWindow().hide();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void fetchData(){
		/** adding the rules*/
		//System.out.println("ok");
		if(goal.getValue() == null){
			System.out.println("no goal selected");
		}else if(type.getValue() == null){
			System.out.println("you have to select a method");
		}else{
			String goal = this.goal.getValue();
			System.out.println(goal);
			result.appendText("\n --- Starting Inferencing Cycle --- \n");

			currentRuleBase.displayVariables(result) ;
			if(type.getValue().equals("forward chain")){
				currentRuleBase.forwardChain() ; // chain until quiescence...
				result.appendText("\n --- Ending Inferencing Cycle --- \n") ;
				String check = currentRuleBase.displayVariables(result);
				if(check!=null){
					if(check.equals(goal)) result.appendText("\n goal found^^\n");
					else result.appendText("\n goal not found :/\n");
				}else result.appendText("\n null\n");

			}
			else{
				currentRuleBase.backwardChain("vehicle") ; // chain until quiescence...
				result.appendText("\n --- Stopping Demo BackwardChain! ---\n ") ;
				String check = currentRuleBase.displayVariables(result);
				if(check!=null){
					if(check.equals(goal)) result.appendText("\n goal found^^\n");
					else result.appendText("\n goal not found :/\n");
				}else result.appendText("\n null\n");
			}


		}
	}

	static public String waitForAnswer(String prompt, String labels) {
		// position dialog over parent dialog
		List<String> choices = new ArrayList<>();
		String[] splitedStr = labels.split(" ");
		for(int i=0;i<splitedStr.length;i++){
			choices.add(splitedStr[i]);
		}
		//System.out.println("label "+labels);
		ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0),choices);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(CarsController.class.getResource("style.css").toExternalForm());
		//dialogPane.getStyleClass().add("style.css");
		dialog.setTitle("Choice Dialog");
		dialog.setHeaderText("Look, a Choice Dialog");
		dialog.setContentText(prompt);

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		/*if (result.isPresent()){
		    System.out.println("Your choice: " + result.get());
		}*/

		// The Java 8 way to get the response value (with lambda expression).
		//result.ifPresent(letter -> System.out.println("Your choice: " + letter));
		return result.get();
	}



}
