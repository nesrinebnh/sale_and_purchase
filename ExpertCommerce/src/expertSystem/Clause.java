package expertSystem;

/*  Clause class

   Constructing Intelligent Agents with Java
   (C) Joseph P.Bigus and Jennifer Bigus 1997


*/

import java.util.*;
//import java.io.*;


public class Clause {
	Vector ruleRefs ;
	public RuleVariable lhs ;
	public String rhs ;
	Condition cond ;
	Boolean consequent ; // true or false
	Boolean truth;      // states = null(unknown), true or false

	public Clause(RuleVariable Lhs, Condition Cond, String Rhs)
	{

		lhs = Lhs ;	cond = Cond ; rhs = Rhs ;
		lhs.addClauseRef(this) ;
		ruleRefs = new Vector() ;
		truth = null ;
		consequent = new Boolean(false) ;
	}
	void addRuleRef(Rule ref) { ruleRefs.addElement(ref) ; }
	Boolean check() {
		if (consequent.booleanValue() == true){
			return null ;
		}
		if (lhs.value == null) {
			return truth = null ;    // Var value is undefined
		} else {
			switch(cond.index) {
				case 1: truth = new Boolean(lhs.value.equals(rhs)) ;
				break ;
				case 2:{
					truth = new Boolean(lhs.value.compareTo(rhs) > 0) ;
					break ;
				}

				case 3:{
					truth = new Boolean(lhs.value.compareTo(rhs) < 0) ;
					break ;
				}

				case 4: truth = new Boolean(lhs.value.compareTo(rhs) != 0) ;
				break ;
				case 5: {
					truth = new Boolean(lhs.value.compareTo(rhs) <= 0) ;
					break ;
				}

				case 6:{
					Double val1 = Double.valueOf(lhs.value);
					Double val2 = Double.valueOf(rhs);
					Double result = val1-val2;
					truth = new Boolean(result >= 0) ;
					break ;
				}
			}
			return truth ;
		}
	}
	void isConsequent() { consequent = new Boolean(true); }
	Rule getRule() { if (consequent.booleanValue() == true)
		return (Rule)ruleRefs.firstElement() ;
	else return null ;}
}