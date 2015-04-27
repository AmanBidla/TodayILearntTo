public class CountAndSay{


	public static void main(String[] args) {
		
		System.out.println( countAndSay(5));

	}

	public static  String countAndSay(int N){

		int i=1;
		String result="1";

		while(i<N){

			int count=1;
			StringBuilder buf = new StringBuilder();

			for(int j=1;j<result.length();j++){

				if(result.charAt(j)== result.charAt(j-1)){
					count++;
				}else{
					buf.append(count);
					buf.append(result.charAt(j-1));
					count=1;
				}
			}

			buf.append(count);
			buf.append(result.charAt(result.length()-1));
			result = buf.toString();
			i++;
		}

		return result;

	}

}