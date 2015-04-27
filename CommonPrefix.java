public class CommonPrefix{

	public static void main(String[] args) {
		
		String [] array={"abcd","abcdef","abcdefgh","abcdefghijk"};
		System.out.println( commonPrefix(array));	
	}

	public static String commonPrefix(String [] array){


		int N = array.length;
		int minLength = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			minLength = Math.min(minLength, array[i].length());
		}

		int i=0;
		while(i<minLength){

			char prev='0';
			for(int j=0;j<N;j++){
				String s = array[j];
				if(j==0){
					prev= s.charAt(i);
					continue;
				}

				if(s.charAt(i)!=prev){
					return s.substring(0,i);
				}
			}

			i++;
		}

		return array[0].substring(0,minLength);
	}

}