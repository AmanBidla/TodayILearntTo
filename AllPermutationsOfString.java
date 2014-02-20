import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class AllPermutationsOfString{

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
						st.append(it.next()).append(",");
					}
					System.out.println(st.substring(0,st.length()-1));
					st= null;

				}

				
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}

	
}

}