package FXML;

import FXML.Part1Q2.LoginController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PartsController implements Initializable {

    @FXML
    private Button sale;

    @FXML
    private Button expertSystem;

    @FXML
    private Button jade;

    @FXML
    private Button jason;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void saleAction(){
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Part1Q2/login.fxml"));
		Parent roote;
		try {
			roote = loader.load();
			LoginController control = loader.getController();
			control.user("expert");
			Scene scene = new Scene(roote);
			rootStage.setScene(scene);
		    rootStage.show();
		    rootStage.setResizable(false);
		    jason.getScene().getWindow().hide();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void expertAction(){
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Part1Q1/CarsUI.fxml"));
		Parent roote;
		try {
			roote = loader.load();
			Scene scene = new Scene(roote);
			rootStage.setScene(scene);
		    rootStage.show();
		    rootStage.setResizable(false);
		    sale.getScene().getWindow().hide();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void jadeAction(){
		Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Part1Q2/login.fxml"));
		Parent roote;
		try {
			roote = loader.load();
			LoginController control = loader.getController();
			control.user("agent");
			Scene scene = new Scene(roote);
			rootStage.setScene(scene);
		    rootStage.show();
		    rootStage.setResizable(false);
		    sale.getScene().getWindow().hide();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
