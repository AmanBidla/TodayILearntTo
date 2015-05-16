public class CountOccurancesOfCharacters{


	public static void find(String S){

		if(S==null || S.length()<1) return;

		S=S.toLowerCase();
		int N = S.length();
		int [] count = new int [256];
		for(int i=0;i<N;i++){
			count[((int) S.charAt(i))]++;
		}

		for(int i=0;i<256;i++){

			if(count[i]!=0){
				System.out.println(" char "+((char)i)+" -- "+count[i]);
			}
		}

	}

	public static void main(String[] args) {
		
		String S="Sreeprasad";
		find(S);
	}
}