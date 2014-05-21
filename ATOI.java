public class ATOI{


	public static int findMaxSum(){
		int []a ={1,2,3,4,5};
        int sum0=0; //will hold the sum till i-2        
        int sum1=0;//will hold the sum till i-1
        for(int k : a){
            int x=Math.max(sum0+k, sum1);//max(sum till (i-2)+a[i], sum till (i-1))
            sum0=sum1;
            sum1=x;
        }
        System.out.println(sum1);
        return sum1;
    }

	private static int convertToInt(String s, int radix) throws NumberFormatException{

		if(isStringNull(s)){
			throw new NumberFormatException("null is not a number");
		}

		if(isRadixInRange(radix)){
			throw new NumberFormatException("radix "+radix+" out of range");	
		}

		int N = s.length();

		if(N==0){
			throw new NumberFormatException(s+" has 0 length");	
		}

		if(N==1 && s.charAt(0)=='-'){
			throw new NumberFormatException(s+"no leading digit after -ive sign");		
		}

		boolean isNegative = isNegative(s);

		int limit = (isNegative)?Integer.MIN_VALUE:Integer.MAX_VALUE;

		int i = (isNegative)?1:0;

		int digit, multLimit = limit/radix,result=0;

		while(i<N){


			digit = Character.digit(s.charAt(i),radix);

			if(digit<0) 
				throw new NumberFormatException(" invalid string "+s);

			result *=radix;

			if(result<(limit+digit))
				throw new NumberFormatException("Out of range of Int "+s);

			result -= digit;
			i++;

		}

		
		return (isNegative)?result:(-1*result);

	}

	private static boolean isStringNull(String s){
		return s==null;
	}

	private static boolean isRadixInRange(int radix){


		return ((radix>Character.MAX_RADIX) || (radix<Character.MIN_RADIX)) ;
		
	}

	private static boolean isNegative(String s){

		return s.charAt(0)=='-';
	}

	public static void main(String[] args) {
		
		String s ="-123";
		int radix =10;
		
		assert(convertToInt(s,radix)==(-123));
		s ="-123.23";
		assert(convertToInt(s,radix)==(-123.23));

		findMaxSum();

	}
	


}