import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Symbols {
	
	private static int count=0;
	public static void main(String[] args) {
		String fileName = args[0];
		Symbols s = new Symbols();
		s.readInput(fileName,s);
		//String answer ="011";
		//s.printStrings(answer.length()-1,answer);
		//System.out.println("count is "+count);
		
	}

	private void readInput(String fileName,Symbols s){
		try{

			Scanner sc = new Scanner(new File(fileName));
	
		while(sc.hasNext()){
			String word = sc.nextLine();
			if(word.length()==1){
				int n = new Integer(word);
				if((n%2==0) || (n%5==0) || (n%7==0) || (n%3==0)) count++;
				System.out.println(count);
			}else{
				s.printStrings(word.length()-1,word);
				System.out.println(count);
			}
			count=0;	
		}

		}catch(IOException e){
			System.out.println(e.toString());
		}
		
	}

	    public void printStrings(int len, String answer)throws IllegalArgumentException{
	     if(len==0){System.out.println();}
	     else if(len<0){throw new IllegalArgumentException();}           
	     else{
	         binaryCount(len,"",answer);
	     }
	    }
	    private void binaryCount(int size,String add, String answer){
	    char [] symbol = {'+','-','*'};
	     if(size==0){
	    	 StringBuffer buf = new StringBuffer();
	    	 for(int i=0;i<answer.length();i++){
	    		 buf.append(answer.charAt(i));
	    		 if(i!=add.length() && add.charAt(i)!='*' )
	    			 buf.append(add.charAt(i));
	    	 }
	    	if(evaluate(buf)) count++;	 
	    	 //System.out.println(add);
	    	// System.out.println(buf);
	    	 //evaluate(buf); count++;
	     }
	     else{
	    	 
	         for(int i=0;i<3;i++){
	          binaryCount(size-1,add+symbol[i],answer);
	         }
	     }
	    }
	 
		private boolean evaluate(StringBuffer buf) {
			int sum =0,local=0;
			StringBuffer add = new StringBuffer();
			char symb ='*';
			for(int i=0;i<buf.length();i++){
				char c = buf.charAt(i);
				if(c!='+'&&c!='-'){
					add.append(c);
				}else if(c=='+'){
 
					local = new Integer(add.toString());
					sum = localAction(sum, local, add, symb,c);
					add = new StringBuffer();
					symb='+';
				}else if(c=='-'){
 
					local = new Integer(add.toString());
					sum = localAction(sum, local, add, symb,c);
					add = new StringBuffer();
					symb='-';
				}
			}
			if(symb=='+') sum+=new Integer(add.toString());
			else  sum-=new Integer(add.toString());
			/*boolean ans = ((sum%2==0) || (sum%5==0) || (sum%7==0) || (sum%3==0))?true:false;
			if(ans)
				System.out.println("buf "+buf+" sum "+sum +" > "+count);
			/System.out.println("buf "+buf+" sum "+sum +" "+((ans)?"--":"")+" > "+count);*/
			return ((sum%2==0) || (sum%5==0) || (sum%7==0) || (sum%3==0));
			
		}
		
		private int localAction(int sum, int local, StringBuffer add, char symb, char c) {
			if(symb=='*') symb=c;
			if(symb=='+'){
				sum+=local;
			}else if(symb=='-'){
				local = new Integer(add.toString());
				//System.out.println("local is "+local);
				if(sum!=0)
					sum-=local;
				else sum=local;
				//System.out.println("sum is "+sum);
			}
			return sum;
		} 
	 
}
