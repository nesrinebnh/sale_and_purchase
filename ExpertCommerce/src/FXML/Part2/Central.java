package FXML.Part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Central extends Agent {
	private LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	private String Path = "";
	private String choice;
	private ContainerController mc;
	private int who;
	private TextField answer;
	private GridPane grid;
	private ImageView image, imageExist;
	private ListView list;
	@Override
	protected void setup(){
		Object[] args = getArguments();
		/** type map mc*/

		Boolean working = (Boolean) args[0];
		if(working == true){
			choice = (String) args[1];
			map = (LinkedHashMap) args[2];
			who = (int) args[3];
			answer= (TextField) args[4];
			grid = (GridPane) args[5];
			image = (ImageView) args[6];
			list = (ListView) args[7];
			imageExist = (ImageView) args[8];
			mc = (ContainerController) args[9];

			System.out.println("I am the "+ this.getAID().getLocalName() +" Agent, I am looking for your vendor...");

			addBehaviour(new CentralBehaviour(answer,grid,image,list, imageExist));


			/**Home to central*/
			if(who == 0){
				Object[] obj = new Object[]{true,map, choice};
				AgentController ag1;
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				message.addReceiver(new AID(choice, AID.ISLOCALNAME));
				message.setContent(String.valueOf(true));
				send(message);

			}
			/*switch(choice){
				case 2:{
					if(who.equals("from domain")) Path = "src/Files/vehiculeRules.txt";
					else Path = "src/Files/VehiculeProducts.txt";
					map = (Map<String, Object>) args[1];
					Object[] obj = new Object[]{mc, map, Path, who};
					AgentController ag1;
					try {
						ag1 = mc.createNewAgent("vendor2", "Agents.Vendor1",obj);
						ag1.start();
					} catch (StaleProxyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}*/

		}else{
			System.out.println(this.getAID().getLocalName() +" is lunched");
		}




	}


}
