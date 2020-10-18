package FXML.Part1Q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.Vector;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import expertSystem.Clause;
import expertSystem.Condition;
import expertSystem.Rule;
import expertSystem.RuleBase;
import expertSystem.RuleVariable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController implements Initializable {

	@FXML
    private JFXDrawer drawer;

	@FXML
    private TilePane tile;

    @FXML
    private JFXListView<String> base;

    @FXML
    private Button remove;

    @FXML
    private JFXHamburger hamburder;

    @FXML
    private Button add;

    @FXML
    private ImageView image;

    @FXML
    private Text nameRuleBase;

    static RuleBase currentRuleBase ;
    static RuleBase vehicles ;
    Condition cEquals = new Condition("=") ;
    ArrayList<String> str = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    ArrayList<String> order = new ArrayList<>();
    String username;

    ArrayList<TextField> array = new ArrayList<>();
    ArrayList<JFXDatePicker> arrayDate = new ArrayList<>();
    ArrayList<JFXTimePicker> arrayTime = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void translateScenes(String path,String type) throws IOException{
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(path));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			if(type.equals("Analytic")){
				AnalyicController buy = loader.getController();
		        buy.user(this.username);
			}else if(type.equals("Cars")){
					AdminController buy = loader.getController();
			        buy.user(this.username);

			}
	        rootStage.setScene(scene);
	        rootStage.show();
	        rootStage.setResizable(false);
	        this.add.getScene().getWindow().hide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@FXML
	public void addRule() throws IOException{
		StringJoiner sj = new StringJoiner(",");

		Clause cfinal;
		ArrayList<Clause> listClause = new ArrayList<Clause>();
		if(!array.get(0).getText().isEmpty()){
			cfinal = new Clause((RuleVariable)vehicles.variableList.get(str.get(0)),cEquals,array.get(0).getText());
			sj.add(array.get(0).getText());
			int i = 1,m=1,k=0,f=0;
			for(int j=0; j<(order.size()-1);j++){
				Clause c;
				switch(order.get(i)){
					case "field":{
						TextField txt = array.get(m);
						if(!txt.getText().isEmpty()){
							sj.add(txt.getText());
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,txt.getText());
						}

						else{
							sj.add("null");
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,"none");

						}
						listClause.add(c);
						m++;
						break;
					}
					case "date":{
						//JFXDatePicker JFXTimePicker
						System.out.println(k+" "+arrayDate.size());
						JFXDatePicker txt = arrayDate.get(k);
						if(txt.getValue() != null){
							sj.add(txt.getValue().toString());
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,txt.getValue().toString());
						}

						else{
							sj.add("null");
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,"none");

						}
						listClause.add(c);
						k++;
						break;
					}
					case "time":{
						JFXTimePicker txt = arrayTime.get(f);
						if(txt.getValue() != null){
							sj.add(txt.getValue().toString());
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,txt.getValue().toString());
						}

						else{
							sj.add("null");
							c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,"none");

						}
						listClause.add(c);
						f++;
						break;
					}

				}

				i++;



			}
			Rule rule = new Rule(vehicles, cfinal.rhs,
		    		listClause,
		    		cfinal) ;
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("By clicking on OK, you will add this rule : "+sj.toString()+" to your rule base");
			alert.setContentText("Are you ok with this?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				FileWriter myWriter = new FileWriter("src/File/"+username+".csv",true);
				myWriter.append(sj.toString());
				myWriter.append("\n");
				myWriter.close();
				vehicles.displayRules(base);


			}else{
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Operation canceled");

				alert.showAndWait();
			}

		}else {
			System.out.println("error");
		}

	}

	@FXML
	public void removeRule() throws IOException{
		String model = base.getSelectionModel().getSelectedItem();
		int modelindex = base.getSelectionModel().getSelectedIndex();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("By clicking on OK, you will delete "+model.split(":")[0]);
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			base.getItems().remove(model);
			File inputFile = new File("src/File/"+username+".csv");
			File tempFile = new File("src/File/","myTempFile.csv");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;

			int line = -1;
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine[] = currentLine.trim().split(",");
			    System.out.println(line+" "+modelindex);

			    if(line == modelindex){
			    	line += 1;
			    	continue;
			    }

			    line += 1;



			    //if(trimmedLine[0].equals(model.split(":")[0])) continue;
			    writer.write(currentLine);
			    writer.write("\n");
			}
			writer.close();
			reader.close();

			boolean delete = inputFile.delete();
			boolean successful = tempFile.renameTo(new File("src/File/",username+".csv"));
		} else {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Operation canceled");

			alert.showAndWait();
		}

	}

	public void user(String username){
		this.username = username;
		try {
			Pane box = FXMLLoader.load(this.getClass().getResource("/FXML/Part1Q2/Drawer.fxml"));
			drawer.setSidePane(box);
			drawer.open();

			for(Node node: box.getChildren()){
				if(node.getAccessibleText() != null){
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
						switch (node.getAccessibleText()){
							case "manageRules":{
								try {
									this.translateScenes("/FXML/Part1Q2/Cars.fxml","Cars");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							}
							case "home":{
								try {
									this.translateScenes("/FXML/Part1Q2/Analytic.fxml","Analytic");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							}
							case "variables":{
								try {
									this.translateScenes("/FXML/Part1Q2/Variables.fxml","Variables");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							}
							case "exit":{
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
								    this.add.getScene().getWindow().hide();


								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								break;
							}

						}
					});
				}

			}

			HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(this.hamburder);
			burgerTask2.setRate(1);
			this.hamburder.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
				burgerTask2.setRate(burgerTask2.getRate()*-1);
				burgerTask2.play();


				if(drawer.isOpened())
					drawer.close();
				else drawer.open();
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		tile.setHgap(14);
		tile.setVgap(14);
		ObservableList<GridPane> list = FXCollections.observableArrayList();
		//tile.getChildren().addAll(list);
		vehicles = new RuleBase(username);
		this.nameRuleBase.setText(username+" Rule Base");
		vehicles.goalClauseStack = new Stack() ; // goals and subgoals
		vehicles.variableList = new Hashtable() ;
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("src/File/"+username+".csv"));
			String row;
			try {
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    for(int i=0;i<data.length;i++){
				    	String[] splitedStr = data[i].split("/");
				    	str.add(splitedStr[0]);
				    	type.add(splitedStr[1]);

				    	RuleVariable rule = new RuleVariable(splitedStr[0]) ;
				    	vehicles.variableList.put(rule.name,rule);

				    }
				}
				vehicles.ruleList = new Vector() ;

				while ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    ArrayList<Clause> listClause = new ArrayList<>();
				    Clause cfinal = null ;
				    for(int i=0;i<data.length;i++){

				    	if(i == 0){
				    		cfinal = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,data[i]);
				    	}else{
				    		if(data[i] == null){
				    			Clause c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,"none");
						    	listClause.add(c);
				    		}else{
				    			Clause c = new Clause((RuleVariable)vehicles.variableList.get(str.get(i)),cEquals,data[i]);
						    	listClause.add(c);
				    		}

				    	}

				    }

				    Rule rule = new Rule(vehicles, data[0],
				    		listClause,
				    		cfinal) ;
				}

				vehicles.displayRules(base);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(2,2,2,2));
		if(str.size()>=11){
			pane.setHgap(14);
			pane.setVgap(14);
		}else  {
			pane.setHgap(str.size()*2);
			pane.setVgap(str.size()*2);
		}
		for(int i=0; i<str.size();i++){
			Label label = new Label(str.get(i));
			label.setStyle("-fx-font-size:14;-fx-text-fill: #333333;");
			if(type.get(i).equals("date")){
				 JFXDatePicker date = new JFXDatePicker();
				 date.setDefaultColor(Color.ORANGE);
				 order.add("date");
				 arrayDate.add(date);
				 pane.add(label, 0, i);
				pane.add(date, 1, i);
			}else if(type.get(i).equals("time")){
				 JFXTimePicker time = new JFXTimePicker();
				 time.setDefaultColor(Color.ORANGE);
				 order.add("time");
				 arrayTime.add(time);
				 pane.add(label, 0, i);
				pane.add(time, 1, i);
			}else{
				TextField txt = new TextField();
				txt.setStyle("-fx-background-color:   #fffaee; -fx-text-fill: #333333;-fx-border-color:  #6b3751;");
				order.add("field");
				array.add(txt);
				pane.add(label, 0, i);
				pane.add(txt, 1, i);
			}


		}
		list.add(pane);
		tile.getChildren().add(pane);

		tile.setAlignment(Pos.CENTER);

	}

}
