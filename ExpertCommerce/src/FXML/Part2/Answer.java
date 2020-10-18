package FXML.Part2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import expertSystem.Rule;

public class Answer implements Serializable {
	ArrayList<String> fired;
	LinkedHashMap<String,String> map;
	String who;

	public Answer(ArrayList<String> fired, LinkedHashMap<String,String>map, String who){
		this.fired = fired;
		this.map = map;
		this.who = who;
	}

}
