package FXML.Part1Q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BuyerController implements Initializable {
	@FXML
    private GridPane grid2;

    @FXML
    private Button display;

    @FXML
    private JFXListView<String> list;

    @FXML
    private Label text;

    @FXML
    private ImageView imageExist;

    @FXML
    private Button reset;

    @FXML
    private Button search;

    @FXML
    private TilePane tile;

    @FXML
    private JFXHamburger hamburder;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private GridPane grid1;

    @FXML
    private Label textNotFond;

    @FXML
    private ImageView imageNotFound;


    ArrayList<ComboBox<String>> array = new ArrayList<ComboBox<String>>();
    ArrayList<TextField> arrayField = new ArrayList<>();

    StringJoiner fileStr = new StringJoiner(",");

    static RuleBase vehicles ;
    Condition cEquals = new Condition("=") ;
    Condition cLessOrEqual = new Condition(">=") ;
    ArrayList<String> str = new ArrayList<>();
    ArrayList<String> typeCol = new ArrayList<>();
    ArrayList<String> order = new ArrayList<>();
    ArrayList<JFXDatePicker> arrayDate = new ArrayList<>();
    ArrayList<JFXTimePicker> arrayTime = new ArrayList<>();
    ArrayList<RuleVariable> variables;

    HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    private String username, type;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}


	@FXML
	public void fetchData(){
		File file ;
        Image image ;
        this.grid2.setVisible(false);
        this.grid1.setVisible(true);
		for(int i=0; i<array.size();i++){
			RuleVariable rvar =
					(RuleVariable)vehicles.variableList.get(array.get(i).getId());
			if(array.get(i).getValue() != null){
				rvar.setValue(array.get(i).getValue());
				fileStr.add(array.get(i).getId()+"="+array.get(i).getValue());
			}

		}
		for(int i=0; i< this.arrayDate.size();i++){
			RuleVariable rvar =
					(RuleVariable)vehicles.variableList.get(arrayDate.get(i).getId());
			if(arrayDate.get(i).getValue()!=null){
				rvar.setValue(arrayDate.get(i).getValue().toString());
				fileStr.add(arrayDate.get(i).getId()+"="+arrayDate.get(i).getValue().toString());
			}

		}

		for(int i=0; i< this.arrayTime.size();i++){
			RuleVariable rvar =
					(RuleVariable)vehicles.variableList.get(arrayTime.get(i).getId());
			if(arrayTime.get(i).getValue()!=null){
				rvar.setValue(arrayTime.get(i).getValue().toString());
				fileStr.add(arrayTime.get(i).getId()+"="+arrayTime.get(i).getValue().toString());
			}

		}
		System.out.println("field "+arrayField.size());
		boolean error = false;
		for(int i=0; i<this.arrayField.size();i++){
			RuleVariable rvar =
					(RuleVariable)vehicles.variableList.get(arrayField.get(i).getId());
			if(arrayField.get(i).getId().equals("price") && arrayField.get(i).getText().isEmpty()){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle(type+" Error");
				alert.setHeaderText("Data insertion error");
				alert.setContentText("Ooops, seems price field is empty!");
				error = true;
				alert.showAndWait();
			}
			if(!arrayField.get(i).getText().isEmpty()){
				System.out.println(arrayField.get(i).getId());
				rvar.setValue(arrayField.get(i).getText());
				fileStr.add(arrayField.get(i).getId()+"="+arrayField.get(i).getText());
			}

		}
		if(!error){
			variables = vehicles.fetchVariables();
			createRules();

			for(RuleVariable s: vehicles.fetchVariables()){
				s.updateClauses();
			}

			ArrayList<Rule> fired = vehicles.forwardChain() ;
			this.list.getItems().clear();
			try {
			    FileWriter myWriter = new FileWriter("src/File/"+type+"Search.txt",true);
				if(fired.size() == 0){

					this.textNotFond.setText("No product matched");

					file = new File("src/asset/notFound.png");
			        image = new Image(file.toURI().toString());
			        this.imageNotFound.setImage(image);
				    myWriter.write("no/"+fileStr.toString()+"\n");
				    myWriter.close();
				}else{
					this.grid1.setVisible(false);
					this.grid2.setVisible(true);
					file = new File("src/asset/"+this.type+".png");
			        image = new Image(file.toURI().toString());
			        this.imageExist.setImage(image);
					this.text.setText("yupii "+fired.size()+" products were matched\n");

					for(Rule r : fired){
						String str = r.name+" : ";
						for(int i=0; i< r.antecedents.length;i++){
							if(r.antecedents[i].lhs.name.equals("price"))
								str+=r.antecedents[i].rhs+"DA\n";
						}
						//System.out.println(r.toString());
						list.getItems().add(str);
					}

					list.getSelectionModel().selectFirst();

					this.display.setVisible(true);
					 myWriter.write("yes/"+fileStr.toString()+"\n");
					    myWriter.close();


				}
			} catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			}

		}


	}

	@FXML
	public void buyAction(){
		String product = this.list.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Purchase Dialog");
		alert.setHeaderText("You are willing to buy "+product);
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			try {
			      FileWriter myWriter = new FileWriter("src/File/"+type+"Buy.txt",true);
			      myWriter.write(product);
			      myWriter.write("\n");
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		}


	}

	@FXML
	public void resetAction() throws IOException{
		/*for(int i=0; i<array.size();i++){
			this.array.get(i).setValue("");
			RuleVariable rvar =
					(RuleVariable)vehicles.variableList.get(str.get(i));
			rvar.setValue("");
		}*/
		this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", "Cars");
	}


	private void createRules(){
		vehicles.ruleList = new Vector() ;
		ArrayList<Integer> indexes = new ArrayList<>();
		ArrayList<Integer> indexesVar = new ArrayList<>();
		RuleVariable vehicule = new RuleVariable("vehicule");
	    vehicles.variableList.put(vehicule.name,vehicule);
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("src/File/"+type+".csv"));
			String row;
			try {
				Clause cfinal = null;

				boolean indexfinal = false;
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    RuleVariable rvar = (RuleVariable)vehicles.variableList.get("price");
				    if(rvar.value!=null){
			    		indexfinal = true;
			    		variables.remove(rvar);
			    	}
				    for(int i=0;i<data.length;i++){
				    	String splited = data[i].split("/")[0];
				    	if(splited.equals("price")) continue;
				    	rvar = (RuleVariable)vehicles.variableList.get(splited);
				    	if(variables.get(variables.indexOf(rvar)).value != null){
				    		indexes.add(i);
				    		indexesVar.add(variables.indexOf(rvar));
				    	}
				    }
				}


				while ((row = csvReader.readLine()) != null) {
					ArrayList<Clause> listClause = new ArrayList<Clause>();
				    String[] data = row.split(",");
				    cfinal = new Clause(vehicule,this.cEquals,data[0]);
				    for(int i=0;i<indexes.size();i++){
						   listClause.add(new Clause((RuleVariable)vehicles.variableList.get(variables.get(indexesVar.get(i)).name),this.cEquals,data[indexes.get(i)]));
				    }
				    if(indexfinal == true)
				    	listClause.add(new Clause((RuleVariable)vehicles.variableList.get(str.get(data.length-1)),this.cLessOrEqual,data[data.length-1]));

				    Rule rule = new Rule(vehicles, data[0],listClause,cfinal);
				}

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
	}

	public void translateScenes(String path, String type) throws IOException{
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(path));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			if(type==null){
				RootController buy = loader.getController();
		        buy.user(username, this.type);
		        rootStage.setScene(scene);
		        rootStage.show();
		        rootStage.setResizable(false);
		        this.drawer.getScene().getWindow().hide();
			}else if(type.equals("logout")){
				LoginController control = loader.getController();
				control.user("expert");
				rootStage.setScene(scene);
		        rootStage.show();
		        rootStage.setResizable(false);
		        this.drawer.getScene().getWindow().hide();
			}else{
				BuyerController buy = loader.getController();
		        buy.user(username,type);
		        rootStage.setScene(scene);
		        rootStage.show();
		        rootStage.setResizable(false);
		        this.drawer.getScene().getWindow().hide();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void user(String user, String type){
		this.username = user;
		this.type = type;
		this.grid1.setVisible(true);
	    ObservableList<GridPane> list2 = FXCollections.observableArrayList();
		try {
			Pane box = FXMLLoader.load(this.getClass().getResource("/FXML/Part1Q2/GeneralDrawer.fxml"));
			drawer.setSidePane(box);
			drawer.open();

			for(Node node: box.getChildren()){
				if(node.getAccessibleText() != null){
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
						switch (node.getAccessibleText()){
						case "home":{
							try {
								this.translateScenes("/FXML/Part1Q2/GeneralHome2.fxml", null);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						case "Cars":{
							try {
								this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", "Cars");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						case "Smartphones":{
							try {
								this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", "Smartphone");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						case "TravelAgency":{
							try {
								this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", "TravelAgency");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						case "logout":{
							try {
								this.translateScenes("/FXML/Part1Q2/login.fxml", "logout");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}

						}
					});
				}

			}

			HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(this.hamburder);
			burgerTask2.setRate(0);
			drawer.close();
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


		/** Reading the file*/
		vehicles = new RuleBase(type);
		vehicles.goalClauseStack = new Stack() ; // goals and subgoals
		vehicles.variableList = new Hashtable() ;


		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("src/File/"+type+".csv"));
			String row;
			try {
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    for(int i=0;i<data.length;i++){
				    	String[] splited = data[i].split("/");
				    	str.add(splited[0]);
				    	typeCol.add(splited[1]);

				    	map.put(splited[0], new HashSet<String>());
				    	RuleVariable rule = new RuleVariable(splited[0]) ;
				    	vehicles.variableList.put(rule.name,rule);

				    }

				}

				while ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    for(int i=0;i<data.length-1;i++){
				    	map.get(str.get(i)).add(data[i]);
				    }

				}

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
		if(str.size()>11){
			pane.setHgap(10);
			pane.setVgap(10);
		}else  {
			pane.setHgap(str.size()*2);
			pane.setVgap(str.size()*2);
		}
		//if(str.size()<=13){
		for(int i=0; i<str.size();i++){
			Label label = new Label(str.get(i));
			label.setStyle("-fx-font-size:14;-fx-text-fill: #fffaee;");
			if(typeCol.get(i).equals("date")){
				 JFXDatePicker date = new JFXDatePicker();
				 date.setDefaultColor(Color.DARKVIOLET);
				 date.setId(str.get(i));
				 date.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333;-fx-pref-width: 150;");
				 //order.add("date");
				 arrayDate.add(date);
				 pane.add(label, 0, i);
				pane.add(date, 1, i);
			}else if(typeCol.get(i).equals("time")){
				 JFXTimePicker time = new JFXTimePicker();
				 time.setDefaultColor(Color.DARKVIOLET);
				 time.setId(str.get(i));
				 time.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333;-fx-pref-width: 150;");
				 //order.add("time");
				 arrayTime.add(time);
				 pane.add(label, 0, i);
				pane.add(time, 1, i);
			}else if(typeCol.get(i).equals("String")){
				ComboBox txt = new ComboBox();
				txt.setId(str.get(i));
				txt.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333;-fx-pref-width: 150;");
				//order.add("field");
				array.add(txt);
				pane.add(label, 0, i);
				pane.add(txt, 1, i);
			}else{
				TextField txt = new TextField();
				txt.setId(str.get(i));
				txt.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333;-fx-pref-width: 150;");
				//order.add("field");
				arrayField.add(txt);
				pane.add(label, 0, i);
				pane.add(txt, 1, i);
			}
		}
		list2.add(pane);
		tile.getChildren().add(pane);

		tile.setAlignment(Pos.CENTER);


		for(int i=0; i<array.size();i++){
			array.get(i).getItems().addAll(map.get(array.get(i).getId()));
		}


	}







}
