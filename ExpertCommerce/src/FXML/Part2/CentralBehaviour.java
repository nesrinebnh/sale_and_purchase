package FXML.Part2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class CentralBehaviour extends CyclicBehaviour {
	int i=0;
	TextField answer;
	GridPane grid;
	ImageView image, image2;
	ListView list;
	public CentralBehaviour(TextField answer, GridPane p, ImageView i, ListView l, ImageView i2){
		this.answer = answer;
		this.grid = p;
		this.image = i;
		this.list = l;
		this.image2 = i2;
	}


	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg = this.getAgent().receive();
		if(msg!=null){

			List<String> vehiculesPath = new ArrayList<String>();
			i++;
			System.out.println("i am "+this.getAgent().getLocalName()+" i received a msg from "+msg.getSender().getLocalName());


			Platform.runLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Answer s = (Answer) msg.getContentObject();
					HomeController.updateAnswer(s,answer, grid, image, list, image2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			// place the code here, that you want to execute
			}});


		}else{
			block();
		}

	}


}
