public class FindRepeatedElementsWith4KBOfMemory {

	public static void main(String[] args) {
		
		int [] array = {2,3,3,4,5,6,6,6,7};
		findDuplicates(array);
	}

	public static void findDuplicates(int [] array){

		Bitset bitset = new Bitset(320000);
		for(int i: array){

			if(bitset.isSet(i-1)){
				System.out.println(i);
			}else{
				bitset.set(i-1);
			}
		}
	}


}

class Bitset{

	int [] array;
	public Bitset(int cap){
		array = new int[(cap>>5)+1];
	}

	public boolean isSet(int pos){

		int wordNumber = pos>>5;
		int mask = (pos & 0X1F);

		return (array[wordNumber] & 1<<mask) != 0;
	}

	public void set(int pos){

		int wordNumber = pos>>5;
		int mask = pos & 0X1F;
		array[wordNumber]|= 1 <<mask;
	}
}