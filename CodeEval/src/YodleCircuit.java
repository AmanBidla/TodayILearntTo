import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

public class YodleCircuit {

	String name;
	YodleSkill skill;
	List<YodleJuggler> selectedJugglers= new ArrayList<>();
	List<YodleJuggler> notSelectedJugglers = new ArrayList<>();
	 
	int largestScore=Integer.MIN_VALUE;
	int smallestScore = Integer.MAX_VALUE;
 

	public YodleCircuit (String name,YodleSkill skill){
		this.name=name;
		this.skill=skill;
	}

	@Override
	public String toString(){
		String string = "name: "+name+" "+skill.toString();
		return string;
	}

	public void addJugglerToCircuit(YodleJuggler juggler,int maxJugglerPermitted){
		int score = calculateScore(juggler);
		if(selectedJugglers.size()>=maxJugglerPermitted){
			//System.out.println("kicking someone from "+this.name+" to add "+juggler.name);			 
			 removeJugglerWithLeastScore(juggler,score);
		}else{
			//System.out.println("adding juggler "+juggler.name+" to "+this.name);
			selectedJugglers.add(juggler);			
			if(score<smallestScore) smallestScore= score;
			if(score>largestScore) largestScore = score;
		}
	}

	private void removeJugglerWithLeastScore(YodleJuggler newJuggler,int newScore){
 		YodleJuggler toBeAdded = newJuggler;
 		boolean addedComplete = false;
 		 for(int i=0;i<selectedJugglers.size();i++){
 		 	YodleJuggler currentJuggler = selectedJugglers.get(i);
 		 	int currentJugglerScore = calculateScore(currentJuggler);
 		 	if(newScore>currentJugglerScore) {
 		 		toBeAdded = selectedJugglers.remove(i); 		 		  		 		
 		 		selectedJugglers.add(newJuggler);
 		 		notSelectedJugglers.add(toBeAdded);
 		 		addedComplete=true;
 		 		//System.out.print("kicked "+toBeAdded.name+" ");
 		 		break;
 		 	}
 		 }
 		 if(!addedComplete){
 		 	notSelectedJugglers.add(newJuggler);
 		 }
 		 //System.out.println("Adding  "+newJuggler.name+" to "+this.name);
 		 
	}

	private int calculateScore(YodleJuggler juggler){
		return juggler.skill.dotProduct(this.skill);
	}

	public boolean kickOutJugglerWithSmallerScore(YodleJuggler newJuggler,int newScore){
		for(int i=0;i<selectedJugglers.size();i++){
			YodleJuggler selectedJuggler = selectedJugglers.get(i);
			int currScore = selectedJuggler.skill.dotProduct(this.skill);
			if(newScore>currScore){
				selectedJugglers.remove(i);
				selectedJugglers.add(newJuggler);
				notSelectedJugglers.add(selectedJuggler);
				return true;
			}
		}
		return false;
	}

}
