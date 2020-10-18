package FXML;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootController implements Initializable {

	@FXML
    private AnchorPane root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		new SplashScreen().start();

	}

	class SplashScreen extends Thread{
		@Override
		public void run(){
			try{
				Thread.sleep(5000);
				Platform.runLater(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
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
						    root.getScene().getWindow().hide();


						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				});


			}catch(Exception e){

			}
		}
	}


}
