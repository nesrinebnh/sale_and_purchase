	// Environment code for project store
import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import java.util.logging.*;

public class StoreEnv extends Environment {


    public static final Term    bg = Literal.parseLiteral("burn(garb)");
	
	
    private Logger logger = Logger.getLogger("store."+StoreEnv.class.getName());

    StoreModel model;
    MainFrame view;
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {  
    	addPercept("central",Literal.parseLiteral("hi1"));
    	model = new StoreModel();
    	view  = new MainFrame(model);
    	model.setView(view);
    	/* */
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info(agName +" doing: "+ action);
        try {
            //if (action.equals(bg)) {
            if (action.getFunctor().equals("burn")) {
                model.burnGarb();
                addPercept(Literal.parseLiteral("term_" +  String.valueOf(action.getTerm(0))));
                return true;
            } else if (action.getFunctor().equals("printR")) {
                model.print(String.valueOf(action.getTerm(0)) + String.valueOf(action.getTerm(1)));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
       /*
      if (action.getFunctor().equals("burn")) {
        addPercept(Literal.parseLiteral("fire"));
        return true;
      } else {
        logger.info("executing: "+action+", but not implemented!");
        return false;
      }*/
    }
    
    public void addprct(String ag, Literal l) {
    	addPercept(ag, l);
    }
    
    /** Called before the end of MAS execution */
    @Override
    public void stop() {
      super.stop();
    }
    
    public class StoreModel extends GridWorldModel {
    	MainFrame view;
    	public void setView(MainFrame v) {
    		super.setView(v);
    		view = v;
    	}
    	protected StoreModel() {
    		super(0, 0, 0);
    	}
    	void print(String s) {
    		view.print("[System] " + s);
    	}
        void burnGarb() {
        	addPercept("central",Literal.parseLiteral("fireeeeee!!!!"));
        }
        void send_phone(String pram) {
        	addPercept("central",Literal.parseLiteral("find_phone("+pram+")"));
        }
        void reset_phone(String pram) {
        	removePercept("central",Literal.parseLiteral("find_phone("+pram+")"));
        }
        void send_car(String pram) {
        	addPercept("central",Literal.parseLiteral("find_car("+pram+")"));
        }
        void reset_car(String pram) {
        	removePercept("central",Literal.parseLiteral("find_car("+pram+")"));
        }
        void send_bus(String pram) {
        	addPercept("central",Literal.parseLiteral("find_bus("+pram+")"));
        }
        void reset_bus(String pram) {
        	removePercept("central",Literal.parseLiteral("find_bus("+pram+")"));
        }
        void send_mc(String pram) {
        	addPercept("central",Literal.parseLiteral("find_mc("+pram+")"));
        }
        void reset_mc(String pram) {
        	removePercept("central",Literal.parseLiteral("find_mc("+pram+")"));
        }
        void send_travel(String pram) {
        	addPercept("central",Literal.parseLiteral("find_travel("+pram+")"));
        }
        void reset_travel(String pram) {
        	removePercept("central",Literal.parseLiteral("find_travel("+pram+")"));
        }
        void send_truck(String pram) {
        	addPercept("central",Literal.parseLiteral("find_truck("+pram+")"));
        }
        void reset_truck(String pram) {
        	removePercept("central",Literal.parseLiteral("find_truck("+pram+")"));
        }
    }
  }