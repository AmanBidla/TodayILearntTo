public class Manacher{
	
	private int [] p;
	private char [] t;
	private String word;

	public Manacher(String word){

		if((word==null) || (word.length()==0)) return ;
		this.word= word;
		t = process(word);
		p = new int[t.length];

		int center=0,right=0;
		for(int i=1;i<t.length-1;i++){

			int mirror = 2*center-i;

			if(right>i){
				p[i]= Math.min((right-i), p[mirror]);
			}

			while(t[i+(1+p[i])] == t[i-(1+p[i])] ){
				p[i]++;
			}

             if (i + p[i] > right) {
				center=i;
				right= p[i]+i;
			}
		}
	}

	public  String findPalindrome(){
		int len=0,center=0;
		for(int i=1;i<p.length-1;i++){
			if(p[i]>len){
				len=p[i];
				center=i;
			}
		}
		return word.substring(((center-1-len)/2),((center-1+len)/2)) ;
	}

	public static void main(String[] args) {
		
		//String word = "abaaba";
		//String word = "babcbabcbaccba";
		String word = "abaxabaxabb";
		Manacher m = new Manacher(word);
 		System.out.println(m.findPalindrome());

		  
	}


	private  char [] process(String word){
		int N = word.length();
		char [] t = new char[(2*N)+3];
		t[0]='$';
		t[(2*N)+2]='@';
		for(int i=0;i<N;i++){
			t[(2*i)+1]='#';
			t[(2*i)+2]=word.charAt(i);
		}

		t[(2*N)+1]='#';
		return t;
	}



}