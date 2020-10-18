package FXML.Part1Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import FXML.Part2.HomeController;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RootController implements Initializable {


	@FXML
    private Button cars;

    @FXML
    private Button travelAgency;

    @FXML
    private Button smartphone;

    @FXML
    private ComboBox<String> logo, categories;

    String username, type;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();
		int count = 0;

		logo.setItems(FXCollections.observableArrayList("logout"));
		try {
	      File myObj = new File("src/File/vendors.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if(!data.equals("Cars")&& !data.equals("TravelAgency") && !data.equals("Smartphone"))
	        	list.add(data);
	        count ++;
	        //category.getItems().add(data);
	      }
	      myReader.close();
	      if(count<=3){
	    	  categories.setVisible(false);
	      }else
	    	  categories.setItems(FXCollections.observableArrayList(list));
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

	}

	@FXML
	public void carsAction() throws IOException{
		if(type.equals("expert")) this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", "Cars");
		else this.translateScenes("/FXML/Part2/Home.fxml", "Cars");
	}

	@FXML
	public void smartphoneAction() throws IOException{
		if(type.equals("expert")) this.translateScenes("/FXML/Part1Q2/Buyer2.fxml","Smartphone");
		else this.translateScenes("/FXML/Part2/Home.fxml", "Smartphone");
	}

	@FXML
	public void travelAction() throws IOException{
		if(type.equals("expert")) this.translateScenes("/FXML/Part1Q2/Buyer2.fxml","TravelAgency");
		else this.translateScenes("/FXML/Part2/Home.fxml", "TravelAgency");
	}




	public void translateScenes(String path, String type) throws IOException{
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(path));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			System.out.println("controller "+loader.getController().getClass().getName());
			if(type != null){
				if(this.type.equals("expert")){
					BuyerController buy = loader.getController();
			        buy.user(null,type);
				}else{
					HomeController buy = loader.getController();
			        buy.user(type,this.type);
				}

			}else{
				LoginController control = loader.getController();
				control.user("expert");
			}
	        rootStage.setScene(scene);
	        rootStage.show();
	        rootStage.setResizable(false);
	        this.cars.getScene().getWindow().hide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void dropMenu() throws IOException{
		String selected = this.logo.getSelectionModel().getSelectedItem();
		if(selected.equals("logout"))  this.translateScenes("/FXML/Part1Q2/login.fxml", null);

	}

	@FXML
	public void selectCategory() throws IOException{
		String selected = this.categories.getSelectionModel().getSelectedItem();
		if(type.equals("expert")) this.translateScenes("/FXML/Part1Q2/Buyer2.fxml", selected);
		else this.translateScenes("/FXML/Part2/Home.fxml", selected);

	}

	public void user(String user, String type){
		this.username = user;
		this.type = type;
	}



}
