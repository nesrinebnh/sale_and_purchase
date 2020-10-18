package FXML.Part1Q2;

import FXML.Part2.HomeController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import expertSystem.Clause;
import expertSystem.Rule;
import expertSystem.RuleVariable;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {

	@FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button login,exit;

    private String type;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	@FXML
	public void signupAction() throws IOException{
		 Stage rootStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/Part1Q2/SignUp.fxml"));
		Parent root;

		root = loader.load();
		Scene scene = new Scene(root);
        rootStage.setScene(scene);
        rootStage.show();
        rootStage.setResizable(false);
        this.login.getScene().getWindow().hide();
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
        this.login.getScene().getWindow().hide();
	}

	@FXML
	public void loginAction() throws IOException{
		String row;
		String path="";
		BufferedReader csvReader = new BufferedReader(new FileReader("src/File/users.txt"));
		boolean found = false;
		while ((row = csvReader.readLine()) != null && !found) {
			String[] data = row.split("/");
			System.out.println(row);
			path = "../../FXML/";

			String[] data1 = data[1].split(" ");
			if(data1[2].equals(username.getText())&& data1[1].equals(password.getText())){
				if(data[0].equals("buyer")){

					path +="Part1Q2/GeneralHome2.fxml";
					System.out.println(path);
					Stage rootStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(this.getClass().getResource(path));
					Parent root;
					try {
						root = loader.load();
						Scene scene = new Scene(root);
						//scene.getStylesheets().add("")
						System.out.println("controller "+loader.getController().getClass().getName());
						RootController buy = loader.getController();
				        buy.user(username.getText(), type);
				        rootStage.setScene(scene);
				        rootStage.show();
				        rootStage.setResizable(false);
				        this.login.getScene().getWindow().hide();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				}else if(data[0].equals("admin")){
					path +="Part1Q2/Variables.fxml";
					System.out.println(path);
					Stage rootStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(this.getClass().getResource(path));
					Parent root;
					try {
						root = loader.load();
						Scene scene = new Scene(root);
						//scene.getStylesheets().add("")
						//System.out.println("controller "+loader.getController().getClass().getName());
						//RootController buy = loader.getController();
				        //buy.user(username.getText(), type);
				        rootStage.setScene(scene);
				        rootStage.show();
				        rootStage.setResizable(false);
				        this.login.getScene().getWindow().hide();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					path += "Part1Q2/Cars.fxml";
					Stage rootStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(this.getClass().getResource(path));
					Parent root;
					try {
						root = loader.load();
						Scene scene = new Scene(root);
						System.out.println("controller "+loader.getController().getClass().getName());
						AdminController buy = loader.getController();
				        buy.user(username.getText());
				        rootStage.setScene(scene);
				        rootStage.show();
				        rootStage.setResizable(false);
				        this.login.getScene().getWindow().hide();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


				found = true;
			}
		}
		if(found == false){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("User Error");
			alert.setHeaderText("User Authentification");
			alert.setContentText("Ooops, no user found!");

			alert.showAndWait();
		}
	}


	public void user(String type){
		this.type = type;
	}
}
