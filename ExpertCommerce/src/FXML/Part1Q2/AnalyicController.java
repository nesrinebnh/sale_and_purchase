package FXML.Part1Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnalyicController implements Initializable{

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburder;

    @FXML
    private PieChart chart;

    @FXML
    private TextArea edit;

    @FXML
    private ImageView image;

    @FXML
    private Separator seperator;

    String username;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	        this.chart.getScene().getWindow().hide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
								    this.chart.getScene().getWindow().hide();


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


		int searchYes = 0;
		int searchNo = 0;
		int buy = 0;
		  try {
		      File myObj = new File("src/File/"+username+"Search.txt");
		      if(myObj.exists()){
		    	  Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine().split("/")[0];
			        if(data.equals("yes")) searchYes++;
			        else searchNo++;

			      }
			      myReader.close();
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  try {
		      File myObj = new File("src/File/"+username+"Buy.txt");
		      if(myObj.exists()){
		    	  Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine();
			        buy++;
			      }
			      myReader.close();
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Product found", searchYes),
                new PieChart.Data("Product not found", searchNo),
                new PieChart.Data("Product sold", buy));
		if(searchYes==0 && searchNo == 0 && buy==0){
			this.chart.setVisible(false);
			this.edit.setVisible(true);
		}else{
			this.edit.setVisible(false);
			this.chart.getData().addAll(pieChartData);
		}
	}



}
