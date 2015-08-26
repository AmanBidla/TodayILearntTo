import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class YodleJuggler implements Comparable<YodleJuggler> {

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