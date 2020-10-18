package FXML.Part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import expertSystem.Clause;
import expertSystem.Condition;
import expertSystem.Rule;
import expertSystem.RuleBase;
import expertSystem.RuleVariable;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class Vendor extends Agent {
	private LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
	private String who = "";
	private static RuleBase vehicles ;
	private Condition cEquals = new Condition("=") ;
	private Condition cLessOrEqual = new Condition(">=") ;
	private ArrayList<RuleVariable> variables;
	private ArrayList<String> str = new ArrayList<>();
	@Override
	protected void setup(){
		Object[] args = getArguments();
		/** type map mc*/


		System.out.println(this.getAID().getLocalName() +" is lunched");
		ACLMessage msg2 = null;
	    msg2 = blockingReceive();
	    if(msg2.getContent().equals("true")){
	    	String agentName = this.getAID().getLocalName();
			System.out.println(this.getAID().getLocalName() +" is selected By Central Agent");
			map = (LinkedHashMap<String,String>) args[1];
			who = (String) args[2];
			vehicles = new RuleBase(who);
			vehicles.goalClauseStack = new Stack() ;
			vehicles.variableList = new Hashtable() ;
			BufferedReader csvReader;
			try {
				csvReader = new BufferedReader(new FileReader("src/File/"+who+".csv"));
				String row;
				boolean indexfinal = false;
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    for(int i=0;i<data.length;i++){
				    	String splited = data[i].split("/")[0];
				    	str.add(splited);
				    	RuleVariable rule = new RuleVariable(splited) ;
				    	vehicles.variableList.put(rule.name,rule);

				    }
				}
				csvReader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (Map.Entry<String, String> entry : map.entrySet()) {
		    	RuleVariable rvar =
						(RuleVariable)vehicles.variableList.get(entry.getKey());
		    	if(entry.getValue()!= null){
		    		rvar.setValue(entry.getValue());
		    	}

			}

			variables = vehicles.fetchVariables();

			createRules();
			vehicles.displayRules();
			for(RuleVariable s: vehicles.fetchVariables()){
				s.updateClauses();
			}
			ArrayList<Rule> fired = vehicles.forwardChain() ;
			ArrayList<String> result  = new ArrayList<String>();
			for(Rule r: fired){
				result.add(r.name);
			}
			String msg = "yes";
			Answer answer = new Answer(result,map,who);
			ACLMessage acl = new ACLMessage(ACLMessage.INFORM);
			acl.addReceiver(new AID("Central",AID.ISLOCALNAME));
			try {
				acl.setContentObject(answer);
				this.send(acl);
				System.out.println("I am the "+agentName+" Agent, I am sending an answer to the central agent.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }


		/*Boolean working = (Boolean) args[0];
		if(working == true){


		}else{

		}*/




	}

	private void createRules(){
		vehicles.ruleList = new Vector() ;
		ArrayList<Integer> indexes = new ArrayList<>();
		ArrayList<Integer> indexesVar = new ArrayList<>();
		RuleVariable vehicule = new RuleVariable("vehicule");
	    vehicles.variableList.put(vehicule.name,vehicule);
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("src/File/"+who+".csv"));
			String row;
			try {
				Clause cfinal = null;

				boolean indexfinal = false;
				if ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    RuleVariable rvar = (RuleVariable)vehicles.variableList.get("price");
				    if(rvar.value!=null){
			    		indexfinal = true;
			    		variables.remove(rvar);
			    	}
				    for(int i=0;i<data.length;i++){
				    	String splited = data[i].split("/")[0];
				    	if(splited.equals("price")) continue;
				    	rvar = (RuleVariable)vehicles.variableList.get(splited);
				    	if(variables.get(variables.indexOf(rvar)).value != null){
				    		indexes.add(i);
				    		indexesVar.add(variables.indexOf(rvar));
				    	}
				    }
				}


				while ((row = csvReader.readLine()) != null) {
					ArrayList<Clause> listClause = new ArrayList<Clause>();
				    String[] data = row.split(",");
				    cfinal = new Clause(vehicule,this.cEquals,data[0]);
				    for(int i=0;i<indexes.size();i++){
						   listClause.add(new Clause((RuleVariable)vehicles.variableList.get(variables.get(indexesVar.get(i)).name),this.cEquals,data[indexes.get(i)]));
				    }
				    if(indexfinal == true){
				    	listClause.add(new Clause((RuleVariable)vehicles.variableList.get(str.get(data.length-1)),this.cLessOrEqual,data[data.length-1]));

				    }

				    Rule rule = new Rule(vehicles, data[0],listClause,cfinal);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
