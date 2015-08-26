public class YodleSkill {

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