package FXML.Part1Q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringJoiner;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class VariablesController implements Initializable {
	@FXML
    private JFXHamburger hamburder;

	@FXML
    private JFXDrawer drawer;

	@FXML
	private TilePane tile;

	@FXML
	private TextField name;

	@FXML
	private ImageView image;

    @FXML
    private Button add, exit;

    private ArrayList<TextField> txtField = new ArrayList<>();
    private ArrayList<ComboBox> cmbBox = new ArrayList<>();

    String username;

    @FXML
    private JFXListView<String> category;


    int i=0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
	      File myObj = new File("src/File/vendors.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        category.getItems().add(data);
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}




	@FXML
	public void addAction(){
		if(i>13){
			this.add.setDisable(true);
		}else{
			System.out.println("add");
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(2,2,2,2));

			TextField txt = new TextField();
			txt.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333; -fx-border-color:  #6b3751;");
			Label label = new Label("Variable Name");
			label.setPadding(new Insets(0,5,0,0));
			label.setStyle("-fx-font-size:14;-fx-text-fill: #333333;");
			Label label2 = new Label("Variable type");
			label2.setStyle("-fx-font-size:14;-fx-text-fill: #333333;");
			label2.setPadding(new Insets(0,5,0,5));
			ComboBox box = new ComboBox();
			box.setStyle("-fx-background-color:    #fffaee; -fx-text-fill: #333333; -fx-border-color:  #6b3751;");
			box.getItems().addAll(FXCollections.observableArrayList("String","date","double","time"));
			pane.add(label, 0, i);
			pane.add(txt, 1, i);
			pane.add(label2, 2, i);
			pane.add(box, 3, i);
			this.txtField.add(txt);
			this.cmbBox.add(box);

			i++;
			tile.getChildren().add(pane);

			tile.setAlignment(Pos.CENTER);
		}


	}

	@FXML
	public void saveAction(){
		this.add.setDisable(true);
		System.out.println(name.getText());
		 try {
	      File myObj = new File("src/File/"+name.getText()+".csv");
	      if (myObj.createNewFile()) {
	    	  try {
	  		    FileWriter myWriter = new FileWriter("src/File/"+name.getText()+".csv");
	  		    StringJoiner str = new StringJoiner(",");
	  			for(int i=0; i<this.txtField.size();i++){
	  				System.out.println(this.txtField.get(i).getText()+" "+this.cmbBox.get(i).getValue());
	  				str.add(this.txtField.get(i).getText()+"/"+this.cmbBox.get(i).getValue());
	  			}
	  			myWriter.append(str.toString());
	  			myWriter.flush();
	  			myWriter.close();

	  			myWriter = new FileWriter("src/File/vendors.txt", true);

	  			myWriter.append(name.getText());
	  			myWriter.flush();
	  			myWriter.close();

	  			myWriter = new FileWriter("src/File/users.txt", true);

	  			myWriter.append("seller/"+name.getText()+"@gmail.com 123456 "+name.getText());
	  			myWriter.flush();
	  			myWriter.close();

	  			category.getItems().add(name.getText());
	  		} catch (IOException e) {
	  		      System.out.println("An error occurred.");
	  		      e.printStackTrace();
	  		 }
	      } else {
	    	  try {
	  		    FileWriter myWriter = new FileWriter("src/File/Laptop.csv");
	  		    StringJoiner str = new StringJoiner(",");
	  			for(int i=0; i<this.txtField.size();i++){
	  				System.out.println(this.txtField.get(i).getText()+" "+this.cmbBox.get(i).getValue());
	  				str.add(this.txtField.get(i).getText()+"/"+this.cmbBox.get(i).getValue());
	  			}
	  			myWriter.append(str.toString());
	  			myWriter.flush();
	  			myWriter.close();
	  		} catch (IOException e) {
	  		      System.out.println("An error occurred.");
	  		      e.printStackTrace();
	  		 }
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }


	}

	@FXML
	public void removeAction() throws IOException{
		String name = this.category.getSelectionModel().getSelectedItem();

		File myObj = new File("src/File/"+name+".csv");
	    if (myObj.delete()) {
	      System.out.println("Deleted the file: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    }

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("By clicking on OK, you will delete the vendor named: "+name);
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			category.getItems().remove(name);
			File inputFile = new File("src/File/vendors.txt");
			File tempFile = new File("src/File/","vendorstmp.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;

			int line = -1;
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();




			    if(trimmedLine.equals(name)) continue;
			    writer.write(currentLine);
			    writer.write("\n");
			}
			writer.close();
			reader.close();

			boolean delete = inputFile.delete();
			boolean successful = tempFile.renameTo(new File("src/File/vendors.txt"));
		} else {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Operation canceled");

			alert.showAndWait();
		}


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
        this.category.getScene().getWindow().hide();
	}
}
