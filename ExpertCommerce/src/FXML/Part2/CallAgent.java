package FXML.Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import javafx.collections.FXCollections;

public class CallAgent {
	public CallAgent(Object[] obj1,ContainerController mc) throws StaleProxyException{
		Runtime rt=Runtime.instance();
		ProfileImpl p= new ProfileImpl("localhost",1099,"RSHP");
		ContainerController mc1= rt.createMainContainer(p);
		int size = obj1.length;


		Object[] obj = new Object[size+1];
		for(int i=0;i<obj1.length;i++){
			obj[i] = obj1[i];
		}
		obj[size] = mc1;


		List<AgentController> vendors = new ArrayList<>();

		try {
	      File myObj = new File("src/File/vendors.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        Object[] obj2 = new Object[]{false, obj1[2], data};
	        AgentController ag= mc1.createNewAgent(data, "FXML.Part2.Vendor",obj2);
	        ag.start();
	        vendors.add(ag);
	        //category.getItems().add(data);
	      }
	      myReader.close();

	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }


		AgentController ag1= mc1.createNewAgent("Central", "FXML.Part2.Central",obj);
		ag1.start();






	}
}
