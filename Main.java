import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main{
private static int count=0;
public static Set <String> myset=null;
public static void perm(String prefix, String s){
	int n=s.length();
	if(n==0) myset.add(prefix);
	else
		for(int i=0;i<n;i++)
			perm(prefix+s.charAt(i),  s.substring(0,i)+s.substring(i+1,n) );
}

public static void main(String args[]){
	try{
			int inputCount=1;
			Scanner sc = new Scanner (new File(args[0]));
			StringBuilder st = null;
			while(sc.hasNext()){
				String words = sc.nextLine();
				if(words.length()>0)
				{	
					myset = new TreeSet<String>();
					perm("",words);
    				Iterator it = myset.iterator();
    				st =new StringBuilder();
					while(it.hasNext()){
						//st.append(it.next()).append(",");
						String s = (String) it.next();
						int plus = s.indexOf("+");
						int minus = s.indexOf("-");
						if((plus+1==minus) || (plus-1==minus))
							it.remove();
						else if((plus==0 || plus == s.length()-1 || minus==0 || minus==s.length()-1))
							it.remove();
						else{
								if(evaluate(s)) count++;
							}
							
					}
					//System.out.println(st.substring(0,st.length()-1));
					st= null;
					System.out.println(count);
					count=0;

				}

				
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}

	
}

		private static boolean evaluate(String s){
			int sum=0,sign=1;
			int plus = s.indexOf('+');
			int minus = s.indexOf('-');
			
			for(int i=0;i<s.length();i++){
				char c = s.charAt(i);
				if(c!='+'&&c!='-'){
					int value = (int)(c-'0');
					value = value*sign;
					if(sign==-1) sign=1;
					sum+=value;
				}
				else if(c=='-'){
					sign=-1;
				}else{
					sign=1;
				}
			}
			boolean  result = (sum%2==0)|| (sum%3==0)|| (sum%5==0) || (sum%7==0);
			System.out.println(s+" "+sum+" "+ result);
			return result;
		}

}