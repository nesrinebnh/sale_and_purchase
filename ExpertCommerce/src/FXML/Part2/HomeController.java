package FXML.Part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import FXML.Part1Q2.BuyerController;
import FXML.Part1Q2.RootController;
import expertSystem.RuleVariable;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private JFXListView<String> variablesList;

    @FXML
    private TextField variableName;

    @FXML
    private TextField variableValue;

    @FXML
    protected TextField answer;

    @FXML
    private GridPane grid1;

    @FXML
    private JFXListView<String> list;

    @FXML
    private Label text;

    @FXML
    private ImageView imageExist;

    @FXML
    private ImageView image;

    @FXML
    private Button next,buy;

    @FXML
    private Button finish;

    @FXML
    private JFXHamburger hamburder;

    @FXML
    private JFXDrawer drawer;

    private String type,username;

    private ContainerController mc;

    private static LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
    AgentController ag1, ag2, ag3, ag4;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Runtime rt=Runtime.instance();
		ProfileImpl p= new ProfileImpl("localhost",1099,"RSHP");
		mc= rt.createMainContainer(p);
		/*Object[] obj = new Object[]{false};

		try {
			ag1 = mc.createNewAgent("Central", "FXML.Part2.Central",obj);
			ag1.start();

			ag2= mc.createNewAgent("Cars", "FXML.Part2.Vendor",obj);
			ag2.start();

			ag3= mc.createNewAgent("TravelAgency", "FXML.Part2.Vendor",obj);
			ag3.start();

			ag4= mc.createNewAgent("Smartphone", "FXML.Part2.Vendor",obj);
			ag4.start();
			mc.kill();
			// mc.getAgent()

		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/




	}

	public void translateScenes(String path, String type) throws IOException{
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(path));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			if(type == null){
				RootController buy = loader.getController();
		        buy.user(username, this.type);
		        rootStage.setScene(scene);
		        rootStage.show();
		        rootStage.setResizable(false);
		        this.drawer.getScene().getWindow().hide();
			}else if(type.equals("logout")){
				rootStage.setScene(scene);
		        rootStage.show();
		        rootStage.setResizable(false);
		        this.drawer.getScene().getWindow().hide();
			}else{
				HomeController buy = loader.getController();
				System.out.println("translate "+username+" "+type+" "+this.type);
		        buy.user(type,this.type);
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


	public void user(String username,String type){
		this.type = type;
		this.username = username;
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
									this.translateScenes("/FXML/Part2/Home.fxml", "Cars");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							}
							case "Smartphones":{
								try {
									this.translateScenes("/FXML/Part2/Home.fxml", "Smartphone");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								break;
							}
							case "TravelAgency":{
								try {
									this.translateScenes("/FXML/Part2/Home.fxml", "TravelAgency");
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
		}catch(Exception e){

		}

		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("src/File/"+username+".csv"));
			String row;
			try {
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    for(int i=0;i<data.length;i++){
				    	String[] splited = data[i].split("/");
				    	this.variablesList.getItems().add(splited[0]);
				    }

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			csvReader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	public static void updateAnswer(Answer answer, TextField vendorAnswer, GridPane p, ImageView i , ListView<String> l,ImageView exist) throws IOException{
		FileWriter myWriter = new FileWriter("src/File/"+answer.who+"Search.txt",true);
		File file;
		Image image;
		map = answer.map;
		l.getItems().clear();
		if(answer.fired.size()==0){
			p.setVisible(false);
			i.setVisible(true);
			vendorAnswer.setText("Product with such criteria not found !");
			file = new File("src/asset/notFound.png");
	        image = new Image(file.toURI().toString());
	        i.setImage(image);
		}else{
			vendorAnswer.setText(answer.fired.size()+" Product with such criteria found !");
			file = new File("src/asset/"+answer.who+".png");
	        image = new Image(file.toURI().toString());
	        exist.setImage(image);
	        i.setVisible(false);
	        p.setVisible(true);
	        for(String s: answer.fired){
	        	l.getItems().add(s);
	        }
		}

	}

	@FXML
	public void nextAction() throws StaleProxyException{
		String name = this.variableName.getText();
		String value = this.variableValue.getText();
		System.out.println(name+" "+value);
		//this.answer.setText("exist");
		this.variableName.setText("");
        this.variableValue.setText("");
		if(map.get(name) == null){
			map.put(name, value);


			Object[] obj = new Object[]{true,username,map,0,this.answer, grid1, image, list, this.imageExist};
	        CallAgent ca=new CallAgent(obj,mc);

		}else{
			if(map.get(name).equals(value)){
				System.out.println(name+" already asked");
				this.answer.setText("the question "+name+"="+value+ " is already asked");
			}else{
				map.put(name, value);
				Object[] obj = new Object[]{true,username,map,0,this.answer, grid1, image, list, this.imageExist};
		        CallAgent ca=new CallAgent(obj,mc);

			}
		}

	}

	@FXML
	public void finishAction(){
		this.answer.setText("ask a new question, we will answer");
		this.variableName.setText("");
		this.variableValue.setText("");
		this.map.clear();
	}

	@FXML
	public void exitAction() throws IOException{
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Parts.fxml"));
		Parent root;

		root = loader.load();
		Scene scene = new Scene(root);
        rootStage.setScene(scene);
        rootStage.show();
        rootStage.setResizable(false);
        this.answer.getScene().getWindow().hide();

	}




}
