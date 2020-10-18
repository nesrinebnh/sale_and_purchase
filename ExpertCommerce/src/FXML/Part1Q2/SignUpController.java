package FXML.Part1Q2;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button signup;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.type.setItems(FXCollections.observableArrayList("seller","buyer"));


	}


	@FXML
	public void signupAction(){
		String email = this.email.getText();
		String password = this.password.getText();
		String username = this.username.getText();
		String type = this.type.getValue();

		try {
		    FileWriter myWriter = new FileWriter("src/File/users.txt",true);
		    myWriter.write(type+"/"+email+" "+password+" "+username+"\n");
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		    Stage rootStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("../FXML/Part1Q2/login.fxml"));
			Parent root;

			root = loader.load();
			Scene scene = new Scene(root);
	        rootStage.setScene(scene);
	        rootStage.show();
	        rootStage.setResizable(false);
	        this.signup.getScene().getWindow().hide();

		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}

	}

}
