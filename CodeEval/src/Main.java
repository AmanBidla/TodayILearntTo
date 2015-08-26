import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;


public class Main{

	private static String INPUT_FILE ="YodleInput.txt";
	private static final String SPACE=" ";
	private static final String COLON=":";
	private static final String COMMA=",";

	private static final int NAME_POSITION=1;
	private static final int COORDINATION_POSITION=2;
	private static final int ENDURANCE_POSITION=3;
	private static final int PIZZAZZ_POSITION=4;
	private static final int PREF_CICUITS_POSITION=5;

	private static final List<YodleCircuit> yodleCircuits = new ArrayList<YodleCircuit>();
	private static final List<YodleJuggler> yodleJugglers = new ArrayList<YodleJuggler>();;
	private static final Map<String,YodleCircuit> circuitNameToCircuit = new HashMap<String,YodleCircuit>();;
	private static int numberOfJugglersPerCircuit;

	 
	private static void enrichCircuitsAndJuggler(String file){
		try{

			BufferedReader buf = new BufferedReader(new FileReader(new File(file)));
			String line = null;

			while((line= buf.readLine())!=null){
				if(line.length()==0) break;
				YodleCircuit yodleCircuit = enrichCircuit(line);				
				yodleCircuits.add(yodleCircuit);
			}

			while((line= buf.readLine())!=null){
				YodleJuggler yodleJuggler = enrichJuggler(line);				
				yodleJugglers.add(yodleJuggler);
			}	

		}catch(IOException e){
			System.out.println("IO Exception "+e);
		}		
	}

	private static YodleJuggler enrichJuggler(String line){
		String [] array = line.split(SPACE);
		YodleJuggler yodleJuggler = new YodleJuggler(enrichName(array),enrichSkill(array),prefferedCircuits(array[PREF_CICUITS_POSITION]));
		return yodleJuggler;
	}

	private static List<YodleCircuit> prefferedCircuits(String line){
		//J J0 H:3 E:9 P:2 C2,C0,C1
		List<YodleCircuit> prefferedCircuit = new ArrayList<YodleCircuit>();
		String [] array = line.split(COMMA);
		for(String name:array){
			prefferedCircuit.add(circuitNameToCircuit.get(name));
		}
		return prefferedCircuit; 
	}

	private static YodleCircuit enrichCircuit(String line){
		String [] array = line.split(SPACE);
		YodleCircuit yodleCircuit = new YodleCircuit(enrichName(array),enrichSkill(array));
		circuitNameToCircuit.put(yodleCircuit.name,yodleCircuit);
		return yodleCircuit;
	}

	private static String enrichName(String[] array){
		return array[NAME_POSITION];
	}

	private static YodleSkill enrichSkill(String[] array){
		int h = Integer.parseInt(array[COORDINATION_POSITION].split(COLON)[1]);
		int e = Integer.parseInt(array[ENDURANCE_POSITION].split(COLON)[1]);
		int p = Integer.parseInt(array[PIZZAZZ_POSITION].split(COLON)[1]);
		YodleSkill skill = new YodleSkill(h,e,p);
		return skill;
	}

	public static void main(String[] args) {
		
		INPUT_FILE = args[0];
		enrichCircuitsAndJuggler(INPUT_FILE);
		
		//printCircuits();
		//printJugglers();
		assignJugglersToHisPrefferedCircuit();
		//showSizeOfEachCircuit();
		//jugglerNotMatched(); 
		//showAll();
		//System.out.println("----------");
		tryToFix();
		//showAll();
		show();
	}

	private static void show(){
	
		 System.out.println(yodleCircuits.get(1970).name);

	}


	private static void showSizeOfEachCircuit(){
		System.out.println("numberOfJugglersPerCircuit "+numberOfJugglersPerCircuit);
		for(YodleCircuit yodleCircuit:yodleCircuits){
			System.out.println(yodleCircuit.selectedJugglers.size());
		}
	}

	private static void showAllScoresForCircits(){

		for(int i=0;i<yodleCircuits.size();i++){
			YodleCircuit eachYodleCircuit = yodleCircuits.get(i);
			System.out.print(eachYodleCircuit.name+" "); 
			List<YodleJuggler> yodleJugglers = eachYodleCircuit.selectedJugglers;			
			Collections.sort(yodleJugglers);
			eachYodleCircuit.selectedJugglers=null;
			eachYodleCircuit.selectedJugglers=yodleJugglers;
			 
			for(YodleJuggler yodleJuggler:yodleJugglers){
				System.out.print(yodleJuggler.name+" "); 
				List<YodleCircuit> prefferedCircuits = yodleJuggler.jugglerPreferredCircuit;
				for(YodleCircuit yodleCircuit:yodleCircuits){
					System.out.print(yodleCircuit.name+" ");
					System.out.print(yodleJuggler.skill.dotProduct(yodleCircuit.skill)+" ");			 
				}
			}
			System.out.print(" | ");
			for(YodleJuggler yodleJuggler:eachYodleCircuit.notSelectedJugglers){
				System.out.print(yodleJuggler.name+" "); 
				List<YodleCircuit> prefferedCircuits = yodleJuggler.jugglerPreferredCircuit;
				/*for(YodleCircuit yodleCircuit:yodleCircuits){
					System.out.print(yodleCircuit.name+" ");
					System.out.print(yodleJuggler.skill.dotProduct(yodleCircuit.skill)+" ");
				}*/
			}
			System.out.println(""); 
		}
	}

	 

	private static void showAll(){
		 
		for(int i=0;i<yodleCircuits.size();i++){
			YodleCircuit eachYodleCircuit = yodleCircuits.get(i);
			System.out.print(eachYodleCircuit.name+" "); 
			List<YodleJuggler> yodleJugglers = eachYodleCircuit.selectedJugglers;			
			Collections.sort(yodleJugglers);
			eachYodleCircuit.selectedJugglers=null;
			eachYodleCircuit.selectedJugglers=yodleJugglers;
			 
			for(YodleJuggler yodleJuggler:yodleJugglers){
				System.out.print(yodleJuggler.name+" "); 
				List<YodleCircuit> prefferedCircuits = yodleJuggler.jugglerPreferredCircuit;
				for(YodleCircuit yodleCircuit:yodleCircuits){
					System.out.print(yodleCircuit.name+" ");
					System.out.print(yodleJuggler.skill.dotProduct(yodleCircuit.skill)+" ");			 
				}
			}
			System.out.print(" | ");
			for(YodleJuggler yodleJuggler:eachYodleCircuit.notSelectedJugglers){
				System.out.print(yodleJuggler.name+" "); 
				List<YodleCircuit> prefferedCircuits = yodleJuggler.jugglerPreferredCircuit;
				/*for(YodleCircuit yodleCircuit:yodleCircuits){
					System.out.print(yodleCircuit.name+" ");
					System.out.print(yodleJuggler.skill.dotProduct(yodleCircuit.skill)+" ");
				}*/
			}
			System.out.println(""); 
		}
		 

	}


	private static void assignJugglersToHisPrefferedCircuit(){
		numberOfJugglersPerCircuit = yodleJugglers.size()/yodleCircuits.size();
 		for(int i=0;i<yodleJugglers.size();i++){
 			YodleJuggler yodleJuggler = yodleJugglers.get(i);
 			List<YodleCircuit> jugglerPrefferedCircuits = yodleJuggler.jugglerPreferredCircuit;
 			for(YodleCircuit yodleCircuit:jugglerPrefferedCircuits){
 				yodleCircuit.addJugglerToCircuit(yodleJuggler,numberOfJugglersPerCircuit);
 				break;
 			}
 		}
	}

	private static void tryToFix(){
		for(int i=0;i<yodleCircuits.size();i++){
			YodleCircuit yodleCircuit = yodleCircuits.get(i);
			List<YodleJuggler> notSelectedJugglers = yodleCircuit.notSelectedJugglers;
			List<YodleJuggler> selectedJugglers = yodleCircuit.selectedJugglers;
			/*
			for(int j=0;j<selectedJugglers.size();){
				YodleJuggler selectedJuggler = selectedJugglers.get(j);
				boolean toBeAdded = matchToCircuit(selectedJuggler,i,yodleCircuit.name);
				if(!toBeAdded) {
					if(findAnyCircuitWithFreeSpaceAndAdd(selectedJuggler)){
						notSelectedJugglers.remove(j);
					}else{
						j++;
					}
				}else{
					 if(notSelectedJugglers.size()!=0) notSelectedJugglers.remove(j);
				}
				 
			}
			*/


			for(int j=0;j<notSelectedJugglers.size();){
				YodleJuggler notSelectedJuggler = notSelectedJugglers.get(j);
				boolean toBeAdded = matchToCircuit(notSelectedJuggler,i,yodleCircuit.name);
				if(!toBeAdded) {
					//System.out.println("finding free space for "+notSelectedJuggler.name);
					if(findAnyCircuitWithFreeSpaceAndAdd(notSelectedJuggler)){
						//System.out.println("removing "+notSelectedJuggler.name);
						notSelectedJugglers.remove(j);
					}else{
						j++;
					}
				}else{
					notSelectedJugglers.remove(j);
				}
			}
		}
	}
 
	private static boolean matchToCircuit(YodleJuggler newJuggler, int nextCircuitNumber,String currCircuitName){

		List<YodleCircuit> prefferedCircuit = newJuggler.jugglerPreferredCircuit;
		boolean toBeAdded = false;	
		for(int i=0;i<prefferedCircuit.size();i++){
			YodleCircuit yodleCircuit = prefferedCircuit.get(i);
			//System.out.println(newJuggler.name+"'s next prefferedCircuit "+ yodleCircuit.name);
			//if(currCircuitName.equals(yodleCircuit.name)) continue;

			//System.out.println("selected juggler "+yodleCircuit.selectedJugglers.size()+" numberOfJugglersPerCircuit "+numberOfJugglersPerCircuit);
			if(yodleCircuit.selectedJugglers.size()<numberOfJugglersPerCircuit){
				//System.out.println("adding "+newJuggler.name+" to "+yodleCircuit.name);
				yodleCircuit.selectedJugglers.add(newJuggler);
				//System.out.println("added in free space");
				toBeAdded= true;
				break;
				 
			}else{
					int newScore = newJuggler.skill.dotProduct(yodleCircuit.skill);
					//showAllSelectedScore(yodleCircuit);
					//System.out.println("newScore "+newScore+" smallest score "+yodleCircuit.smallestScore);
					if(yodleCircuit.kickOutJugglerWithSmallerScore(newJuggler,newScore)){						
						//System.out.println("kicked out someone");
						toBeAdded= true;
						break;
					}
				}
		}
		return toBeAdded;

		
		 
	}

	private static void showAllSelectedScore(YodleCircuit circuit){
		int [] array = new int [circuit.selectedJugglers.size()];
		List<YodleJuggler> selectedJugglers = circuit.selectedJugglers;
		for(int i=0;i<selectedJugglers.size();i++){
			YodleJuggler juggler = selectedJugglers.get(i);
			array[i]=juggler.skill.dotProduct(circuit.skill);
		}
		System.out.println(Arrays.toString(array));
	}

	private static boolean findAnyCircuitWithFreeSpaceAndAdd(YodleJuggler newJuggler){
		for(int i=0;i<yodleCircuits.size();i++){
			YodleCircuit yodleCircuit = yodleCircuits.get(i);
			System.out.println(" curr circuit size "+yodleCircuit.selectedJugglers.size()+" J/C "+numberOfJugglersPerCircuit);
			if(yodleCircuit.selectedJugglers.size()<numberOfJugglersPerCircuit){
				yodleCircuit.selectedJugglers.add(newJuggler);
				System.out.println("adding "+newJuggler.name+" to "+yodleCircuit.name);
				return true;
			}
		}
		System.out.println("sorry could not find space ");
		return false;
	}

	private static void jugglerNotMatched(){
		for(int i=0;i<yodleCircuits.size();i++){
			YodleCircuit yodleCircuit = yodleCircuits.get(i);
			List<YodleJuggler> selectedJugglers = yodleCircuit.selectedJugglers;
			for(YodleJuggler yodleJuggler:selectedJugglers){
				System.out.println("selected score "+yodleJuggler.skill.dotProduct(yodleCircuit.skill));
			}
			System.out.println("least score that was added "+yodleCircuit.smallestScore);
			List<YodleJuggler> notSelectedJugglers = yodleCircuit.notSelectedJugglers;
			for(YodleJuggler yodleJuggler:notSelectedJugglers){
				System.out.println("not selected score "+yodleJuggler.skill.dotProduct(yodleCircuit.skill));
			}
		}
	}

	private static void printCircuits(){
		System.out.println("\nCircuits: \n");
		for(YodleCircuit yodleCircuit:yodleCircuits){
			System.out.println(yodleCircuit);
		}
	}
	private static void printJugglers(){
		System.out.println("\nJugglers: \n");
		for(YodleJuggler yodleJuggler:yodleJugglers){
			System.out.println(yodleJuggler);
		}
	}
}

/// Yodle circuit //////

class YodleCircuit {

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

////////////////////////

///// yodle juggler /////

class YodleJuggler implements Comparable<YodleJuggler> {

	String name;
	YodleSkill skill;
	List<YodleCircuit> jugglerPreferredCircuit;
	int score;
	
	private static final String COMMA =",";

	public YodleJuggler(String name,YodleSkill skill,List<YodleCircuit> jugglerPreferredCircuit){
		this.name=name;
		this.skill=skill;
		this.jugglerPreferredCircuit=jugglerPreferredCircuit;
	}

	@Override
	public String toString(){
		String prefferedCircuitName = getPrefferedCircuitNames();
		String string = "name: "+name+" "+skill.toString()+" prefferedCircuitName "+ prefferedCircuitName;
		return string;
	}

	private String getPrefferedCircuitNames(){
		StringBuilder buf = new StringBuilder();
		for(YodleCircuit yodleCircuit:jugglerPreferredCircuit){
			buf.append(yodleCircuit.name);
			buf.append(COMMA);
		}
		return buf.toString();
	}

	@Override
	public int compareTo(YodleJuggler other){
		if(this.score<other.score) return -1;
		else if(this.score>other.score) return 1;
		else return 0;
	}
}

///////////////////////

////// yodle skill //////

class YodleSkill {

	int coordination;
	int endurance;
	int pizzazz;

	public YodleSkill(int coordination,int endurance,int pizzazz){
		this.coordination=coordination;
		this.endurance=endurance;
		this.pizzazz=pizzazz;
	}

	@Override
	public String toString(){
		String string = "coordination: "+coordination+" endurance: "+endurance+" pizzazz: "+pizzazz;
		return string;
	}

	public int dotProduct(YodleSkill thatYodleSkill){
		int sum =coordination * thatYodleSkill.coordination +
				 endurance * thatYodleSkill.endurance +
				 pizzazz * thatYodleSkill.pizzazz;
		return sum;
	}

}


////////////////////////