public class SortASCIICharacterArray {

	public static void sort(char[] array){

		int [] map = new int[256];
		for(int i=0;i<array.length;i++){
			map[ (int) array[i]]++;
		}

		int j=0;
		for(int i=0;i<256;i++){

			if(map[i] !=0){
				System.out.println("found char "+((char)i));
				while(map[i]>0){
					array[j]=(char)i;
					j++; map[i]--;
				}
			}
		}

		System.out.println(new String(array));
	}

	public static void main(String[] args) {
		
		String S ="sreeprasad";
		sort(S.toCharArray());
	}
}