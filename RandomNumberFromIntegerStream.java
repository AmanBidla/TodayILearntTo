import java.util.Random;

public class RandomNumberFromIntegerStream{


	static int count=0;
	static int result=0;

	public static int select(int x){

		count++;
		if(count==1){
			result=x;
		}else{

			int max=count-1;
			int min=1;
			Random random = new Random();
			int r = random.nextInt((max-min)+1)+1;
			if(r==(count-1)){
				result=x;
			}
		}
		return result;		
	}

	public static void main(String[] args) {
		
		int [] array={1,2,3,4};
		for(int i=0;i<array.length;i++){
			System.out.println(i+"th random "+ select(array[i]));	
		}		
	}
}