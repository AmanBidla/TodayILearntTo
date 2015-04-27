import java.util.List;
import java.util.ArrayList; 
public class RemoveLeadingAndTrailing{

	final static char SPACE =' ';

	public static void main(String[] args) {
		

		//String S ="   hello   world   ";
		//String S ="      ";
		//String S ="      S";
		//String S ="S      ";
		String S ="  S D C    AB";
		String updatedS= remove(S);
		System.out.println(updatedS+" has length "+updatedS.length());

	}
	public  static String remove(String S){

		char[] array = S.toCharArray();
		StringBuffer buf = new StringBuffer();
		int N = array.length;
		int lastSpace=-1,lastChar=-1;

		if(array[0]!=SPACE) {
			buf.append(array[0]);
			lastChar=0;
		}

	
		for(int i=1;i<N;i++){

			char prev = array[i-1];
			char curr = array[i];

			if(prev==SPACE && curr!=SPACE){
				buf.append(curr);
				lastChar=i;
			}

			if(prev!=SPACE && curr!=SPACE){
				buf.append(curr);
				lastChar=i;
			}

			else if( prev!=SPACE && curr==SPACE){
				buf.append(SPACE);
				lastSpace=i;
			}

		}

		int BN = buf.length();
		if(lastSpace==(lastChar+1)) return buf.toString().substring(0,BN-1);
		return buf.toString();
		
	}

}